<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2003/Exerc%C3%ADcio%2003">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2003">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 03 · Hypotenuse

## Description

The program determines the hypotenuse of a right triangle from the lengths of its two legs. It applies the Pythagorean theorem by adding the squared lengths and taking the square root. This page contains the `C03ex03` solution and the `CalculaHipotenusa` example on which the exercise is based.

## Statement

Adapt the `CalculaHipotenusa` example to the class name `C03ex03`. Enter the lengths of both legs and calculate the hypotenuse. For lengths of 10 and 15, check that the result is approximately 18.0277.

## Solution

Square each leg, add the squares and raise the sum to the power 1/2.

### Hypotenuse

Source file: [C03ex03.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2003/Exercise%2003/src/C03ex03.java)

<details>
<summary>💻 | Java code</summary>

```java
package FirstStage;

import java.util.Scanner;

/**
 * Square each leg, add the squares and raise the sum to the power 1/2.
 *
 * Assignment: C03ex03.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C03ex03 {

  public static void main(String[] args) {

    double hipotenusa, cateto1, cateto2;

    // Input: read the values supplied through the console.
    Scanner teclado = new Scanner(System.in);

    System.out.print("Enter the value of leg 1: ");
    cateto1 = teclado.nextDouble();

    System.out.print("Enter the value of leg 2: ");
    cateto2 = teclado.nextDouble();

    teclado.close();

    // Processing: Square each leg, add the squares and raise the sum to the power 1/2.
    hipotenusa = Math.pow(Math.pow(cateto1, 2) + Math.pow(cateto2, 2), 1.0 / 2);

    // Output: display the message for the current result.
    System.out.print("Hypotenuse = " + hipotenusa);
  }
}
```

</details>

### Additional hypotenuse example

Calculate the hypotenuse inside a try block that closes the Scanner automatically.

The second prompt still says leg 1 although its input is stored in cateto2. The original package is Etapa1.Stage1.

Source file: [CalculaHipotenusa.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2003/Exercise%2003/src/CalculaHipotenusa.java)

<details>
<summary>💻 | Java code</summary>

```java
package Etapa1.Stage1;

import java.util.Scanner;

/**
 * Calculate the hypotenuse inside a try block that closes the Scanner automatically.
 *
 * Assignment: CalculaHipotenusa.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class CalculaHipotenusa {
   public static void main(String[] args) {
     double hipotenusa, cateto1, cateto2;
       // Input: read the values supplied through the console.
       try (Scanner teclado = new Scanner(System.in)) {
           System.out.print("Enter the value of leg 1: ");
           cateto1 = teclado.nextDouble();
           System.out.print("Enter the value of leg 1: ");
           cateto2 = teclado.nextDouble();
           // Processing: Calculate the hypotenuse inside a try block that closes the Scanner
           // automatically.
           hipotenusa = Math.pow(Math.pow(cateto1,2)+Math.pow(cateto2,2),1.0/2);
           // Output: display the message for the current result.
           System.out.print("Hypotenuse = "+hipotenusa);
       }
   }
}
```

</details>
