<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2005/Exerc%C3%ADcio%2009">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2005">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 09 · Weighted mean

## Description

**Statement summary:** Read three grades and calculate their mean with respective weights 2, 3 and 5.

**Statement source:** [original lecture slides](https://github.com/guihn/academic-materials/blob/5a9473bbf24a271032a41b141ab6bd435076c1d5/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2005/Algoritmos%20-%20Aulas%20-%20Conte%C3%BAdo%205%20-%20Comando%20de%20ATRIBUI%C3%87%C3%83O%2C%20Express%C3%B5es%20Aritm%C3%A9ticas.pptx), slide(s) 42. [Material folder](https://github.com/guihn/academic-materials/tree/main/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2005).

**Supplied source:** [C05ex09.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/FirstStage/C05ex09.java).

## Solution

Multiply each grade by its weight, add the products and divide by the sum of the weights.

[Source file: C05ex09.java](https://github.com/guihn/Academic-Projects/blob/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2005/Exercise%2009/src/C05ex09.java) · [Download](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2005/Exercise%2009/src/C05ex09.java)

<details>
<summary>💻 | Java code</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Multiply each grade by its weight, add the products and divide by the sum of the weights.
 *
 * Assignment: C05ex09.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C05ex09 {

    static void main() {

        String note1Str, note2Str, note3Str;

        double note1, note2, note3, weightedAverage, weightedSum;

        // Input: collect the requested values through dialog boxes.
        note1Str = JOptionPane.showInputDialog(null,
                "Enter the first grade:",
                "Content 05 | Exercise 09",
                JOptionPane.QUESTION_MESSAGE);

        note2Str = JOptionPane.showInputDialog(null,
                "Enter the second grade:",
                "Content 05 | Exercise 09",
                JOptionPane.QUESTION_MESSAGE);

        note3Str = JOptionPane.showInputDialog(null,
                "Enter the third grade:",
                "Content 05 | Exercise 09",
                JOptionPane.QUESTION_MESSAGE);

        note1 = Double.valueOf(note1Str);
        note2 = Double.valueOf(note2Str);
        note3 = Double.valueOf(note3Str);

        // Processing: Multiply each grade by its weight, add the products and divide by the sum of
        // the weights.
        weightedSum = (note1 * 2) + (note2 * 3) + (note3 * 5);

        weightedAverage = weightedSum / (2 + 3 + 5);

        // Output: display the message for the current result.
        JOptionPane.showMessageDialog(null,
                "Average: " + weightedAverage,
                "Content 05 | Exercise 09",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
```

</details>
