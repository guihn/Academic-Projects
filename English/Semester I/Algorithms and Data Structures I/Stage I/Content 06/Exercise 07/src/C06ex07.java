package FirstStage;

import javax.swing.JOptionPane;

/**
 * Choose the fixed allowance and percentage, calculate the gross participation and subtract the
 * exercise tax.
 *
 * Assignment: C06ex07.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex07 {

    static void main() {

        String employeeSalaryStr;

        double employeeSalary, grossPL, liquidPL, incomeTax, fixedValor, percentageOverSalary, percentage;

        // Input: collect the requested values through dialog boxes.
        employeeSalaryStr = JOptionPane.showInputDialog(null,
                "Enter the salary:",
                "Content 06 | Exercise 07",
                JOptionPane.QUESTION_MESSAGE);

        employeeSalary = Double.valueOf(employeeSalaryStr);

        // Processing: Choose the fixed allowance and percentage, calculate the gross participation
        // and subtract the exercise tax.
        if (employeeSalary <= 300) {
            fixedValor = 500;
            percentage = 0.70;
        }

        else if (employeeSalary > 300 && employeeSalary <= 1000) {
            fixedValor = 200;
            percentage = 0.50;
        }
        
        else {
            fixedValor = 0;
            percentage = 0.30;
        }

        percentageOverSalary = employeeSalary * percentage;

        grossPL = fixedValor + percentageOverSalary;

        incomeTax = 0.25 * grossPL;

        liquidPL = grossPL - incomeTax;

        // Output: display the message for the current result.
        JOptionPane.showMessageDialog(null,
                "Net profit sharing: " + liquidPL,
                "Content 06 | Exercise 07",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
