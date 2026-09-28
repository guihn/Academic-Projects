package FirstStage;

import javax.swing.JOptionPane;

/**
 * Rejeitar valores fora de 1000–9999, extrair os dígitos e concatená-los das unidades aos
 * milhares.
 *
 * Atividade: C06ex14.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex14 {

    static void main() {

        String numberStr;

        int number, d1, d2, d3, d4;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        numberStr = JOptionPane.showInputDialog(null,
                "Informe um número em sequência (5 dígitos):",
                "Conteúdo 05 | Exercício 14",
                JOptionPane.QUESTION_MESSAGE);

        number = Integer.valueOf(numberStr);

        // Processamento: Rejeitar valores fora de 1000–9999, extrair os dígitos e concatená-los das
        // unidades aos milhares.
        if (number < 1000 || number > 9999) {
            // Saída: apresentar a mensagem correspondente ao resultado atual.
            JOptionPane.showMessageDialog(null,
                    "NÚMERO TEM QUE TER 4 DÍGITOS",
                    "Conteúdo 06 | Exercício 14",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        d1 = number / 1000 % 10;

        d2 = number / 100 % 10;

        d3 = number / 10 % 10;

        d4 = number % 10;

        JOptionPane.showMessageDialog(null,
                "Número impresso: " + d4 + d3 + d2 + d1,
                "Conteúdo 05 | Exercício 14",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
