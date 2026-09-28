<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006/Exercise%2007">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 07 · Participação nos lucros líquida

## Descrição

**Resumo do enunciado:** Calcular a participação nos lucros pelas faixas salariais do exercício e descontar 25% do valor bruto.

**Fonte do enunciado:** [slides originais da aula](https://github.com/guihn/academic-materials/blob/5a9473bbf24a271032a41b141ab6bd435076c1d5/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2006/Algoritmos%20-%20Aulas%20-%20Conte%C3%BAdo%206%20-%20Comando%20Condicional%20%E2%80%93%20IF%2C%20Express%C3%B5es%20Booleanas.pptx), slide(s) 49. [Pasta do material](https://github.com/guihn/academic-materials/tree/main/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2006).

**Código fornecido:** [C06ex07.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/FirstStage/C06ex07.java).

## Solução

Escolher a parcela fixa e o percentual, calcular a participação bruta e subtrair o imposto do exercício.

[Arquivo fonte: C06ex07.java](https://github.com/guihn/Academic-Projects/blob/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2007/src/C06ex07.java) · [Baixar](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2007/src/C06ex07.java)

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
