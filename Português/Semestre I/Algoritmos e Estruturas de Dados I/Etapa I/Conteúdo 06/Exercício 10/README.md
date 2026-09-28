<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006/Exercise%2010">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 10 · Exercício de resgate de aplicação

## Descrição

**Resumo do enunciado:** Calcular rendimento diário simples, imposto de 15% sobre o rendimento e resgate após taxa administrativa de R$10, conforme as regras do exercício.

**Código fornecido:** [C06ex10.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/FirstStage/C06ex10.java).

## Solução

Converter o percentual diário para fração, calcular o rendimento e subtrair o imposto e a taxa administrativa.

[Arquivo fonte: C06ex10.java](https://github.com/guihn/Academic-Projects/blob/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2010/src/C06ex10.java) · [Baixar](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2010/src/C06ex10.java)

<details>
<summary>💻 | Código Java</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Converter o percentual diário para fração, calcular o rendimento e subtrair o imposto e a taxa
 * administrativa.
 *
 * Atividade: C06ex10.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex10 {

    static void main() {

        String appliedCapitalStr, numberdaysStr, diaryFeeStr;

        double appliedCapital, numberdays, diaryFee, yield, incomeTax, adminFee, finalvalor;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        appliedCapitalStr = JOptionPane.showInputDialog(null,
                "Informe o capital aplicado:",
                "Conteúdo 06 | Exercício 10",
                JOptionPane.QUESTION_MESSAGE);

        numberdaysStr = JOptionPane.showInputDialog(null,
                "Informe o número de dias aplicados (em números):",
                "Conteúdo 06 | Exercício 10",
                JOptionPane.QUESTION_MESSAGE);

        diaryFeeStr = JOptionPane.showInputDialog(null,
                "Informe a taxa diária (em números, 10 = 10%):",
                "Conteúdo 06 | Exercício 10",
                JOptionPane.QUESTION_MESSAGE);

        appliedCapital = Double.valueOf(appliedCapitalStr);
        numberdays = Double.valueOf(numberdaysStr);
        diaryFee = Double.valueOf(diaryFeeStr);

        // Processamento: Converter o percentual diário para fração, calcular o rendimento e
        // subtrair o imposto e a taxa administrativa.
        diaryFee = diaryFee / 100;

        yield = appliedCapital * diaryFee * numberdays;

        incomeTax = yield * 0.15;

        adminFee = 10;

        finalvalor = appliedCapital + yield - incomeTax - adminFee;

        // Saída: apresentar a mensagem correspondente ao resultado atual.
        JOptionPane.showMessageDialog(null,
                "Rendimento: R$" + yield +
                        "\nImposto de renda: R$" + incomeTax +
                        "\nValor resgatado: R$" + finalvalor,
                "Conteúdo 06 | Exercício 10",
                JOptionPane.INFORMATION_MESSAGE);

    }
}
```

</details>
