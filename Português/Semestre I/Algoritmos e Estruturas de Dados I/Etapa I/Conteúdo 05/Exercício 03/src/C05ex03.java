package FirstStage;

import javax.swing.JOptionPane;

/**
 * Subtrair o desconto por dependentes do salário e aplicar o percentual informado na janela.
 *
 * Atividade: C05ex03.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C05ex03 {

    static void main() {

        String salaryStr, dependentsStr, irStr;

        double salary, dependents, ir, liquidSalary;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        salaryStr = JOptionPane.showInputDialog(null,
                "Informe o salário:",
                "Conteúdo 05 | Exercício 03",
                JOptionPane.QUESTION_MESSAGE);

        dependentsStr = JOptionPane.showInputDialog(null,
                "Informe o número de dependentes:",
                "Conteúdo 05 | Exercício 03",
                JOptionPane.QUESTION_MESSAGE);

        irStr = JOptionPane.showInputDialog(null,
                "Informe a porcentagem do imposto de renda (Ex.: 15):",
                "Conteúdo 05 | Exercício 03",
                JOptionPane.QUESTION_MESSAGE);

        salary = Double.valueOf(salaryStr);
        dependents = Double.valueOf(dependentsStr);
        ir = Double.valueOf(irStr);

        // Processamento: Subtrair o desconto por dependentes do salário e aplicar o percentual
        // informado na janela.
        liquidSalary = salary - dependents * 60.00;

        ir = liquidSalary * ir / 100.0;

        // Saída: apresentar a mensagem correspondente ao resultado atual.
        JOptionPane.showMessageDialog(null,
                "Líquido: R$" + liquidSalary + "\nImposto de renda: R$" + ir,
                "Conteúdo 05 | Exercício 03",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
