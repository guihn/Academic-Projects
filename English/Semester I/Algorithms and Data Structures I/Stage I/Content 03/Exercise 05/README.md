<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2003/Exerc%C3%ADcio%2005">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2003">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 05 · Age in a given year

## Description

**Statement summary:** Adapt the age example, reading a name, birth year and reference year.

**Statement source:** [original lecture slides](https://github.com/guihn/academic-materials/blob/5a9473bbf24a271032a41b141ab6bd435076c1d5/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2003/Algoritmos%20-%20Aulas%20-%20Conte%C3%BAdo%203%20-%20Compiladores%2C%20Dados%20e%20Vari%C3%A1veis.pptx), slide(s) 89–90. [Material folder](https://github.com/guihn/academic-materials/tree/main/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2003).

**Supplied source:** [C03ex05.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/FirstStage/C03ex05.java).

## Solution

Subtract the birth year from the reference year to obtain the age reached during that year.

[Source file: C03ex05.java](https://github.com/guihn/Academic-Projects/blob/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2003/Exercise%2005/src/C03ex05.java) · [Download](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2003/Exercise%2005/src/C03ex05.java)

<details>
<summary>💻 | Java code</summary>

```java
package FirstStage;

import java.util.Scanner;

/**
 * Subtract the birth year from the reference year to obtain the age reached during that year.
 *
 * Assignment: C03ex05.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C03ex05 {

    public static void main(String[] args) {

        String nome;

        int anoNasc, anoAtual, idade;

        // Input: read the values supplied through the console.
        Scanner teclado = new Scanner(System.in);

        System.out.print("Enter your name: ");
        nome = teclado.nextLine();

        System.out.print("Enter the year you were born: ");
        anoNasc = teclado.nextInt();

        System.out.print("Enter the current year: ");
        anoAtual = teclado.nextInt();

        // Processing: Subtract the birth year from the reference year to obtain the age reached
        // during that year.
        idade = anoAtual - anoNasc;

        teclado.close();

        // Output: display the message for the current result.
        System.out.println(nome + ", you are/will be " + idade + " years old in " + anoAtual);
    }
}
```

</details>
