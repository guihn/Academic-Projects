package FirstStage;

import javax.swing.JOptionPane;

/**
 * Converter o percentual diário para fração, calcular o rendimento e subtrair o imposto e a taxa
 * administrativa.
 *
 * Atividade: C06ex10.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex10 {

    static void main() {

        String appliedCapitalStr, numberdaysStr, diaryFeeStr;

        double appliedCapital, numberdays, diaryFee, yield, incomeTax, adminFee, finalvalor;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        appliedCapitalStr = JOptionPane.showInputDialog(null,
                "Informe o capital aplicado:",
                "Conteúdo 06 | Exercício 10",
                JOptionPane.QUESTION_MESSAGE);

        numberdaysStr = JOptionPane.showInputDialog(null,
                "Informe o número de dias aplicados (em números):",
                "Conteúdo 06 | Exercício 10",
                JOptionPane.QUESTION_MESSAGE);

        diaryFeeStr = JOptionPane.showInputDialog(null,
                "Informe a taxa diária (em números, 10 = 10%):",
                "Conteúdo 06 | Exercício 10",
                JOptionPane.QUESTION_MESSAGE);

        appliedCapital = Double.valueOf(appliedCapitalStr);
        numberdays = Double.valueOf(numberdaysStr);
        diaryFee = Double.valueOf(diaryFeeStr);

        // Processamento: Converter o percentual diário para fração, calcular o rendimento e
        // subtrair o imposto e a taxa administrativa.
        diaryFee = diaryFee / 100;

        yield = appliedCapital * diaryFee * numberdays;

        incomeTax = yield * 0.15;

        adminFee = 10;

        finalvalor = appliedCapital + yield - incomeTax - adminFee;

        // Saída: apresentar a mensagem correspondente ao resultado atual.
        JOptionPane.showMessageDialog(null,
                "Rendimento: R$" + yield +
                        "\nImposto de renda: R$" + incomeTax +
                        "\nValor resgatado: R$" + finalvalor,
                "Conteúdo 06 | Exercício 10",
                JOptionPane.INFORMATION_MESSAGE);

    }
}
