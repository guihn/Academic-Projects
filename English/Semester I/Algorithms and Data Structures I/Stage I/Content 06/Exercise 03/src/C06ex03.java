package FirstStage;

import javax.swing.JOptionPane;

/**
 * Select a salary expression according to the monthly sales band.
 *
 * Assignment: C06ex03.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex03 {

    static void main() {

        String monthlySaleStr;

        double monthlySale, fixedValor, salary;

        fixedValor = 240;

        // Input: collect the requested values through dialog boxes.
        monthlySaleStr = JOptionPane.showInputDialog(null,
                "Enter the total monthly sales:",
                "Content 06 | Exercise 03",
                JOptionPane.QUESTION_MESSAGE);

        monthlySale = Double.valueOf(monthlySaleStr);

        // Processing: Select a salary expression according to the monthly sales band.
        if (monthlySale <= 1000)
            salary = fixedValor;

        else if (monthlySale > 1000 && monthlySale <= 10000)
            salary = fixedValor + (monthlySale * 0.10);
            
        else
            // This original branch omits the fixed component of 240.
            salary = 1000;

        // Output: display the message for the current result.
        JOptionPane.showMessageDialog(null,
                "Salary: " + salary,
                "Content 06 | Exercise 03",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
