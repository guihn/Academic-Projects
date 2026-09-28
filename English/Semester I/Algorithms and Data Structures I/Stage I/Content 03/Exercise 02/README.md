<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2003/Exerc%C3%ADcio%2002">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2003">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 02 · Arithmetic mean

## Description

This exercise calculates the arithmetic mean of three integers entered by the user. The program must add the values and divide the total by three while retaining the fractional part. Console input and output show how the entered values become the calculated mean.

## Statement

Reproduce the program from example 6 using the class name `C03ex02`. Read three integers and display their arithmetic mean. Check the program with the inputs 8, 12 and 63: the mean must be 27.66666…

## Solution

Add the three long values and divide their sum by 3.0 to retain a fractional result.

Source file: [C03ex02.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2003/Exercise%2002/src/C03ex02.java)

<details>
<summary>💻 | Java code</summary>

```java
package FirstStage;

import java.util.Scanner;

/**
 * Add the three long values and divide their sum by 3.0 to retain a fractional result.
 *
 * Assignment: C03ex02.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C03ex02 {

    public static void main(String[] args) {

        long n1, n2, n3, soma;

        double media;

        // Input: read the values supplied through the console.
        Scanner teclado = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        n1 = teclado.nextLong();

        System.out.print("Enter the second number: ");
        n2 = teclado.nextLong();

        System.out.print("Enter the third number: ");
        n3 = teclado.nextLong();

        // Processing: Add the three long values and divide their sum by 3.0 to retain a fractional
        // result.
        soma = n1 + n2 + n3;

        media = soma / 3.0;

        // Output: display the message for the current result.
        System.out.println("The average is " + media);

        teclado.close();
    }
}
```

</details>
