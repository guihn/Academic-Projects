package FirstStage;

import javax.swing.JOptionPane;

/**
 * Calcular a raiz quadrada da soma dos quadrados das diferenças entre as coordenadas
 * correspondentes.
 *
 * Atividade: C05ex04.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C05ex04 {

    static void main() {

        String x1Str, y1Str, x2Str, y2Str;

        double x1, y1, x2, y2, distance;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        x1Str = JOptionPane.showInputDialog(null,
                "Informe o X do ponto 1:",
                "Conteúdo 05 | Exercício 04",
                JOptionPane.QUESTION_MESSAGE);

        y1Str = JOptionPane.showInputDialog(null,
                "Informe o Y do ponto 1:",
                "Conteúdo 05 | Exercício 04",
                JOptionPane.QUESTION_MESSAGE);

        x2Str = JOptionPane.showInputDialog(null,
                "Informe o X do ponto 2:",
                "Conteúdo 05 | Exercício 04",
                JOptionPane.QUESTION_MESSAGE);

        y2Str = JOptionPane.showInputDialog(null,
                "Informe o Y do ponto 2:",
                "Conteúdo 05 | Exercício 04",
                JOptionPane.QUESTION_MESSAGE);

        x1 = Double.valueOf(x1Str);
        y1 = Double.valueOf(y1Str);
        x2 = Double.valueOf(x2Str);
        y2 = Double.valueOf(y2Str);

        // Processamento: Calcular a raiz quadrada da soma dos quadrados das diferenças entre as
        // coordenadas correspondentes.
        distance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));

        // Saída: apresentar a mensagem correspondente ao resultado atual.
        JOptionPane.showMessageDialog(null,
                "Distância: " + distance,
                "Conteúdo 05 | Exercício 04",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
