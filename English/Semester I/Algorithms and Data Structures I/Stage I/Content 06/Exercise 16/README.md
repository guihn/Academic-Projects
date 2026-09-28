<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2016">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 16 · Final grade classification

## Description

This exercise calculates an academic classification from grades, attendance and age. Only the two highest test grades enter the mean, whose weight depends on absences; the final assignment receives a weight based on age. The numeric result is then converted into one of the exercise's five classifications.

## Statement

Read absences, three test grades, the final assignment grade and age. Calculate:

Final score = mean of the two highest test grades × weight 1 + assignment grade × weight 2.

| Absences | Weight&nbsp;1 |
| --- | --- |
| Up to 5 | 3 |
| Above 5 through 10 | 2 |
| Above 10 | 1 |

| Age | Weight&nbsp;2 |
| --- | --- |
| Up to 17 | 1 |
| From 18 through 50 | 2 |
| Above 50 | 3 |

| Final&nbsp;score | Result |
| --- | --- |
| Up to 50 | Failed |
| Above 50 through 70 | Fair |
| Above 70 through 80 | Good |
| Above 80 through 90 | Very good |
| Above 90 | Excellent |

Display the final result corresponding to the calculated score.

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
