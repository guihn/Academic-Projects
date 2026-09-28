package FirstTest;

import javax.swing.JOptionPane;
import java.util.Scanner;

/**
 * Calcular c1 = 0.75x⁷ − 4, atribuir (5 + x)/2 a c3 e c2 e avaliar c1 × c2 + c3.
 *
 * Atividade: D30912A.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class D30912A {
    static void main() {
        String xStr;
        double x, fx, c1, c2, c3;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        xStr = JOptionPane.showInputDialog(null,
                "Informe o valor de X",
                "Primeira Avaliação | Questão A",
                JOptionPane.QUESTION_MESSAGE);

        x = Double.valueOf(xStr);

        // Processamento: Calcular c1 = 0.75x⁷ − 4, atribuir (5 + x)/2 a c3 e c2 e avaliar c1 × c2 +
        // c3.
        c1 = 3.0/4 * Math.pow(x, 7) - 4;
        // A próxima linha continua esta atribuição encadeada a c2 e c3.
        c2 =
        c3 = (5 + x) / 2;

        fx = c1 * c2 + c3;

        // Saída: apresentar a mensagem correspondente ao resultado atual.
        JOptionPane.showMessageDialog(null,
                "X: " + x + "\nf(x): " + fx,
                "Primeira Avaliação | Questão A",
                JOptionPane.INFORMATION_MESSAGE);

    }
}
