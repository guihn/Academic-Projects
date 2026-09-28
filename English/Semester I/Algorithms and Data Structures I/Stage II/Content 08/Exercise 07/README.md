<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20II/Conte%C3%BAdo%2008/Exerc%C3%ADcio%2007">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20II/Content%2008">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 07 · Age statistics

## Description

This exercise produces age statistics for a class of fifty students. Every age contributes to the overall mean, but only those meeting the limits enter the specific counters. The requested groups are students aged up to 12 and students older than 30.

## Statement

Read the name and age of 50 students. Calculate and print how many are aged up to 12, how many are older than 30, and the mean of all entered ages.

## Solution

Accumulate all ages, maintain age band counters and divide the total age by the record count.

### Implementation notes

The original condition includes age 30 in the upper group, whereas the statement asks for ages above 30.

Source file: [C08ex07.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20II/Content%2008/Exercise%2007/src/C08ex07.java)

<details>
<summary>💻 | Java code</summary>

```java
package SecondStage;

import javax.swing.JOptionPane;
import java.awt.*;

/**
 * Accumulate all ages, maintain age band counters and divide the total age by the record count.
 *
 * Assignment: C08ex07.
 */
public class C08ex07 {
    static void main() {
        String name, ageStr;
        int age, allages, untiltwelve, higherthirty, rep;
        float mediaOfAllAges;

        allages = 0;
        untiltwelve = 0;
        higherthirty = 0;
        rep = 50;

        // Processing: Accumulate all ages, maintain age band counters and divide the total age by
        // the record count.
        for (int i = 1; i <= rep; i ++) {
            // Input: collect the requested values through dialog boxes.
            name = JOptionPane.showInputDialog(null,
                    "Enter your name:",
                    "Content 08 | Exercise 07",
                    JOptionPane.QUESTION_MESSAGE);
            ageStr = JOptionPane.showInputDialog(null,
                    "Enter your age:",
                    "Content 08 | Exercise 07",
                    JOptionPane.QUESTION_MESSAGE);
            age = Integer.parseInt(ageStr);

            if (age <=12) {
                untiltwelve++;
                allages += age;
            }
            // The original comparison includes age 30 in this group.
            else if (age >=30) {
                higherthirty++;
                allages += age;
            }
            else {
                allages += age;
            }
        }

        mediaOfAllAges = (float) allages / rep;
        // Output: display the message for the current result.
        JOptionPane.showMessageDialog(null,
                "Students aged up to 12: " + untiltwelve + "\nStudents aged above 30: " + higherthirty + "\nAverage of the reported ages: " + mediaOfAllAges );
    }
}
```

</details>
