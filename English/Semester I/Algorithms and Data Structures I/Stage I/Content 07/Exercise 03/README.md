<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2007/Exerc%C3%ADcio%2003">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2007">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 03 · Late payment fine

## Description

**Statement summary:** Read a tax amount and overdue days and calculate the fine according to the exercise delay bands.

## Solution

Use switch to select exemption, 2%, 10% plus 0.5% per day, or 150% plus R$1 per day.

Source file: [C07ex03.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2007/Exercise%2003/src/C07ex03.java)

<details>
<summary>💻 | Java code</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Use switch to select exemption, 2%, 10% plus 0.5% per day, or 150% plus R$1 per day.
 *
 * Assignment: C07ex03.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C07ex03 {

    static void main() {

        String taxStr, lateDaysStr;

        int lateDays;

        double tax, fee, percentualFee;

        // Input: collect the requested values through dialog boxes.
        taxStr = JOptionPane.showInputDialog(null,
                "Enter the tax amount: ",
                "Content 07 | Exercise 03",
                JOptionPane.QUESTION_MESSAGE);

        lateDaysStr = JOptionPane.showInputDialog(null,
                "Enter the number of overdue days: ",
                "Content 07 | Exercise 03",
                JOptionPane.QUESTION_MESSAGE);

        tax = Double.valueOf(taxStr);
        lateDays = Integer.valueOf(lateDaysStr);

        // Processing: Use switch to select exemption, 2%, 10% plus 0.5% per day, or 150% plus R$1
        // per day.
        switch (lateDays) {
            case 0, 1, 2, 3, 4, 5 -> {
                
                percentualFee = 0;
                fee = tax * percentualFee;
            }
            case 6, 7, 8 -> {
                
                percentualFee = 0.02;
                fee = tax * percentualFee;
            }
            case 9, 10 -> {

                percentualFee = 0.10 + 0.005 * lateDays;
                fee = tax * percentualFee;
            }
            default -> {

                percentualFee = 1.50;
                fee = (tax * percentualFee) + (1 * lateDays);
            }
        }

        // Output: display the message for the current result.
        JOptionPane.showMessageDialog(null,
                "Fine: R$" + fee,
                "Content 07 | Exercise 03",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
```

</details>
