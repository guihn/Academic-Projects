<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2007/Exerc%C3%ADcio%2001">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2007">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 01 · Sports lottery prizes

## Description

The program determines a betting prize from the number of correct predictions across 13 games. Lower bands produce no prize or another slip, while 11, 12 and 13 correct predictions correspond to cash amounts. The output must identify the bettor and the prize associated with their total.

## Statement

Read the bettor's name and number of correct predictions. Calculate and print the prize using the exercise table:

| Correct&nbsp;predictions | Prize |
| --- | --- |
| Up to 5 | None |
| From 6 through 10 | Another slip |
| 11 | R$100.00 |
| 12 | R$1,000.00 |
| 13 | R$50,000.00 |

## Solution

Handle the low score bands with if statements and select the cash prize for 11, 12 or 13 correct predictions with switch.

Source file: [C07ex01.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2007/Exercise%2001/src/C07ex01.java)

<details>
<summary>💻 | Java code</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Handle the low score bands with if statements and select the cash prize for 11, 12 or 13
 * correct predictions with switch.
 *
 * Assignment: C07ex01.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C07ex01 {

    static void main() {

        String name, winsStr;

        int wins;

        double award;

        // Input: collect the requested values through dialog boxes.
        name = JOptionPane.showInputDialog(null,
                "Enter your name: ",
                "Content 07 | Exercise 01",
                JOptionPane.QUESTION_MESSAGE);

        winsStr = JOptionPane.showInputDialog(null,
                "Enter your number of correct predictions: ",
                "Content 07 | Exercise 01",
                JOptionPane.QUESTION_MESSAGE);

        wins = Integer.valueOf(winsStr);

        // Processing: Handle the low score bands with if statements and select the cash prize for
        // 11, 12 or 13 correct predictions with switch.
        if (wins <= 5) {
            // Output: display the message for the current result.
            JOptionPane.showMessageDialog(null,
                    name + ", you got too few correct predictions and will receive no prize!",
                    "Content 07 | Exercise 01",
                    JOptionPane.ERROR_MESSAGE);
        } else if (wins <= 10) {
            
            JOptionPane.showMessageDialog(null,
                    name + ", you got few correct predictions, but will receive another betting slip!",
                    "Content 07 | Exercise 01",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {

            switch (wins) {
                case 11 -> {
                    
                    award = 100.00;
                }
                case 12 -> {
                    
                    award = 1000.00;
                }
                case 13 -> {
                    
                    award = 50000.00;
                }
                default -> {
                    
                    award = 0;
                    JOptionPane.showMessageDialog(null,
                            name + ", you did not enter a valid number of correct predictions! Your prize was set to zero.",
                            "Content 07 | Exercise 01",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            JOptionPane.showMessageDialog(null,
                    name + ", you got " + wins + " correct predictions and will receive a prize of R$" + award,
                    "Content 07 | Exercise 01",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
```

</details>
