<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2005/Exerc%C3%ADcio%2002">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2005">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 02 · Sphere area and volume

## Description

**Statement summary:** Read a sphere radius and calculate its surface area and volume using π = 3.1416.

**Supplied source:** [C05ex02.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/FirstStage/C05ex02.java).

## Solution

Apply 4πr² for the surface area and (4/3)πr³ for the volume, using floating point division.

[Source file: C05ex02.java](https://github.com/guihn/Academic-Projects/blob/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2005/Exercise%2002/src/C05ex02.java) · [Download](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2005/Exercise%2002/src/C05ex02.java)

<details>
<summary>💻 | Java code</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Apply 4πr² for the surface area and (4/3)πr³ for the volume, using floating point division.
 *
 * Assignment: C05ex02.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C05ex02 {

    static void main() {

        String raiostr;

        double pi = 3.1416, raio, area, volume;

        // Input: collect the requested values through dialog boxes.
        raiostr = JOptionPane.showInputDialog(null,
                "Enter the radius:",
                "Content 05 | Exercise 02",
                JOptionPane.QUESTION_MESSAGE);

        raio = Double.valueOf(raiostr);

        // Processing: Apply 4πr² for the surface area and (4/3)πr³ for the volume, using floating
        // point division.
        area = 4 * pi * Math.pow(raio, 2);

        volume = 4.0 / 3.0 * pi * Math.pow(raio, 3);

        // Output: display the message for the current result.
        JOptionPane.showMessageDialog(null,
                "Area: " + area + "\nVolume: " + volume,
                "Content 05 | Exercise 02",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
```

</details>
