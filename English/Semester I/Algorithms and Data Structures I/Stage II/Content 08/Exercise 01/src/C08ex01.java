package SecondStage;

import javax.swing.JOptionPane;

/**
 * Repeat the input and area calculation ten times, displaying each result inside the loop.
 *
 * Assignment: C08ex01.
 */
public class C08ex01 {
    static void main() {
        String rayStr;
        double ray, pi = 3.1416, area;

        // Processing: Repeat the input and area calculation ten times, displaying each result
        // inside the loop.
        for (int i = 1; i <=10; i++) {
            // Input: collect the requested values through dialog boxes.
            rayStr = JOptionPane.showInputDialog(null,
                    "Enter the circle radius: ",
                    "Content 08 | Exercise 01",
                    JOptionPane.QUESTION_MESSAGE);
            ray = Double.valueOf(rayStr);

            area = pi * Math.pow(ray, 2);

            // Output: display the message for the current result.
            JOptionPane.showMessageDialog(null,
                    "Area: " + area,
                    "Content 08 | Exercise 01",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
