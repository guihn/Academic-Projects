<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2012">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 12 · Packaging and warehouse costs

## Description

**Statement summary:** Discard defective balls, pack up to 10 per box and rent warehouses holding up to 850 boxes until the event. Include incomplete boxes and warehouses in the cost.

**Statement source:** [original lecture slides](https://github.com/guihn/academic-materials/blob/5a9473bbf24a271032a41b141ab6bd435076c1d5/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2006/Algoritmos%20-%20Aulas%20-%20Conte%C3%BAdo%206%20-%20Comando%20Condicional%20%E2%80%93%20IF%2C%20Express%C3%B5es%20Booleanas.pptx), slide(s) 54. [Material folder](https://github.com/guihn/academic-materials/tree/main/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2006).

**Supplied source:** [C06ex12.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/FirstStage/C06ex12.java).

## Solution

Round box and warehouse counts upward with Math.ceil, then add packaging and rental costs.

[Source file: C06ex12.java](https://github.com/guihn/Academic-Projects/blob/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006/Exercise%2012/src/C06ex12.java) · [Download](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006/Exercise%2012/src/C06ex12.java)

<details>
<summary>💻 | Java code</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Round box and warehouse counts upward with Math.ceil, then add packaging and rental costs.
 *
 * Assignment: C06ex12.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex12 {

    static void main() {

        String fabricatedBallsStr, defectsballsStr, unitaryPriceBoxesStr, monthlyuntilCupStr, mensalvaluerentalStr;

        double fabricatedBalls, defectsballs, goodBalls, unitaryPriceBoxes, necessaryBoxes, boxesCost, necessaryWarehouses, monthswarehousePrices, warehouseCost, monthlyuntilCup, mensalvaluerental, totalCost;

        // Input: collect the requested values through dialog boxes.
        fabricatedBallsStr = JOptionPane.showInputDialog(null,
                "Enter the number of balls manufactured: ",
                "Content 06 | Exercise 12",
                JOptionPane.QUESTION_MESSAGE);

        defectsballsStr = JOptionPane.showInputDialog(null,
                "Enter the number of defective balls: ",
                "Content 06 | Exercise 12",
                JOptionPane.QUESTION_MESSAGE);

        unitaryPriceBoxesStr = JOptionPane.showInputDialog(null,
                "Enter the unit price of the boxes: ",
                "Content 06 | Exercise 12",
                JOptionPane.QUESTION_MESSAGE);

        monthlyuntilCupStr = JOptionPane.showInputDialog(null,
                "Enter the number of months until the World Cup: ",
                "Content 06 | Exercise 12",
                JOptionPane.QUESTION_MESSAGE);

        mensalvaluerentalStr = JOptionPane.showInputDialog(null,
                "Enter the rental amount: ",
                "Content 06 | Exercise 12",
                JOptionPane.QUESTION_MESSAGE);

        fabricatedBalls = Double.valueOf(fabricatedBallsStr);
        defectsballs = Double.valueOf(defectsballsStr);
        unitaryPriceBoxes = Double.valueOf(unitaryPriceBoxesStr);
        monthlyuntilCup = Double.valueOf(monthlyuntilCupStr);
        mensalvaluerental = Double.valueOf(mensalvaluerentalStr);

        // Processing: Round box and warehouse counts upward with Math.ceil, then add packaging and
        // rental costs.
        goodBalls = fabricatedBalls - defectsballs;

        // Round up because a partly filled box still needs to be purchased.
        necessaryBoxes = Math.ceil(goodBalls / 10);

        boxesCost = unitaryPriceBoxes * necessaryBoxes;

        // A partly occupied warehouse also counts toward the rental cost.
        necessaryWarehouses = Math.ceil(necessaryBoxes / 850);

        monthswarehousePrices = mensalvaluerental * necessaryWarehouses;

        warehouseCost = monthswarehousePrices * monthlyuntilCup;

        totalCost = boxesCost + warehouseCost;

        // Output: display the message for the current result.
        JOptionPane.showMessageDialog(null,
                "Total cost: " + totalCost);
    }
}
```

</details>
