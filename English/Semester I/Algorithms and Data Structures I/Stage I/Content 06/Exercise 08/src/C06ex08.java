package FirstStage;

import javax.swing.JOptionPane;

/**
 * Multiply squared height by 20 and 25 to obtain the two endpoints.
 *
 * Assignment: C06ex08.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex08 {

    static void main() {

        String name, heightStr;

        double height, weight, weightMin, weightMax;

        // Input: collect the requested values through dialog boxes.
        name = JOptionPane.showInputDialog(null,
                "Enter your name:",
                "Content 06 | Exercise 08",
                JOptionPane.QUESTION_MESSAGE);

        heightStr = JOptionPane.showInputDialog(null,
                "Enter your height:",
                "Content 06 | Exercise 08",
                JOptionPane.QUESTION_MESSAGE);

        height = Double.valueOf(heightStr);

        // Processing: Multiply squared height by 20 and 25 to obtain the two endpoints.
        weightMin = 20 * Math.pow(height, 2);

        weightMax = 25 * Math.pow(height, 2);

        // Output: display the message for the current result.
        JOptionPane.showMessageDialog(null,
                "Minimum weight: " + weightMin + "\nMaximum weight: " + weightMax,
                "Content 06 | Exercise 08",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
