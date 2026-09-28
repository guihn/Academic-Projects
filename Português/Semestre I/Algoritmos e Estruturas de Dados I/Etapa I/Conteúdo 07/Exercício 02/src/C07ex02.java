package FirstStage;

import javax.swing.JOptionPane;

/**
 * Usar divisão inteira na média e selecionar o texto de saída com switch.
 *
 * Atividade: C07ex02.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C07ex02 {

    static void main() {

        String parcialNoteOneStr, parcialNoteTwoStr, parcialNoteThreeStr, concept;

        int parcialNoteOne, parcialNoteTwo, parcialNoteThree, finalNote, media;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        parcialNoteOneStr = JOptionPane.showInputDialog(null,
                "Informe sua 1° nota: ",
                "Conteúdo 07 | Exercício 02",
                JOptionPane.QUESTION_MESSAGE);

        parcialNoteTwoStr = JOptionPane.showInputDialog(null,
                "Informe sua 2° nota: ",
                "Conteúdo 07 | Exercício 02",
                JOptionPane.QUESTION_MESSAGE);

        parcialNoteThreeStr = JOptionPane.showInputDialog(null,
                "Informe sua 3° nota: ",
                "Conteúdo 07 | Exercício 02",
                JOptionPane.QUESTION_MESSAGE);

        parcialNoteOne = Integer.valueOf(parcialNoteOneStr);
        parcialNoteTwo = Integer.valueOf(parcialNoteTwoStr);
        parcialNoteThree = Integer.valueOf(parcialNoteThreeStr);

        // Processamento: Usar divisão inteira na média e selecionar o texto de saída com switch.
        finalNote = (parcialNoteOne + parcialNoteTwo + parcialNoteThree) / 3;

        switch (finalNote) {
            
            case 9, 10 ->
                    concept = "A";
            
            case 8 ->
                    concept = "B";
            
            case 7 ->
                    concept = "C";
            
            case 5, 6 ->
                    concept = "D";
            
            case 1, 2, 3, 4 ->
                    concept = "E";
            case 0 ->
                concept = "Desiste da sua vida";
            
            default ->
                    concept = "Você não inseriu notas até 10.";
        }

        // Saída: apresentar a mensagem correspondente ao resultado atual.
        JOptionPane.showMessageDialog(null,
                "Conceito: " + concept,
                "Conteúdo 07 | Exercício 02",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
