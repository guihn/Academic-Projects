<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2005/Exerc%C3%ADcio%2009">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2005">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 09 · Weighted mean

## Description

This exercise calculates a final grade in which three assessments have different importance. Grades must be read in the order of weights 2, 3 and 5 so each contributes correctly to the result. The weighted sum is divided by 10, the sum of the weights, and the final mean is displayed.

## Statement

Read a student's three grades, then calculate and print their weighted mean. Use weights 2, 3 and 5 respectively:

$$M = \frac{2N_1+3N_2+5N_3}{10}$$

## Solution

Multiply each grade by its weight, add the products and divide by the sum of the weights.

Source file: [C05ex09.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2005/Exercise%2009/src/C05ex09.java)

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
