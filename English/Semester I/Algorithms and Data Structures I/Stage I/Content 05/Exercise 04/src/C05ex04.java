package FirstStage;

import javax.swing.JOptionPane;

/**
 * Compute the square root of the sum of the squared differences between corresponding
 * coordinates.
 *
 * Assignment: C05ex04.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C05ex04 {

    static void main() {

        String x1Str, y1Str, x2Str, y2Str;

        double x1, y1, x2, y2, distance;

        // Input: collect the requested values through dialog boxes.
        x1Str = JOptionPane.showInputDialog(null,
                "Enter X for point 1:",
                "Content 05 | Exercise 04",
                JOptionPane.QUESTION_MESSAGE);

        y1Str = JOptionPane.showInputDialog(null,
                "Enter Y for point 1:",
                "Content 05 | Exercise 04",
                JOptionPane.QUESTION_MESSAGE);

        x2Str = JOptionPane.showInputDialog(null,
                "Enter X for point 2:",
                "Content 05 | Exercise 04",
                JOptionPane.QUESTION_MESSAGE);

        y2Str = JOptionPane.showInputDialog(null,
                "Enter Y for point 2:",
                "Content 05 | Exercise 04",
                JOptionPane.QUESTION_MESSAGE);

        x1 = Double.valueOf(x1Str);
        y1 = Double.valueOf(y1Str);
        x2 = Double.valueOf(x2Str);
        y2 = Double.valueOf(y2Str);

        // Processing: Compute the square root of the sum of the squared differences between
        // corresponding coordinates.
        distance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));

        // Output: display the message for the current result.
        JOptionPane.showMessageDialog(null,
                "Distance: " + distance,
                "Content 05 | Exercise 04",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
