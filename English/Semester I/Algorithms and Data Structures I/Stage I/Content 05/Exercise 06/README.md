<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2005/Exerc%C3%ADcio%2006">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2005">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 06 · Distance from a point to a line

## Description

**Statement summary:** Read line coefficients A, B and C and the coordinates of a point to calculate the distance between them.

**Supplied source:** [C05ex06.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/FirstStage/C05ex06.java).

## Solution

Divide |Ax + By + C| by the square root of A² + B².

### Implementation notes

There is no check preventing A and B from both being zero.

[Source file: C05ex06.java](https://github.com/guihn/Academic-Projects/blob/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2005/Exercise%2006/src/C05ex06.java) · [Download](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2005/Exercise%2006/src/C05ex06.java)

<details>
<summary>💻 | Java code</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Divide |Ax + By + C| by the square root of A² + B².
 *
 * Assignment: C05ex06.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C05ex06 {

    static void main() {

        String aRStr, bRStr, cRStr, xPStr, yPStr;

        double distance, c1, c2, aR, bR, cR, xP, yP;

        // Input: collect the requested values through dialog boxes.
        aRStr = JOptionPane.showInputDialog(null,
                "Enter coefficient A of line R:",
                "Content 05 | Exercise 06",
                JOptionPane.QUESTION_MESSAGE);

        bRStr = JOptionPane.showInputDialog(null,
                "Enter coefficient B of line R:",
                "Content 05 | Exercise 06",
                JOptionPane.QUESTION_MESSAGE);

        cRStr = JOptionPane.showInputDialog(null,
                "Enter coefficient C of line R:",
                "Content 05 | Exercise 06",
                JOptionPane.QUESTION_MESSAGE);

        xPStr = JOptionPane.showInputDialog(null,
                "Enter the X coordinate of point P:",
                "Content 05 | Exercise 06",
                JOptionPane.QUESTION_MESSAGE);

        yPStr = JOptionPane.showInputDialog(null,
                "Enter the Y coordinate of point P:",
                "Content 05 | Exercise 06",
                JOptionPane.QUESTION_MESSAGE);

        aR = Double.valueOf(aRStr);
        bR = Double.valueOf(bRStr);
        cR = Double.valueOf(cRStr);
        xP = Double.valueOf(xPStr);
        yP = Double.valueOf(yPStr);

        // Processing: Divide |Ax + By + C| by the square root of A² + B².
        c1 = aR * xP + bR * yP + cR;

        c2 = Math.sqrt(Math.pow(aR, 2) + Math.pow(bR, 2));

        distance = Math.abs(c1) / c2;

        // Output: display the message for the current result.
        JOptionPane.showMessageDialog(null,
                "Distance: " + distance,
                "Content 05 | Exercise 06",
                JOptionPane.INFORMATION_MESSAGE);

    }
}
```

</details>
