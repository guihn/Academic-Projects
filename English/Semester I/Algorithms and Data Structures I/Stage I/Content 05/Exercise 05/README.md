<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2005/Exerc%C3%ADcio%2005">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2005">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 05 · Temperature conversion

## Description

**Statement summary:** Read a Celsius temperature and convert it to Kelvin and Fahrenheit.

**Statement source:** [original lecture slides](https://github.com/guihn/academic-materials/blob/5a9473bbf24a271032a41b141ab6bd435076c1d5/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2005/Algoritmos%20-%20Aulas%20-%20Conte%C3%BAdo%205%20-%20Comando%20de%20ATRIBUI%C3%87%C3%83O%2C%20Express%C3%B5es%20Aritm%C3%A9ticas.pptx), slide(s) 38. [Material folder](https://github.com/guihn/academic-materials/tree/main/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2005).

**Supplied source:** [C05ex05.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/FirstStage/C05ex05.java).

## Solution

Add 273.15 for Kelvin and calculate 1.8 times Celsius plus 32 for Fahrenheit.

### Implementation notes

The implementation uses 273.15 in the Kelvin conversion. The slide example uses the rounded offset 273.

[Source file: C05ex05.java](https://github.com/guihn/Academic-Projects/blob/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2005/Exercise%2005/src/C05ex05.java) · [Download](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2005/Exercise%2005/src/C05ex05.java)

<details>
<summary>💻 | Java code</summary>

```java
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
```

</details>
