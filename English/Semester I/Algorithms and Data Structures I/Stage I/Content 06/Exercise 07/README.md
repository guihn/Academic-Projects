<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2007">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 07 · Net profit sharing

## Description

**Statement summary:** Calculate profit sharing using the exercise salary bands and deduct 25% of the gross amount.

## Solution

Choose the fixed allowance and percentage, calculate the gross participation and subtract the exercise tax.

Source file: [C06ex07.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006/Exercise%2007/src/C06ex07.java)

<details>
<summary>💻 | Java code</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Choose the fixed allowance and percentage, calculate the gross participation and subtract the
 * exercise tax.
 *
 * Assignment: C06ex07.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex07 {

    static void main() {

        String employeeSalaryStr;

        double employeeSalary, grossPL, liquidPL, incomeTax, fixedValor, percentageOverSalary, percentage;

        // Input: collect the requested values through dialog boxes.
        employeeSalaryStr = JOptionPane.showInputDialog(null,
                "Enter the salary:",
                "Content 06 | Exercise 07",
                JOptionPane.QUESTION_MESSAGE);

        employeeSalary = Double.valueOf(employeeSalaryStr);

        // Processing: Choose the fixed allowance and percentage, calculate the gross participation
        // and subtract the exercise tax.
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

        // Output: display the message for the current result.
        JOptionPane.showMessageDialog(null,
                "Net profit sharing: " + liquidPL,
                "Content 06 | Exercise 07",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
```

</details>
