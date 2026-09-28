<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2015">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 15 · Cable television bill

## Description

**Statement summary:** Calculate the monthly package fee, daily pay-per-view usage, extra services and city tax using the exercise tables.

**Statement source:** [original lecture slides](https://github.com/guihn/academic-materials/blob/5a9473bbf24a271032a41b141ab6bd435076c1d5/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2006/Algoritmos%20-%20Aulas%20-%20Conte%C3%BAdo%206%20-%20Comando%20Condicional%20%E2%80%93%20IF%2C%20Express%C3%B5es%20Booleanas.pptx), slide(s) 57. [Material folder](https://github.com/guihn/academic-materials/tree/main/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2006).

**Supplied source:** [C06ex15.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/FirstStage/C06ex15.java).

## Solution

Select city and package rates, cap Basic pay-per-view at R$65 and apply city tax to the subtotal.

[Source file: C06ex15.java](https://github.com/guihn/Academic-Projects/blob/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006/Exercise%2015/src/C06ex15.java) · [Download](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006/Exercise%2015/src/C06ex15.java)

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
