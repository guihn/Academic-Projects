package FirstStage;

import javax.swing.JOptionPane;

/**
 * Dividir o peso pelo quadrado da altura e escolher a mensagem correspondente por comparações
 * sucessivas.
 *
 * Atividade: C06ex04.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex04 {

    static void main() {

        String name, heightStr, weightStr;

        double height, weight, imc;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        name = JOptionPane.showInputDialog(null,
                "Informe seu nome:",
                "Conteúdo 06 | Exercício 04",
                JOptionPane.QUESTION_MESSAGE);

        heightStr = JOptionPane.showInputDialog(null,
                "Informe sua altura (em metros):",
                "Conteúdo 06 | Exercício 04",
                JOptionPane.QUESTION_MESSAGE);

        weightStr = JOptionPane.showInputDialog(null,
                "Informe seu peso (em Kg):",
                "Conteúdo 06 | Exercício 04",
                JOptionPane.QUESTION_MESSAGE);

        height = Double.valueOf(heightStr);
        weight = Double.valueOf(weightStr);

        // Processamento: Dividir o peso pelo quadrado da altura e escolher a mensagem
        // correspondente por comparações sucessivas.
        imc = weight / Math.pow(height, 2);

        if (imc < 18)
            // Saída: apresentar a mensagem correspondente ao resultado atual.
            JOptionPane.showMessageDialog(null,
                    name + ", você está desnutrida. " + imc,
                    "Conteúdo 06 | Exercício 04",
                    JOptionPane.INFORMATION_MESSAGE);
            
        else if (imc < 20)
            JOptionPane.showMessageDialog(null,
                    name + ", você está abaixo do peso.",
                    "Conteúdo 06 | Exercício 04",
                    JOptionPane.INFORMATION_MESSAGE);
            
        else if (imc >= 20 && imc <= 25)
            JOptionPane.showMessageDialog(null,
                    name + ", você está no peso ideal.",
                    "Conteúdo 06 | Exercício 04",
                    JOptionPane.INFORMATION_MESSAGE);
            
        else if (imc > 25 && imc <= 27)
            JOptionPane.showMessageDialog(null,
                    name + ", você está acima do peso.",
                    "Conteúdo 06 | Exercício 04",
                    JOptionPane.INFORMATION_MESSAGE);
            
        else if (imc > 27)
            JOptionPane.showMessageDialog(null,
                    name + ", você está gigaaaanta",
                    "Conteúdo 06 | Exercício 04",
                    JOptionPane.INFORMATION_MESSAGE);
    }
}
