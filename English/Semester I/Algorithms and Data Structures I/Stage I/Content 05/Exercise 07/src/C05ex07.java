package FirstStage;

import javax.swing.JOptionPane;

/**
 * Calculate the square root of (x/4 + 1)² plus the real fifth root of x, preserving the sign of
 * the fifth root.
 *
 * Assignment: C05ex07.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C05ex07 {

    static void main() {

        String xStr;

        double x, fx, c1, c2;

        // Input: collect the requested values through dialog boxes.
        xStr = JOptionPane.showInputDialog(null,
                "Enter the value of X:",
                "Content 05 | Exercise 07",
                JOptionPane.QUESTION_MESSAGE);

        x = Double.valueOf(xStr);

        // Processing: Calculate the square root of (x/4 + 1)² plus the real fifth root of x,
        // preserving the sign of the fifth root.
        c1 = Math.pow((x / 4 + 1), 2);

        // Keep the fifth root real for negative x by restoring its sign.
        c2 = Math.copySign(Math.pow(Math.abs(x), 1.0 / 5), x);

        fx = Math.sqrt(c1 + c2);

        // Output: display the message for the current result.
        JOptionPane.showMessageDialog(null,
                "X: " + x + "\nf(x): " + fx,
                "Content 05 | Exercise 07",
                JOptionPane.INFORMATION_MESSAGE);

    }
}
