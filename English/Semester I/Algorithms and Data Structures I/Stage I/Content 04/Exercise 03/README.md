<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2004/Exerc%C3%ADcio%2003">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2004">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 03 · Pollutant fine table

## Description

**Statement summary:** Read two emission limits and three fine amounts and assemble the table described in the slides.

**Statement source:** [original lecture slides](https://github.com/guihn/academic-materials/blob/5a9473bbf24a271032a41b141ab6bd435076c1d5/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2004/Algoritmos%20-%20Aulas%20-%20Conte%C3%BAdo%204%20-%20Comandos%20de%20IO%20%E2%80%93%20SCANNER%2C%20PRINT.pptx), slide(s) 37–38. [Material folder](https://github.com/guihn/academic-materials/tree/main/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2004).

**Supplied source:** [C04ex03.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/FirstStage/C04ex03.java).

## Solution

Read the table parameters and display its three emission bands without calculating a fine for a specific company.

[Source file: C04ex03.java](https://github.com/guihn/Academic-Projects/blob/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2004/Exercise%2003/src/C04ex03.java) · [Download](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2004/Exercise%2003/src/C04ex03.java)

<details>
<summary>💻 | Java code</summary>

```java
package FirstStage;

import java.util.Scanner;

/**
 * Read the table parameters and display its three emission bands without calculating a fine for
 * a specific company.
 *
 * Assignment: C04ex03.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C04ex03 {

    static void main() {

        int poluentex, poluentey;

        double multadex, multaxatey, multadey;

        // Input: read the values supplied through the console.
        Scanner kb = new Scanner(System.in);

        System.out.print("Amount of pollutant X: ");
        poluentex = kb.nextInt();

        System.out.print("Fine for amount X: ");
        multadex = kb.nextDouble();

        System.out.print("Amount of pollutant Y (greater than X): ");
        poluentey = kb.nextInt();

        System.out.print("Fine for the amount between X and Y: ");
        multaxatey = kb.nextDouble();

        System.out.print("Fine for the amount above Y: ");
        multadey = kb.nextDouble();

        kb.close();

        // Processing: Read the table parameters and display its three emission bands without
        // calculating a fine for a specific company.
        // Output: display the message for the current result.
        System.out.println("Amount of Pollutant Emitted x Fine");

        System.out.println("\nUp to " + poluentex + " fine of R$" + multadex);

        System.out.println("Above " + poluentex + " up to " + poluentey + " fine of R$" + multaxatey);

        System.out.println("Above " + poluentey + " fine of R$" + multadey + " per unit of pollutant emitted.");
    }
}
```

</details>
