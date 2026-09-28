package FirstStage;

import javax.swing.JOptionPane;

/**
 * Apply 4πr² for the surface area and (4/3)πr³ for the volume, using floating point division.
 *
 * Assignment: C05ex02.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C05ex02 {

    static void main() {

        String raiostr;

        double pi = 3.1416, raio, area, volume;

        // Input: collect the requested values through dialog boxes.
        raiostr = JOptionPane.showInputDialog(null,
                "Enter the radius:",
                "Content 05 | Exercise 02",
                JOptionPane.QUESTION_MESSAGE);

        raio = Double.valueOf(raiostr);

        // Processing: Apply 4πr² for the surface area and (4/3)πr³ for the volume, using floating
        // point division.
        area = 4 * pi * Math.pow(raio, 2);

        volume = 4.0 / 3.0 * pi * Math.pow(raio, 3);

        // Output: display the message for the current result.
        JOptionPane.showMessageDialog(null,
                "Area: " + area + "\nVolume: " + volume,
                "Content 05 | Exercise 02",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
