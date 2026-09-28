<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2003">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 03 · Sales commission

## Description

The program calculates a salesperson's monthly pay from their sales. The salary combines a fixed component and a commission that varies by sales band. The output must show total pay, including the fixed component in every band.

## Statement

Request the month's total sales and calculate salary as R$240.00 plus the commission in this table:

| Monthly&nbsp;sales | Commission |
| --- | --- |
| Up to R$1,000.00 | Zero |
| Above R$1,000.00 through R$10,000.00 | 10% of sales |
| Above R$10,000.00 | Fixed R$1,000.00 |

## Solution

Select a salary expression according to the monthly sales band.

### Implementation notes

For sales above R$10000, the original code assigns a total salary of R$1000 and omits the R$240 fixed component.

Source file: [C06ex03.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006/Exercise%2003/src/C06ex03.java)

<details>
<summary>💻 | Java code</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Select a salary expression according to the monthly sales band.
 *
 * Assignment: C06ex03.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex03 {

    static void main() {

        String monthlySaleStr;

        double monthlySale, fixedValor, salary;

        fixedValor = 240;

        // Input: collect the requested values through dialog boxes.
        monthlySaleStr = JOptionPane.showInputDialog(null,
                "Enter the total monthly sales:",
                "Content 06 | Exercise 03",
                JOptionPane.QUESTION_MESSAGE);

        monthlySale = Double.valueOf(monthlySaleStr);

        // Processing: Select a salary expression according to the monthly sales band.
        if (monthlySale <= 1000)
            salary = fixedValor;

        else if (monthlySale > 1000 && monthlySale <= 10000)
            salary = fixedValor + (monthlySale * 0.10);
            
        else
            // This original branch omits the fixed component of 240.
            salary = 1000;

        // Output: display the message for the current result.
        JOptionPane.showMessageDialog(null,
                "Salary: " + salary,
                "Content 06 | Exercise 03",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
```

</details>
