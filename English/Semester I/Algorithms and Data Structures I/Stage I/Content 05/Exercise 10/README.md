<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2005/Exerc%C3%ADcio%2010">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2005">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 10 · Vertical digits

## Description

**Statement summary:** Read a five digit integer and display one digit per line.

**Statement source:** [original lecture slides](https://github.com/guihn/academic-materials/blob/5a9473bbf24a271032a41b141ab6bd435076c1d5/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2005/Algoritmos%20-%20Aulas%20-%20Conte%C3%BAdo%205%20-%20Comando%20de%20ATRIBUI%C3%87%C3%83O%2C%20Express%C3%B5es%20Aritm%C3%A9ticas.pptx), slide(s) 54–55. [Material folder](https://github.com/guihn/academic-materials/tree/main/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2005).

**Supplied source:** [C05ex10.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/FirstStage/C05ex10.java).

## Solution

Use integer division and remainders to extract digits from the highest place to the units.

[Source file: C05ex10.java](https://github.com/guihn/Academic-Projects/blob/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2005/Exercise%2010/src/C05ex10.java) · [Download](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2005/Exercise%2010/src/C05ex10.java)

<details>
<summary>💻 | Java code</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Use integer division and remainders to extract digits from the highest place to the units.
 *
 * Assignment: C05ex10.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C05ex10 {

    static void main() {

        String numberStr;

        int number, d1, d2, d3, d4, d5;

        // Input: collect the requested values through dialog boxes.
        numberStr = JOptionPane.showInputDialog(null,
                "Enter a number (5 digits):",
                "Content 05 | Exercise 10",
                JOptionPane.QUESTION_MESSAGE);

        number = Integer.valueOf(numberStr);

        // Processing: Use integer division and remainders to extract digits from the highest place
        // to the units.
        d1 = number / 10000;

        d2 = number / 1000 % 10;

        d3 = number / 100 % 10;

        d4 = number / 10 % 10;

        d5 = number % 10;

        // Output: display the message for the current result.
        JOptionPane.showMessageDialog(null,
                "Printed number:\n" + d1 + "\n" + d2 + "\n" + d3 + "\n" + d4 + "\n" + d5,
                "Content 05 | Exercise 10",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
```

</details>
