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
