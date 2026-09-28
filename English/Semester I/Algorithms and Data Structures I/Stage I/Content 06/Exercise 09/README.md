<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2009">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 09 · Weight formulas by sex

## Description

**Statement summary:** Read height and the M or F option and apply the corresponding weight formula from the exercise.

**Supplied source:** [C06ex09.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/FirstStage/C06ex09.java).

## Solution

Use 72.7h − 58 for M and 62.1h − 44.7 for F, reporting other inputs as invalid.

[Source file: C06ex09.java](https://github.com/guihn/Academic-Projects/blob/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006/Exercise%2009/src/C06ex09.java) · [Download](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006/Exercise%2009/src/C06ex09.java)

<details>
<summary>💻 | Java code</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Use 72.7h − 58 for M and 62.1h − 44.7 for F, reporting other inputs as invalid.
 *
 * Assignment: C06ex09.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex09 {

    static void main() {

        String heightStr, genderStr;

        double height, idealHeightF, idealHeightM;

        // Input: collect the requested values through dialog boxes.
        heightStr = JOptionPane.showInputDialog(null,
                "Enter your height (in meters):",
                "Content 06 | Exercise 09",
                JOptionPane.QUESTION_MESSAGE);

        genderStr = JOptionPane.showInputDialog(null,
                "Enter your biological sex (M or F):",
                "Content 06 | Exercise 09",
                JOptionPane.QUESTION_MESSAGE);

        height = Double.valueOf(heightStr);

        // Processing: Use 72.7h − 58 for M and 62.1h − 44.7 for F, reporting other inputs as
        // invalid.
        if (genderStr.equals("M")) {
            idealHeightM = 72.7 * height - 58;

            // Output: display the message for the current result.
            JOptionPane.showMessageDialog(null,
                    "Ideal weight: " + idealHeightM,
                    "Content 06 | Exercise 09",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        
        else if (genderStr.equals("F")) {
            idealHeightF = 62.1 * height - 44.7;

            JOptionPane.showMessageDialog(null,
                    "Ideal weight: " + idealHeightF,
                    "Content 06 | Exercise 09",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        
        else
            JOptionPane.showMessageDialog(null,
                    "Invalid sex.",
                    "Content 06 | Exercise 09",
                    JOptionPane.INFORMATION_MESSAGE);

    }
}
```

</details>
