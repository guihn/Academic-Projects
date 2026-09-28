package FirstStage;

import javax.swing.JOptionPane;

/**
 * Evaluate x³ + 4x + 10 using Math.pow for the cubic term.
 *
 * Assignment: C05ex01.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C05ex01 {

    static void main() {

        String xStr;

        int x;

        double fx;

        // Input: collect the requested values through dialog boxes.
        xStr = JOptionPane.showInputDialog(null,
                "Enter the value of X:",
                "Content 05 | Exercise 01",
                JOptionPane.QUESTION_MESSAGE);

        x = Integer.valueOf(xStr);

        // Processing: Evaluate x³ + 4x + 10 using Math.pow for the cubic term.
        fx = 1 * Math.pow(x, 3) + 4 * x + 10;

        // Output: display the message for the current result.
        JOptionPane.showMessageDialog(null,
                "X = " + xStr + " -> f(x) = " + fx,
                "Content 05 | Exercise 01",
                JOptionPane.INFORMATION_MESSAGE);

    }
}
