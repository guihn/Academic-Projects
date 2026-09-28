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
