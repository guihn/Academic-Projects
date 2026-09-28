package SecondStage;

import javax.swing.JOptionPane;

/**
 * Classify each record, update the supplied grade and attendance variables and divide the stored
 * grade value by the pass count.
 *
 * Assignment: C08ex08.
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
        // Processing: Classify each record, update the supplied grade and attendance variables and
        // divide the stored grade value by the pass count.
        for (i = 1; i <= rep; i++) {
            // Input: collect the requested values through dialog boxes.
            finalNoteStr = JOptionPane.showInputDialog(null,
                    "Enter the final grade for student " + i + ": ",
                    "Content 08 | Exercise 08",
                    JOptionPane.QUESTION_MESSAGE);
            absensesStr = JOptionPane.showInputDialog(null,
                    "Enter the number of absences for student " + i + ": ",
                    "Content 08 | Exercise 08",
                    JOptionPane.QUESTION_MESSAGE);

            finalNote = Integer.parseInt(finalNoteStr);
            absenses = Integer.parseInt(absensesStr);

            if (finalNote >= 65 && absenses <= 16) {
                approved++;
                // Output: display the message for the current result.
                JOptionPane.showMessageDialog(null,
                        "You PASSED!",
                        "Content 08 | Exercise 08",
                        JOptionPane.INFORMATION_MESSAGE);
                // The original =+ applies unary plus and assigns the value; it does not accumulate
                // like +=.
                allNotesApproved =+ finalNote;
            }
            else if (absenses > 16) {
                over16Absenses++;
                JOptionPane.showMessageDialog(null,
                        "You FAILED!",
                        "Content 08 | Exercise 08",
                        JOptionPane.ERROR_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog(null,
                        "You FAILED!",
                        "Content 08 | Exercise 08",
                        JOptionPane.ERROR_MESSAGE);
        }

        // This integer division has no guard for a zero pass count.
        mediaOfAllNotesApproved = allNotesApproved / approved;
        JOptionPane.showMessageDialog(null,
                "Average grade of students who passed: " + mediaOfAllNotesApproved + "\nNumber of students with more than 16 absences: " + over16Absenses);
    }
}
