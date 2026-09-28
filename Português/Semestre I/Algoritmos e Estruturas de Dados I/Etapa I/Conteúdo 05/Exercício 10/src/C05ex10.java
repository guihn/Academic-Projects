package FirstStage;

import javax.swing.JOptionPane;

/**
 * Usar divisão inteira e restos para extrair os dígitos da maior ordem até as unidades.
 *
 * Atividade: C05ex10.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C05ex10 {

    static void main() {

        String numberStr;

        int number, d1, d2, d3, d4, d5;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        numberStr = JOptionPane.showInputDialog(null,
                "Informe um número em sequência (5 dígitos):",
                "Conteúdo 05 | Exercício 10",
                JOptionPane.QUESTION_MESSAGE);

        number = Integer.valueOf(numberStr);

        // Processamento: Usar divisão inteira e restos para extrair os dígitos da maior ordem até
        // as unidades.
        d1 = number / 10000;

        d2 = number / 1000 % 10;

        d3 = number / 100 % 10;

        d4 = number / 10 % 10;

        d5 = number % 10;

        // Saída: apresentar a mensagem correspondente ao resultado atual.
        JOptionPane.showMessageDialog(null,
                "Número impresso:\n" + d1 + "\n" + d2 + "\n" + d3 + "\n" + d4 + "\n" + d5,
                "Conteúdo 05 | Exercício 10",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
