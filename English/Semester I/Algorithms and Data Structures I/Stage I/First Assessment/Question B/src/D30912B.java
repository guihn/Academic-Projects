package FirstTest;

import javax.swing.JOptionPane;

/**
 * Validate 100–999, extract hundreds, tens and units and compare the sum of their cubes with the
 * original number.
 *
 * Assignment: D30912B.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class D30912B {
    static void main() {
        int receivedNumber;
        String numberArmstrongStr;
        double firstNumb, secondNumb, thirdNumb, testing;

        // Input: collect the requested values through dialog boxes.
        numberArmstrongStr = JOptionPane.showInputDialog(null,
                "Enter a number of up to 3 digits to test: ",
                "First Test | Question B",
                JOptionPane.INFORMATION_MESSAGE);

        receivedNumber = Integer.valueOf(numberArmstrongStr);

        // Processing: Validate 100–999, extract hundreds, tens and units and compare the sum of
        // their cubes with the original number.
        if (receivedNumber >= 100 && receivedNumber < 1000) {

            firstNumb = receivedNumber / 100 % 10;
            secondNumb = receivedNumber / 10 % 10;
            thirdNumb = receivedNumber % 10;

            testing = Math.pow(firstNumb, 3) + Math.pow(secondNumb, 3) + Math.pow(thirdNumb, 3);
            if (testing == receivedNumber) {
                // Output: display the message for the current result.
                JOptionPane.showMessageDialog(null,
                        "This number is an Armstrong number!",
                        "First Test | Question B",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(null,
                        "This number is not an Armstrong number!",
                        "First Test | Question B",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        else {
            JOptionPane.showMessageDialog(null,
                    "You did not enter a valid number of up to 3 digits!",
                    "First Test | Question B",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
