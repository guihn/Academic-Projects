// The page communicates with Flask; only the server calls the Google client.
const $ = id => document.getElementById(id);
let result = null;
let submitted = null;
let weeklyReport = null;
let serviceResult = null;
const labels = {
  produto: 'Product',
  categoria: 'Category',
  lote: 'Lot',
  data_validade: 'Expiration date',
  quantidade: 'Quantity (units)',
  setor: 'Section',
  armazenamento: 'Storage'
};

// The page uses dd/mm/yyyy; the server receives yyyy-mm-dd.
function referenceDateISO(value) {
  const match = /^(\d{2})\/(\d{2})\/(\d{4})$/.exec(value);
  if (!match) return null;
  const [, day, month, year] = match;
  const iso = year + '-' + month + '-' + day;
  const date = new Date(iso + 'T00:00:00Z');
  return Number(year) > 0 && !Number.isNaN(date.getTime()) &&
    date.toISOString().slice(0, 10) === iso ? iso : null;
}

const referenceInput = $('date');
const referencePicker = $('date-picker');
referenceInput.addEventListener('beforeinput', event => {
  if (event.data && /[^0-9/]/.test(event.data)) event.preventDefault();
});
referenceInput.addEventListener('input', () => {
  const cursor = referenceInput.selectionStart ?? referenceInput.value.length;
  const digitsBefore = referenceInput.value.slice(0, cursor).replace(/[^0-9]/g, '').length;
  const digits = referenceInput.value.replace(/[^0-9]/g, '').slice(0, 8);
  referenceInput.value = digits.slice(0, 2) +
    (digits.length > 2 ? '/' + digits.slice(2, 4) : '') +
    (digits.length > 4 ? '/' + digits.slice(4) : '');
  let caret = 0,
    count = 0;
  while (caret < referenceInput.value.length && count < digitsBefore) {
    if (/[0-9]/.test(referenceInput.value[caret])) count++;
    caret++;
  }
  if (referenceInput.value[caret] === '/') caret++;
  referenceInput.setSelectionRange(caret, caret);
  const iso = referenceDateISO(referenceInput.value);
  referenceInput.setCustomValidity(iso ? '' : 'Invalid date. Expected format: dd/mm/yyyy.');
  referencePicker.value = iso ?? '';
});
$('reference-calendar').addEventListener('click', () => {
  referencePicker.value = referenceDateISO(referenceInput.value) ?? '';
  if (typeof referencePicker.showPicker === 'function') referencePicker.showPicker();
  else {
    referencePicker.focus();
    referencePicker.click();
  }
});
referencePicker.addEventListener('change', () => {
  if (!referencePicker.value) return;
  referenceInput.value = referencePicker.value.split('-').reverse().join('/');
  referenceInput.dispatchEvent(new Event('input', {
    bubbles: true
  }));
  referenceInput.focus();
});

// Editing prevents approval of a result calculated from outdated data.
function invalidateChangedInput() {
  if (submitted && (submitted.texto !== $('text').value ||
      submitted.data_referencia !== referenceDateISO($('date').value))) {
    submitted = null;
    result = null;
    $('review').hidden = true;
    $('result').hidden = true;
    message('The description or reference date changed. A new extraction is required.');
  }
}
$('text').addEventListener('input', invalidateChangedInput);
$('date').addEventListener('input', invalidateChangedInput);
$('fields').addEventListener('input', () => {
  if (!result) return;
  result = null;
  $('result').hidden = true;
  message('The lot fields changed. Confirmation is required to recalculate the recommendation.');
});

async function api(url, data) {
  const options = data === undefined ? {} : {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
  };
  const response = await fetch(url, options);
  let json;
  try {
    json = await response.json();
  } catch {
    throw Error('The server returned an invalid response. Check whether the application is running.');
  }
  if (!response.ok) throw Error(json.erro || 'Request failed.');
  return json;
}

function message(text, error = false) {
  $('message').textContent = text;
  $('message').className = error ? 'error' : '';
  if (error) $('message').scrollIntoView({
    block: 'center',
    behavior: 'smooth'
  });
}
async function busy(fn) {
  const controls = document.querySelectorAll('button,input,textarea,select');
  controls.forEach(control => control.disabled = true);
  try {
    await fn();
  } catch (error) {
    message(error.message, true);
  } finally {
    // Extraction can create fields, so the control collection is refreshed.
    document.querySelectorAll('button,input,textarea,select').forEach(control => control.disabled = false);
    connectionStatus().catch(() => {});
  }
}

function buildFields(lot) {
  $('fields').replaceChildren();
  for (const [key, value] of Object.entries(lot)) {
    const box = document.createElement('div');
    const label = document.createElement('label');
    label.textContent = labels[key];
    label.htmlFor = 'f_' + key;
    const input = document.createElement(key === 'armazenamento' ? 'select' : 'input');
    input.id = 'f_' + key;
    input.name = key;
    if (key === 'armazenamento') {
      for (const name of ['ambiente', 'refrigerado', 'congelado']) {
        const option = document.createElement('option');
        option.value = name;
        option.textContent = name;
        input.append(option);
      }
    }
    if (key === 'data_validade') input.type = 'date';
    if (key === 'quantidade') {
      input.max = 2147483647;
      input.type = 'number';
      input.min = 1;
      input.step = 1;
    }
    input.value = value ?? '';
    input.required = key !== 'categoria';
    box.append(label, input);
    $('fields').append(box);
  }
}
async function extractLot() {
  result = null;
  $('result').hidden = true;
  $('review').hidden = true;
  submitted = {
    texto: $('text').value,
    data_referencia: referenceDateISO($('date').value)
  };
  message('Gemini data extraction in progress…');
  const response = await api('/api/analisar', submitted);
  buildFields(response.lote);
  submitted.extracao_id = response.extracao_id;
  $('review').hidden = false;
  message('Extracted fields available for review.');
}
async function confirmLot() {
  const lot = {};
  for (const key of Object.keys(labels)) {
    lot[key] = key === 'quantidade' ? Number($('f_' + key).value) : $('f_' + key).value || null;
  }
  message('Classification and recommendation in progress…');
  result = await api('/api/analisar', {
    ...submitted,
    lote_confirmado: lot
  });
  render();
  message('Analysis completed. Recommendation available for review.');
  await history();
}

function render() {
  $('result').hidden = false;
  $('risk').textContent = result.risco.classificacao + ' · ' + result.risco.dias_restantes + ' day(s)';
  $('action').textContent = result.acao?.acao || 'Lot under regular monitoring, without an alert.';
  $('deadline').textContent = result.acao ? 'Deadline: ' + result.acao.prazo + ' | Responsible role: ' + result.acao.responsavel : '';
  $('approve').hidden = result.aprovado || !result.acao;
  $('alert').hidden = !result.alerta;
  $('alert').textContent = result.alerta?.mensagem || '';
  $('log').textContent = JSON.stringify(result, null, 2);
}
async function approveAction() {
  message('Alert generation after approval in progress…');
  result = await api('/api/aprovar/' + result.id, {});
  render();
  message('Approval recorded. Alert displayed below.');
  await history();
}

function downloadJSON(value, name) {
  if (!value) return;
  const link = document.createElement('a');
  const url = URL.createObjectURL(new Blob([JSON.stringify(value, null, 2)], {
    type: 'application/json'
  }));
  link.href = url;
  link.download = name + '-' + value.id + '.json';
  link.click();
  URL.revokeObjectURL(url);
}

function downloadLog() {
  downloadJSON(result, 'validamarket');
}

function paragraph(container, text) {
  const p = document.createElement('p');
  p.textContent = text;
  container.append(p);
}

function reference() {
  const iso = referenceDateISO($('date').value);
  if (!iso) throw Error('Invalid reference date. Expected format: dd/mm/yyyy.');
  return iso;
}

function money(cents) {
  return cents === null ? 'not provided' : (cents / 100).toLocaleString('pt-BR', {
    style: 'currency',
    currency: 'BRL'
  });
}
async function history() {
  const list = await api('/api/historico');
  $('history').replaceChildren();
  const selected = $('writeoff-record').value;
  $('writeoff-record').replaceChildren(new Option('Selection of an approved analysis', ''));
  if (!list.length) $('history').textContent = 'No recorded lots.';
  for (const record of list) {
    const status = !record.dados.acao ? 'Monitoring' : record.aprovado ? 'Approved' : 'Awaiting review';
    paragraph($('history'), record.dados.lote.produto + ' · ' + record.dados.lote.lote + ' · ' + record.dados.risco.classificacao + ' · ' + status + ' · Written off: ' + record.quantidade_baixada + ' · Record balance: ' + record.saldo_registro);
    if (record.aprovado && record.dados.acao && record.saldo_registro > 0) {
      const option = new Option(record.dados.lote.produto + ' · ' + record.dados.lote.lote + ' · balance ' + record.saldo_registro + ' · analysis ' + record.id.slice(0, 8), record.id);
      option.dataset.saldo = record.saldo_registro;
      $('writeoff-record').append(option);
    }
  }
  $('writeoff-record').value = selected;
  updateWriteoffLimit();
  await managementHistory();
}

function updateWriteoffLimit() {
  const option = $('writeoff-record').selectedOptions[0];
  $('writeoff-quantity').max = option?.dataset.saldo || '2147483647';
}

function renderReport(value) {
  weeklyReport = value;
  const box = $('report-result');
  box.replaceChildren();
  const {
    periodo,
    totais,
    por_produto_setor
  } = value.dados;
  paragraph(box, periodo.inicio.split('-').reverse().join('/') + ' to ' + periodo.fim.split('-').reverse().join('/'));
  paragraph(box, 'Analyses: ' + totais.analises + ' · Approvals: ' + totais.acoes_aprovadas + ' · Writeoffs: ' + totais.baixas_registradas + ' · Units written off: ' + totais.unidades_baixadas);
  paragraph(box, 'Reported amount: ' + money(totais.valor_centavos_informado) + ' · Writeoffs without an amount: ' + totais.baixas_sem_valor + ' · Customer interactions: ' + totais.atendimentos + ' · Shelf reports: ' + totais.relatos_na_gondola);
  paragraph(box, value.dados.observacao);
  for (const group of por_produto_setor) {
    paragraph(box, group.produto + ' · ' + group.setor + ' · ' + group.unidades + ' unit(s) · Reported amounts: ' + money(group.baixas === group.baixas_sem_valor ? null : group.valor_centavos_informado) + ' · Writeoffs without an amount: ' + group.baixas_sem_valor);
  }
  paragraph(box, value.relatorio.resumo);
  for (const [key, title] of [
      ['causas_possiveis', 'Possible causes'],
      ['medidas_preventivas', 'Preventive measures']
    ]) {
    const heading = document.createElement('h3');
    heading.textContent = title;
    const list = document.createElement('ul');
    for (const text of value.relatorio[key]) {
      const li = document.createElement('li');
      li.textContent = text;
      list.append(li);
    }
    box.append(heading, list);
  }
  $('report-download').hidden = false;
}

function renderService(value) {
  serviceResult = value;
  $('service-result').replaceChildren();
  paragraph($('service-result'), 'Reference: ' + value.data_referencia.split('-').reverse().join('/'));
  paragraph($('service-result'), value.resposta.mensagem);
  if (value.alerta) {
    const alert = document.createElement('pre');
    alert.textContent = value.alerta.mensagem;
    $('service-result').append(alert);
  }
  $('service-download').hidden = false;
}
async function managementHistory() {
  const data = await api('/api/gestao');
  $('writeoff-history').replaceChildren();
  for (const item of data.baixas) paragraph($('writeoff-history'), item.data.split('-').reverse().join('/') + ' · ' + item.quantidade + ' unit(s) · ' + item.motivo + ' · Total amount: ' + money(item.valor_centavos) + ' · analysis ' + item.registro_id.slice(0, 8));
  for (const [id, items, render] of [
      ['report-history', data.relatorios, renderReport],
      ['service-history', data.atendimentos, renderService]
    ]) {
    $(id).replaceChildren();
    if (!items.length) paragraph($(id), 'No records.');
    for (const item of items) {
      const button = document.createElement('button');
      button.type = 'button';
      button.className = 'secondary';
      button.textContent = id === 'report-history' ? item.dados.periodo.fim.split('-').reverse().join('/') + ' · report ' + item.id.slice(0, 8) : item.pergunta;
      button.onclick = () => render(item);
      $(id).append(button);
    }
  }
}

async function connectionStatus() {
  const state = await api('/api/status');
  $('provider').textContent = 'Gemini · ' + state.modelo;
  $('connection-status').textContent = !state.cliente_disponivel ? 'Google client unavailable. Sign-in requires the official client.' :
    state.conexao?.estado === 'conectada' ? 'Connection verified in this installation.' : 'Google client available for sign-in and connection verification.';
  $('google-login').disabled = !state.cliente_disponivel;
  $('google-check').disabled = !state.cliente_disponivel;
}

// Forms share communication and error handling functions.
$('entry').onsubmit = event => {
  event.preventDefault();
  busy(extractLot);
};
$('confirmation').onsubmit = event => {
  event.preventDefault();
  if (!submitted || submitted.texto !== $('text').value ||
    submitted.data_referencia !== referenceDateISO($('date').value)) {
    invalidateChangedInput();
    message('Confirmation requires a new data extraction.', true);
    return;
  }
  busy(confirmLot);
};
$('approve').onclick = () => busy(approveAction);
$('download').onclick = downloadLog;
$('refresh').onclick = () => busy(history);
$('google-login').onclick = () => busy(async () => {
  $('connection-message').textContent = 'Opening the official Google client…';
  try {
    const response = await api('/api/conexao/entrar', {});
    $('connection-message').textContent = response.mensagem;
  } catch (error) {
    $('connection-message').textContent = error.message;
  }
});
$('google-check').onclick = () => busy(async () => {
  $('connection-message').textContent = 'Gemini access verification in progress…';
  try {
    const response = await api('/api/conexao/verificar', {});
    $('connection-message').textContent = response.mensagem;
  } catch (error) {
    $('connection-message').textContent = error.message;
  } finally {
    await connectionStatus();
  }
});
connectionStatus().catch(error => message(error.message, true));
history().catch(error => message(error.message, true));

$('writeoff-record').onchange = updateWriteoffLimit;
$('writeoff-form').onsubmit = event => {
  event.preventDefault();
  busy(async () => {
    await api('/api/baixas/' + $('writeoff-record').value, {
      quantidade: Number($('writeoff-quantity').value),
      motivo: $('writeoff-reason').value,
      valor: $('writeoff-value').value,
      realizada: $('writeoff-done').checked,
      data: reference()
    });
    $('writeoff-form').reset();
    message('Writeoff recorded. The report includes only the supplied amount.');
    await history();
  });
};
$('report-generate').onclick = () => busy(async () => {
  message('Preparing the weekly report with Gemini…');
  renderReport(await api('/api/relatorios', {
    data_referencia: reference()
  }));
  await managementHistory();
  message('Weekly report recorded.');
});
$('service-form').onsubmit = event => {
  event.preventDefault();
  busy(async () => {
    message('Preparing the customer-service response with Gemini…');
    renderService(await api('/api/atendimento', {
      texto: $('service-text').value,
      data_referencia: reference()
    }));
    await managementHistory();
    message('Customer interaction recorded.' + (serviceResult.alerta ? ' Shelf report forwarded for verification in a local alert.' : ''));
  });
};
$('report-download').onclick = () => downloadJSON(weeklyReport, 'relatorio');
$('service-download').onclick = () => downloadJSON(serviceResult, 'atendimento');
