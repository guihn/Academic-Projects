package FirstTest;

import javax.swing.JOptionPane;

/**
 * Selecionar o ramo do combustível e a faixa de ano e aplicar a isenção ou o percentual de
 * desconto programado ao imposto original.
 *
 * Atividade: D30912C.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class D30912C {
    static void main() {
        String originalPriceIPVAStr, typeofOil, fabricatedYearStr;
        double originalPriceIPVA, fabricatedYear, descount, descountPercentage, ipvatoPay;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        originalPriceIPVAStr = JOptionPane.showInputDialog(null,
                "Informe o preço original do IPVA do veículo: ",
                "Primeira Avaliação | Questão C",
                JOptionPane.QUESTION_MESSAGE);
        typeofOil = JOptionPane.showInputDialog(null,
                "Informe o tipo de combustível usado no veículo ('A' para álcool, 'G' para Gasolina e 'D' para diesel: ",
                "Primeira Avaliação | Questão C",
                JOptionPane.QUESTION_MESSAGE);
        fabricatedYearStr = JOptionPane.showInputDialog(null,
                "Informe o ano de fabricação do veículo: ",
                "Primeira Avaliação | Questão C",
                JOptionPane.QUESTION_MESSAGE);

        originalPriceIPVA = Double.valueOf(originalPriceIPVAStr);
        fabricatedYear = Double.valueOf(fabricatedYearStr);
        typeofOil = typeofOil.toUpperCase();

        // Processamento: Selecionar o ramo do combustível e a faixa de ano e aplicar a isenção ou o
        // percentual de desconto programado ao imposto original.
        switch (typeofOil) {
            default -> {
                // Saída: apresentar a mensagem correspondente ao resultado atual.
                JOptionPane.showMessageDialog(null,
                        "Você não inseriu uma letra válida!",
                        "Primeira Avaliação | Questão C",
                        JOptionPane.ERROR_MESSAGE);
            }
            case "A" -> {
                if (fabricatedYear < 1960) {
                    JOptionPane.showMessageDialog(null,
                            "Não paga IPVA!",
                            "Primeira Avaliação | Questão C",
                            JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                else if (fabricatedYear >= 1960 && fabricatedYear <= 1970) {
                    descountPercentage = 0.55;
                    descount = originalPriceIPVA * descountPercentage;
                    ipvatoPay = originalPriceIPVA - descount;

                    JOptionPane.showMessageDialog(null,
                            "IPVA a pagar: R$" + ipvatoPay,
                            "Primeira Avaliação | Questão C",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else if (fabricatedYear >= 1971 && fabricatedYear <= 1980) {
                    descountPercentage = 0.25;
                    descount = originalPriceIPVA * descountPercentage;
                    ipvatoPay = originalPriceIPVA - descount;

                    JOptionPane.showMessageDialog(null,
                            "IPVA a pagar: R$" + ipvatoPay,
                            "Primeira Avaliação | Questão C",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    descountPercentage = 0.05;
                    descount = originalPriceIPVA * descountPercentage;
                    ipvatoPay = originalPriceIPVA - descount;

                    JOptionPane.showMessageDialog(null,
                            "IPVA a pagar: R$" + ipvatoPay,
                            "Primeira Avaliação | Questão C",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
            case "G" -> {
                if (fabricatedYear < 1960) {
                    JOptionPane.showMessageDialog(null,
                            "Não paga IPVA!",
                            "Primeira Avaliação | Questão C",
                            JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                else if (fabricatedYear >= 1960 && fabricatedYear <= 1970) {
                    descountPercentage = 0.50;
                    descount = originalPriceIPVA * descountPercentage;
                    ipvatoPay = originalPriceIPVA - descount;

                    JOptionPane.showMessageDialog(null,
                            "IPVA a pagar: R$" + ipvatoPay,
                            "Primeira Avaliação | Questão C",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else if (fabricatedYear >= 1971 && fabricatedYear <= 1980) {
                    descountPercentage = 0.20;
                    descount = originalPriceIPVA * descountPercentage;
                    ipvatoPay = originalPriceIPVA - descount;

                    JOptionPane.showMessageDialog(null,
                            "IPVA a pagar: R$" + ipvatoPay,
                            "Primeira Avaliação | Questão C",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    descountPercentage = 0.0;
                    descount = originalPriceIPVA * descountPercentage;
                    ipvatoPay = originalPriceIPVA - descount;

                    JOptionPane.showMessageDialog(null,
                            "IPVA a pagar: R$" + ipvatoPay,
                            "Primeira Avaliação | Questão C",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
            case "D" -> {
                if (fabricatedYear < 1960) {
                    JOptionPane.showMessageDialog(null,
                            "Não paga IPVA!",
                            "Primeira Avaliação | Questão C",
                            JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                else if (fabricatedYear >= 1960 && fabricatedYear <= 1970) {
                    descountPercentage = 0.50;
                    descount = originalPriceIPVA * descountPercentage;
                    ipvatoPay = originalPriceIPVA - descount;

                    JOptionPane.showMessageDialog(null,
                            "IPVA a pagar: R$" + ipvatoPay,
                            "Primeira Avaliação | Questão C",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else if (fabricatedYear >= 1971 && fabricatedYear <= 1980) {
                    descountPercentage = 0.20;
                    descount = originalPriceIPVA * descountPercentage;
                    ipvatoPay = originalPriceIPVA - descount;

                    JOptionPane.showMessageDialog(null,
                            "IPVA a pagar: R$" + ipvatoPay,
                            "Primeira Avaliação | Questão C",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    descountPercentage = 0.0;
                    descount = originalPriceIPVA * descountPercentage;
                    ipvatoPay = originalPriceIPVA - descount;

                    JOptionPane.showMessageDialog(null,
                            "IPVA a pagar: R$" + ipvatoPay,
                            "Primeira Avaliação | Questão C",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }
}
