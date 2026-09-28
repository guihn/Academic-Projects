package FirstStage;

import javax.swing.JOptionPane;

/**
 * Calcular a raiz quadrada de (x/4 + 1)² mais a raiz quinta real de x, preservando o sinal da
 * raiz quinta.
 *
 * Atividade: C05ex07.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C05ex07 {

    static void main() {

        String xStr;

        double x, fx, c1, c2;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        xStr = JOptionPane.showInputDialog(null,
                "Digite o valor de X:",
                "Conteúdo 05 | Exercício 07",
                JOptionPane.QUESTION_MESSAGE);

        x = Double.valueOf(xStr);

        // Processamento: Calcular a raiz quadrada de (x/4 + 1)² mais a raiz quinta real de x,
        // preservando o sinal da raiz quinta.
        c1 = Math.pow((x / 4 + 1), 2);

        // Manter real a raiz quinta de x negativo restaurando seu sinal.
        c2 = Math.copySign(Math.pow(Math.abs(x), 1.0 / 5), x);

        fx = Math.sqrt(c1 + c2);

        // Saída: apresentar a mensagem correspondente ao resultado atual.
        JOptionPane.showMessageDialog(null,
                "X: " + x + "\nf(x): " + fx,
                "Conteúdo 05 | Exercício 07",
                JOptionPane.INFORMATION_MESSAGE);

    }
}
