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
