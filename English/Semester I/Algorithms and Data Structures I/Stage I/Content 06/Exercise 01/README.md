<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2001">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 01 · Piecewise function

## Description

The program evaluates a piecewise function by choosing an expression according to whether x is less than, equal to or greater than 4. The two open intervals share a numerator but use different square-root denominators. At x = 4, the result is defined directly as zero.

## Statement

Read x, then calculate and print f(x) according to this definition:

$$f(x)=\begin{cases}\dfrac{5x+3}{\sqrt{16-x^2}}, & x<4 \\ 0, & x=4 \\ \dfrac{5x+3}{\sqrt{x^2-16}}, & x>4\end{cases}$$

## Solution

Calculate the two expressions, then select the first for x < 4, zero for x = 4 or the second for x > 4.

### Implementation notes

Both expressions are evaluated before the conditional. Some inputs produce a negative square-root argument or a zero denominator.

Source file: [C06ex01.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006/Exercise%2001/src/C06ex01.java)

<details>
<summary>💻 | Java code</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Calculate the two expressions, then select the first for x &lt; 4, zero for x = 4 or the
 * second for x &gt; 4.
 *
 * Assignment: C06ex01.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex01 {

    static void main() {

        String xStr;

        double x, fx, c1, c2;

        // Input: collect the requested values through dialog boxes.
        xStr = JOptionPane.showInputDialog(null,
                "Enter the value of X:",
                "Content 06 | Exercise 01",
                JOptionPane.QUESTION_MESSAGE);

        x = Double.valueOf(xStr);

        // Processing: Calculate the two expressions, then select the first for x < 4, zero for x =
        // 4 or the second for x > 4.
        c1 = (5 * x + 3) / Math.sqrt(16 - Math.pow(x, 2));

        c2 = (5 * x + 3) / Math.sqrt(Math.pow(x, 2) - 16);

        if (x < 4)
            fx = c1;
            
        else if (x == 4)
            fx = 0;
            
        else
            fx = c2;

        // Output: display the message for the current result.
        JOptionPane.showMessageDialog(null,
                "f(x): " + fx,
                "Content 06 | Exercise 01",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
```

</details>
