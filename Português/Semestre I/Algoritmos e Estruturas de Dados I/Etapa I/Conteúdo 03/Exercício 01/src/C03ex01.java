package FirstStage;

import java.util.Scanner;

/**
 * Inicializar o produto em 1 e multiplicá-lo por cada inteiro de 2 até o número informado.
 *
 * Atividade: C03ex01.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C03ex01 {

    public static void main(String[] args) {

        long numero, fatorial, contador;

        // Entrada: ler os valores informados pelo console.
        Scanner teclado = new Scanner(System.in);

        System.out.print("Informe um número: ");
        numero = teclado.nextLong();

        teclado.close();

        // Processamento: Inicializar o produto em 1 e multiplicá-lo por cada inteiro de 2 até o
        // número informado.
        fatorial = 1L;

        // O produto acumulado contém o fatorial até o valor anterior do contador.
        for (contador = 2; contador <= numero; contador++) {
            
            fatorial = fatorial * contador;
        }

        // Saída: apresentar a mensagem correspondente ao resultado atual.
        System.out.println("Fatorial = " + fatorial);
    }
}
