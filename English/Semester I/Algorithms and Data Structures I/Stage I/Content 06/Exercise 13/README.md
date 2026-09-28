<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2013">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 13 · Game duration

## Description

**Statement summary:** Read starting and ending hours and minutes for a game that starts and ends on the same day.

## Solution

Subtract the times and borrow one hour when the minute difference is negative.

Source file: [C06ex13.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006/Exercise%2013/src/C06ex13.java)

<details>
<summary>💻 | Java code</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Subtract the times and borrow one hour when the minute difference is negative.
 *
 * Assignment: C06ex13.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex13 {

    static void main() {

        String initialHourStr, initialMinuteStr, finalHourStr, finalMinuteStr;

        int initialHour, initialMinute, finalHour, finalMinute, durationHour, durationMinute;

        // Input: collect the requested values through dialog boxes.
        initialHourStr = JOptionPane.showInputDialog(null,
                "Enter the starting hour: ",
                "Content 06 | Exercise 13",
                JOptionPane.QUESTION_MESSAGE);

        initialMinuteStr = JOptionPane.showInputDialog(null,
                "Enter the starting minute: ",
                "Content 06 | Exercise 13",
                JOptionPane.QUESTION_MESSAGE);

        finalHourStr = JOptionPane.showInputDialog(null,
                "Enter the ending hour: ",
                "Content 06 | Exercise 13",
                JOptionPane.QUESTION_MESSAGE);

        finalMinuteStr = JOptionPane.showInputDialog(null,
                "Enter the ending minute: ",
                "Content 06 | Exercise 13",
                JOptionPane.QUESTION_MESSAGE);

        initialHour = Integer.valueOf(initialHourStr);
        initialMinute = Integer.valueOf(initialMinuteStr);
        finalHour = Integer.valueOf(finalHourStr);
        finalMinute = Integer.valueOf(finalMinuteStr);

        // Processing: Subtract the times and borrow one hour when the minute difference is
        // negative.
        durationHour = finalHour - initialHour;
        durationMinute = finalMinute - initialMinute;

        // Borrow one hour and convert it to 60 minutes.
        if (durationMinute < 0) {
            durationHour = durationHour - 1;
            durationMinute = durationMinute + 60;
        }

        else {
            durationHour = durationHour;
            durationMinute = durationMinute;
        }

        // Output: display the message for the current result.
        JOptionPane.showMessageDialog(null,
                "Duration: " + durationHour + " hours and " + durationMinute + " minutes.");
    }
}
```

</details>
