<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Commenting%20Standard">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Padrão de comentários

Este padrão orienta os comentários dos programas fornecidos e das futuras contribuições de código. Os comentários explicam o comportamento implementado e ajudam a entender as decisões de cada cálculo.

## Descrição da classe ou arquivo

Use um bloco Javadoc curto acima da classe Java para informar sua finalidade e o identificador da atividade. Mantenha a autoria apenas quando ela estiver presente no código fornecido. Em outras linguagens, use o comentário de documentação equivalente.

## Explicações dentro da solução

Use comentários // antes de blocos relevantes. Entrada, Processamento e Saída são rótulos úteis quando essas responsabilidades formam blocos distintos. Explique fórmulas, unidades, condições de limite, sentinelas, contadores, acumuladores e recursos quando precisarem de esclarecimento. Um laço ou ramo pode combinar várias responsabilidades. Evite comentar cada atribuição ou chave de fechamento.

## Métodos e contratos

Documente métodos reutilizáveis com sua finalidade e as hipóteses relevantes. Adicione @param, @return e @throws apenas quando esclarecerem um parâmetro, resultado ou exceção real. Não descreva o método main como recebendo ou retornando dados que ele não utiliza.

## Equivalência entre idiomas

Escreva comentários e mensagens ao usuário no idioma da versão correspondente. Preserve identificadores, fórmulas, operadores, índices de opções, caminhos de recursos e valores de entrada usados na lógica. Atualize as duas versões em conjunto. Nomes como Masculino usados como entrada aceita continuam sendo valores literais e devem ser explicados ao leitor.

## Precisão e manutenção

Descreva o que o código faz atualmente. Quando a implementação fornecida diferir do enunciado, registre a diferença explicitamente em vez de descrever uma correção que não foi feita. Remova separadores redundantes e exemplos comentados obsoletos ao organizar os comentários. Evite inventar autores, datas, versões ou alegações de execução bem-sucedida. Mantenha o bloco completo de código no README da atividade idêntico ao arquivo fonte, atualizando ambos no mesmo commit do idioma.

## Exemplo de comentário

```java
// Arredondar para cima, pois uma caixa parcialmente preenchida também precisa ser comprada.
necessaryBoxes = Math.ceil(goodBalls / 10);
```

[Normas gerais](https://github.com/guihn/repo-rules/tree/main) · [Regras de Academic Projects](https://github.com/guihn/repo-rules/tree/main/Academic%20Projects)
