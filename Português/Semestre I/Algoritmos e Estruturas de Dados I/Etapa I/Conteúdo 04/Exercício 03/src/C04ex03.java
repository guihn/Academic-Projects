package FirstStage;

import java.util.Scanner;

/**
 * Ler os parâmetros da tabela e exibir suas três faixas de emissão sem calcular a multa de uma
 * empresa específica.
 *
 * Atividade: C04ex03.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C04ex03 {

    static void main() {

        int poluentex, poluentey;

        double multadex, multaxatey, multadey;

        // Entrada: ler os valores informados pelo console.
        Scanner kb = new Scanner(System.in);

        System.out.print("Quantidade de poluente X: ");
        poluentex = kb.nextInt();

        System.out.print("Valor da multa para a quantidade X: ");
        multadex = kb.nextDouble();

        System.out.print("Quantidade de poluente Y (valor maior que X): ");
        poluentey = kb.nextInt();

        System.out.print("Valor da multa para a quantidade entre X e Y: ");
        multaxatey = kb.nextDouble();

        System.out.print("Valor da multa para a quantidade acima de Y: ");
        multadey = kb.nextDouble();

        kb.close();

        // Processamento: Ler os parâmetros da tabela e exibir suas três faixas de emissão sem
        // calcular a multa de uma empresa específica.
        // Saída: apresentar a mensagem correspondente ao resultado atual.
        System.out.println("Quantidade de Poluente Emitido x Valor da Multa");

        System.out.println("\nAté " + poluentex + " multa de R$" + multadex);

        System.out.println("Acima de " + poluentex + " até " + poluentey + " multa de R$" + multaxatey);

        System.out.println("Acima de " + poluentey + " multa de R$" + multadey + " por poluente emitido.");
    }
}
