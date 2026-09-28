<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Primeira%20Avalia%C3%A7%C3%A3o/Quest%C3%A3o%20B">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/First%20Assessment">Parent&nbsp;folder</a></td>
</tr>
</table>

# Question B · Armstrong number

## Description

Summary of the supplied code: test whether a positive three digit integer equals the sum of the cubes of its digits. The original assessment statement is unavailable.

**Supplied source:** [D30912B.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/FirstStage/FirstTest/D30912B.java).

## Solution

Validate 100–999, extract hundreds, tens and units and compare the sum of their cubes with the original number.

### Implementation notes

The prompt says up to three digits, but the validation accepts exactly three positive digits.

[Source file: D30912B.java](https://github.com/guihn/Academic-Projects/blob/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/First%20Assessment/Question%20B/src/D30912B.java) · [Download](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/First%20Assessment/Question%20B/src/D30912B.java)

<details>
<summary>💻 | Java code</summary>

```java
package FirstTest;

import javax.swing.JOptionPane;

/**
 * Validate 100–999, extract hundreds, tens and units and compare the sum of their cubes with the
 * original number.
 *
 * Assignment: D30912B.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class D30912B {
    static void main() {
        int receivedNumber;
        String numberArmstrongStr;
        double firstNumb, secondNumb, thirdNumb, testing;

        // Input: collect the requested values through dialog boxes.
        numberArmstrongStr = JOptionPane.showInputDialog(null,
                "Enter a number of up to 3 digits to test: ",
                "First Test | Question B",
                JOptionPane.INFORMATION_MESSAGE);

        receivedNumber = Integer.valueOf(numberArmstrongStr);

        // Processing: Validate 100–999, extract hundreds, tens and units and compare the sum of
        // their cubes with the original number.
        if (receivedNumber >= 100 && receivedNumber < 1000) {

            firstNumb = receivedNumber / 100 % 10;
            secondNumb = receivedNumber / 10 % 10;
            thirdNumb = receivedNumber % 10;

            testing = Math.pow(firstNumb, 3) + Math.pow(secondNumb, 3) + Math.pow(thirdNumb, 3);
            if (testing == receivedNumber) {
                // Output: display the message for the current result.
                JOptionPane.showMessageDialog(null,
                        "This number is an Armstrong number!",
                        "First Test | Question B",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(null,
                        "This number is not an Armstrong number!",
                        "First Test | Question B",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        else {
            JOptionPane.showMessageDialog(null,
                    "You did not enter a valid number of up to 3 digits!",
                    "First Test | Question B",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
```

</details>
