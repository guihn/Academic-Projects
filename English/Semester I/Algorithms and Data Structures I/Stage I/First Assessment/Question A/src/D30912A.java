package FirstTest;

import javax.swing.JOptionPane;
import java.util.Scanner;

/**
 * Calculate c1 = 0.75x⁷ − 4, assign (5 + x)/2 to both c3 and c2, then evaluate c1 × c2 + c3.
 *
 * Assignment: D30912A.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class D30912A {
    static void main() {
        String xStr;
        double x, fx, c1, c2, c3;

        // Input: collect the requested values through dialog boxes.
        xStr = JOptionPane.showInputDialog(null,
                "Enter the value of X",
                "First Test | Question A",
                JOptionPane.QUESTION_MESSAGE);

        x = Double.valueOf(xStr);

        // Processing: Calculate c1 = 0.75x⁷ − 4, assign (5 + x)/2 to both c3 and c2, then evaluate
        // c1 × c2 + c3.
        c1 = 3.0/4 * Math.pow(x, 7) - 4;
        // The next line continues this chained assignment to c2 and c3.
        c2 =
        c3 = (5 + x) / 2;

        fx = c1 * c2 + c3;

        // Output: display the message for the current result.
        JOptionPane.showMessageDialog(null,
                "X: " + x + "\nf(x): " + fx,
                "First Test | Question A",
                JOptionPane.INFORMATION_MESSAGE);

    }
}
