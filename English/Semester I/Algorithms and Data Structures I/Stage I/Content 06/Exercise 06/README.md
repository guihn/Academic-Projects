<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2006">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 06 · Quadratic equation roots

## Description

This exercise calculates the real roots of a quadratic equation from coefficients A, B and C. The discriminant determines whether there are two distinct roots, a repeated root or no real roots. The program must present the result appropriate to the identified case.

## Statement

Request A, B and C for $f(x)=Ax^2+Bx+C$, then calculate and print its real roots using the quadratic formula:

$$\Delta=B^2-4AC \qquad x=\frac{-B\pm\sqrt{\Delta}}{2A}$$

Distinguish negative, zero and positive discriminants.

## Solution

Calculate the discriminant and report no real roots, one repeated root or two distinct roots.

### Implementation notes

The program assumes A is nonzero and does not validate that condition.

Source file: [C06ex06.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006/Exercise%2006/src/C06ex06.java)

<details>
<summary>💻 | Java code</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Calculate the discriminant and report no real roots, one repeated root or two distinct roots.
 *
 * Assignment: C06ex06.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex06 {

    static void main() {

        String aStr, bStr, cStr;

        double a, b, c, fx, delta, c1, c2;

        // Input: collect the requested values through dialog boxes.
        aStr = JOptionPane.showInputDialog(null,
                "Enter the value of A:",
                "Content 06 | Exercise 06",
                JOptionPane.QUESTION_MESSAGE);

        bStr = JOptionPane.showInputDialog(null,
                "Enter the value of B:",
                "Content 06 | Exercise 06",
                JOptionPane.QUESTION_MESSAGE);

        cStr = JOptionPane.showInputDialog(null,
                "Enter the value of C:",
                "Content 06 | Exercise 06",
                JOptionPane.QUESTION_MESSAGE);

        a = Double.valueOf(aStr);
        b = Double.valueOf(bStr);
        c = Double.valueOf(cStr);

        // Processing: Calculate the discriminant and report no real roots, one repeated root or two
        // distinct roots.
        delta = Math.pow(b, 2) - (4 * a * c);

        if (delta < 0) {
            // Output: display the message for the current result.
            JOptionPane.showMessageDialog(null,
                    "There are no real roots",
                    "Content 06 | Exercise 06",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {

            c1 = (-b + Math.sqrt(delta)) / (2 * a);
            c2 = (-b - Math.sqrt(delta)) / (2 * a);

            if (c1 == c2) {
                JOptionPane.showMessageDialog(null,
                        "There is 1 root = " + c1,
                        "Content 06 | Exercise 06",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                
                JOptionPane.showMessageDialog(null,
                        "There are 2 roots = " + c1 + " and " + c2,
                        "Content 06 | Exercise 06",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
```

</details>
