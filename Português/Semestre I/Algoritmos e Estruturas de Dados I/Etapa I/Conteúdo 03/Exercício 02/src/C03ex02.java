package FirstStage;

import java.util.Scanner;

/**
 * Somar os três valores long e dividir a soma por 3.0 para preservar a parte fracionária.
 *
 * Atividade: C03ex02.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C03ex02 {

    public static void main(String[] args) {

        long n1, n2, n3, soma;

        double media;

        // Entrada: ler os valores informados pelo console.
        Scanner teclado = new Scanner(System.in);

        System.out.print("Informe o primeiro número: ");
        n1 = teclado.nextLong();

        System.out.print("Informe o segundo número: ");
        n2 = teclado.nextLong();

        System.out.print("Informe o terceiro número: ");
        n3 = teclado.nextLong();

        // Processamento: Somar os três valores long e dividir a soma por 3.0 para preservar a parte
        // fracionária.
        soma = n1 + n2 + n3;

        media = soma / 3.0;

        // Saída: apresentar a mensagem correspondente ao resultado atual.
        System.out.println("A média é " + media);

        teclado.close();
    }
}
