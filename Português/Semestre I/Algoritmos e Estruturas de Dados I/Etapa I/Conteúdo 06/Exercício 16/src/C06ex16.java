package FirstStage;

import javax.swing.JOptionPane;

/**
 * Descartar a menor nota de prova, escolher os dois pesos e classificar a expressão ponderada
 * nas cinco faixas de nota.
 *
 * Atividade: C06ex16.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex16 {

    static void main() {

        String absencesStr, firstTestStr, secondTestStr, thirdTestStr, finalWorkStr, studentAgeStr;

        int absences, weightOne, weightTwo, studentAge;

        double firstTest, secondTest, thirdTest, highestNoteOne, highestNoteTwo, finalWork, finalNote;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        absencesStr = JOptionPane.showInputDialog(null,
                "Informe a quantidade de faltas: ",
                "Conteúdo 06 | Exercício 16",
                JOptionPane.QUESTION_MESSAGE);

        firstTestStr = JOptionPane.showInputDialog(null,
                "Informe a nota da 1° prova: ",
                "Conteúdo 06 | Exercício 16",
                JOptionPane.QUESTION_MESSAGE);

        secondTestStr = JOptionPane.showInputDialog(null,
                "Informe a nota da 2° prova: ",
                "Conteúdo 06 | Exercício 16",
                JOptionPane.QUESTION_MESSAGE);

        thirdTestStr = JOptionPane.showInputDialog(null,
                "Informe a nota da 3° prova: ",
                "Conteúdo 06 | Exercício 16",
                JOptionPane.QUESTION_MESSAGE);

        finalWorkStr = JOptionPane.showInputDialog(null,
                "Informe a nota do trabalho final: ",
                "Conteúdo 06 | Exercício 16",
                JOptionPane.QUESTION_MESSAGE);

        studentAgeStr = JOptionPane.showInputDialog(null,
                "Informe sua idade: ",
                "Conteúdo 06 | Exercício 16",
                JOptionPane.QUESTION_MESSAGE);

        absences = Integer.valueOf(absencesStr);
        firstTest = Double.valueOf(firstTestStr);
        secondTest = Double.valueOf(secondTestStr);
        thirdTest = Double.valueOf(thirdTestStr);
        finalWork = Double.valueOf(finalWorkStr);
        studentAge = Integer.valueOf(studentAgeStr);

        // Processamento: Descartar a menor nota de prova, escolher os dois pesos e classificar a
        // expressão ponderada nas cinco faixas de nota.
        if (firstTest <= secondTest && firstTest <= thirdTest) {
            highestNoteOne = secondTest;
            highestNoteTwo = thirdTest;
        }
        
        else if (secondTest <= firstTest && secondTest <= thirdTest) {
            highestNoteOne = firstTest;
            highestNoteTwo = thirdTest;
        }
        
        else {
            highestNoteOne = firstTest;
            highestNoteTwo = secondTest;
        }

        if (absences <= 5)
            weightOne = 3;
            
        else if (absences <= 10)
            weightOne = 2;
            
        else
            weightOne = 1;

        if (studentAge <= 17)
            weightTwo = 1;
            
        else if (studentAge <= 50)
            weightTwo = 2;
            
        else
            weightTwo = 3;

        finalNote = (highestNoteOne + highestNoteTwo) / 2 * weightOne + finalWork * weightTwo;

        if (finalNote <= 50)
            // Saída: apresentar a mensagem correspondente ao resultado atual.
            JOptionPane.showMessageDialog(null,
                    "Reprovado!",
                    "Conteúdo 06 | Exercício 16",
                    JOptionPane.ERROR_MESSAGE);
            
        else if (finalNote <= 70)
            JOptionPane.showMessageDialog(null,
                    "Regular!",
                    "Conteúdo 06 | Exercício 16",
                    JOptionPane.INFORMATION_MESSAGE);
            
        else if (finalNote <= 80)
            JOptionPane.showMessageDialog(null,
                    "Bom!",
                    "Conteúdo 06 | Exercício 16",
                    JOptionPane.INFORMATION_MESSAGE);
            
        else if (finalNote <= 90)
            JOptionPane.showMessageDialog(null,
                    "Muito bom!",
                    "Conteúdo 06 | Exercício 16",
                    JOptionPane.INFORMATION_MESSAGE);
            
        else
            JOptionPane.showMessageDialog(null,
                    "Excelente!",
                    "Conteúdo 06 | Exercício 16",
                    JOptionPane.INFORMATION_MESSAGE);
    }
}
