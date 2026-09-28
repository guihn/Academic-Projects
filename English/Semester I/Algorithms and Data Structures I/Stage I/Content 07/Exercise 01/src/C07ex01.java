package FirstStage;

import javax.swing.JOptionPane;

/**
 * Handle the low score bands with if statements and select the cash prize for 11, 12 or 13
 * correct predictions with switch.
 *
 * Assignment: C07ex01.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C07ex01 {

    static void main() {

        String name, winsStr;

        int wins;

        double award;

        // Input: collect the requested values through dialog boxes.
        name = JOptionPane.showInputDialog(null,
                "Enter your name: ",
                "Content 07 | Exercise 01",
                JOptionPane.QUESTION_MESSAGE);

        winsStr = JOptionPane.showInputDialog(null,
                "Enter your number of correct predictions: ",
                "Content 07 | Exercise 01",
                JOptionPane.QUESTION_MESSAGE);

        wins = Integer.valueOf(winsStr);

        // Processing: Handle the low score bands with if statements and select the cash prize for
        // 11, 12 or 13 correct predictions with switch.
        if (wins <= 5) {
            // Output: display the message for the current result.
            JOptionPane.showMessageDialog(null,
                    name + ", you got too few correct predictions and will receive no prize!",
                    "Content 07 | Exercise 01",
                    JOptionPane.ERROR_MESSAGE);
        } else if (wins <= 10) {
            
            JOptionPane.showMessageDialog(null,
                    name + ", you got few correct predictions, but will receive another betting slip!",
                    "Content 07 | Exercise 01",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {

            switch (wins) {
                case 11 -> {
                    
                    award = 100.00;
                }
                case 12 -> {
                    
                    award = 1000.00;
                }
                case 13 -> {
                    
                    award = 50000.00;
                }
                default -> {
                    
                    award = 0;
                    JOptionPane.showMessageDialog(null,
                            name + ", you did not enter a valid number of correct predictions! Your prize was set to zero.",
                            "Content 07 | Exercise 01",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            JOptionPane.showMessageDialog(null,
                    name + ", you got " + wins + " correct predictions and will receive a prize of R$" + award,
                    "Content 07 | Exercise 01",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
