package SecondStage;

import javax.swing.JOptionPane;

/**
 * Read each record inside a loop, interrupt on the implemented negative thresholds and test the
 * grade and attendance together.
 *
 * Assignment: C08ex02.
 */
public class C08ex02 {
    static void main() {
        String finalNoteStr, abscensesStr;
        double finalNote, abscenses;

        // Processing: Read each record inside a loop, interrupt on the implemented negative
        // thresholds and test the grade and attendance together.
        for (int i = 1; i <=50; i ++) {
        // Input: collect the requested values through dialog boxes.
        finalNoteStr = JOptionPane.showInputDialog(null,
                "Enter the student's final grade: ",
                "Content 08 | Exercise 02",
                JOptionPane.QUESTION_MESSAGE);

            finalNote = Double.valueOf(finalNoteStr);

            if (finalNote <= -1) {
                // Output: display the message for the current result.
                JOptionPane.showMessageDialog(null,
                        "The program ended because negative numbers were used.",
                        "Content 08 | Exercise 02",
                        JOptionPane.ERROR_MESSAGE);
                break;
            } else {
                abscensesStr = JOptionPane.showInputDialog(null,
                        "Enter the student's number of absences: ",
                        "Content 08 | Exercise 02",
                        JOptionPane.QUESTION_MESSAGE);

                abscenses = Double.valueOf(abscensesStr);

                if (abscenses <= -1) {
                    JOptionPane.showMessageDialog(null,
                            "The program ended because negative numbers were used.",
                            "Content 08 | Exercise 02",
                            JOptionPane.ERROR_MESSAGE);
                    break;
                } else {

                    if (finalNote >= 65 && abscenses <= 16) {
                        JOptionPane.showMessageDialog(null,
                                "Student passed!",
                                "Content 08 | Exercise 02",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else
                        JOptionPane.showMessageDialog(null,
                                "Student failed!",
                                "Content 08 | Exercise 02",
                                JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
