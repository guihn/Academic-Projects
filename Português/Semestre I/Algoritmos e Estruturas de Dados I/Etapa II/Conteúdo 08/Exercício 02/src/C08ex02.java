package SecondStage;

import javax.swing.JOptionPane;

/**
 * Ler cada registro em um laço, interromper nos limites negativos implementados e testar nota e
 * frequência em conjunto.
 *
 * Atividade: C08ex02.
 */
public class C08ex02 {
    static void main() {
        String finalNoteStr, abscensesStr;
        double finalNote, abscenses;

        // Processamento: Ler cada registro em um laço, interromper nos limites negativos
        // implementados e testar nota e frequência em conjunto.
        for (int i = 1; i <=50; i ++) {
        // Entrada: coletar os valores solicitados por caixas de diálogo.
        finalNoteStr = JOptionPane.showInputDialog(null,
                "Informe a nota final do aluno: ",
                "Conteúdo 08 | Exercício 02",
                JOptionPane.QUESTION_MESSAGE);

            finalNote = Double.valueOf(finalNoteStr);

            if (finalNote <= -1) {
                // Saída: apresentar a mensagem correspondente ao resultado atual.
                JOptionPane.showMessageDialog(null,
                        "Programa encerrado devido a utilização de números negativos.",
                        "Conteúdo 08 | Exercício 02",
                        JOptionPane.ERROR_MESSAGE);
                break;
            } else {
                abscensesStr = JOptionPane.showInputDialog(null,
                        "Informe o número de faltas do aluno: ",
                        "Conteúdo 08 | Exercício 02",
                        JOptionPane.QUESTION_MESSAGE);

                abscenses = Double.valueOf(abscensesStr);

                if (abscenses <= -1) {
                    JOptionPane.showMessageDialog(null,
                            "Programa encerrado devido a utilização de números negativos.",
                            "Conteúdo 08 | Exercício 02",
                            JOptionPane.ERROR_MESSAGE);
                    break;
                } else {

                    if (finalNote >= 65 && abscenses <= 16) {
                        JOptionPane.showMessageDialog(null,
                                "Aluno aprovado!",
                                "Conteúdo 08 | Exercício 02",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else
                        JOptionPane.showMessageDialog(null,
                                "Aluno reprovado!",
                                "Conteúdo 08 | Exercício 02",
                                JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
