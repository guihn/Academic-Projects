package FirstStage;

import javax.swing.JOptionPane;

/**
 * Selecionar as taxas por cidade e pacote, limitar o pay-per-view Basic a R$65 e aplicar o
 * imposto da cidade sobre o subtotal.
 *
 * Atividade: C06ex15.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex15 {

    static void main() {

        int packageCode, daysQuantity;

        String packageCodeStr, daysQuantityStr, extrasServicesPriceStr, city;

        double extrasServicesPrice, monthFinalCost, fixedValue, payperview, incometax;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        packageCodeStr = JOptionPane.showInputDialog(null,
                "Informe o código do seu pacote: ",
                "Conteúdo 06 | Exercício 15",
                JOptionPane.QUESTION_MESSAGE);

        daysQuantityStr = JOptionPane.showInputDialog(null,
                "Informe a quantidade de dias de consumo de canais pay-per-view: ",
                "Conteúdo 06 | Exercício 15",
                JOptionPane.QUESTION_MESSAGE);

        extrasServicesPriceStr = JOptionPane.showInputDialog(null,
                "Informe valor dos serviços extras: ",
                "Conteúdo 06 | Exercício 15",
                JOptionPane.QUESTION_MESSAGE);

        city = JOptionPane.showInputDialog(null,
                "Informe a sua cidade: ",
                "Conteúdo 06 | Exercício 15",
                JOptionPane.QUESTION_MESSAGE);

        packageCode = Integer.valueOf(packageCodeStr);
        daysQuantity = Integer.valueOf(daysQuantityStr);
        extrasServicesPrice = Double.valueOf(extrasServicesPriceStr);

        // Processamento: Selecionar as taxas por cidade e pacote, limitar o pay-per-view Basic a
        // R$65 e aplicar o imposto da cidade sobre o subtotal.
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
                
                // Saída: apresentar a mensagem correspondente ao resultado atual.
                JOptionPane.showMessageDialog(null,
                        "Você não informou um código válido para algum pacote!",
                        "Conteúdo 06 | Exercício 15",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        monthFinalCost = fixedValue + payperview + extrasServicesPrice;

        monthFinalCost += monthFinalCost * incometax;

        JOptionPane.showMessageDialog(null,
                "Conta: " + monthFinalCost,
                "Sua conta",
                JOptionPane.INFORMATION_MESSAGE);

    }
}
