<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2004/Exerc%C3%ADcio%2003">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2004">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 03 · Pollutant fine table

## Description

The program builds an environmental fine table from parameters chosen by the user. Two emission limits and three fine amounts define the lower, middle and upper bands. The output presents the complete table; this exercise does not read a company's emissions to calculate an individual fine.

## Statement

An environmental department applies fines according to pollutant emissions. Request the two limits and three variable fine amounts, then display these rules:

| Emissions | Fine |
| --- | --- |
| Up to the first limit | First fine amount |
| Above the first limit through the second | Second fine amount |
| Above the second limit | Third amount per unit of pollutant emitted |

## Solution

Read the table parameters and display its three emission bands without calculating a fine for a specific company.

Source file: [C04ex03.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2004/Exercise%2003/src/C04ex03.java)

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
