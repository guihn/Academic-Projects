package FirstStage;

import javax.swing.JOptionPane;

/**
 * Divide |Ax + By + C| by the square root of A² + B².
 *
 * Assignment: C05ex06.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C05ex06 {

    static void main() {

        String aRStr, bRStr, cRStr, xPStr, yPStr;

        double distance, c1, c2, aR, bR, cR, xP, yP;

        // Input: collect the requested values through dialog boxes.
        aRStr = JOptionPane.showInputDialog(null,
                "Enter coefficient A of line R:",
                "Content 05 | Exercise 06",
                JOptionPane.QUESTION_MESSAGE);

        bRStr = JOptionPane.showInputDialog(null,
                "Enter coefficient B of line R:",
                "Content 05 | Exercise 06",
                JOptionPane.QUESTION_MESSAGE);

        cRStr = JOptionPane.showInputDialog(null,
                "Enter coefficient C of line R:",
                "Content 05 | Exercise 06",
                JOptionPane.QUESTION_MESSAGE);

        xPStr = JOptionPane.showInputDialog(null,
                "Enter the X coordinate of point P:",
                "Content 05 | Exercise 06",
                JOptionPane.QUESTION_MESSAGE);

        yPStr = JOptionPane.showInputDialog(null,
                "Enter the Y coordinate of point P:",
                "Content 05 | Exercise 06",
                JOptionPane.QUESTION_MESSAGE);

        aR = Double.valueOf(aRStr);
        bR = Double.valueOf(bRStr);
        cR = Double.valueOf(cRStr);
        xP = Double.valueOf(xPStr);
        yP = Double.valueOf(yPStr);

        // Processing: Divide |Ax + By + C| by the square root of A² + B².
        c1 = aR * xP + bR * yP + cR;

        c2 = Math.sqrt(Math.pow(aR, 2) + Math.pow(bR, 2));

        distance = Math.abs(c1) / c2;

        // Output: display the message for the current result.
        JOptionPane.showMessageDialog(null,
                "Distance: " + distance,
                "Content 05 | Exercise 06",
                JOptionPane.INFORMATION_MESSAGE);

    }
}
