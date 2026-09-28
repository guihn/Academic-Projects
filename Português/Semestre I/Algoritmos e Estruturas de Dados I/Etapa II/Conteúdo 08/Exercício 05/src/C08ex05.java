package SecondStage;

import javax.swing.JOptionPane;

/**
 * Contar cada código válido e comparar os totais. Decrementar o contador do laço para repetir
 * uma entrada inválida.
 *
 * Atividade: C08ex05.
 */
public class C08ex05 {
    static void main() {
        String votesStr;
        int votes, votes1C, votes2C, votes3C, rep;

        votes = 0;
        votes1C = 0;
        votes2C = 0;
        votes3C = 0;
        rep = 100;

        // Processamento: Contar cada código válido e comparar os totais. Decrementar o contador do
        // laço para repetir uma entrada inválida.
        for (int i = 1; i <= rep; i ++) {

            // Entrada: coletar os valores solicitados por caixas de diálogo.
            votesStr = JOptionPane.showInputDialog(null,
                    "Informe o numero do candidato: ",
                    "Conteúdo 08 | Exercício 05",
                    JOptionPane.QUESTION_MESSAGE);
            votes = Integer.parseInt(votesStr);

            switch (votes) {
                case 1 -> {
                    votes1C++;
                    // Saída: apresentar a mensagem correspondente ao resultado atual.
                    JOptionPane.showMessageDialog(null,
                            "Voto computado!",
                            "Conteúdo 08 | Exercício 05",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                case 2 -> {
                    votes2C++;
                    JOptionPane.showMessageDialog(null,
                            "Voto computado!",
                            "Conteúdo 08 | Exercício 05",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                case 3 -> {
                    votes3C++;
                    JOptionPane.showMessageDialog(null,
                            "Voto computado!",
                            "Conteúdo 08 | Exercício 05",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                default -> {
                    JOptionPane.showMessageDialog(null,
                            "Você digitou um número inválido! Tente: 1, 2 ou 3.",
                            "Conteúdo 08 | Exercício 05",
                            JOptionPane.ERROR_MESSAGE);
                    i--;
                }
            }
        }

        if (votes1C > votes2C && votes1C > votes3C) {
            JOptionPane.showMessageDialog(null,
                    "O candidato 'Fulano' venceu! O número de votos dele foi de: " + votes1C,
                    "Conteúdo 08 | Exercício 05",
                    JOptionPane.INFORMATION_MESSAGE);
        } else if (votes2C > votes1C && votes2C > votes3C) {
            JOptionPane.showMessageDialog(null,
                    "O candidato 'Ciclano' venceu! O número de votos dele foi de: " + votes2C,
                    "Conteúdo 08 | Exercício 05",
                    JOptionPane.INFORMATION_MESSAGE);
        } else if (votes3C > votes1C && votes3C > votes2C) {
            JOptionPane.showMessageDialog(null,
                    "O candidato 'Beltrano' venceu! O número de votos dele foi de: " + votes3C,
                    "Conteúdo 08 | Exercício 05",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Houve talvez um empate, porém esse programa não responderá a essa questão.",
                    "Conteúdo 08 | Exercício 05",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
