<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2003/Exerc%C3%ADcio%2001">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2003">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 01 · Factorial

## Description

**Statement summary:** Adapt the factorial example to the exercise class name and check its calculation for an integer input.

## Solution

Initialize the product to 1 and multiply it by each integer from 2 through the supplied number.

### Implementation notes

The program does not reject negative input or detect overflow of long.

Source file: [C03ex01.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2003/Exercise%2001/src/C03ex01.java)

<details>
<summary>💻 | Java code</summary>

```java
package FirstStage;

import java.util.Scanner;

/**
 * Initialize the product to 1 and multiply it by each integer from 2 through the supplied
 * number.
 *
 * Assignment: C03ex01.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C03ex01 {

    public static void main(String[] args) {

        long numero, fatorial, contador;

        // Input: read the values supplied through the console.
        Scanner teclado = new Scanner(System.in);

        System.out.print("Enter a number: ");
        numero = teclado.nextLong();

        teclado.close();

        // Processing: Initialize the product to 1 and multiply it by each integer from 2 through
        // the supplied number.
        fatorial = 1L;

        // The running product contains the factorial through the previous counter value.
        for (contador = 2; contador <= numero; contador++) {
            
            fatorial = fatorial * contador;
        }

        // Output: display the message for the current result.
        System.out.println("Factorial = " + fatorial);
    }
}
```

</details>
