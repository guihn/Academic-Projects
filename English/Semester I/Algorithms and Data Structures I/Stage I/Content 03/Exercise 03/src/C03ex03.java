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
