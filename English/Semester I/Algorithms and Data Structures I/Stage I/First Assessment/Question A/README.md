<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Primeira%20Avalia%C3%A7%C3%A3o/Quest%C3%A3o%20A">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/First%20Assessment">Parent&nbsp;folder</a></td>
</tr>
</table>

# Question A · Assessment function calculation

## Description

Code description: read x and combine a power expression with two intermediate variables. The original assessment statement is unavailable.

**Supplied source:** [D30912A.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/FirstStage/FirstTest/D30912A.java).

## Solution

Calculate c1 = 0.75x⁷ − 4, assign (5 + x)/2 to both c3 and c2, then evaluate c1 × c2 + c3.

### Implementation notes

The original lines c2 = and c3 = (5 + x) / 2 form a chained assignment. Without the assessment statement, the intended formula cannot be confirmed.

[Source file: D30912A.java](https://github.com/guihn/Academic-Projects/blob/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/First%20Assessment/Question%20A/src/D30912A.java) · [Download](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/First%20Assessment/Question%20A/src/D30912A.java)

<details>
<summary>💻 | Java code</summary>

```java
package FirstTest;

import javax.swing.JOptionPane;
import java.util.Scanner;

/**
 * Calculate c1 = 0.75x⁷ − 4, assign (5 + x)/2 to both c3 and c2, then evaluate c1 × c2 + c3.
 *
 * Assignment: D30912A.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class D30912A {
    static void main() {
        String xStr;
        double x, fx, c1, c2, c3;

        // Input: collect the requested values through dialog boxes.
        xStr = JOptionPane.showInputDialog(null,
                "Enter the value of X",
                "First Test | Question A",
                JOptionPane.QUESTION_MESSAGE);

        x = Double.valueOf(xStr);

        // Processing: Calculate c1 = 0.75x⁷ − 4, assign (5 + x)/2 to both c3 and c2, then evaluate
        // c1 × c2 + c3.
        c1 = 3.0/4 * Math.pow(x, 7) - 4;
        // The next line continues this chained assignment to c2 and c3.
        c2 =
        c3 = (5 + x) / 2;

        fx = c1 * c2 + c3;

        // Output: display the message for the current result.
        JOptionPane.showMessageDialog(null,
                "X: " + x + "\nf(x): " + fx,
                "First Test | Question A",
                JOptionPane.INFORMATION_MESSAGE);

    }
}
```

</details>
