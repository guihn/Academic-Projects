<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2008">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 08 · Weight interval from BMI

## Description

**Statement summary:** Read name and height and calculate the weights corresponding to BMI values 20 and 25 in the exercise table.

## Solution

Multiply squared height by 20 and 25 to obtain the two endpoints.

Source file: [C06ex08.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006/Exercise%2008/src/C06ex08.java)

<details>
<summary>💻 | Java code</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Multiply squared height by 20 and 25 to obtain the two endpoints.
 *
 * Assignment: C06ex08.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex08 {

    static void main() {

        String name, heightStr;

        double height, weight, weightMin, weightMax;

        // Input: collect the requested values through dialog boxes.
        name = JOptionPane.showInputDialog(null,
                "Enter your name:",
                "Content 06 | Exercise 08",
                JOptionPane.QUESTION_MESSAGE);

        heightStr = JOptionPane.showInputDialog(null,
                "Enter your height:",
                "Content 06 | Exercise 08",
                JOptionPane.QUESTION_MESSAGE);

        height = Double.valueOf(heightStr);

        // Processing: Multiply squared height by 20 and 25 to obtain the two endpoints.
        weightMin = 20 * Math.pow(height, 2);

        weightMax = 25 * Math.pow(height, 2);

        // Output: display the message for the current result.
        JOptionPane.showMessageDialog(null,
                "Minimum weight: " + weightMin + "\nMaximum weight: " + weightMax,
                "Content 06 | Exercise 08",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
```

</details>
