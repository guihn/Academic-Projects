package FirstStage;

import javax.swing.JOptionPane;

/**
 * Multiply each grade by its weight, add the products and divide by the sum of the weights.
 *
 * Assignment: C05ex09.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C05ex09 {

    static void main() {

        String note1Str, note2Str, note3Str;

        double note1, note2, note3, weightedAverage, weightedSum;

        // Input: collect the requested values through dialog boxes.
        note1Str = JOptionPane.showInputDialog(null,
                "Enter the first grade:",
                "Content 05 | Exercise 09",
                JOptionPane.QUESTION_MESSAGE);

        note2Str = JOptionPane.showInputDialog(null,
                "Enter the second grade:",
                "Content 05 | Exercise 09",
                JOptionPane.QUESTION_MESSAGE);

        note3Str = JOptionPane.showInputDialog(null,
                "Enter the third grade:",
                "Content 05 | Exercise 09",
                JOptionPane.QUESTION_MESSAGE);

        note1 = Double.valueOf(note1Str);
        note2 = Double.valueOf(note2Str);
        note3 = Double.valueOf(note3Str);

        // Processing: Multiply each grade by its weight, add the products and divide by the sum of
        // the weights.
        weightedSum = (note1 * 2) + (note2 * 3) + (note3 * 5);

        weightedAverage = weightedSum / (2 + 3 + 5);

        // Output: display the message for the current result.
        JOptionPane.showMessageDialog(null,
                "Average: " + weightedAverage,
                "Content 05 | Exercise 09",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
