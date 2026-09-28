<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2007/Exerc%C3%ADcio%2002">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2007">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 02 · Grade categories

## Description

**Statement summary:** Read three integer grades, take the integer part of their mean and assign the category from the slide table.

**Statement source:** [original lecture slides](https://github.com/guihn/academic-materials/blob/5a9473bbf24a271032a41b141ab6bd435076c1d5/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2007/Algoritmos%20-%20Aulas%20-%20Conte%C3%BAdo%207%20-%20Comando%20Condicional%20%E2%80%93%20SWITCH.pptx), slide(s) 18. [Material folder](https://github.com/guihn/academic-materials/tree/main/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2007).

**Supplied source:** [C07ex02.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/FirstStage/C07ex02.java).

## Solution

Use integer division for the mean and select the output text with switch.

### Implementation notes

The code contains an additional message for a zero mean and validates the final mean rather than each input grade. The zero message is not defined in the slide table.

[Source file: C07ex02.java](https://github.com/guihn/Academic-Projects/blob/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2007/Exercise%2002/src/C07ex02.java) · [Download](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2007/Exercise%2002/src/C07ex02.java)

<details>
<summary>💻 | Java code</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Use integer division for the mean and select the output text with switch.
 *
 * Assignment: C07ex02.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C07ex02 {

    static void main() {

        String parcialNoteOneStr, parcialNoteTwoStr, parcialNoteThreeStr, concept;

        int parcialNoteOne, parcialNoteTwo, parcialNoteThree, finalNote, media;

        // Input: collect the requested values through dialog boxes.
        parcialNoteOneStr = JOptionPane.showInputDialog(null,
                "Enter your first grade: ",
                "Content 07 | Exercise 02",
                JOptionPane.QUESTION_MESSAGE);

        parcialNoteTwoStr = JOptionPane.showInputDialog(null,
                "Enter your second grade: ",
                "Content 07 | Exercise 02",
                JOptionPane.QUESTION_MESSAGE);

        parcialNoteThreeStr = JOptionPane.showInputDialog(null,
                "Enter your third grade: ",
                "Content 07 | Exercise 02",
                JOptionPane.QUESTION_MESSAGE);

        parcialNoteOne = Integer.valueOf(parcialNoteOneStr);
        parcialNoteTwo = Integer.valueOf(parcialNoteTwoStr);
        parcialNoteThree = Integer.valueOf(parcialNoteThreeStr);

        // Processing: Use integer division for the mean and select the output text with switch.
        finalNote = (parcialNoteOne + parcialNoteTwo + parcialNoteThree) / 3;

        switch (finalNote) {
            
            case 9, 10 ->
                    concept = "A";
            
            case 8 ->
                    concept = "B";
            
            case 7 ->
                    concept = "C";
            
            case 5, 6 ->
                    concept = "D";
            
            case 1, 2, 3, 4 ->
                    concept = "E";
            case 0 ->
                concept = "Give up on your life";
            
            default ->
                    concept = "You did not enter grades up to 10.";
        }

        // Output: display the message for the current result.
        JOptionPane.showMessageDialog(null,
                "Grade category: " + concept,
                "Content 07 | Exercise 02",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
```

</details>
