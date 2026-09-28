package FirstStage;

import javax.swing.JOptionPane;

/**
 * Preparar as multas fixa e proporcional e escolher a mensagem pelos limites de emissão do
 * código.
 *
 * Atividade: C06ex02.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex02 {

    static void main() {

        String pollutantStr;

        double pollutant, fee15x35, fee35;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        pollutantStr = JOptionPane.showInputDialog(null,
                "Informe a quantidade de poluentes:",
                "Conteúdo 06 | Exercício 02",
                JOptionPane.QUESTION_MESSAGE);

        pollutant = Double.valueOf(pollutantStr);

        // Processamento: Preparar as multas fixa e proporcional e escolher a mensagem pelos limites
        // de emissão do código.
        fee15x35 = 3000;

        fee35 = 5000 * pollutant;

        if (pollutant <= 1500)
            // Saída: apresentar a mensagem correspondente ao resultado atual.
            JOptionPane.showMessageDialog(null,
                    "Multa isenta.",
                    "Conteúdo 06 | Exercício 02",
                    JOptionPane.INFORMATION_MESSAGE);

        // O limite superior fornecido é 3000; o enunciado usa 3500.
        else if (pollutant >= 1500 && pollutant <= 3000)
            JOptionPane.showMessageDialog(null,
                    "Multa: R$" + fee15x35,
                    "Conteúdo 06 | Exercício 02",
                    JOptionPane.INFORMATION_MESSAGE);
            
        else
            JOptionPane.showMessageDialog(null,
                    "Multa: R$" + fee35,
                    "Conteúdo 06 | Exercício 02",
                    JOptionPane.INFORMATION_MESSAGE);
    }
}
