package FirstStage;

import javax.swing.JOptionPane;

/**
 * Subtract the dependent allowance from the salary and apply the percentage entered in the
 * dialog.
 *
 * Assignment: C05ex03.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C05ex03 {

    static void main() {

        String salaryStr, dependentsStr, irStr;

        double salary, dependents, ir, liquidSalary;

        // Input: collect the requested values through dialog boxes.
        salaryStr = JOptionPane.showInputDialog(null,
                "Enter the salary:",
                "Content 05 | Exercise 03",
                JOptionPane.QUESTION_MESSAGE);

        dependentsStr = JOptionPane.showInputDialog(null,
                "Enter the number of dependents:",
                "Content 05 | Exercise 03",
                JOptionPane.QUESTION_MESSAGE);

        irStr = JOptionPane.showInputDialog(null,
                "Enter the income tax percentage (e.g. 15):",
                "Content 05 | Exercise 03",
                JOptionPane.QUESTION_MESSAGE);

        salary = Double.valueOf(salaryStr);
        dependents = Double.valueOf(dependentsStr);
        ir = Double.valueOf(irStr);

        // Processing: Subtract the dependent allowance from the salary and apply the percentage
        // entered in the dialog.
        liquidSalary = salary - dependents * 60.00;

        ir = liquidSalary * ir / 100.0;

        // Output: display the message for the current result.
        JOptionPane.showMessageDialog(null,
                "Net amount: R$" + liquidSalary + "\nIncome tax: R$" + ir,
                "Content 05 | Exercise 03",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
