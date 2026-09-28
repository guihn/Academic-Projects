package FirstStage;

import javax.swing.JOptionPane;

/**
 * Use switch to select exemption, 2%, 10% plus 0.5% per day, or 150% plus R$1 per day.
 *
 * Assignment: C07ex03.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C07ex03 {

    static void main() {

        String taxStr, lateDaysStr;

        int lateDays;

        double tax, fee, percentualFee;

        // Input: collect the requested values through dialog boxes.
        taxStr = JOptionPane.showInputDialog(null,
                "Enter the tax amount: ",
                "Content 07 | Exercise 03",
                JOptionPane.QUESTION_MESSAGE);

        lateDaysStr = JOptionPane.showInputDialog(null,
                "Enter the number of overdue days: ",
                "Content 07 | Exercise 03",
                JOptionPane.QUESTION_MESSAGE);

        tax = Double.valueOf(taxStr);
        lateDays = Integer.valueOf(lateDaysStr);

        // Processing: Use switch to select exemption, 2%, 10% plus 0.5% per day, or 150% plus R$1
        // per day.
        switch (lateDays) {
            case 0, 1, 2, 3, 4, 5 -> {
                
                percentualFee = 0;
                fee = tax * percentualFee;
            }
            case 6, 7, 8 -> {
                
                percentualFee = 0.02;
                fee = tax * percentualFee;
            }
            case 9, 10 -> {

                percentualFee = 0.10 + 0.005 * lateDays;
                fee = tax * percentualFee;
            }
            default -> {

                percentualFee = 1.50;
                fee = (tax * percentualFee) + (1 * lateDays);
            }
        }

        // Output: display the message for the current result.
        JOptionPane.showMessageDialog(null,
                "Fine: R$" + fee,
                "Content 07 | Exercise 03",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
