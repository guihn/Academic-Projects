package FirstStage;

import java.util.Scanner;

/**
 * Elevar cada cateto ao quadrado, somar os quadrados e elevar a soma à potência 1/2.
 *
 * Atividade: C03ex03.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C03ex03 {

  public static void main(String[] args) {

    double hipotenusa, cateto1, cateto2;

    // Entrada: ler os valores informados pelo console.
    Scanner teclado = new Scanner(System.in);

    System.out.print("Informe o valor do cateto 1: ");
    cateto1 = teclado.nextDouble();

    System.out.print("Informe o valor do cateto 2: ");
    cateto2 = teclado.nextDouble();

    teclado.close();

    // Processamento: Elevar cada cateto ao quadrado, somar os quadrados e elevar a soma à potência
    // 1/2.
    hipotenusa = Math.pow(Math.pow(cateto1, 2) + Math.pow(cateto2, 2), 1.0 / 2);

    // Saída: apresentar a mensagem correspondente ao resultado atual.
    System.out.print("Hipotenusa = " + hipotenusa);
  }
}
