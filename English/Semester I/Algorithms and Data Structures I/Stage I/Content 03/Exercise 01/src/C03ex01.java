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
