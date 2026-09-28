<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2017">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 17 · Programming job questionnaire

## Description

**Statement summary:** Ask nine questions and evaluate the training, experience and preference conditions listed in the exercise.

**Supplied source:** [C06ex17.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/FirstStage/C06ex17.java).

## Solution

Store the dialog option comparisons and combine them with AND, OR, negation and an exclusive preference comparison.

### Implementation notes

The buttons are ordered Yes/No, but every answer is converted to true when option index 1 (No) is selected. This reverses the meaning expected by the variable names.

[Source file: C06ex17.java](https://github.com/guihn/Academic-Projects/blob/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006/Exercise%2017/src/C06ex17.java) · [Download](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006/Exercise%2017/src/C06ex17.java)

<details>
<summary>💻 | Java code</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Store the dialog option comparisons and combine them with AND, OR, negation and an exclusive
 * preference comparison.
 *
 * Assignment: C06ex17.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex17 {

    static void main() {

        boolean tecnicianCourse, higherCourse, threeYearsOfExp, criativePearson, leadOrBeLead, workLonelyorinTeam, selfTaught, initialSalary, onlyBH, apt, tecnicianCourseandExp;

        // Option index 1 is No. The existing comparisons therefore invert affirmative answers.
        Object[] buttons = {"Yes", "No"};

        // Input: collect the requested values through dialog boxes.
        tecnicianCourse = JOptionPane.showOptionDialog(null,
                "1 | 9 - Do you have a technical qualification?",
                "Content 06 | Exercise 17",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                buttons,
                buttons[1]) == 1;

        higherCourse = JOptionPane.showOptionDialog(null,
                "2 | 9 - Do you have a university degree?",
                "Content 06 | Exercise 17",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                buttons,
                buttons[1]) == 1;

        threeYearsOfExp = JOptionPane.showOptionDialog(null,
                "3 | 9 - Do you have less than 3 years of experience?",
                "Content 06 | Exercise 17",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                buttons,
                buttons[1]) == 1;

        criativePearson = JOptionPane.showOptionDialog(null,
                "4 | 9 - Do you consider yourself creative?",
                "Content 06 | Exercise 17",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                buttons,
                buttons[1]) == 1;

        leadOrBeLead = JOptionPane.showOptionDialog(null,
                "5 | 9 - Do you prefer leading to being led?",
                "Content 06 | Exercise 17",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                buttons,
                buttons[1]) == 1;

        workLonelyorinTeam = JOptionPane.showOptionDialog(null,
                "6 | 9 - Do you prefer working alone?",
                "Content 06 | Exercise 17",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                buttons,
                buttons[1]) == 1;

        selfTaught = JOptionPane.showOptionDialog(null,
                "7 | 9 - Are you self-taught?",
                "Content 06 | Exercise 17",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                buttons,
                buttons[1]) == 1;

        initialSalary = JOptionPane.showOptionDialog(null,
                "8 | 9 - Would you accept an initial salary of up to R$1,500.00?",
                "Content 06 | Exercise 17",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                buttons,
                buttons[1]) == 1;

        onlyBH = JOptionPane.showOptionDialog(null,
                "9 | 9 - Would you only work at company offices in Greater Belo Horizonte?",
                "Content 06 | Exercise 17",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                buttons,
                buttons[1]) == 1;

        // Processing: Store the dialog option comparisons and combine them with AND, OR, negation
        // and an exclusive preference comparison.
        tecnicianCourseandExp = tecnicianCourse && !threeYearsOfExp;

        if (higherCourse || tecnicianCourseandExp) {

            if (leadOrBeLead != initialSalary) {

                if (criativePearson && !workLonelyorinTeam && selfTaught && !onlyBH) {
                    apt = true;
                } else apt = false;
            } else apt = false;
        } else apt = false;

        if (apt == true) {
            // Output: display the message for the current result.
            JOptionPane.showMessageDialog(null,
                    "This person is SUITABLE!",
                    "Content 06 | Exercise 17",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            
            JOptionPane.showMessageDialog(null,
                    "This person is UNSUITABLE!",
                    "Content 06 | Exercise 17",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
```

</details>
