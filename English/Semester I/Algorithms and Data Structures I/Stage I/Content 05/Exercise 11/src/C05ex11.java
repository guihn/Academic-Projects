package FirstStage;

import javax.swing.JOptionPane;

/**
 * Extract the three groups with integer division and remainder operations.
 *
 * Assignment: C05ex11.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C05ex11 {

    static void main() {

        String numberStr;

        int number, bank, agency, sequencial;

        // Input: collect the requested values through dialog boxes.
        numberStr = JOptionPane.showInputDialog(null,
                "Enter the number (9 digits):",
                "Content 05 | Exercise 11",
                JOptionPane.QUESTION_MESSAGE);

        number = Integer.valueOf(numberStr);

        // Processing: Extract the three groups with integer division and remainder operations.
        bank = number / 1000000;

        agency = number / 1000 % 1000;

        sequencial = number % 1000;

        // Output: display the message for the current result.
        JOptionPane.showMessageDialog(null,
                "Bank: " + bank + "\nBranch: " + agency + "\nSequence: " + sequencial,
                "Content 05 | Exercise 11",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
