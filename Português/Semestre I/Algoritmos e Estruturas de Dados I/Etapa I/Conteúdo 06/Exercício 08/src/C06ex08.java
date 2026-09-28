package FirstStage;

import javax.swing.JOptionPane;

/**
 * Multiplicar o quadrado da altura por 20 e 25 para obter os dois limites.
 *
 * Atividade: C06ex08.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex08 {

    static void main() {

        String name, heightStr;

        double height, weight, weightMin, weightMax;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        name = JOptionPane.showInputDialog(null,
                "Informe seu nome:",
                "Conteúdo 06 | Exercício 08",
                JOptionPane.QUESTION_MESSAGE);

        heightStr = JOptionPane.showInputDialog(null,
                "Informe sua altura:",
                "Conteúdo 06 | Exercício 08",
                JOptionPane.QUESTION_MESSAGE);

        height = Double.valueOf(heightStr);

        // Processamento: Multiplicar o quadrado da altura por 20 e 25 para obter os dois limites.
        weightMin = 20 * Math.pow(height, 2);

        weightMax = 25 * Math.pow(height, 2);

        // Saída: apresentar a mensagem correspondente ao resultado atual.
        JOptionPane.showMessageDialog(null,
                "Peso mínimo: " + weightMin + "\nPeso máximo: " + weightMax,
                "Conteúdo 06 | Exercício 08",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
