package FirstTest;

import javax.swing.JOptionPane;

/**
 * Select the fuel branch and year band, then apply the programmed exemption or discount
 * percentage to the original tax amount.
 *
 * Assignment: D30912C.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class D30912C {
    static void main() {
        String originalPriceIPVAStr, typeofOil, fabricatedYearStr;
        double originalPriceIPVA, fabricatedYear, descount, descountPercentage, ipvatoPay;

        // Input: collect the requested values through dialog boxes.
        originalPriceIPVAStr = JOptionPane.showInputDialog(null,
                "Enter the original vehicle IPVA tax amount: ",
                "First Test | Question C",
                JOptionPane.QUESTION_MESSAGE);
        typeofOil = JOptionPane.showInputDialog(null,
                "Enter the vehicle fuel type ('A' for ethanol, 'G' for gasoline and 'D' for diesel: ",
                "First Test | Question C",
                JOptionPane.QUESTION_MESSAGE);
        fabricatedYearStr = JOptionPane.showInputDialog(null,
                "Enter the vehicle manufacturing year: ",
                "First Test | Question C",
                JOptionPane.QUESTION_MESSAGE);

        originalPriceIPVA = Double.valueOf(originalPriceIPVAStr);
        fabricatedYear = Double.valueOf(fabricatedYearStr);
        typeofOil = typeofOil.toUpperCase();

        // Processing: Select the fuel branch and year band, then apply the programmed exemption or
        // discount percentage to the original tax amount.
        switch (typeofOil) {
            default -> {
                // Output: display the message for the current result.
                JOptionPane.showMessageDialog(null,
                        "You did not enter a valid letter!",
                        "First Test | Question C",
                        JOptionPane.ERROR_MESSAGE);
            }
            case "A" -> {
                if (fabricatedYear < 1960) {
                    JOptionPane.showMessageDialog(null,
                            "No IPVA tax is due!",
                            "First Test | Question C",
                            JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                else if (fabricatedYear >= 1960 && fabricatedYear <= 1970) {
                    descountPercentage = 0.55;
                    descount = originalPriceIPVA * descountPercentage;
                    ipvatoPay = originalPriceIPVA - descount;

                    JOptionPane.showMessageDialog(null,
                            "IPVA tax due: R$" + ipvatoPay,
                            "First Test | Question C",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else if (fabricatedYear >= 1971 && fabricatedYear <= 1980) {
                    descountPercentage = 0.25;
                    descount = originalPriceIPVA * descountPercentage;
                    ipvatoPay = originalPriceIPVA - descount;

                    JOptionPane.showMessageDialog(null,
                            "IPVA tax due: R$" + ipvatoPay,
                            "First Test | Question C",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    descountPercentage = 0.05;
                    descount = originalPriceIPVA * descountPercentage;
                    ipvatoPay = originalPriceIPVA - descount;

                    JOptionPane.showMessageDialog(null,
                            "IPVA tax due: R$" + ipvatoPay,
                            "First Test | Question C",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
            case "G" -> {
                if (fabricatedYear < 1960) {
                    JOptionPane.showMessageDialog(null,
                            "No IPVA tax is due!",
                            "First Test | Question C",
                            JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                else if (fabricatedYear >= 1960 && fabricatedYear <= 1970) {
                    descountPercentage = 0.50;
                    descount = originalPriceIPVA * descountPercentage;
                    ipvatoPay = originalPriceIPVA - descount;

                    JOptionPane.showMessageDialog(null,
                            "IPVA tax due: R$" + ipvatoPay,
                            "First Test | Question C",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else if (fabricatedYear >= 1971 && fabricatedYear <= 1980) {
                    descountPercentage = 0.20;
                    descount = originalPriceIPVA * descountPercentage;
                    ipvatoPay = originalPriceIPVA - descount;

                    JOptionPane.showMessageDialog(null,
                            "IPVA tax due: R$" + ipvatoPay,
                            "First Test | Question C",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    descountPercentage = 0.0;
                    descount = originalPriceIPVA * descountPercentage;
                    ipvatoPay = originalPriceIPVA - descount;

                    JOptionPane.showMessageDialog(null,
                            "IPVA tax due: R$" + ipvatoPay,
                            "First Test | Question C",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
            case "D" -> {
                if (fabricatedYear < 1960) {
                    JOptionPane.showMessageDialog(null,
                            "No IPVA tax is due!",
                            "First Test | Question C",
                            JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                else if (fabricatedYear >= 1960 && fabricatedYear <= 1970) {
                    descountPercentage = 0.50;
                    descount = originalPriceIPVA * descountPercentage;
                    ipvatoPay = originalPriceIPVA - descount;

                    JOptionPane.showMessageDialog(null,
                            "IPVA tax due: R$" + ipvatoPay,
                            "First Test | Question C",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else if (fabricatedYear >= 1971 && fabricatedYear <= 1980) {
                    descountPercentage = 0.20;
                    descount = originalPriceIPVA * descountPercentage;
                    ipvatoPay = originalPriceIPVA - descount;

                    JOptionPane.showMessageDialog(null,
                            "IPVA tax due: R$" + ipvatoPay,
                            "First Test | Question C",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    descountPercentage = 0.0;
                    descount = originalPriceIPVA * descountPercentage;
                    ipvatoPay = originalPriceIPVA - descount;

                    JOptionPane.showMessageDialog(null,
                            "IPVA tax due: R$" + ipvatoPay,
                            "First Test | Question C",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }
}
