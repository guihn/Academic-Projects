<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2005/Exerc%C3%ADcio%2001">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2005">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 01 · Polynomial function

## Description

The program evaluates a polynomial for a real value of x chosen by the user. The calculation combines a cubic power, a linear term and a constant while respecting operator precedence. The output associates the input value with the function result.

## Statement

Read x, then calculate and display the function:

$$f(x) = x^3 + 4x + 10$$

## Solution

Evaluate x³ + 4x + 10 using Math.pow for the cubic term.

Source file: [C05ex01.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2005/Exercise%2001/src/C05ex01.java)

<details>
<summary>💻 | Java code</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Evaluate x³ + 4x + 10 using Math.pow for the cubic term.
 *
 * Assignment: C05ex01.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C05ex01 {

    static void main() {

        String xStr;

        int x;

        double fx;

        // Input: collect the requested values through dialog boxes.
        xStr = JOptionPane.showInputDialog(null,
                "Enter the value of X:",
                "Content 05 | Exercise 01",
                JOptionPane.QUESTION_MESSAGE);

        x = Integer.valueOf(xStr);

        // Processing: Evaluate x³ + 4x + 10 using Math.pow for the cubic term.
        fx = 1 * Math.pow(x, 3) + 4 * x + 10;

        // Output: display the message for the current result.
        JOptionPane.showMessageDialog(null,
                "X = " + xStr + " -> f(x) = " + fx,
                "Content 05 | Exercise 01",
                JOptionPane.INFORMATION_MESSAGE);

    }
}
```

</details>
