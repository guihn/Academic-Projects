<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2010">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 10 · Investment redemption exercise

## Description

**Statement summary:** Calculate simple daily earnings, 15% tax on earnings and redemption after a R$10 administration fee using the exercise rules.

**Supplied source:** [C06ex10.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/FirstStage/C06ex10.java).

## Solution

Convert the daily percentage to a fraction, calculate earnings and subtract the tax and administration fee.

[Source file: C06ex10.java](https://github.com/guihn/Academic-Projects/blob/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006/Exercise%2010/src/C06ex10.java) · [Download](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006/Exercise%2010/src/C06ex10.java)

<details>
<summary>💻 | Java code</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Convert the daily percentage to a fraction, calculate earnings and subtract the tax and
 * administration fee.
 *
 * Assignment: C06ex10.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex10 {

    static void main() {

        String appliedCapitalStr, numberdaysStr, diaryFeeStr;

        double appliedCapital, numberdays, diaryFee, yield, incomeTax, adminFee, finalvalor;

        // Input: collect the requested values through dialog boxes.
        appliedCapitalStr = JOptionPane.showInputDialog(null,
                "Enter the invested capital:",
                "Content 06 | Exercise 10",
                JOptionPane.QUESTION_MESSAGE);

        numberdaysStr = JOptionPane.showInputDialog(null,
                "Enter the number of investment days:",
                "Content 06 | Exercise 10",
                JOptionPane.QUESTION_MESSAGE);

        diaryFeeStr = JOptionPane.showInputDialog(null,
                "Enter the daily rate as a percentage (10 = 10%):",
                "Content 06 | Exercise 10",
                JOptionPane.QUESTION_MESSAGE);

        appliedCapital = Double.valueOf(appliedCapitalStr);
        numberdays = Double.valueOf(numberdaysStr);
        diaryFee = Double.valueOf(diaryFeeStr);

        // Processing: Convert the daily percentage to a fraction, calculate earnings and subtract
        // the tax and administration fee.
        diaryFee = diaryFee / 100;

        yield = appliedCapital * diaryFee * numberdays;

        incomeTax = yield * 0.15;

        adminFee = 10;

        finalvalor = appliedCapital + yield - incomeTax - adminFee;

        // Output: display the message for the current result.
        JOptionPane.showMessageDialog(null,
                "Earnings: R$" + yield +
                        "\nIncome tax: R$" + incomeTax +
                        "\nRedemption value: R$" + finalvalor,
                "Content 06 | Exercise 10",
                JOptionPane.INFORMATION_MESSAGE);

    }
}
```

</details>
