<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20II/Conte%C3%BAdo%2008/Exerc%C3%ADcio%2008">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20II/Content%2008">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 08 · Grades and attendance statistics

## Description

**Statement summary:** Evaluate 50 students and report the average grade of those who passed and the count with more than 16 absences.

## Solution

Classify each record, update the grade and attendance variables and divide the stored grade value by the pass count.

### Implementation notes

The original uses three records. The assignment allNotesApproved =+ finalNote replaces the previous value instead of accumulating it. The final division is integer division and fails when nobody passes.

Source file: [C08ex08.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20II/Content%2008/Exercise%2008/src/C08ex08.java)

<details>
<summary>💻 | Java code</summary>

```java
package SecondStage;

import javax.swing.JOptionPane;

/**
 * Classify each record, update the grade and attendance variables and divide the stored
 * grade value by the pass count.
 *
 * Assignment: C08ex08.
 */
public class C08ex08 {
    static void main() {
        String finalNoteStr, absensesStr;
        int rep, finalNote, absenses, approved, allNotesApproved, mediaOfAllNotesApproved, over16Absenses;

        rep = 3;
        approved = 0;
        allNotesApproved = 0;
        over16Absenses = 0;

        int i;
        // Processing: Classify each record, update the grade and attendance variables and
        // divide the stored grade value by the pass count.
        for (i = 1; i <= rep; i++) {
            // Input: collect the requested values through dialog boxes.
            finalNoteStr = JOptionPane.showInputDialog(null,
                    "Enter the final grade for student " + i + ": ",
                    "Content 08 | Exercise 08",
                    JOptionPane.QUESTION_MESSAGE);
            absensesStr = JOptionPane.showInputDialog(null,
                    "Enter the number of absences for student " + i + ": ",
                    "Content 08 | Exercise 08",
                    JOptionPane.QUESTION_MESSAGE);

            finalNote = Integer.parseInt(finalNoteStr);
            absenses = Integer.parseInt(absensesStr);

            if (finalNote >= 65 && absenses <= 16) {
                approved++;
                // Output: display the message for the current result.
                JOptionPane.showMessageDialog(null,
                        "You PASSED!",
                        "Content 08 | Exercise 08",
                        JOptionPane.INFORMATION_MESSAGE);
                // The original =+ applies unary plus and assigns the value; it does not accumulate
                // like +=.
                allNotesApproved =+ finalNote;
            }
            else if (absenses > 16) {
                over16Absenses++;
                JOptionPane.showMessageDialog(null,
                        "You FAILED!",
                        "Content 08 | Exercise 08",
                        JOptionPane.ERROR_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog(null,
                        "You FAILED!",
                        "Content 08 | Exercise 08",
                        JOptionPane.ERROR_MESSAGE);
        }

        // This integer division has no guard for a zero pass count.
        mediaOfAllNotesApproved = allNotesApproved / approved;
        JOptionPane.showMessageDialog(null,
                "Average grade of students who passed: " + mediaOfAllNotesApproved + "\nNumber of students with more than 16 absences: " + over16Absenses);
    }
}
```

</details>
