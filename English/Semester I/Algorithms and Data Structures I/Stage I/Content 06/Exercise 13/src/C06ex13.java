package FirstStage;

import javax.swing.JOptionPane;

/**
 * Subtract the times and borrow one hour when the minute difference is negative.
 *
 * Assignment: C06ex13.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex13 {

    static void main() {

        String initialHourStr, initialMinuteStr, finalHourStr, finalMinuteStr;

        int initialHour, initialMinute, finalHour, finalMinute, durationHour, durationMinute;

        // Input: collect the requested values through dialog boxes.
        initialHourStr = JOptionPane.showInputDialog(null,
                "Enter the starting hour: ",
                "Content 06 | Exercise 13",
                JOptionPane.QUESTION_MESSAGE);

        initialMinuteStr = JOptionPane.showInputDialog(null,
                "Enter the starting minute: ",
                "Content 06 | Exercise 13",
                JOptionPane.QUESTION_MESSAGE);

        finalHourStr = JOptionPane.showInputDialog(null,
                "Enter the ending hour: ",
                "Content 06 | Exercise 13",
                JOptionPane.QUESTION_MESSAGE);

        finalMinuteStr = JOptionPane.showInputDialog(null,
                "Enter the ending minute: ",
                "Content 06 | Exercise 13",
                JOptionPane.QUESTION_MESSAGE);

        initialHour = Integer.valueOf(initialHourStr);
        initialMinute = Integer.valueOf(initialMinuteStr);
        finalHour = Integer.valueOf(finalHourStr);
        finalMinute = Integer.valueOf(finalMinuteStr);

        // Processing: Subtract the times and borrow one hour when the minute difference is
        // negative.
        durationHour = finalHour - initialHour;
        durationMinute = finalMinute - initialMinute;

        // Borrow one hour and convert it to 60 minutes.
        if (durationMinute < 0) {
            durationHour = durationHour - 1;
            durationMinute = durationMinute + 60;
        }

        else {
            durationHour = durationHour;
            durationMinute = durationMinute;
        }

        // Output: display the message for the current result.
        JOptionPane.showMessageDialog(null,
                "Duration: " + durationHour + " hours and " + durationMinute + " minutes.");
    }
}
