package FirstStage;

import javax.swing.JOptionPane;

/**
 * Calculate the discriminant and report no real roots, one repeated root or two distinct roots.
 *
 * Assignment: C06ex06.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex06 {

    static void main() {

        String aStr, bStr, cStr;

        double a, b, c, fx, delta, c1, c2;

        // Input: collect the requested values through dialog boxes.
        aStr = JOptionPane.showInputDialog(null,
                "Enter the value of A:",
                "Content 06 | Exercise 06",
                JOptionPane.QUESTION_MESSAGE);

        bStr = JOptionPane.showInputDialog(null,
                "Enter the value of B:",
                "Content 06 | Exercise 06",
                JOptionPane.QUESTION_MESSAGE);

        cStr = JOptionPane.showInputDialog(null,
                "Enter the value of C:",
                "Content 06 | Exercise 06",
                JOptionPane.QUESTION_MESSAGE);

        a = Double.valueOf(aStr);
        b = Double.valueOf(bStr);
        c = Double.valueOf(cStr);

        // Processing: Calculate the discriminant and report no real roots, one repeated root or two
        // distinct roots.
        delta = Math.pow(b, 2) - (4 * a * c);

        if (delta < 0) {
            // Output: display the message for the current result.
            JOptionPane.showMessageDialog(null,
                    "There are no real roots",
                    "Content 06 | Exercise 06",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {

            c1 = (-b + Math.sqrt(delta)) / (2 * a);
            c2 = (-b - Math.sqrt(delta)) / (2 * a);

            if (c1 == c2) {
                JOptionPane.showMessageDialog(null,
                        "There is 1 root = " + c1,
                        "Content 06 | Exercise 06",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                
                JOptionPane.showMessageDialog(null,
                        "There are 2 roots = " + c1 + " and " + c2,
                        "Content 06 | Exercise 06",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
