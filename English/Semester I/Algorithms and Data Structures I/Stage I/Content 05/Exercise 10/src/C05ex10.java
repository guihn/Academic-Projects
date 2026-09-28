package FirstStage;

import javax.swing.JOptionPane;

/**
 * Use integer division and remainders to extract digits from the highest place to the units.
 *
 * Assignment: C05ex10.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C05ex10 {

    static void main() {

        String numberStr;

        int number, d1, d2, d3, d4, d5;

        // Input: collect the requested values through dialog boxes.
        numberStr = JOptionPane.showInputDialog(null,
                "Enter a number (5 digits):",
                "Content 05 | Exercise 10",
                JOptionPane.QUESTION_MESSAGE);

        number = Integer.valueOf(numberStr);

        // Processing: Use integer division and remainders to extract digits from the highest place
        // to the units.
        d1 = number / 10000;

        d2 = number / 1000 % 10;

        d3 = number / 100 % 10;

        d4 = number / 10 % 10;

        d5 = number % 10;

        // Output: display the message for the current result.
        JOptionPane.showMessageDialog(null,
                "Printed number:\n" + d1 + "\n" + d2 + "\n" + d3 + "\n" + d4 + "\n" + d5,
                "Content 05 | Exercise 10",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
