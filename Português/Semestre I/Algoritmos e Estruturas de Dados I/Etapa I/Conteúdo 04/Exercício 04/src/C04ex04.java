package FirstStage;

import javax.swing.JOptionPane;

/**
 * Converter a idade de texto para inteiro e exibir o sobrenome antes dos demais nomes.
 *
 * Atividade: C04ex04.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C04ex04 {

    static void main() {

        String name, midname, surname, agestr;

        int age;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        name = JOptionPane.showInputDialog(null,
                "Informe o seu primeiro nome:",
                "Conteúdo 04 | Exercício 04",
                JOptionPane.QUESTION_MESSAGE);

        midname = JOptionPane.showInputDialog(null,
                "Informe o seu segundo nome:",
                "Conteúdo 04 | Exercício 04",
                JOptionPane.QUESTION_MESSAGE);

        surname = JOptionPane.showInputDialog(null,
                "Informe o seu sobrenome:",
                "Conteúdo 04 | Exercício 04",
                JOptionPane.QUESTION_MESSAGE);

        agestr = JOptionPane.showInputDialog(null,
                "Informe a sua idade:",
                "Conteúdo 04 | Exercício 04",
                JOptionPane.QUESTION_MESSAGE);

        // Processamento: Converter a idade de texto para inteiro e exibir o sobrenome antes dos
        // demais nomes.
        age = Integer.valueOf(agestr);

        // Saída: apresentar a mensagem correspondente ao resultado atual.
        JOptionPane.showMessageDialog(null,
                surname + ", " + name + " " + midname + "\n" + age + " anos.",
                "Conteúdo 04 | Exercício 04",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
