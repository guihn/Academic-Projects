package FirstStage;

import javax.swing.JOptionPane;

/**
 * Armazenar as comparações das opções das janelas e combiná-las com E, OU, negação e uma
 * comparação de preferências exclusivas.
 *
 * Atividade: C06ex17.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex17 {

    static void main() {

        boolean tecnicianCourse, higherCourse, threeYearsOfExp, criativePearson, leadOrBeLead, workLonelyorinTeam, selfTaught, initialSalary, onlyBH, apt, tecnicianCourseandExp;

        // O índice de opção 1 é Não. As comparações existentes invertem, portanto, as respostas
        // afirmativas.
        Object[] buttons = {"Sim", "Não"};

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        tecnicianCourse = JOptionPane.showOptionDialog(null,
                "1 | 9 - Você possui curso técnico?",
                "Conteúdo 06 | Exercício 17",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                buttons,
                buttons[1]) == 1;

        higherCourse = JOptionPane.showOptionDialog(null,
                "2 | 9 - Você possui curso superior?",
                "Conteúdo 06 | Exercício 17",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                buttons,
                buttons[1]) == 1;

        threeYearsOfExp = JOptionPane.showOptionDialog(null,
                "3 | 9 - Você possui menos de 3 anos de experiência?",
                "Conteúdo 06 | Exercício 17",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                buttons,
                buttons[1]) == 1;

        criativePearson = JOptionPane.showOptionDialog(null,
                "4 | 9 - Você se considera uma pessoa criativa?",
                "Conteúdo 06 | Exercício 17",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                buttons,
                buttons[1]) == 1;

        leadOrBeLead = JOptionPane.showOptionDialog(null,
                "5 | 9 - Você prefere liderar a ser liderado?",
                "Conteúdo 06 | Exercício 17",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                buttons,
                buttons[1]) == 1;

        workLonelyorinTeam = JOptionPane.showOptionDialog(null,
                "6 | 9 - Você prefere trabalhar sozinho?",
                "Conteúdo 06 | Exercício 17",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                buttons,
                buttons[1]) == 1;

        selfTaught = JOptionPane.showOptionDialog(null,
                "7 | 9 - Você é autodidata (aprende sozinho)?",
                "Conteúdo 06 | Exercício 17",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                buttons,
                buttons[1]) == 1;

        initialSalary = JOptionPane.showOptionDialog(null,
                "8 | 9 - Você aceitaria uma remuneração inicial de até R$1.500,00?",
                "Conteúdo 06 | Exercício 17",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                buttons,
                buttons[1]) == 1;

        onlyBH = JOptionPane.showOptionDialog(null,
                "9 | 9 - Você só aceitaria trabalhar em escritórios da empresa dentro da Grande BH?",
                "Conteúdo 06 | Exercício 17",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                buttons,
                buttons[1]) == 1;

        // Processamento: Armazenar as comparações das opções das janelas e combiná-las com E, OU,
        // negação e uma comparação de preferências exclusivas.
        tecnicianCourseandExp = tecnicianCourse && !threeYearsOfExp;

        if (higherCourse || tecnicianCourseandExp) {

            if (leadOrBeLead != initialSalary) {

                if (criativePearson && !workLonelyorinTeam && selfTaught && !onlyBH) {
                    apt = true;
                } else apt = false;
            } else apt = false;
        } else apt = false;

        if (apt == true) {
            // Saída: apresentar a mensagem correspondente ao resultado atual.
            JOptionPane.showMessageDialog(null,
                    "Essa pessoa está APTA!",
                    "Conteúdo 06 | Exercício 17",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            
            JOptionPane.showMessageDialog(null,
                    "Essa pessoa está INAPTA!",
                    "Conteúdo 06 | Exercício 17",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
