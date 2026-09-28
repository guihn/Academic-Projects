package SecondStage;

import javax.swing.JOptionPane;

/**
 * Maintain separate counters while applying the grade ≥ 65 and absences ≤ 16 condition to each
 * record.
 *
 * Assignment: C08ex03.
 */
public class C08ex03 {
    static void main() {
        String finalNoteStr, abscensesStr;
        int  approved = 0, disapproved = 0;
        double finalNote, abscenses;

        // Processing: Maintain separate counters while applying the grade ≥ 65 and absences ≤ 16
        // condition to each record.
        for (int i = 1; i <=3; i ++) {
            // Input: collect the requested values through dialog boxes.
            finalNoteStr = JOptionPane.showInputDialog(null,
                    "Enter the student's final grade: ",
                    "Content 08 | Exercise 03",
                    JOptionPane.QUESTION_MESSAGE);

            finalNote = Double.valueOf(finalNoteStr);

            if (finalNote <= -1) {
                // Output: display the message for the current result.
                JOptionPane.showMessageDialog(null,
                        "The program ended because negative numbers were used.",
                        "Content 08 | Exercise 03",
                        JOptionPane.ERROR_MESSAGE);
                break;
            } else {
                abscensesStr = JOptionPane.showInputDialog(null,
                        "Enter the student's number of absences: ",
                        "Content 08 | Exercise 03",
                        JOptionPane.QUESTION_MESSAGE);

                abscenses = Double.valueOf(abscensesStr);

                if (abscenses <= -1) {
                    JOptionPane.showMessageDialog(null,
                            "The program ended because negative numbers were used.",
                            "Content 08 | Exercise 03",
                            JOptionPane.ERROR_MESSAGE);
                    break;
                } else {

                    if (finalNote >= 65 && abscenses <= 16) {
                        JOptionPane.showMessageDialog(null,
                                "Student passed!",
                                "Content 08 | Exercise 03",
                                JOptionPane.INFORMATION_MESSAGE);

                        approved++;

                        } else {
                        JOptionPane.showMessageDialog(null,
                                "Student failed!",
                                "Content 08 | Exercise 03",
                                JOptionPane.ERROR_MESSAGE);

                        disapproved++;
                    }
                }
            }
        }

        JOptionPane.showMessageDialog(null,
                "Passed: " + approved + "\nFailed: " + disapproved,
                "Content 08 | Exercise 03",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
