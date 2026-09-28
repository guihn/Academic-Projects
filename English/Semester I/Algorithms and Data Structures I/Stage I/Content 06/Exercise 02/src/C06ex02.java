package FirstStage;

import javax.swing.JOptionPane;

/**
 * Prepare the fixed and proportional fines and choose a message using the emission thresholds in
 * the code.
 *
 * Assignment: C06ex02.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex02 {

    static void main() {

        String pollutantStr;

        double pollutant, fee15x35, fee35;

        // Input: collect the requested values through dialog boxes.
        pollutantStr = JOptionPane.showInputDialog(null,
                "Enter the amount of pollutants:",
                "Content 06 | Exercise 02",
                JOptionPane.QUESTION_MESSAGE);

        pollutant = Double.valueOf(pollutantStr);

        // Processing: Prepare the fixed and proportional fines and choose a message using the
        // emission thresholds in the code.
        fee15x35 = 3000;

        fee35 = 5000 * pollutant;

        if (pollutant <= 1500)
            // Output: display the message for the current result.
            JOptionPane.showMessageDialog(null,
                    "Exempt from the fine.",
                    "Content 06 | Exercise 02",
                    JOptionPane.INFORMATION_MESSAGE);

        // The supplied upper limit is 3000; the statement uses 3500.
        else if (pollutant >= 1500 && pollutant <= 3000)
            JOptionPane.showMessageDialog(null,
                    "Fine: R$" + fee15x35,
                    "Content 06 | Exercise 02",
                    JOptionPane.INFORMATION_MESSAGE);
            
        else
            JOptionPane.showMessageDialog(null,
                    "Fine: R$" + fee35,
                    "Content 06 | Exercise 02",
                    JOptionPane.INFORMATION_MESSAGE);
    }
}
