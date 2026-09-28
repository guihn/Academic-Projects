package FirstStage;

import javax.swing.JOptionPane;

/**
 * Extrair os três grupos com operações de divisão inteira e resto.
 *
 * Atividade: C05ex11.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C05ex11 {

    static void main() {

        String numberStr;

        int number, bank, agency, sequencial;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        numberStr = JOptionPane.showInputDialog(null,
                "Informe o número (9 dígitos):",
                "Conteúdo 05 | Exercício 11",
                JOptionPane.QUESTION_MESSAGE);

        number = Integer.valueOf(numberStr);

        // Processamento: Extrair os três grupos com operações de divisão inteira e resto.
        bank = number / 1000000;

        agency = number / 1000 % 1000;

        sequencial = number % 1000;

        // Saída: apresentar a mensagem correspondente ao resultado atual.
        JOptionPane.showMessageDialog(null,
                "Banco: " + bank + "\nAgência: " + agency + "\nSequencial: " + sequencial,
                "Conteúdo 05 | Exercício 11",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
