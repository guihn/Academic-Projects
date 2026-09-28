package SecondStage;

import javax.swing.JOptionPane;

/**
 * Repetir a entrada e o cálculo da área dez vezes, apresentando cada resultado dentro do laço.
 *
 * Atividade: C08ex01.
 */
public class C08ex01 {
    static void main() {
        String rayStr;
        double ray, pi = 3.1416, area;

        // Processamento: Repetir a entrada e o cálculo da área dez vezes, apresentando cada
        // resultado dentro do laço.
        for (int i = 1; i <=10; i++) {
            // Entrada: coletar os valores solicitados por caixas de diálogo.
            rayStr = JOptionPane.showInputDialog(null,
                    "Informe o raio do círculo: ",
                    "Conteúdo 08 | Exercício 01",
                    JOptionPane.QUESTION_MESSAGE);
            ray = Double.valueOf(rayStr);

            area = pi * Math.pow(ray, 2);

            // Saída: apresentar a mensagem correspondente ao resultado atual.
            JOptionPane.showMessageDialog(null,
                    "Area: " + area,
                    "Conteúdo 08 | Exercício 01",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
