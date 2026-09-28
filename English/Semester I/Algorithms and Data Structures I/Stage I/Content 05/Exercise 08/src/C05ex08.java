package FirstStage;

import javax.swing.JOptionPane;

/**
 * Calculate the square root of 360S divided by απ, with the angle in degrees.
 *
 * Assignment: C05ex08.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C05ex08 {

    static void main() {

        String sStr, aStr;

        double s, a, pi, r;

        pi = 3.1416;

        // Input: collect the requested values through dialog boxes.
        sStr = JOptionPane.showInputDialog(null,
                "Enter the area of a circular sector:",
                "Content 05 | Exercise 08",
                JOptionPane.QUESTION_MESSAGE);

        aStr = JOptionPane.showInputDialog(null,
                "Enter the angle:",
                "Content 05 | Exercise 08",
                JOptionPane.QUESTION_MESSAGE);

        s = Double.valueOf(sStr);
        a = Double.valueOf(aStr);

        // Processing: Calculate the square root of 360S divided by απ, with the angle in degrees.
        r = Math.sqrt((360 * s) / (a * pi));

        // Output: display the message for the current result.
        JOptionPane.showMessageDialog(null,
                "S: " + s + " A: " + a + " R: " + r,
                "Content 05 | Exercise 08",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
