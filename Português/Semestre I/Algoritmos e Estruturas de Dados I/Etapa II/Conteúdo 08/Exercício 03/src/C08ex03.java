package SecondStage;

import javax.swing.JOptionPane;

/**
 * Manter contadores separados ao aplicar a condição nota ≥ 65 e faltas ≤ 16 a cada registro.
 *
 * Atividade: C08ex03.
 */
public class C08ex03 {
    static void main() {
        String finalNoteStr, abscensesStr;
        int  approved = 0, disapproved = 0;
        double finalNote, abscenses;

        // Processamento: Manter contadores separados ao aplicar a condição nota ≥ 65 e faltas ≤ 16
        // a cada registro.
        for (int i = 1; i <=3; i ++) {
            // Entrada: coletar os valores solicitados por caixas de diálogo.
            finalNoteStr = JOptionPane.showInputDialog(null,
                    "Informe a nota final do aluno: ",
                    "Conteúdo 08 | Exercício 03",
                    JOptionPane.QUESTION_MESSAGE);

            finalNote = Double.valueOf(finalNoteStr);

            if (finalNote <= -1) {
                // Saída: apresentar a mensagem correspondente ao resultado atual.
                JOptionPane.showMessageDialog(null,
                        "Programa encerrado devido a utilização de números negativos.",
                        "Conteúdo 08 | Exercício 03",
                        JOptionPane.ERROR_MESSAGE);
                break;
            } else {
                abscensesStr = JOptionPane.showInputDialog(null,
                        "Informe o número de faltas do aluno: ",
                        "Conteúdo 08 | Exercício 03",
                        JOptionPane.QUESTION_MESSAGE);

                abscenses = Double.valueOf(abscensesStr);

                if (abscenses <= -1) {
                    JOptionPane.showMessageDialog(null,
                            "Programa encerrado devido a utilização de números negativos.",
                            "Conteúdo 08 | Exercício 03",
                            JOptionPane.ERROR_MESSAGE);
                    break;
                } else {

                    if (finalNote >= 65 && abscenses <= 16) {
                        JOptionPane.showMessageDialog(null,
                                "Aluno aprovado!",
                                "Conteúdo 08 | Exercício 03",
                                JOptionPane.INFORMATION_MESSAGE);

                        approved++;

                        } else {
                        JOptionPane.showMessageDialog(null,
                                "Aluno reprovado!",
                                "Conteúdo 08 | Exercício 03",
                                JOptionPane.ERROR_MESSAGE);

                        disapproved++;
                    }
                }
            }
        }

        JOptionPane.showMessageDialog(null,
                "Aprovados: " + approved + "\nReprovados: " + disapproved,
                "Conteúdo 08 | Exercício 03",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
