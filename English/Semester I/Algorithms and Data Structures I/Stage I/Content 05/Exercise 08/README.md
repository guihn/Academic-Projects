<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2005/Exerc%C3%ADcio%2008">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2005">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 08 · Circular sector radius

## Description

**Statement summary:** Read the area and angle of a circular sector and calculate its radius with π = 3.1416.

## Solution

Calculate the square root of 360S divided by απ, with the angle in degrees.

Source file: [C05ex08.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2005/Exercise%2008/src/C05ex08.java)

<details>
<summary>💻 | Java code</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Calculate the square root of 360S divided by απ, with the angle in degrees.
 *
 * Assignment: C05ex08.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C05ex08 {

    static void main() {

        String sStr, aStr;

        double s, a, pi, r;

        pi = 3.1416;

        // Input: collect the requested values through dialog boxes.
        sStr = JOptionPane.showInputDialog(null,
                "Enter the area of a circular sector:",
                "Content 05 | Exercise 08",
                JOptionPane.QUESTION_MESSAGE);

        aStr = JOptionPane.showInputDialog(null,
                "Enter the angle:",
                "Content 05 | Exercise 08",
                JOptionPane.QUESTION_MESSAGE);

        s = Double.valueOf(sStr);
        a = Double.valueOf(aStr);

        // Processing: Calculate the square root of 360S divided by απ, with the angle in degrees.
        r = Math.sqrt((360 * s) / (a * pi));

        // Output: display the message for the current result.
        JOptionPane.showMessageDialog(null,
                "S: " + s + " A: " + a + " R: " + r,
                "Content 05 | Exercise 08",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
```

</details>
