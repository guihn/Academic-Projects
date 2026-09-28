package SecondStage;

import javax.swing.JOptionPane;

/**
 * Incrementar um de dois contadores conforme cada idade informada.
 *
 * Atividade: C08ex04.
 */
public class C08ex04 {
    static void main() {
        String name, ageStr;
        int age, lowerthan18 = 0, higherthan18 = 0;

        // Processamento: Incrementar um de dois contadores conforme cada idade informada.
        for (int students = 1; students <= 5; students ++) {
            // Entrada: coletar os valores solicitados por caixas de diálogo.
            name = JOptionPane.showInputDialog(null,
                    "Informe seu nome: ",
                    "Conteúdo 08 | Exercício 04",
                    JOptionPane.QUESTION_MESSAGE);
            ageStr = JOptionPane.showInputDialog(null,
                    "Informe sua idade: ",
                    "Conteúdo 08 | Exercício 04",
                    JOptionPane.QUESTION_MESSAGE);

            age = Integer.valueOf(ageStr);

            if (age <= 18) {
                lowerthan18++;
            }
            else {
                higherthan18++;
            }
        }
        // Saída: apresentar a mensagem correspondente ao resultado atual.
        JOptionPane.showMessageDialog(null,
                "Até 18: " + lowerthan18 + "\nAcima de 18: " + higherthan18,
                "Conteúdo 08 | Exercício 04",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
