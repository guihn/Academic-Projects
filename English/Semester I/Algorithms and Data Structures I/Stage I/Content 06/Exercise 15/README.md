<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2015">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 15 · Cable television bill

## Description

The program builds a monthly cable bill from a fixed charge, daily usage, extra services and city tax. The package determines the fixed fee and pay-per-view rule, while the city determines the tax percentage. The Basic package's usage cap must be applied before calculating tax on the subtotal.

## Statement

Request package code, pay-per-view days, extra-service amount and city. Calculate the bill using these tables:

| Package | Code | Monthly&nbsp;fee | Pay-per-view |
| --- | --- | --- | --- |
| Basic | 1 | R$65.00 | R$1.20 per day, capped at R$65.00 |
| Advanced | 2 | R$104.00 | R$2.10 per day |
| Premium | 3 | R$137.00 | Exempt |

| City | Tax |
| --- | --- |
| Belo Horizonte | Exempt |
| São Paulo | 1% |
| Rio de Janeiro | 1.5% |
| Other cities | 2% |

Add the monthly fee, pay-per-view and extras; apply tax to that sum and add it to the bill.

## Solution

Select city and package rates, cap Basic pay-per-view at R$65 and apply city tax to the subtotal.

Source file: [C06ex15.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006/Exercise%2015/src/C06ex15.java)

<details>
<summary>💻 | Java code</summary>

```java
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
```

</details>
