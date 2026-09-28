package Etapa1.Stage1;

import java.util.Scanner;

/**
 * Calcular a hipotenusa dentro de um bloco try que fecha o Scanner automaticamente.
 *
 * Atividade: CalculaHipotenusa.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class CalculaHipotenusa {
   public static void main(String[] args) {
     double hipotenusa, cateto1, cateto2;
       // Entrada: ler os valores informados pelo console.
       try (Scanner teclado = new Scanner(System.in)) {
           System.out.print("Informe o valor do cateto 1: ");
           cateto1 = teclado.nextDouble();
           System.out.print("Informe o valor do cateto 1 : ");
           cateto2 = teclado.nextDouble();
           // Processamento: Calcular a hipotenusa dentro de um bloco try que fecha o Scanner
           // automaticamente.
           hipotenusa = Math.pow(Math.pow(cateto1,2)+Math.pow(cateto2,2),1.0/2);
           // Saída: apresentar a mensagem correspondente ao resultado atual.
           System.out.print("Hipotenusa = "+hipotenusa);
       }
   }
}
