package FirstStage;

import javax.swing.JOptionPane;

/**
 * Tratar as faixas baixas de acertos com if e selecionar o prêmio de 11, 12 ou 13 acertos com
 * switch.
 *
 * Atividade: C07ex01.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C07ex01 {

    static void main() {

        String name, winsStr;

        int wins;

        double award;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        name = JOptionPane.showInputDialog(null,
                "Informe seu nome: ",
                "Conteúdo 07 | Exercício 01",
                JOptionPane.QUESTION_MESSAGE);

        winsStr = JOptionPane.showInputDialog(null,
                "Informe seu número de acertos: ",
                "Conteúdo 07 | Exercício 01",
                JOptionPane.QUESTION_MESSAGE);

        wins = Integer.valueOf(winsStr);

        // Processamento: Tratar as faixas baixas de acertos com if e selecionar o prêmio de 11, 12
        // ou 13 acertos com switch.
        if (wins <= 5) {
            // Saída: apresentar a mensagem correspondente ao resultado atual.
            JOptionPane.showMessageDialog(null,
                    name + ", você acertou muito pouco e não receberá nenhum prêmio!",
                    "Conteúdo 07 | Exercício 01",
                    JOptionPane.ERROR_MESSAGE);
        } else if (wins <= 10) {
            
            JOptionPane.showMessageDialog(null,
                    name + ", você acertou muito pouco, mas receberá um novo cartao!",
                    "Conteúdo 07 | Exercício 01",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {

            switch (wins) {
                case 11 -> {
                    
                    award = 100.00;
                }
                case 12 -> {
                    
                    award = 1000.00;
                }
                case 13 -> {
                    
                    award = 50000.00;
                }
                default -> {
                    
                    award = 0;
                    JOptionPane.showMessageDialog(null,
                            name + ", você não informou um número de acertos válidos! O seu prêmio foi zerado.",
                            "Conteúdo 07 | Exercício 01",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            JOptionPane.showMessageDialog(null,
                    name + ", você acertou " + wins + " e receberá o prêmio de: R$" + award,
                    "Conteúdo 07 | Exercício 01",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
