<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2003">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 03 · Sales commission

## Description

**Statement summary:** Calculate a salary consisting of R$240 plus commission: zero up to R$1000 in sales, 10% through R$10000, or R$1000 above that.

**Statement source:** [original lecture slides](https://github.com/guihn/academic-materials/blob/5a9473bbf24a271032a41b141ab6bd435076c1d5/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2006/Algoritmos%20-%20Aulas%20-%20Conte%C3%BAdo%206%20-%20Comando%20Condicional%20%E2%80%93%20IF%2C%20Express%C3%B5es%20Booleanas.pptx), slide(s) 44. [Material folder](https://github.com/guihn/academic-materials/tree/main/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2006).

**Supplied source:** [C06ex03.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/FirstStage/C06ex03.java).

## Solution

Select a salary expression according to the monthly sales band.

### Implementation notes

For sales above R$10000, the original code assigns a total salary of R$1000 and omits the R$240 fixed component.

[Source file: C06ex03.java](https://github.com/guihn/Academic-Projects/blob/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006/Exercise%2003/src/C06ex03.java) · [Download](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006/Exercise%2003/src/C06ex03.java)

<details>
<summary>💻 | Java code</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Select a salary expression according to the monthly sales band.
 *
 * Assignment: C06ex03.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex03 {

    static void main() {

        String monthlySaleStr;

        double monthlySale, fixedValor, salary;

        fixedValor = 240;

        // Input: collect the requested values through dialog boxes.
        monthlySaleStr = JOptionPane.showInputDialog(null,
                "Enter the total monthly sales:",
                "Content 06 | Exercise 03",
                JOptionPane.QUESTION_MESSAGE);

        monthlySale = Double.valueOf(monthlySaleStr);

        // Processing: Select a salary expression according to the monthly sales band.
        if (monthlySale <= 1000)
            salary = fixedValor;

        else if (monthlySale > 1000 && monthlySale <= 10000)
            salary = fixedValor + (monthlySale * 0.10);
            
        else
            // This original branch omits the fixed component of 240.
            salary = 1000;

        // Output: display the message for the current result.
        JOptionPane.showMessageDialog(null,
                "Salary: " + salary,
                "Content 06 | Exercise 03",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
```

</details>
