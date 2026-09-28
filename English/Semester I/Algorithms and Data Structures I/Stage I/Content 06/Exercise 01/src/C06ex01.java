package FirstStage;

import javax.swing.JOptionPane;

/**
 * Calculate the two expressions, then select the first for x &lt; 4, zero for x = 4 or the
 * second for x &gt; 4.
 *
 * Assignment: C06ex01.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex01 {

    static void main() {

        String xStr;

        double x, fx, c1, c2;

        // Input: collect the requested values through dialog boxes.
        xStr = JOptionPane.showInputDialog(null,
                "Enter the value of X:",
                "Content 06 | Exercise 01",
                JOptionPane.QUESTION_MESSAGE);

        x = Double.valueOf(xStr);

        // Processing: Calculate the two expressions, then select the first for x < 4, zero for x =
        // 4 or the second for x > 4.
        c1 = (5 * x + 3) / Math.sqrt(16 - Math.pow(x, 2));

        c2 = (5 * x + 3) / Math.sqrt(Math.pow(x, 2) - 16);

        if (x < 4)
            fx = c1;
            
        else if (x == 4)
            fx = 0;
            
        else
            fx = c2;

        // Output: display the message for the current result.
        JOptionPane.showMessageDialog(null,
                "f(x): " + fx,
                "Content 06 | Exercise 01",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
