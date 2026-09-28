<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2002">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 02 · Fine by emission band

## Description

This exercise calculates an environmental fine from a company's emission band. The program reads the quantity of pollutants and must choose between exemption, a fixed fine and a fine proportional to total emissions. Band boundaries must be respected so values at the limits receive the specified treatment.

## Statement

Read pollutant emissions in mg/(t·m²), then calculate and print the fine using the exercise table:

| Quantity | Fine |
| --- | --- |
| Up to 1500 | Exempt |
| Above 1500 through 3500 | R$3,000.00 |
| Above 3500 | R$5,000.00 × pollutant quantity |

## Solution

Prepare the fixed and proportional fines and choose a message using the emission thresholds in the code.

### Implementation notes

The code uses 3000 as the upper limit of the middle band. The statement uses 3500.

Source file: [C06ex02.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006/Exercise%2002/src/C06ex02.java)

<details>
<summary>💻 | Java code</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Prepare the fixed and proportional fines and choose a message using the emission thresholds in
 * the code.
 *
 * Assignment: C06ex02.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex02 {

    static void main() {

        String pollutantStr;

        double pollutant, fee15x35, fee35;

        // Input: collect the requested values through dialog boxes.
        pollutantStr = JOptionPane.showInputDialog(null,
                "Enter the amount of pollutants:",
                "Content 06 | Exercise 02",
                JOptionPane.QUESTION_MESSAGE);

        pollutant = Double.valueOf(pollutantStr);

        // Processing: Prepare the fixed and proportional fines and choose a message using the
        // emission thresholds in the code.
        fee15x35 = 3000;

        fee35 = 5000 * pollutant;

        if (pollutant <= 1500)
            // Output: display the message for the current result.
            JOptionPane.showMessageDialog(null,
                    "Exempt from the fine.",
                    "Content 06 | Exercise 02",
                    JOptionPane.INFORMATION_MESSAGE);

        // The upper limit in the code is 3000; the statement uses 3500.
        else if (pollutant >= 1500 && pollutant <= 3000)
            JOptionPane.showMessageDialog(null,
                    "Fine: R$" + fee15x35,
                    "Content 06 | Exercise 02",
                    JOptionPane.INFORMATION_MESSAGE);
            
        else
            JOptionPane.showMessageDialog(null,
                    "Fine: R$" + fee35,
                    "Content 06 | Exercise 02",
                    JOptionPane.INFORMATION_MESSAGE);
    }
}
```

</details>
