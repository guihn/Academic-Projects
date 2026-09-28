<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2004">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 04 · BMI classification exercise

## Description

This exercise practices chained conditions using a classroom BMI table. The program reads a name, height in metres and weight in kilograms, calculates weight divided by squared height and selects a category. The message must associate the name with the result from the exercise bands.

## Statement

Read name, height and weight and report the category defined in this exercise. Calculate BMI = weight / height² and apply:

| BMI | Exercise&nbsp;category |
| --- | --- |
| Below 18 | Undernourished |
| From 18 to below 20 | Underweight |
| From 20 through 25 | Ideal weight |
| Above 25 through 27 | Overweight |
| Above 27 | Obese |

## Solution

Divide weight by squared height and choose the corresponding message through successive comparisons.

### Implementation notes

The classification and messages belong to the classroom program. For BMI above 27, its message differs from the slide label.

Source file: [C06ex04.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006/Exercise%2004/src/C06ex04.java)

<details>
<summary>💻 | Java code</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Divide weight by squared height and choose the corresponding message through successive
 * comparisons.
 *
 * Assignment: C06ex04.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex04 {

    static void main() {

        String name, heightStr, weightStr;

        double height, weight, imc;

        // Input: collect the requested values through dialog boxes.
        name = JOptionPane.showInputDialog(null,
                "Enter your name:",
                "Content 06 | Exercise 04",
                JOptionPane.QUESTION_MESSAGE);

        heightStr = JOptionPane.showInputDialog(null,
                "Enter your height (in meters):",
                "Content 06 | Exercise 04",
                JOptionPane.QUESTION_MESSAGE);

        weightStr = JOptionPane.showInputDialog(null,
                "Enter your weight (in kg):",
                "Content 06 | Exercise 04",
                JOptionPane.QUESTION_MESSAGE);

        height = Double.valueOf(heightStr);
        weight = Double.valueOf(weightStr);

        // Processing: Divide weight by squared height and choose the corresponding message through
        // successive comparisons.
        imc = weight / Math.pow(height, 2);

        if (imc < 18)
            // Output: display the message for the current result.
            JOptionPane.showMessageDialog(null,
                    name + ", you are malnourished. " + imc,
                    "Content 06 | Exercise 04",
                    JOptionPane.INFORMATION_MESSAGE);
            
        else if (imc < 20)
            JOptionPane.showMessageDialog(null,
                    name + ", you are underweight.",
                    "Content 06 | Exercise 04",
                    JOptionPane.INFORMATION_MESSAGE);
            
        else if (imc >= 20 && imc <= 25)
            JOptionPane.showMessageDialog(null,
                    name + ", you are at the ideal weight.",
                    "Content 06 | Exercise 04",
                    JOptionPane.INFORMATION_MESSAGE);
            
        else if (imc > 25 && imc <= 27)
            JOptionPane.showMessageDialog(null,
                    name + ", you are overweight.",
                    "Content 06 | Exercise 04",
                    JOptionPane.INFORMATION_MESSAGE);
            
        else if (imc > 27)
            JOptionPane.showMessageDialog(null,
                    name + ", you are huuuuge",
                    "Content 06 | Exercise 04",
                    JOptionPane.INFORMATION_MESSAGE);
    }
}
```

</details>
