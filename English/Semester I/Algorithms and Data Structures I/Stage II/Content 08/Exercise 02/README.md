<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20II/Conte%C3%BAdo%2008/Exerc%C3%ADcio%2002">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20II/Content%2008">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 02 · Student pass or fail

## Description

This exercise checks the status of up to fifty students using grade and attendance together. Passing requires meeting the minimum grade and staying within the absence limit. The special grade input −1 must end reading before the full class is processed, acting as a sentinel.

## Statement

Read the final grade and absence count of up to 50 students. For each student, report passed when the grade is at least 65 and absences do not exceed 16; otherwise report failed. Stop the repetitions if the entered grade is −1.

## Solution

Read each record inside a loop, interrupt on the implemented negative thresholds and test the grade and attendance together.

### Implementation notes

The original code stops for grade or absences less than or equal to −1. The statement specifies −1 in the grade field.

Source file: [C08ex02.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20II/Content%2008/Exercise%2002/src/C08ex02.java)

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
