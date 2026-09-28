package FirstStage;

import javax.swing.JOptionPane;

/**
 * Usar switch para selecionar isenção, 2%, 10% mais 0.5% por dia ou 150% mais R$1 por dia.
 *
 * Atividade: C07ex03.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C07ex03 {

    static void main() {

        String taxStr, lateDaysStr;

        int lateDays;

        double tax, fee, percentualFee;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        taxStr = JOptionPane.showInputDialog(null,
                "Informe o valor do imposto: ",
                "Conteúdo 07 | Exercício 03",
                JOptionPane.QUESTION_MESSAGE);

        lateDaysStr = JOptionPane.showInputDialog(null,
                "Informe a quantidade de dias atrasados: ",
                "Conteúdo 07 | Exercício 03",
                JOptionPane.QUESTION_MESSAGE);

        tax = Double.valueOf(taxStr);
        lateDays = Integer.valueOf(lateDaysStr);

        // Processamento: Usar switch para selecionar isenção, 2%, 10% mais 0.5% por dia ou 150%
        // mais R$1 por dia.
        switch (lateDays) {
            case 0, 1, 2, 3, 4, 5 -> {
                
                percentualFee = 0;
                fee = tax * percentualFee;
            }
            case 6, 7, 8 -> {
                
                percentualFee = 0.02;
                fee = tax * percentualFee;
            }
            case 9, 10 -> {

                percentualFee = 0.10 + 0.005 * lateDays;
                fee = tax * percentualFee;
            }
            default -> {

                percentualFee = 1.50;
                fee = (tax * percentualFee) + (1 * lateDays);
            }
        }

        // Saída: apresentar a mensagem correspondente ao resultado atual.
        JOptionPane.showMessageDialog(null,
                "Multa: R$" + fee,
                "Conteúdo 07 | Exercício 03",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
