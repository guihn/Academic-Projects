package FirstStage;

import javax.swing.JOptionPane;

/**
 * Atribuir 3–0 pontos para placares de sets 3–0 ou 3–1 e 2–1 pontos para placar 3–2, incluindo
 * os casos simétricos.
 *
 * Atividade: C06ex11.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex11 {

    static void main() {

        String team1, team2, set1Str, set2Str;

        double set1, set2, points1, points2;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        team1 = JOptionPane.showInputDialog(null,
                "Qual o nome do 1° Time? ",
                "Conteúdo 06 | Exercício 11",
                JOptionPane.QUESTION_MESSAGE);

        team2 = JOptionPane.showInputDialog(null,
                "Qual o nome do 2° Time? ",
                "Conteúdo 06 | Exercício 11",
                JOptionPane.QUESTION_MESSAGE);

        set1Str = JOptionPane.showInputDialog(null,
                "Quanto sets o 1° time venceu? (Ex.: 3)? ",
                "Conteúdo 06 | Exercício 11",
                JOptionPane.QUESTION_MESSAGE);

        set2Str = JOptionPane.showInputDialog(null,
                "Quanto sets o 2° time venceu? (Ex.: 3)? ",
                "Conteúdo 06 | Exercício 11",
                JOptionPane.QUESTION_MESSAGE);

        set1 = Double.valueOf(set1Str);
        set2 = Double.valueOf(set2Str);

        // Processamento: Atribuir 3–0 pontos para placares de sets 3–0 ou 3–1 e 2–1 pontos para
        // placar 3–2, incluindo os casos simétricos.
        points1 = 0;
        points2 = 0;

        if (set1 == 3 && set2 == 0)
            points1 = 3;
        else if (set1 == 3 && set2 == 1)
            points1 = 3;
            
        else if (set1 == 0 && set2 == 3)
            points2 = 3;
        else if (set1 == 1 && set2 == 3)
            points2 = 3;

        else if (set1 == 3 && set2 == 2) {
            points1 = 2;
            points2 = 1;
        }
        
        else if (set1 == 2 && set2 == 3) {
            points1 = 1;
            points2 = 2;
        }
        
        else {
            points1 = 69;
            points2 = 69;
        }

        // Saída: apresentar a mensagem correspondente ao resultado atual.
        JOptionPane.showMessageDialog(null,
                "Pontos do " + team1 + ": " + points1 + "\nPontos do " + team2 + ": " + points2);
    }
}
