package FirstStage;

import javax.swing.JOptionPane;

/**
 * Multiplicar cada nota por seu peso, somar os produtos e dividir pela soma dos pesos.
 *
 * Atividade: C05ex09.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C05ex09 {

    static void main() {

        String note1Str, note2Str, note3Str;

        double note1, note2, note3, weightedAverage, weightedSum;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        note1Str = JOptionPane.showInputDialog(null,
                "Informe a 1ª nota:",
                "Conteúdo 05 | Exercício 09",
                JOptionPane.QUESTION_MESSAGE);

        note2Str = JOptionPane.showInputDialog(null,
                "Informe a 2ª nota:",
                "Conteúdo 05 | Exercício 09",
                JOptionPane.QUESTION_MESSAGE);

        note3Str = JOptionPane.showInputDialog(null,
                "Informe a 3ª nota:",
                "Conteúdo 05 | Exercício 09",
                JOptionPane.QUESTION_MESSAGE);

        note1 = Double.valueOf(note1Str);
        note2 = Double.valueOf(note2Str);
        note3 = Double.valueOf(note3Str);

        // Processamento: Multiplicar cada nota por seu peso, somar os produtos e dividir pela soma
        // dos pesos.
        weightedSum = (note1 * 2) + (note2 * 3) + (note3 * 5);

        weightedAverage = weightedSum / (2 + 3 + 5);

        // Saída: apresentar a mensagem correspondente ao resultado atual.
        JOptionPane.showMessageDialog(null,
                "Média: " + weightedAverage,
                "Conteúdo 05 | Exercício 09",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
