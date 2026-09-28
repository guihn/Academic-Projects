<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2005/Exerc%C3%ADcio%2004">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2005">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 04 · Distance between two points

## Description

**Statement summary:** Read the coordinates of two points in the Cartesian plane and calculate the distance between them.

## Solution

Compute the square root of the sum of the squared differences between corresponding coordinates.

Source file: [C05ex04.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2005/Exercise%2004/src/C05ex04.java)

<details>
<summary>💻 | Java code</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Compute the square root of the sum of the squared differences between corresponding
 * coordinates.
 *
 * Assignment: C05ex04.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C05ex04 {

    static void main() {

        String x1Str, y1Str, x2Str, y2Str;

        double x1, y1, x2, y2, distance;

        // Input: collect the requested values through dialog boxes.
        x1Str = JOptionPane.showInputDialog(null,
                "Enter X for point 1:",
                "Content 05 | Exercise 04",
                JOptionPane.QUESTION_MESSAGE);

        y1Str = JOptionPane.showInputDialog(null,
                "Enter Y for point 1:",
                "Content 05 | Exercise 04",
                JOptionPane.QUESTION_MESSAGE);

        x2Str = JOptionPane.showInputDialog(null,
                "Enter X for point 2:",
                "Content 05 | Exercise 04",
                JOptionPane.QUESTION_MESSAGE);

        y2Str = JOptionPane.showInputDialog(null,
                "Enter Y for point 2:",
                "Content 05 | Exercise 04",
                JOptionPane.QUESTION_MESSAGE);

        x1 = Double.valueOf(x1Str);
        y1 = Double.valueOf(y1Str);
        x2 = Double.valueOf(x2Str);
        y2 = Double.valueOf(y2Str);

        // Processing: Compute the square root of the sum of the squared differences between
        // corresponding coordinates.
        distance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));

        // Output: display the message for the current result.
        JOptionPane.showMessageDialog(null,
                "Distance: " + distance,
                "Content 05 | Exercise 04",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
```

</details>
