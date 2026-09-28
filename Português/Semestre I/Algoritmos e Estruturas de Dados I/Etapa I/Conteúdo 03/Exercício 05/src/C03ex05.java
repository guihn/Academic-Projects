package FirstStage;

import java.util.Scanner;

/**
 * Subtrair o ano de nascimento do ano de referência para obter a idade completada naquele ano.
 *
 * Atividade: C03ex05.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C03ex05 {

    public static void main(String[] args) {

        String nome;

        int anoNasc, anoAtual, idade;

        // Entrada: ler os valores informados pelo console.
        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite o seu nome: ");
        nome = teclado.nextLine();

        System.out.print("Digite o ano em que você nasceu: ");
        anoNasc = teclado.nextInt();

        System.out.print("Digite o ano atual: ");
        anoAtual = teclado.nextInt();

        // Processamento: Subtrair o ano de nascimento do ano de referência para obter a idade
        // completada naquele ano.
        idade = anoAtual - anoNasc;

        teclado.close();

        // Saída: apresentar a mensagem correspondente ao resultado atual.
        System.out.println(nome + ", você tem/terá " + idade + " anos em " + anoAtual);
    }
}
