<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2016">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 16 · Final grade classification

## Description

**Statement summary:** Use the two highest test grades, final assignment, absences and age to calculate and classify the final score according to the exercise tables.

## Solution

Discard the lowest test grade, choose both weights and classify the weighted expression across the five score bands.

Source file: [C06ex16.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006/Exercise%2016/src/C06ex16.java)

<details>
<summary>💻 | Java code</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Discard the lowest test grade, choose both weights and classify the weighted expression across
 * the five score bands.
 *
 * Assignment: C06ex16.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex16 {

    static void main() {

        String absencesStr, firstTestStr, secondTestStr, thirdTestStr, finalWorkStr, studentAgeStr;

        int absences, weightOne, weightTwo, studentAge;

        double firstTest, secondTest, thirdTest, highestNoteOne, highestNoteTwo, finalWork, finalNote;

        // Input: collect the requested values through dialog boxes.
        absencesStr = JOptionPane.showInputDialog(null,
                "Enter the number of absences: ",
                "Content 06 | Exercise 16",
                JOptionPane.QUESTION_MESSAGE);

        firstTestStr = JOptionPane.showInputDialog(null,
                "Enter the first test grade: ",
                "Content 06 | Exercise 16",
                JOptionPane.QUESTION_MESSAGE);

        secondTestStr = JOptionPane.showInputDialog(null,
                "Enter the second test grade: ",
                "Content 06 | Exercise 16",
                JOptionPane.QUESTION_MESSAGE);

        thirdTestStr = JOptionPane.showInputDialog(null,
                "Enter the third test grade: ",
                "Content 06 | Exercise 16",
                JOptionPane.QUESTION_MESSAGE);

        finalWorkStr = JOptionPane.showInputDialog(null,
                "Enter the final assignment grade: ",
                "Content 06 | Exercise 16",
                JOptionPane.QUESTION_MESSAGE);

        studentAgeStr = JOptionPane.showInputDialog(null,
                "Enter your age: ",
                "Content 06 | Exercise 16",
                JOptionPane.QUESTION_MESSAGE);

        absences = Integer.valueOf(absencesStr);
        firstTest = Double.valueOf(firstTestStr);
        secondTest = Double.valueOf(secondTestStr);
        thirdTest = Double.valueOf(thirdTestStr);
        finalWork = Double.valueOf(finalWorkStr);
        studentAge = Integer.valueOf(studentAgeStr);

        // Processing: Discard the lowest test grade, choose both weights and classify the weighted
        // expression across the five score bands.
        if (firstTest <= secondTest && firstTest <= thirdTest) {
            highestNoteOne = secondTest;
            highestNoteTwo = thirdTest;
        }
        
        else if (secondTest <= firstTest && secondTest <= thirdTest) {
            highestNoteOne = firstTest;
            highestNoteTwo = thirdTest;
        }
        
        else {
            highestNoteOne = firstTest;
            highestNoteTwo = secondTest;
        }

        if (absences <= 5)
            weightOne = 3;
            
        else if (absences <= 10)
            weightOne = 2;
            
        else
            weightOne = 1;

        if (studentAge <= 17)
            weightTwo = 1;
            
        else if (studentAge <= 50)
            weightTwo = 2;
            
        else
            weightTwo = 3;

        finalNote = (highestNoteOne + highestNoteTwo) / 2 * weightOne + finalWork * weightTwo;

        if (finalNote <= 50)
            // Output: display the message for the current result.
            JOptionPane.showMessageDialog(null,
                    "Failed!",
                    "Content 06 | Exercise 16",
                    JOptionPane.ERROR_MESSAGE);
            
        else if (finalNote <= 70)
            JOptionPane.showMessageDialog(null,
                    "Fair!",
                    "Content 06 | Exercise 16",
                    JOptionPane.INFORMATION_MESSAGE);
            
        else if (finalNote <= 80)
            JOptionPane.showMessageDialog(null,
                    "Good!",
                    "Content 06 | Exercise 16",
                    JOptionPane.INFORMATION_MESSAGE);
            
        else if (finalNote <= 90)
            JOptionPane.showMessageDialog(null,
                    "Very good!",
                    "Content 06 | Exercise 16",
                    JOptionPane.INFORMATION_MESSAGE);
            
        else
            JOptionPane.showMessageDialog(null,
                    "Excellent!",
                    "Content 06 | Exercise 16",
                    JOptionPane.INFORMATION_MESSAGE);
    }
}
```

</details>
