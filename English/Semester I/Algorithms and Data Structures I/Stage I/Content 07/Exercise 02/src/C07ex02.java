package FirstStage;

import javax.swing.JOptionPane;

/**
 * Use integer division for the mean and select the output text with switch.
 *
 * Assignment: C07ex02.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C07ex02 {

    static void main() {

        String parcialNoteOneStr, parcialNoteTwoStr, parcialNoteThreeStr, concept;

        int parcialNoteOne, parcialNoteTwo, parcialNoteThree, finalNote, media;

        // Input: collect the requested values through dialog boxes.
        parcialNoteOneStr = JOptionPane.showInputDialog(null,
                "Enter your first grade: ",
                "Content 07 | Exercise 02",
                JOptionPane.QUESTION_MESSAGE);

        parcialNoteTwoStr = JOptionPane.showInputDialog(null,
                "Enter your second grade: ",
                "Content 07 | Exercise 02",
                JOptionPane.QUESTION_MESSAGE);

        parcialNoteThreeStr = JOptionPane.showInputDialog(null,
                "Enter your third grade: ",
                "Content 07 | Exercise 02",
                JOptionPane.QUESTION_MESSAGE);

        parcialNoteOne = Integer.valueOf(parcialNoteOneStr);
        parcialNoteTwo = Integer.valueOf(parcialNoteTwoStr);
        parcialNoteThree = Integer.valueOf(parcialNoteThreeStr);

        // Processing: Use integer division for the mean and select the output text with switch.
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
                concept = "Give up on your life";
            
            default ->
                    concept = "You did not enter grades up to 10.";
        }

        // Output: display the message for the current result.
        JOptionPane.showMessageDialog(null,
                "Grade category: " + concept,
                "Content 07 | Exercise 02",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
