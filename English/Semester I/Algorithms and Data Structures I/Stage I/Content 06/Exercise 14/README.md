<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2014">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 14 · Reverse four digits

## Description

**Statement summary:** Validate that an integer has four digits and display those digits in reverse order.

**Statement source:** [original lecture slides](https://github.com/guihn/academic-materials/blob/5a9473bbf24a271032a41b141ab6bd435076c1d5/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2006/Algoritmos%20-%20Aulas%20-%20Conte%C3%BAdo%206%20-%20Comando%20Condicional%20%E2%80%93%20IF%2C%20Express%C3%B5es%20Booleanas.pptx), slide(s) 56. [Material folder](https://github.com/guihn/academic-materials/tree/main/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2006).

**Supplied source:** [C06ex14.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/FirstStage/C06ex14.java).

## Solution

Reject values outside 1000–9999, extract the digits and concatenate them from units to thousands.

### Implementation notes

The original input prompt asks for five digits and some dialog titles say Content 05, although the validation and assignment belong to four digits and Content 06.

[Source file: C06ex14.java](https://github.com/guihn/Academic-Projects/blob/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006/Exercise%2014/src/C06ex14.java) · [Download](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006/Exercise%2014/src/C06ex14.java)

<details>
<summary>💻 | Java code</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Reject values outside 1000–9999, extract the digits and concatenate them from units to
 * thousands.
 *
 * Assignment: C06ex14.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex14 {

    static void main() {

        String numberStr;

        int number, d1, d2, d3, d4;

        // Input: collect the requested values through dialog boxes.
        numberStr = JOptionPane.showInputDialog(null,
                "Enter a number (5 digits):",
                "Content 05 | Exercise 14",
                JOptionPane.QUESTION_MESSAGE);

        number = Integer.valueOf(numberStr);

        // Processing: Reject values outside 1000–9999, extract the digits and concatenate them from
        // units to thousands.
        if (number < 1000 || number > 9999) {
            // Output: display the message for the current result.
            JOptionPane.showMessageDialog(null,
                    "THE NUMBER MUST HAVE 4 DIGITS",
                    "Content 06 | Exercise 14",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        d1 = number / 1000 % 10;

        d2 = number / 100 % 10;

        d3 = number / 10 % 10;

        d4 = number % 10;

        JOptionPane.showMessageDialog(null,
                "Printed number: " + d4 + d3 + d2 + d1,
                "Content 05 | Exercise 14",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
```

</details>
