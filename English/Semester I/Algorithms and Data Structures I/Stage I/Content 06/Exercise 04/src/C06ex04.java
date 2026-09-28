package FirstStage;

import javax.swing.JOptionPane;

/**
 * Divide weight by squared height and choose the corresponding message through successive
 * comparisons.
 *
 * Assignment: C06ex04.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex04 {

    static void main() {

        String name, heightStr, weightStr;

        double height, weight, imc;

        // Input: collect the requested values through dialog boxes.
        name = JOptionPane.showInputDialog(null,
                "Enter your name:",
                "Content 06 | Exercise 04",
                JOptionPane.QUESTION_MESSAGE);

        heightStr = JOptionPane.showInputDialog(null,
                "Enter your height (in meters):",
                "Content 06 | Exercise 04",
                JOptionPane.QUESTION_MESSAGE);

        weightStr = JOptionPane.showInputDialog(null,
                "Enter your weight (in kg):",
                "Content 06 | Exercise 04",
                JOptionPane.QUESTION_MESSAGE);

        height = Double.valueOf(heightStr);
        weight = Double.valueOf(weightStr);

        // Processing: Divide weight by squared height and choose the corresponding message through
        // successive comparisons.
        imc = weight / Math.pow(height, 2);

        if (imc < 18)
            // Output: display the message for the current result.
            JOptionPane.showMessageDialog(null,
                    name + ", you are malnourished. " + imc,
                    "Content 06 | Exercise 04",
                    JOptionPane.INFORMATION_MESSAGE);
            
        else if (imc < 20)
            JOptionPane.showMessageDialog(null,
                    name + ", you are underweight.",
                    "Content 06 | Exercise 04",
                    JOptionPane.INFORMATION_MESSAGE);
            
        else if (imc >= 20 && imc <= 25)
            JOptionPane.showMessageDialog(null,
                    name + ", you are at the ideal weight.",
                    "Content 06 | Exercise 04",
                    JOptionPane.INFORMATION_MESSAGE);
            
        else if (imc > 25 && imc <= 27)
            JOptionPane.showMessageDialog(null,
                    name + ", you are overweight.",
                    "Content 06 | Exercise 04",
                    JOptionPane.INFORMATION_MESSAGE);
            
        else if (imc > 27)
            JOptionPane.showMessageDialog(null,
                    name + ", you are huuuuge",
                    "Content 06 | Exercise 04",
                    JOptionPane.INFORMATION_MESSAGE);
    }
}
