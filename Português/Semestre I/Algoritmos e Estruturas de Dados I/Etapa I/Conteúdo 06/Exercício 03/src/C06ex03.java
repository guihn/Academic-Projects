package FirstStage;

import javax.swing.JOptionPane;

/**
 * Selecionar uma expressão de salário conforme a faixa de vendas mensais.
 *
 * Atividade: C06ex03.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex03 {

    static void main() {

        String monthlySaleStr;

        double monthlySale, fixedValor, salary;

        fixedValor = 240;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        monthlySaleStr = JOptionPane.showInputDialog(null,
                "Informe o total mensal vendido:",
                "Conteúdo 06 | Exercício 03",
                JOptionPane.QUESTION_MESSAGE);

        monthlySale = Double.valueOf(monthlySaleStr);

        // Processamento: Selecionar uma expressão de salário conforme a faixa de vendas mensais.
        if (monthlySale <= 1000)
            salary = fixedValor;

        else if (monthlySale > 1000 && monthlySale <= 10000)
            salary = fixedValor + (monthlySale * 0.10);
            
        else
            // Este ramo original omite a parcela fixa de 240.
            salary = 1000;

        // Saída: apresentar a mensagem correspondente ao resultado atual.
        JOptionPane.showMessageDialog(null,
                "Salário: " + salary,
                "Conteúdo 06 | Exercício 03",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
