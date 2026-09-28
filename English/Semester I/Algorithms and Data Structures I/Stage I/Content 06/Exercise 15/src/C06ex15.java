package FirstStage;

import javax.swing.JOptionPane;

/**
 * Select city and package rates, cap Basic pay-per-view at R$65 and apply city tax to the
 * subtotal.
 *
 * Assignment: C06ex15.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex15 {

    static void main() {

        int packageCode, daysQuantity;

        String packageCodeStr, daysQuantityStr, extrasServicesPriceStr, city;

        double extrasServicesPrice, monthFinalCost, fixedValue, payperview, incometax;

        // Input: collect the requested values through dialog boxes.
        packageCodeStr = JOptionPane.showInputDialog(null,
                "Enter your package code: ",
                "Content 06 | Exercise 15",
                JOptionPane.QUESTION_MESSAGE);

        daysQuantityStr = JOptionPane.showInputDialog(null,
                "Enter the number of days of pay-per-view use: ",
                "Content 06 | Exercise 15",
                JOptionPane.QUESTION_MESSAGE);

        extrasServicesPriceStr = JOptionPane.showInputDialog(null,
                "Enter the cost of extra services: ",
                "Content 06 | Exercise 15",
                JOptionPane.QUESTION_MESSAGE);

        city = JOptionPane.showInputDialog(null,
                "Enter your city: ",
                "Content 06 | Exercise 15",
                JOptionPane.QUESTION_MESSAGE);

        packageCode = Integer.valueOf(packageCodeStr);
        daysQuantity = Integer.valueOf(daysQuantityStr);
        extrasServicesPrice = Double.valueOf(extrasServicesPriceStr);

        // Processing: Select city and package rates, cap Basic pay-per-view at R$65 and apply city
        // tax to the subtotal.
        fixedValue = 0;
        payperview = 0;
        incometax = 0;

        if (city.equalsIgnoreCase("Belo Horizonte")) {
            incometax = 0;
        }
        
        else if (city.equalsIgnoreCase("Rio de Janeiro")) {
            incometax = 0.015;
        }
        
        else if (city.equalsIgnoreCase("São paulo")) {
            incometax = 0.01;
        }
        
        else
            incometax = 0.02;

        switch (packageCode) {
            case 1 -> {
                
                fixedValue = 65.00;
                payperview = 1.20;

                payperview *= daysQuantity;

                if (payperview > 65) {
                    payperview = 65.00;
                }
            }
            case 2 -> {
                
                fixedValue = 104.00;
                payperview = 2.10;
                payperview *= daysQuantity;
            }
            case 3 -> {
                
                fixedValue = 137.00;
                payperview = 0;
            }
            default -> {
                
                // Output: display the message for the current result.
                JOptionPane.showMessageDialog(null,
                        "You did not enter a valid package code!",
                        "Content 06 | Exercise 15",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        monthFinalCost = fixedValue + payperview + extrasServicesPrice;

        monthFinalCost += monthFinalCost * incometax;

        JOptionPane.showMessageDialog(null,
                "Bill: " + monthFinalCost,
                "Your bill",
                JOptionPane.INFORMATION_MESSAGE);

    }
}
