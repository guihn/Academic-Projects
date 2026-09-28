package FirstStage;

import javax.swing.JOptionPane;

/**
 * Calcular a raiz quadrada de 360S dividido por απ, com o ângulo em graus.
 *
 * Atividade: C05ex08.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C05ex08 {

    static void main() {

        String sStr, aStr;

        double s, a, pi, r;

        pi = 3.1416;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        sStr = JOptionPane.showInputDialog(null,
                "Informe o valor da área de um setor circular:",
                "Conteúdo 05 | Exercício 08",
                JOptionPane.QUESTION_MESSAGE);

        aStr = JOptionPane.showInputDialog(null,
                "Informe o valor do ângulo:",
                "Conteúdo 05 | Exercício 08",
                JOptionPane.QUESTION_MESSAGE);

        s = Double.valueOf(sStr);
        a = Double.valueOf(aStr);

        // Processamento: Calcular a raiz quadrada de 360S dividido por απ, com o ângulo em graus.
        r = Math.sqrt((360 * s) / (a * pi));

        // Saída: apresentar a mensagem correspondente ao resultado atual.
        JOptionPane.showMessageDialog(null,
                "S: " + s + " A: " + a + " R: " + r,
                "Conteúdo 05 | Exercício 08",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
