package FirstStage;

import javax.swing.JOptionPane;

/**
 * Use 72.7h − 58 for M and 62.1h − 44.7 for F, reporting other inputs as invalid.
 *
 * Assignment: C06ex09.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex09 {

    static void main() {

        String heightStr, genderStr;

        double height, idealHeightF, idealHeightM;

        // Input: collect the requested values through dialog boxes.
        heightStr = JOptionPane.showInputDialog(null,
                "Enter your height (in meters):",
                "Content 06 | Exercise 09",
                JOptionPane.QUESTION_MESSAGE);

        genderStr = JOptionPane.showInputDialog(null,
                "Enter your biological sex (M or F):",
                "Content 06 | Exercise 09",
                JOptionPane.QUESTION_MESSAGE);

        height = Double.valueOf(heightStr);

        // Processing: Use 72.7h − 58 for M and 62.1h − 44.7 for F, reporting other inputs as
        // invalid.
        if (genderStr.equals("M")) {
            idealHeightM = 72.7 * height - 58;

            // Output: display the message for the current result.
            JOptionPane.showMessageDialog(null,
                    "Ideal weight: " + idealHeightM,
                    "Content 06 | Exercise 09",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        
        else if (genderStr.equals("F")) {
            idealHeightF = 62.1 * height - 44.7;

            JOptionPane.showMessageDialog(null,
                    "Ideal weight: " + idealHeightF,
                    "Content 06 | Exercise 09",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        
        else
            JOptionPane.showMessageDialog(null,
                    "Invalid sex.",
                    "Content 06 | Exercise 09",
                    JOptionPane.INFORMATION_MESSAGE);

    }
}
