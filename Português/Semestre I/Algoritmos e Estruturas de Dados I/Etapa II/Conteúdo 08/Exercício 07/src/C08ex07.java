package SecondStage;

import javax.swing.JOptionPane;
import java.awt.*;

/**
 * Acumular todas as idades, manter contadores por faixa e dividir a soma das idades pela
 * quantidade de registros.
 *
 * Atividade: C08ex07.
 */
public class C08ex07 {
    static void main() {
        String name, ageStr;
        int age, allages, untiltwelve, higherthirty, rep;
        float mediaOfAllAges;

        allages = 0;
        untiltwelve = 0;
        higherthirty = 0;
        rep = 50;

        // Processamento: Acumular todas as idades, manter contadores por faixa e dividir a soma das
        // idades pela quantidade de registros.
        for (int i = 1; i <= rep; i ++) {
            // Entrada: coletar os valores solicitados por caixas de diálogo.
            name = JOptionPane.showInputDialog(null,
                    "Informe seu nome:",
                    "Conteúdo 08 | Exercício 07",
                    JOptionPane.QUESTION_MESSAGE);
            ageStr = JOptionPane.showInputDialog(null,
                    "Informe sua idade:",
                    "Conteúdo 08 | Exercício 07",
                    JOptionPane.QUESTION_MESSAGE);
            age = Integer.parseInt(ageStr);

            if (age <=12) {
                untiltwelve++;
                allages += age;
            }
            // A comparação original inclui a idade de 30 anos neste grupo.
            else if (age >=30) {
                higherthirty++;
                allages += age;
            }
            else {
                allages += age;
            }
        }

        mediaOfAllAges = (float) allages / rep;
        // Saída: apresentar a mensagem correspondente ao resultado atual.
        JOptionPane.showMessageDialog(null,
                "Alunos que possuem idade de até 12 anos: " + untiltwelve + "\nAlunos que possuem idade acima de 30 anos: " + higherthirty + "\nMédia das idades informadas: " + mediaOfAllAges );
    }
}
