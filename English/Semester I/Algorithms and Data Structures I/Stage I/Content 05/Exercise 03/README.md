<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2005/Exerc%C3%ADcio%2003">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2005">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 03 · Income tax calculation

## Description

**Statement summary:** Deduct R$60 per dependent from a salary and calculate 15% of that base as the exercise income tax.

**Supplied source:** [C05ex03.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/FirstStage/C05ex03.java).

## Solution

Subtract the dependent allowance from the salary and apply the percentage entered in the dialog.

### Implementation notes

The supplied code asks for the tax percentage. The statement fixes it at 15%. The displayed net amount is the calculation base before this tax.

[Source file: C05ex03.java](https://github.com/guihn/Academic-Projects/blob/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2005/Exercise%2003/src/C05ex03.java) · [Download](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2005/Exercise%2003/src/C05ex03.java)

<details>
<summary>💻 | Java code</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Subtract the dependent allowance from the salary and apply the percentage entered in the
 * dialog.
 *
 * Assignment: C05ex03.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C05ex03 {

    static void main() {

        String salaryStr, dependentsStr, irStr;

        double salary, dependents, ir, liquidSalary;

        // Input: collect the requested values through dialog boxes.
        salaryStr = JOptionPane.showInputDialog(null,
                "Enter the salary:",
                "Content 05 | Exercise 03",
                JOptionPane.QUESTION_MESSAGE);

        dependentsStr = JOptionPane.showInputDialog(null,
                "Enter the number of dependents:",
                "Content 05 | Exercise 03",
                JOptionPane.QUESTION_MESSAGE);

        irStr = JOptionPane.showInputDialog(null,
                "Enter the income tax percentage (e.g. 15):",
                "Content 05 | Exercise 03",
                JOptionPane.QUESTION_MESSAGE);

        salary = Double.valueOf(salaryStr);
        dependents = Double.valueOf(dependentsStr);
        ir = Double.valueOf(irStr);

        // Processing: Subtract the dependent allowance from the salary and apply the percentage
        // entered in the dialog.
        liquidSalary = salary - dependents * 60.00;

        ir = liquidSalary * ir / 100.0;

        // Output: display the message for the current result.
        JOptionPane.showMessageDialog(null,
                "Net amount: R$" + liquidSalary + "\nIncome tax: R$" + ir,
                "Content 05 | Exercise 03",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
```

</details>
