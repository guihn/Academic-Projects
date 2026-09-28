<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2005/Exercise%2003">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2005">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 03 · Cálculo de imposto de renda

## Descrição

A atividade simula uma retenção de imposto com regras fixadas para o exercício. O salário e a quantidade de dependentes determinam uma base reduzida por uma dedução por pessoa. Sobre essa base deve ser aplicado o percentual indicado no enunciado para obter o valor retido.

## Enunciado

Solicite o salário e o número de dependentes. Calcule e apresente o imposto de renda pelas regras do exercício:

- Líquido = salário − número de dependentes × R$60,00.
- Imposto de renda = 15% do líquido.

## Solução

Subtrair o desconto por dependentes do salário e aplicar o percentual informado na janela.

### Observações da implementação

O código solicita o percentual do imposto. O enunciado fixa 15%. O valor exibido como líquido é a base de cálculo antes desse imposto.

Arquivo fonte: [C05ex03.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2005/Exerc%C3%ADcio%2003/src/C05ex03.java)

<details>
<summary>💻 | Código Java</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Subtrair o desconto por dependentes do salário e aplicar o percentual informado na janela.
 *
 * Atividade: C05ex03.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C05ex03 {

    static void main() {

        String salaryStr, dependentsStr, irStr;

        double salary, dependents, ir, liquidSalary;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        salaryStr = JOptionPane.showInputDialog(null,
                "Informe o salário:",
                "Conteúdo 05 | Exercício 03",
                JOptionPane.QUESTION_MESSAGE);

        dependentsStr = JOptionPane.showInputDialog(null,
                "Informe o número de dependentes:",
                "Conteúdo 05 | Exercício 03",
                JOptionPane.QUESTION_MESSAGE);

        irStr = JOptionPane.showInputDialog(null,
                "Informe a porcentagem do imposto de renda (Ex.: 15):",
                "Conteúdo 05 | Exercício 03",
                JOptionPane.QUESTION_MESSAGE);

        salary = Double.valueOf(salaryStr);
        dependents = Double.valueOf(dependentsStr);
        ir = Double.valueOf(irStr);

        // Processamento: Subtrair o desconto por dependentes do salário e aplicar o percentual
        // informado na janela.
        liquidSalary = salary - dependents * 60.00;

        ir = liquidSalary * ir / 100.0;

        // Saída: apresentar a mensagem correspondente ao resultado atual.
        JOptionPane.showMessageDialog(null,
                "Líquido: R$" + liquidSalary + "\nImposto de renda: R$" + ir,
                "Conteúdo 05 | Exercício 03",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
```

</details>
