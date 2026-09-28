package FirstStage;

import javax.swing.JOptionPane;

/**
 * Subtrair os horários e emprestar uma hora quando a diferença de minutos for negativa.
 *
 * Atividade: C06ex13.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex13 {

    static void main() {

        String initialHourStr, initialMinuteStr, finalHourStr, finalMinuteStr;

        int initialHour, initialMinute, finalHour, finalMinute, durationHour, durationMinute;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        initialHourStr = JOptionPane.showInputDialog(null,
                "Informe a hora inicial: ",
                "Conteúdo 06 | Exercício 13",
                JOptionPane.QUESTION_MESSAGE);

        initialMinuteStr = JOptionPane.showInputDialog(null,
                "Informe o minuto inicial: ",
                "Conteúdo 06 | Exercício 13",
                JOptionPane.QUESTION_MESSAGE);

        finalHourStr = JOptionPane.showInputDialog(null,
                "Informe a hora final: ",
                "Conteúdo 06 | Exercício 13",
                JOptionPane.QUESTION_MESSAGE);

        finalMinuteStr = JOptionPane.showInputDialog(null,
                "Informe o minuto final: ",
                "Conteúdo 06 | Exercício 13",
                JOptionPane.QUESTION_MESSAGE);

        initialHour = Integer.valueOf(initialHourStr);
        initialMinute = Integer.valueOf(initialMinuteStr);
        finalHour = Integer.valueOf(finalHourStr);
        finalMinute = Integer.valueOf(finalMinuteStr);

        // Processamento: Subtrair os horários e emprestar uma hora quando a diferença de minutos
        // for negativa.
        durationHour = finalHour - initialHour;
        durationMinute = finalMinute - initialMinute;

        // Emprestar uma hora e convertê-la em 60 minutos.
        if (durationMinute < 0) {
            durationHour = durationHour - 1;
            durationMinute = durationMinute + 60;
        }

        else {
            durationHour = durationHour;
            durationMinute = durationMinute;
        }

        // Saída: apresentar a mensagem correspondente ao resultado atual.
        JOptionPane.showMessageDialog(null,
                "Duração: " + durationHour + " horas e " + durationMinute + " minutos.");
    }
}
