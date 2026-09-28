package SecondStage;

import javax.swing.JOptionPane;

/**
 * Use remainders to classify each number and maintain the sum and count inside the loop.
 *
 * Assignment: C08ex06.
 */
public class C08ex06 {
    static void main() {
        String numberStr;
        int number, oddoreven, div4, div3, rep, div4sum, ifdiv3;
        rep = 10;
        div4sum = 0;
        div3 = 0;

        // Processing: Use remainders to classify each number and maintain the sum and count inside
        // the loop.
        for (int i = 1; i <= rep; i++) {
            // Input: collect the requested values through dialog boxes.
            numberStr = JOptionPane.showInputDialog(null,
                    "Enter an integer: ",
                    "Content 08 | Exercise 06",
                    JOptionPane.QUESTION_MESSAGE);
            number = Integer.parseInt(numberStr);

            oddoreven = number % 2;
            div4 = number % 4;
            ifdiv3 = number % 3;

            if (oddoreven == 0) {
                // Output: display the message for the current result.
                JOptionPane.showMessageDialog(null,
                        "The number is even!",
                        "Content 08 | Exercise 06",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null,
                        "The number is odd!",
                        "Content 08 | Exercise 06",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            if (div4 == 0) {
                div4sum += number;
            }
            // This original else if excludes multiples of 4 from the multiples-of-3 count.
            else if (ifdiv3 == 0) {
                div3++;
            }
        }
            JOptionPane.showMessageDialog(null,
                    "Sum of numbers divisible by 4: " + div4sum + "\nCount of numbers divisible by 3: " + div3 + " numbers.",
                    "Content 08 | Exercise 06",
                    JOptionPane.QUESTION_MESSAGE);
    }
}
