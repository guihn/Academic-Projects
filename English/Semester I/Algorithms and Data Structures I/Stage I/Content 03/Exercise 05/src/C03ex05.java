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
