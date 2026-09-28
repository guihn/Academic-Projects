package FirstStage;

import javax.swing.JOptionPane;

/**
 * Convert the daily percentage to a fraction, calculate earnings and subtract the tax and
 * administration fee.
 *
 * Assignment: C06ex10.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex10 {

    static void main() {

        String appliedCapitalStr, numberdaysStr, diaryFeeStr;

        double appliedCapital, numberdays, diaryFee, yield, incomeTax, adminFee, finalvalor;

        // Input: collect the requested values through dialog boxes.
        appliedCapitalStr = JOptionPane.showInputDialog(null,
                "Enter the invested capital:",
                "Content 06 | Exercise 10",
                JOptionPane.QUESTION_MESSAGE);

        numberdaysStr = JOptionPane.showInputDialog(null,
                "Enter the number of investment days:",
                "Content 06 | Exercise 10",
                JOptionPane.QUESTION_MESSAGE);

        diaryFeeStr = JOptionPane.showInputDialog(null,
                "Enter the daily rate as a percentage (10 = 10%):",
                "Content 06 | Exercise 10",
                JOptionPane.QUESTION_MESSAGE);

        appliedCapital = Double.valueOf(appliedCapitalStr);
        numberdays = Double.valueOf(numberdaysStr);
        diaryFee = Double.valueOf(diaryFeeStr);

        // Processing: Convert the daily percentage to a fraction, calculate earnings and subtract
        // the tax and administration fee.
        diaryFee = diaryFee / 100;

        yield = appliedCapital * diaryFee * numberdays;

        incomeTax = yield * 0.15;

        adminFee = 10;

        finalvalor = appliedCapital + yield - incomeTax - adminFee;

        // Output: display the message for the current result.
        JOptionPane.showMessageDialog(null,
                "Earnings: R$" + yield +
                        "\nIncome tax: R$" + incomeTax +
                        "\nRedemption value: R$" + finalvalor,
                "Content 06 | Exercise 10",
                JOptionPane.INFORMATION_MESSAGE);

    }
}
