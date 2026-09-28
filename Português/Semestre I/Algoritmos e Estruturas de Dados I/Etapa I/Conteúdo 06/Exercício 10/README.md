<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006/Exercise%2010">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 10 · Exercício de resgate de aplicação

## Descrição

A atividade simula o resgate de uma aplicação com juros simples diários. Capital, prazo e taxa percentual permitem calcular o rendimento, do qual é retido o imposto definido no exercício. O valor final combina o capital inicial, o rendimento e os descontos de imposto e administração.

## Enunciado

Solicite capital aplicado, número de dias e taxa diária percentual. Converta a taxa para fração e apresente o rendimento, o imposto e o resgate:

- Rendimento = capital × taxa diária × dias.
- Imposto = 15% do rendimento.
- Resgate = capital + rendimento − imposto − R$10,00 de administração.

## Solução

Converter o percentual diário para fração, calcular o rendimento e subtrair o imposto e a taxa administrativa.

Arquivo fonte: [C06ex10.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2010/src/C06ex10.java)

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
