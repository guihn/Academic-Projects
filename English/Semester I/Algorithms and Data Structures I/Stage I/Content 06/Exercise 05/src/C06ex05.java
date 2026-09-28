package FirstStage;

import javax.swing.JOptionPane;

/**
 * Compare each remainder with zero and distinguish divisibility by both values, only one or
 * neither.
 *
 * Assignment: C06ex05.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex05 {

    static void main() {

        String numberStr;

        int number;

        // Input: collect the requested values through dialog boxes.
        numberStr = JOptionPane.showInputDialog(null,
                "Enter a number:",
                "Content 06 | Exercise 05",
                JOptionPane.QUESTION_MESSAGE);

        number = Integer.valueOf(numberStr);

        // Processing: Compare each remainder with zero and distinguish divisibility by both values,
        // only one or neither.
        if (number % 5 == 0 && number % 7 == 0)
            // Output: display the message for the current result.
            JOptionPane.showMessageDialog(null,
                    "This number is divisible by 5 and by 7.",
                    "Content 06 | Exercise 05",
                    JOptionPane.INFORMATION_MESSAGE);
            
        else if (number % 5 == 0 && number % 7 != 0)
            JOptionPane.showMessageDialog(null,
                    "This number is divisible by 5 only.",
                    "Content 06 | Exercise 05",
                    JOptionPane.INFORMATION_MESSAGE);
            
        else if (number % 5 != 0 && number % 7 == 0)
            JOptionPane.showMessageDialog(null,
                    "This number is divisible by 7 only.",
                    "Content 06 | Exercise 05",
                    JOptionPane.INFORMATION_MESSAGE);
            
        else if (number % 5 != 0 && number % 7 != 0)
            JOptionPane.showMessageDialog(null,
                    "This number is divisible by neither 5 nor 7.",
                    "Content 06 | Exercise 05",
                    JOptionPane.INFORMATION_MESSAGE);
    }
}
