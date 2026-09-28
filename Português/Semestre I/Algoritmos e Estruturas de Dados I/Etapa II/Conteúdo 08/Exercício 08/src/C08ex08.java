package SecondStage;

import javax.swing.JOptionPane;

/**
 * Classificar cada registro, atualizar as variáveis de nota e frequência fornecidas e dividir o
 * valor de nota armazenado pela quantidade de aprovados.
 *
 * Atividade: C08ex08.
 */
public class C08ex08 {
    static void main() {
        String finalNoteStr, absensesStr;
        int rep, finalNote, absenses, approved, allNotesApproved, mediaOfAllNotesApproved, over16Absenses;

        rep = 3;
        approved = 0;
        allNotesApproved = 0;
        over16Absenses = 0;

        int i;
        // Processamento: Classificar cada registro, atualizar as variáveis de nota e frequência
        // fornecidas e dividir o valor de nota armazenado pela quantidade de aprovados.
        for (i = 1; i <= rep; i++) {
            // Entrada: coletar os valores solicitados por caixas de diálogo.
            finalNoteStr = JOptionPane.showInputDialog(null,
                    "Informe o número da nota final do " + i + "° aluno: ",
                    "Conteúdo 08 | Exercício 08",
                    JOptionPane.QUESTION_MESSAGE);
            absensesStr = JOptionPane.showInputDialog(null,
                    "Informe o número de faltas do " + i + "° aluno: ",
                    "Conteúdo 08 | Exercício 08",
                    JOptionPane.QUESTION_MESSAGE);

            finalNote = Integer.parseInt(finalNoteStr);
            absenses = Integer.parseInt(absensesStr);

            if (finalNote >= 65 && absenses <= 16) {
                approved++;
                // Saída: apresentar a mensagem correspondente ao resultado atual.
                JOptionPane.showMessageDialog(null,
                        "Você foi APROVADO!",
                        "Conteúdo 08 | Exercício 08",
                        JOptionPane.INFORMATION_MESSAGE);
                // O =+ original aplica o mais unário e atribui o valor; não acumula como +=.
                allNotesApproved =+ finalNote;
            }
            else if (absenses > 16) {
                over16Absenses++;
                JOptionPane.showMessageDialog(null,
                        "Você foi REPROVADO!",
                        "Conteúdo 08 | Exercício 08",
                        JOptionPane.ERROR_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog(null,
                        "Você foi REPROVADO!",
                        "Conteúdo 08 | Exercício 08",
                        JOptionPane.ERROR_MESSAGE);
        }

        // Esta divisão inteira não verifica se a quantidade de aprovados é zero.
        mediaOfAllNotesApproved = allNotesApproved / approved;
        JOptionPane.showMessageDialog(null,
                "Média das notas dos aprovados: " + mediaOfAllNotesApproved + "\nQuantidade de alunos com mais de 16 faltas: " + over16Absenses);
    }
}
