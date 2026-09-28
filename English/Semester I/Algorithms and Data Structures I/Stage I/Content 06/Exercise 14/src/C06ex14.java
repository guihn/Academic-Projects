package FirstStage;

import javax.swing.JOptionPane;

/**
 * Reject values outside 1000–9999, extract the digits and concatenate them from units to
 * thousands.
 *
 * Assignment: C06ex14.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex14 {

    static void main() {

        String numberStr;

        int number, d1, d2, d3, d4;

        // Input: collect the requested values through dialog boxes.
        numberStr = JOptionPane.showInputDialog(null,
                "Enter a number (5 digits):",
                "Content 05 | Exercise 14",
                JOptionPane.QUESTION_MESSAGE);

        number = Integer.valueOf(numberStr);

        // Processing: Reject values outside 1000–9999, extract the digits and concatenate them from
        // units to thousands.
        if (number < 1000 || number > 9999) {
            // Output: display the message for the current result.
            JOptionPane.showMessageDialog(null,
                    "THE NUMBER MUST HAVE 4 DIGITS",
                    "Content 06 | Exercise 14",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        d1 = number / 1000 % 10;

        d2 = number / 100 % 10;

        d3 = number / 10 % 10;

        d4 = number % 10;

        JOptionPane.showMessageDialog(null,
                "Printed number: " + d4 + d3 + d2 + d1,
                "Content 05 | Exercise 14",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
