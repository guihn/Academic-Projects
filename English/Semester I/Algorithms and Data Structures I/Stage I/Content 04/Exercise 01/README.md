<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2004/Exerc%C3%ADcio%2001">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2004">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 01 · Name and age in the console

## Description

**Statement summary:** Read first name, middle name, surname and age, then present the surname before the given names.

**Statement source:** [original lecture slides](https://github.com/guihn/academic-materials/blob/5a9473bbf24a271032a41b141ab6bd435076c1d5/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2004/Algoritmos%20-%20Aulas%20-%20Conte%C3%BAdo%204%20-%20Comandos%20de%20IO%20%E2%80%93%20SCANNER%2C%20PRINT.pptx), slide(s) 34. [Material folder](https://github.com/guihn/academic-materials/tree/main/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2004).

**Supplied source:** [C04ex01.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/FirstStage/C04ex01.java).

## Solution

Read the text fields before the integer age and combine them in the console message.

[Source file: C04ex01.java](https://github.com/guihn/Academic-Projects/blob/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2004/Exercise%2001/src/C04ex01.java) · [Download](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2004/Exercise%2001/src/C04ex01.java)

<details>
<summary>💻 | Java code</summary>

```java
package FirstStage;

import java.util.Scanner;

/**
 * Read the text fields before the integer age and combine them in the console message.
 *
 * Assignment: C04ex01.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C04ex01 {

    public static void main() {

        String name, midname, surname;

        int age;

        // Input: read the values supplied through the console.
        Scanner kb = new Scanner(System.in);

        System.out.print("Enter your first name: ");
        name = kb.nextLine();

        System.out.print("Enter your middle name: ");
        midname = kb.nextLine();

        System.out.print("Enter your surname: ");
        surname = kb.nextLine();

        System.out.print("Enter your age: ");
        age = kb.nextInt();

        // Processing: Read the text fields before the integer age and combine them in the console
        // message.
        // Output: display the message for the current result.
        System.out.println(surname + ", " + name + " " + midname + "\nAge: " + age);

        kb.close();
    }
}
```

</details>
