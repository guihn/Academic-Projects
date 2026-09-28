<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2005">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 05 · Divisibility by 5 and 7

## Description

The program checks a joint property of an integer: being a multiple of both 5 and 7. Each divisibility test is determined by a remainder, and the two results must be combined. Divisibility by only one of the values is therefore insufficient to satisfy the requested condition.

## Statement

Request an integer and report whether it is divisible by both 5 and 7. Use the `%` operator: a zero remainder indicates divisibility. Keep the variables used in these operations as integers.

## Solution

Compare each remainder with zero and distinguish divisibility by both values, only one or neither.

Source file: [C06ex05.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006/Exercise%2005/src/C06ex05.java)

<details>
<summary>💻 | Java code</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Compare each remainder with zero and distinguish divisibility by both values, only one or
 * neither.
 *
 * Assignment: C06ex05.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex05 {

    static void main() {

        String numberStr;

        int number;

        // Input: collect the requested values through dialog boxes.
        numberStr = JOptionPane.showInputDialog(null,
                "Enter a number:",
                "Content 06 | Exercise 05",
                JOptionPane.QUESTION_MESSAGE);

        number = Integer.valueOf(numberStr);

        // Processing: Compare each remainder with zero and distinguish divisibility by both values,
        // only one or neither.
        if (number % 5 == 0 && number % 7 == 0)
            // Output: display the message for the current result.
            JOptionPane.showMessageDialog(null,
                    "This number is divisible by 5 and by 7.",
                    "Content 06 | Exercise 05",
                    JOptionPane.INFORMATION_MESSAGE);
            
        else if (number % 5 == 0 && number % 7 != 0)
            JOptionPane.showMessageDialog(null,
                    "This number is divisible by 5 only.",
                    "Content 06 | Exercise 05",
                    JOptionPane.INFORMATION_MESSAGE);
            
        else if (number % 5 != 0 && number % 7 == 0)
            JOptionPane.showMessageDialog(null,
                    "This number is divisible by 7 only.",
                    "Content 06 | Exercise 05",
                    JOptionPane.INFORMATION_MESSAGE);
            
        else if (number % 5 != 0 && number % 7 != 0)
            JOptionPane.showMessageDialog(null,
                    "This number is divisible by neither 5 nor 7.",
                    "Content 06 | Exercise 05",
                    JOptionPane.INFORMATION_MESSAGE);
    }
}
```

</details>
