<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006/Exercise%2007">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 07 · Participação nos lucros líquida

## Descrição

O programa simula o cálculo de participação nos lucros com regras definidas pelo exercício. O salário seleciona uma parcela fixa e um percentual, cuja soma forma o valor bruto. Depois de descontar 25% desse valor, a saída deve informar a participação líquida do empregado.

## Enunciado

Leia o salário e calcule a participação líquida nos lucros pelas regras abaixo:

| Salário | Parcela&nbsp;fixa | Percentual&nbsp;do&nbsp;salário |
| --- | --- | --- |
| Até R$300,00 | R$500,00 | 70% |
| Acima de R$300,00 até R$1.000,00 | R$200,00 | 50% |
| Acima de R$1.000,00 | Zero | 30% |

PL bruto = parcela fixa + percentual sobre o salário. O imposto corresponde a 25% do PL bruto. Apresente PL líquido = PL bruto − imposto.

## Solução

Escolher a parcela fixa e o percentual, calcular a participação bruta e subtrair o imposto do exercício.

Arquivo fonte: [C06ex07.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2007/src/C06ex07.java)

<details>
<summary>💻 | Código Java</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Escolher a parcela fixa e o percentual, calcular a participação bruta e subtrair o imposto do
 * exercício.
 *
 * Atividade: C06ex07.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex07 {

    static void main() {

        String employeeSalaryStr;

        double employeeSalary, grossPL, liquidPL, incomeTax, fixedValor, percentageOverSalary, percentage;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        employeeSalaryStr = JOptionPane.showInputDialog(null,
                "Informe o salário:",
                "Conteúdo 06 | Exercício 07",
                JOptionPane.QUESTION_MESSAGE);

        employeeSalary = Double.valueOf(employeeSalaryStr);

        // Processamento: Escolher a parcela fixa e o percentual, calcular a participação bruta e
        // subtrair o imposto do exercício.
        if (employeeSalary <= 300) {
            fixedValor = 500;
            percentage = 0.70;
        }

        else if (employeeSalary > 300 && employeeSalary <= 1000) {
            fixedValor = 200;
            percentage = 0.50;
        }
        
        else {
            fixedValor = 0;
            percentage = 0.30;
        }

        percentageOverSalary = employeeSalary * percentage;

        grossPL = fixedValor + percentageOverSalary;

        incomeTax = 0.25 * grossPL;

        liquidPL = grossPL - incomeTax;

        // Saída: apresentar a mensagem correspondente ao resultado atual.
        JOptionPane.showMessageDialog(null,
                "PL líquido: " + liquidPL,
                "Conteúdo 06 | Exercício 07",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
```

</details>
