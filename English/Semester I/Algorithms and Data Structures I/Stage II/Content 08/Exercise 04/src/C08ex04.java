package SecondStage;

import javax.swing.JOptionPane;

/**
 * Increment one of two counters according to each reported age.
 *
 * Assignment: C08ex04.
 */
public class C08ex04 {
    static void main() {
        String name, ageStr;
        int age, lowerthan18 = 0, higherthan18 = 0;

        // Processing: Increment one of two counters according to each reported age.
        for (int students = 1; students <= 5; students ++) {
            // Input: collect the requested values through dialog boxes.
            name = JOptionPane.showInputDialog(null,
                    "Enter your name: ",
                    "Content 08 | Exercise 04",
                    JOptionPane.QUESTION_MESSAGE);
            ageStr = JOptionPane.showInputDialog(null,
                    "Enter your age: ",
                    "Content 08 | Exercise 04",
                    JOptionPane.QUESTION_MESSAGE);

            age = Integer.valueOf(ageStr);

            if (age <= 18) {
                lowerthan18++;
            }
            else {
                higherthan18++;
            }
        }
        // Output: display the message for the current result.
        JOptionPane.showMessageDialog(null,
                "Up to 18: " + lowerthan18 + "\nAbove 18: " + higherthan18,
                "Content 08 | Exercise 04",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
