<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20II/Conte%C3%BAdo%2008/Exerc%C3%ADcio%2006">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20II/Content%2008">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 06 · Parity and divisibility totals

## Description

The program performs three analyses on the same sequence of ten integers. Parity is reported after each input, while a sum of multiples of 4 and a count of multiples of 3 are maintained until the end. A number can contribute to both totals if it meets both divisibility criteria.

## Statement

Read 10 integers and report whether each is even or odd. At the end, print the sum of numbers divisible by 4 and the count of numbers divisible by 3. Use integer remainders to test divisibility.

## Solution

Use remainders to classify each number and maintain the sum and count inside the loop.

### Implementation notes

The original else if makes the divisibility checks exclusive. Numbers divisible by both 4 and 3 enter the sum but are omitted from the multiples-of-3 count.

Source file: [C08ex06.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20II/Content%2008/Exercise%2006/src/C08ex06.java)

<details>
<summary>💻 | Java code</summary>

```java
package SecondStage;

import javax.swing.JOptionPane;

/**
 * Use remainders to classify each number and maintain the sum and count inside the loop.
 *
 * Assignment: C08ex06.
 */
public class C08ex06 {
    static void main() {
        String numberStr;
        int number, oddoreven, div4, div3, rep, div4sum, ifdiv3;
        rep = 10;
        div4sum = 0;
        div3 = 0;

        // Processing: Use remainders to classify each number and maintain the sum and count inside
        // the loop.
        for (int i = 1; i <= rep; i++) {
            // Input: collect the requested values through dialog boxes.
            numberStr = JOptionPane.showInputDialog(null,
                    "Enter an integer: ",
                    "Content 08 | Exercise 06",
                    JOptionPane.QUESTION_MESSAGE);
            number = Integer.parseInt(numberStr);

            oddoreven = number % 2;
            div4 = number % 4;
            ifdiv3 = number % 3;

            if (oddoreven == 0) {
                // Output: display the message for the current result.
                JOptionPane.showMessageDialog(null,
                        "The number is even!",
                        "Content 08 | Exercise 06",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null,
                        "The number is odd!",
                        "Content 08 | Exercise 06",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            if (div4 == 0) {
                div4sum += number;
            }
            // This original else if excludes multiples of 4 from the multiples-of-3 count.
            else if (ifdiv3 == 0) {
                div3++;
            }
        }
            JOptionPane.showMessageDialog(null,
                    "Sum of numbers divisible by 4: " + div4sum + "\nCount of numbers divisible by 3: " + div3 + " numbers.",
                    "Content 08 | Exercise 06",
                    JOptionPane.QUESTION_MESSAGE);
    }
}
```

</details>
