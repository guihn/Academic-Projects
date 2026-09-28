<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2004/Exerc%C3%ADcio%2004">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2004">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 04 · Name and age in dialogs

## Description

This exercise revisits the name-and-age presentation using dialog boxes for interaction. The program requests each part of the name and the age, then combines them into two lines in a final dialog. The interface change retains the surname-first ordering and a clearly labeled age.

## Statement

Request the first name, middle name, surname and age. Use dialog boxes for both input and output, displaying:

```text
Surname, FirstName MiddleName
Age: 99 years.
```

## Solution

Convert the age text to an integer and display the surname before the given names.

Source file: [C04ex04.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2004/Exercise%2004/src/C04ex04.java)

<details>
<summary>💻 | Java code</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Convert the age text to an integer and display the surname before the given names.
 *
 * Assignment: C04ex04.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C04ex04 {

    static void main() {

        String name, midname, surname, agestr;

        int age;

        // Input: collect the requested values through dialog boxes.
        name = JOptionPane.showInputDialog(null,
                "Enter your first name:",
                "Content 04 | Exercise 04",
                JOptionPane.QUESTION_MESSAGE);

        midname = JOptionPane.showInputDialog(null,
                "Enter your middle name:",
                "Content 04 | Exercise 04",
                JOptionPane.QUESTION_MESSAGE);

        surname = JOptionPane.showInputDialog(null,
                "Enter your surname:",
                "Content 04 | Exercise 04",
                JOptionPane.QUESTION_MESSAGE);

        agestr = JOptionPane.showInputDialog(null,
                "Enter your age:",
                "Content 04 | Exercise 04",
                JOptionPane.QUESTION_MESSAGE);

        // Processing: Convert the age text to an integer and display the surname before the given
        // names.
        age = Integer.valueOf(agestr);

        // Output: display the message for the current result.
        JOptionPane.showMessageDialog(null,
                surname + ", " + name + " " + midname + "\n" + age + " years old.",
                "Content 04 | Exercise 04",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
```

</details>
