<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20II/Conte%C3%BAdo%2008/Exerc%C3%ADcio%2004">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20II/Content%2008">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 04 · Students by age band

## Description

This exercise divides a class into two age bands. Name and age are read for each person, and age determines which counter to increment. Age 18 belongs to the first band so each student is counted exactly once.

## Statement

Read the name and age of all 50 students in a class. Calculate and print the number aged up to 18 and the number older than 18.

## Solution

Increment one of two counters according to each reported age.

### Implementation notes

The original loop processes five students, as in the reduced slide example.

Source file: [C08ex04.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20II/Content%2008/Exercise%2004/src/C08ex04.java)

<details>
<summary>💻 | Java code</summary>

```java
package SecondStage;

import javax.swing.JOptionPane;

/**
 * Increment one of two counters according to each reported age.
 *
 * Assignment: C08ex04.
 */
public class C08ex04 {
    static void main() {
        String name, ageStr;
        int age, lowerthan18 = 0, higherthan18 = 0;

        // Processing: Increment one of two counters according to each reported age.
        for (int students = 1; students <= 5; students ++) {
            // Input: collect the requested values through dialog boxes.
            name = JOptionPane.showInputDialog(null,
                    "Enter your name: ",
                    "Content 08 | Exercise 04",
                    JOptionPane.QUESTION_MESSAGE);
            ageStr = JOptionPane.showInputDialog(null,
                    "Enter your age: ",
                    "Content 08 | Exercise 04",
                    JOptionPane.QUESTION_MESSAGE);

            age = Integer.valueOf(ageStr);

            if (age <= 18) {
                lowerthan18++;
            }
            else {
                higherthan18++;
            }
        }
        // Output: display the message for the current result.
        JOptionPane.showMessageDialog(null,
                "Up to 18: " + lowerthan18 + "\nAbove 18: " + higherthan18,
                "Content 08 | Exercise 04",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
```

</details>
