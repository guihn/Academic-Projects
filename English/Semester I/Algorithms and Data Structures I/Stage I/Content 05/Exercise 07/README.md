<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2005/Exerc%C3%ADcio%2007">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2005">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 07 · Function with roots

## Description

**Statement summary:** Read x and evaluate the function shown in the slide.

**Statement source:** [original lecture slides](https://github.com/guihn/academic-materials/blob/5a9473bbf24a271032a41b141ab6bd435076c1d5/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2005/Algoritmos%20-%20Aulas%20-%20Conte%C3%BAdo%205%20-%20Comando%20de%20ATRIBUI%C3%87%C3%83O%2C%20Express%C3%B5es%20Aritm%C3%A9ticas.pptx), slide(s) 40. [Material folder](https://github.com/guihn/academic-materials/tree/main/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2005).

**Supplied source:** [C05ex07.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/FirstStage/C05ex07.java).

## Solution

Calculate the square root of (x/4 + 1)² plus the real fifth root of x, preserving the sign of the fifth root.

[Source file: C05ex07.java](https://github.com/guihn/Academic-Projects/blob/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2005/Exercise%2007/src/C05ex07.java) · [Download](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2005/Exercise%2007/src/C05ex07.java)

<details>
<summary>💻 | Java code</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Calculate the square root of (x/4 + 1)² plus the real fifth root of x, preserving the sign of
 * the fifth root.
 *
 * Assignment: C05ex07.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C05ex07 {

    static void main() {

        String xStr;

        double x, fx, c1, c2;

        // Input: collect the requested values through dialog boxes.
        xStr = JOptionPane.showInputDialog(null,
                "Enter the value of X:",
                "Content 05 | Exercise 07",
                JOptionPane.QUESTION_MESSAGE);

        x = Double.valueOf(xStr);

        // Processing: Calculate the square root of (x/4 + 1)² plus the real fifth root of x,
        // preserving the sign of the fifth root.
        c1 = Math.pow((x / 4 + 1), 2);

        // Keep the fifth root real for negative x by restoring its sign.
        c2 = Math.copySign(Math.pow(Math.abs(x), 1.0 / 5), x);

        fx = Math.sqrt(c1 + c2);

        // Output: display the message for the current result.
        JOptionPane.showMessageDialog(null,
                "X: " + x + "\nf(x): " + fx,
                "Content 05 | Exercise 07",
                JOptionPane.INFORMATION_MESSAGE);

    }
}
```

</details>
