package FirstStage;

import javax.swing.JOptionPane;

/**
 * Escolher a parcela fixa e o percentual, calcular a participação bruta e subtrair o imposto do
 * exercício.
 *
 * Atividade: C06ex07.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex07 {

    static void main() {

        String employeeSalaryStr;

        double employeeSalary, grossPL, liquidPL, incomeTax, fixedValor, percentageOverSalary, percentage;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        employeeSalaryStr = JOptionPane.showInputDialog(null,
                "Informe o salário:",
                "Conteúdo 06 | Exercício 07",
                JOptionPane.QUESTION_MESSAGE);

        employeeSalary = Double.valueOf(employeeSalaryStr);

        // Processamento: Escolher a parcela fixa e o percentual, calcular a participação bruta e
        // subtrair o imposto do exercício.
        if (employeeSalary <= 300) {
            fixedValor = 500;
            percentage = 0.70;
        }

        else if (employeeSalary > 300 && employeeSalary <= 1000) {
            fixedValor = 200;
            percentage = 0.50;
        }
        
        else {
            fixedValor = 0;
            percentage = 0.30;
        }

        percentageOverSalary = employeeSalary * percentage;

        grossPL = fixedValor + percentageOverSalary;

        incomeTax = 0.25 * grossPL;

        liquidPL = grossPL - incomeTax;

        // Saída: apresentar a mensagem correspondente ao resultado atual.
        JOptionPane.showMessageDialog(null,
                "PL líquido: " + liquidPL,
                "Conteúdo 06 | Exercício 07",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
