<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20II/Conte%C3%BAdo%2008/Exerc%C3%ADcio%2001">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20II/Content%2008">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 01 · Areas of ten circles

## Description

The program applies the same area calculation to ten consecutive circles. Each iteration requests a radius and displays its area before the next input. The exercise introduces a fixed-count loop without requiring all radii to be stored at once.

## Statement

Request the radii of 10 circles. For each radius R, calculate and print $A=\pi R^2$, using π = 3.1416.

## Solution

Repeat the input and area calculation ten times, displaying each result inside the loop.

Source file: [C08ex01.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20II/Content%2008/Exercise%2001/src/C08ex01.java)

<details>
<summary>💻 | Java code</summary>

```java
package SecondStage;

import javax.swing.JOptionPane;

/**
 * Repeat the input and area calculation ten times, displaying each result inside the loop.
 *
 * Assignment: C08ex01.
 */
public class C08ex01 {
    static void main() {
        String rayStr;
        double ray, pi = 3.1416, area;

        // Processing: Repeat the input and area calculation ten times, displaying each result
        // inside the loop.
        for (int i = 1; i <=10; i++) {
            // Input: collect the requested values through dialog boxes.
            rayStr = JOptionPane.showInputDialog(null,
                    "Enter the circle radius: ",
                    "Content 08 | Exercise 01",
                    JOptionPane.QUESTION_MESSAGE);
            ray = Double.valueOf(rayStr);

            area = pi * Math.pow(ray, 2);

            // Output: display the message for the current result.
            JOptionPane.showMessageDialog(null,
                    "Area: " + area,
                    "Content 08 | Exercise 01",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
```

</details>
