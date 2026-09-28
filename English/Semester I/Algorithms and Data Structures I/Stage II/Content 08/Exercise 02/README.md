<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20II/Conte%C3%BAdo%2008/Exerc%C3%ADcio%2002">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20II/Content%2008">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 02 · Student pass or fail

## Description

**Statement summary:** Read final grade and absences for up to 50 students. Passing requires grade at least 65 and at most 16 absences. Stop when the grade is −1.

**Statement source:** [original lecture slides](https://github.com/guihn/academic-materials/blob/5a9473bbf24a271032a41b141ab6bd435076c1d5/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20II/Contents/Content%2008/Algoritmos%20-%20Aulas%20-%20Conte%C3%BAdo%208%20-%20Comando%20de%20Repeti%C3%A7%C3%A3o%20%E2%80%93%20FOR.pptx), slide(s) 26. [Material folder](https://github.com/guihn/academic-materials/tree/main/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20II/Contents/Content%2008).

**Supplied source:** [C08ex02.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/SecondStage/C08ex02.java).

## Solution

Read each record inside a loop, interrupt on the implemented negative thresholds and test the grade and attendance together.

### Implementation notes

The original code stops for grade or absences less than or equal to −1. The statement specifies −1 in the grade field.

[Source file: C08ex02.java](https://github.com/guihn/Academic-Projects/blob/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20II/Content%2008/Exercise%2002/src/C08ex02.java) · [Download](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20II/Content%2008/Exercise%2002/src/C08ex02.java)

<details>
<summary>💻 | Java code</summary>

```java
package SecondStage;

import javax.swing.JOptionPane;

/**
 * Read each record inside a loop, interrupt on the implemented negative thresholds and test the
 * grade and attendance together.
 *
 * Assignment: C08ex02.
 */
public class C08ex02 {
    static void main() {
        String finalNoteStr, abscensesStr;
        double finalNote, abscenses;

        // Processing: Read each record inside a loop, interrupt on the implemented negative
        // thresholds and test the grade and attendance together.
        for (int i = 1; i <=50; i ++) {
        // Input: collect the requested values through dialog boxes.
        finalNoteStr = JOptionPane.showInputDialog(null,
                "Enter the student's final grade: ",
                "Content 08 | Exercise 02",
                JOptionPane.QUESTION_MESSAGE);

            finalNote = Double.valueOf(finalNoteStr);

            if (finalNote <= -1) {
                // Output: display the message for the current result.
                JOptionPane.showMessageDialog(null,
                        "The program ended because negative numbers were used.",
                        "Content 08 | Exercise 02",
                        JOptionPane.ERROR_MESSAGE);
                break;
            } else {
                abscensesStr = JOptionPane.showInputDialog(null,
                        "Enter the student's number of absences: ",
                        "Content 08 | Exercise 02",
                        JOptionPane.QUESTION_MESSAGE);

                abscenses = Double.valueOf(abscensesStr);

                if (abscenses <= -1) {
                    JOptionPane.showMessageDialog(null,
                            "The program ended because negative numbers were used.",
                            "Content 08 | Exercise 02",
                            JOptionPane.ERROR_MESSAGE);
                    break;
                } else {

                    if (finalNote >= 65 && abscenses <= 16) {
                        JOptionPane.showMessageDialog(null,
                                "Student passed!",
                                "Content 08 | Exercise 02",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else
                        JOptionPane.showMessageDialog(null,
                                "Student failed!",
                                "Content 08 | Exercise 02",
                                JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
```

</details>
