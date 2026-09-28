package FirstStage;

import javax.swing.JOptionPane;

/**
 * Comparar cada resto com zero e distinguir divisibilidade pelos dois valores, por apenas um ou
 * por nenhum.
 *
 * Atividade: C06ex05.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex05 {

    static void main() {

        String numberStr;

        int number;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        numberStr = JOptionPane.showInputDialog(null,
                "Informe um número:",
                "Conteúdo 06 | Exercício 05",
                JOptionPane.QUESTION_MESSAGE);

        number = Integer.valueOf(numberStr);

        // Processamento: Comparar cada resto com zero e distinguir divisibilidade pelos dois
        // valores, por apenas um ou por nenhum.
        if (number % 5 == 0 && number % 7 == 0)
            // Saída: apresentar a mensagem correspondente ao resultado atual.
            JOptionPane.showMessageDialog(null,
                    "Este número é divisível por 5 e por 7.",
                    "Conteúdo 06 | Exercício 05",
                    JOptionPane.INFORMATION_MESSAGE);
            
        else if (number % 5 == 0 && number % 7 != 0)
            JOptionPane.showMessageDialog(null,
                    "Este número é divisível por 5 apenas.",
                    "Conteúdo 06 | Exercício 05",
                    JOptionPane.INFORMATION_MESSAGE);
            
        else if (number % 5 != 0 && number % 7 == 0)
            JOptionPane.showMessageDialog(null,
                    "Este número é divisível por 7 apenas.",
                    "Conteúdo 06 | Exercício 05",
                    JOptionPane.INFORMATION_MESSAGE);
            
        else if (number % 5 != 0 && number % 7 != 0)
            JOptionPane.showMessageDialog(null,
                    "Este número não é divisível por 5 nem por 7.",
                    "Conteúdo 06 | Exercício 05",
                    JOptionPane.INFORMATION_MESSAGE);
    }
}
