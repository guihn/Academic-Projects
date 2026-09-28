<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2011">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 11 · Volleyball match points

## Description

**Statement summary:** Read team names and the set score and allocate points according to the table in the statement.

**Statement source:** [original lecture slides](https://github.com/guihn/academic-materials/blob/5a9473bbf24a271032a41b141ab6bd435076c1d5/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2006/Algoritmos%20-%20Aulas%20-%20Conte%C3%BAdo%206%20-%20Comando%20Condicional%20%E2%80%93%20IF%2C%20Express%C3%B5es%20Booleanas.pptx), slide(s) 53. [Material folder](https://github.com/guihn/academic-materials/tree/main/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2006).

**Supplied source:** [C06ex11.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/FirstStage/C06ex11.java).

## Solution

Award 3–0 points for 3–0 or 3–1 set scores and 2–1 points for a 3–2 score, with symmetric cases.

### Implementation notes

Unrecognized scores assign 69 points to each team in the supplied implementation.

[Source file: C06ex11.java](https://github.com/guihn/Academic-Projects/blob/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006/Exercise%2011/src/C06ex11.java) · [Download](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006/Exercise%2011/src/C06ex11.java)

<details>
<summary>💻 | Java code</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Award 3–0 points for 3–0 or 3–1 set scores and 2–1 points for a 3–2 score, with symmetric
 * cases.
 *
 * Assignment: C06ex11.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex11 {

    static void main() {

        String team1, team2, set1Str, set2Str;

        double set1, set2, points1, points2;

        // Input: collect the requested values through dialog boxes.
        team1 = JOptionPane.showInputDialog(null,
                "What is the name of team 1? ",
                "Content 06 | Exercise 11",
                JOptionPane.QUESTION_MESSAGE);

        team2 = JOptionPane.showInputDialog(null,
                "What is the name of team 2? ",
                "Content 06 | Exercise 11",
                JOptionPane.QUESTION_MESSAGE);

        set1Str = JOptionPane.showInputDialog(null,
                "How many sets did team 1 win (e.g. 3)? ",
                "Content 06 | Exercise 11",
                JOptionPane.QUESTION_MESSAGE);

        set2Str = JOptionPane.showInputDialog(null,
                "How many sets did team 2 win (e.g. 3)? ",
                "Content 06 | Exercise 11",
                JOptionPane.QUESTION_MESSAGE);

        set1 = Double.valueOf(set1Str);
        set2 = Double.valueOf(set2Str);

        // Processing: Award 3–0 points for 3–0 or 3–1 set scores and 2–1 points for a 3–2 score,
        // with symmetric cases.
        points1 = 0;
        points2 = 0;

        if (set1 == 3 && set2 == 0)
            points1 = 3;
        else if (set1 == 3 && set2 == 1)
            points1 = 3;
            
        else if (set1 == 0 && set2 == 3)
            points2 = 3;
        else if (set1 == 1 && set2 == 3)
            points2 = 3;

        else if (set1 == 3 && set2 == 2) {
            points1 = 2;
            points2 = 1;
        }
        
        else if (set1 == 2 && set2 == 3) {
            points1 = 1;
            points2 = 2;
        }
        
        else {
            points1 = 69;
            points2 = 69;
        }

        // Output: display the message for the current result.
        JOptionPane.showMessageDialog(null,
                "Points for " + team1 + ": " + points1 + "\nPoints for " + team2 + ": " + points2);
    }
}
```

</details>
