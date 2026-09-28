package FirstStage;

import javax.swing.JOptionPane;

/**
 * Usar 72.7h − 58 para M e 62.1h − 44.7 para F, informando que outras entradas são inválidas.
 *
 * Atividade: C06ex09.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex09 {

    static void main() {

        String heightStr, genderStr;

        double height, idealHeightF, idealHeightM;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        heightStr = JOptionPane.showInputDialog(null,
                "Informe sua altura (em metros):",
                "Conteúdo 06 | Exercício 09",
                JOptionPane.QUESTION_MESSAGE);

        genderStr = JOptionPane.showInputDialog(null,
                "Informe seu gênero biológico (M ou F):",
                "Conteúdo 06 | Exercício 09",
                JOptionPane.QUESTION_MESSAGE);

        height = Double.valueOf(heightStr);

        // Processamento: Usar 72.7h − 58 para M e 62.1h − 44.7 para F, informando que outras
        // entradas são inválidas.
        if (genderStr.equals("M")) {
            idealHeightM = 72.7 * height - 58;

            // Saída: apresentar a mensagem correspondente ao resultado atual.
            JOptionPane.showMessageDialog(null,
                    "Peso ideal: " + idealHeightM,
                    "Conteúdo 06 | Exercício 09",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        
        else if (genderStr.equals("F")) {
            idealHeightF = 62.1 * height - 44.7;

            JOptionPane.showMessageDialog(null,
                    "Peso ideal: " + idealHeightF,
                    "Conteúdo 06 | Exercício 09",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        
        else
            JOptionPane.showMessageDialog(null,
                    "Gênero inválido.",
                    "Conteúdo 06 | Exercício 09",
                    JOptionPane.INFORMATION_MESSAGE);

    }
}
