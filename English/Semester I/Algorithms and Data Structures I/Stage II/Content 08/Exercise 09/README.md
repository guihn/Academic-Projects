<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20II/Conte%C3%BAdo%2008/Exerc%C3%ADcio%2009">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20II/Content%2008">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 09 · Average ages by sex

## Description

**Statement summary:** Read the number of participants, then their names, ages and M/F options, and calculate a separate average age for each group.

**Supplied source:** [C08ex09.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/SecondStage/C08ex09.java).

## Solution

Accumulate ages and counts for the recognized M and F options, then calculate the two floating point averages.

### Implementation notes

The accepted input tokens remain M, Masculino, F and Feminino in both versions. A group with no participants produces NaN because there is no zero-count check.

[Source file: C08ex09.java](https://github.com/guihn/Academic-Projects/blob/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20II/Content%2008/Exercise%2009/src/C08ex09.java) · [Download](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20II/Content%2008/Exercise%2009/src/C08ex09.java)

<details>
<summary>💻 | Java code</summary>

```java
package SecondStage;

import javax.swing.JOptionPane;

/**
 * Accumulate ages and counts for the recognized M and F options, then calculate the two floating
 * point averages.
 *
 * Assignment: C08ex09.
 */
public class C08ex09 {
    static void main() {
        String repStr, name, ageStr, gender;
        int rep, age, mans, womens, mansAges, womensAges;
        float mansMedia, womensMedia;

        gender = "";
        // Processing: Accumulate ages and counts for the recognized M and F options, then calculate
        // the two floating point averages.
        mans = 0;
        womens = 0;
        mansAges = 0;
        womensAges = 0;

        // Input: collect the requested values through dialog boxes.
        repStr = JOptionPane.showInputDialog(null,
                "Enter the number of people taking part in the survey: ",
                "Content 08 | Exercise 09",
                JOptionPane.QUESTION_MESSAGE);
        rep = Integer.parseInt(repStr);

        for (int i = 1; i <= rep; i ++) {
            name = JOptionPane.showInputDialog(null,
                    "Enter the name of person " + i + ": ",
                    "Content 08 | Exercise 09",
                    JOptionPane.QUESTION_MESSAGE);
            ageStr = JOptionPane.showInputDialog(null,
                    "Enter the age of person " + i + ": ",
                    "Content 08 | Exercise 09",
                    JOptionPane.QUESTION_MESSAGE);
            gender = JOptionPane.showInputDialog(null,
                    "Enter the sex of person " + i + ": ",
                    "Content 08 | Exercise 09",
                    JOptionPane.QUESTION_MESSAGE);
            age = Integer.parseInt(ageStr);
            if (gender.equalsIgnoreCase("M") || gender.equalsIgnoreCase("Masculino")) {
                mansAges += age;
                mans++;
            } else if (gender.equalsIgnoreCase("F") || gender.equalsIgnoreCase("Feminino")) {
                womensAges += age;
                womens++;
            } else {
                // Output: display the message for the current result.
                JOptionPane.showMessageDialog(null,
                        "You entered an invalid character or sex! This person was excluded. Try 'M' or 'Masculino', 'F' or 'Feminino'",
                        "Content 08 | Exercise 09",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

        mansMedia = (float) mansAges / mans;
        womensMedia = (float) womensAges / womens;

        JOptionPane.showMessageDialog(null,
                "The average age of men is: " + mansMedia + "\nThe average age of women is: " + womensMedia);
    }
}
```

</details>
