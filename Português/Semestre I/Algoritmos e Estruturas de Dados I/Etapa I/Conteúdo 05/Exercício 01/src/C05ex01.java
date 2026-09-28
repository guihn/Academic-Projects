package FirstStage;

import javax.swing.JOptionPane;

/**
 * Calcular x³ + 4x + 10 usando Math.pow no termo cúbico.
 *
 * Atividade: C05ex01.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C05ex01 {

    static void main() {

        String xStr;

        int x;

        double fx;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        xStr = JOptionPane.showInputDialog(null,
                "Informe o valor de X:",
                "Conteúdo 05 | Exercício 01",
                JOptionPane.QUESTION_MESSAGE);

        x = Integer.valueOf(xStr);

        // Processamento: Calcular x³ + 4x + 10 usando Math.pow no termo cúbico.
        fx = 1 * Math.pow(x, 3) + 4 * x + 10;

        // Saída: apresentar a mensagem correspondente ao resultado atual.
        JOptionPane.showMessageDialog(null,
                "X = " + xStr + " -> f(x) = " + fx,
                "Conteúdo 05 | Exercício 01",
                JOptionPane.INFORMATION_MESSAGE);

    }
}
