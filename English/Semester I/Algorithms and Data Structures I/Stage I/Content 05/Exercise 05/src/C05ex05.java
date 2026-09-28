package FirstStage;

import javax.swing.JOptionPane;

/**
 * Add 273.15 for Kelvin and calculate 1.8 times Celsius plus 32 for Fahrenheit.
 *
 * Assignment: C05ex05.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C05ex05 {

    static void main() {

        String celsiusStr;

        double celsius, kelvin, farenheit;

        // Input: collect the requested values through dialog boxes.
        celsiusStr = JOptionPane.showInputDialog(null,
                "Enter the temperature in °C:",
                "Content 05 | Exercise 05",
                JOptionPane.QUESTION_MESSAGE);

        celsius = Double.valueOf(celsiusStr);

        // Processing: Add 273.15 for Kelvin and calculate 1.8 times Celsius plus 32 for Fahrenheit.
        kelvin = celsius + 273.15;

        farenheit = celsius * 1.8 + 32;

        // Output: display the message for the current result.
        JOptionPane.showMessageDialog(null,
                "Celsius: " + celsius + " -> Kelvin: " + kelvin + " and Fahrenheit: " + farenheit,
                "Content 05 | Exercise 05",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
