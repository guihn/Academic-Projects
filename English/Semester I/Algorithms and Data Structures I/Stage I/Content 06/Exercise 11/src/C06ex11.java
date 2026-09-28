package FirstStage;

import javax.swing.JOptionPane;

/**
 * Award 3–0 points for 3–0 or 3–1 set scores and 2–1 points for a 3–2 score, with symmetric
 * cases.
 *
 * Assignment: C06ex11.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex11 {

    static void main() {

        String team1, team2, set1Str, set2Str;

        double set1, set2, points1, points2;

        // Input: collect the requested values through dialog boxes.
        team1 = JOptionPane.showInputDialog(null,
                "What is the name of team 1? ",
                "Content 06 | Exercise 11",
                JOptionPane.QUESTION_MESSAGE);

        team2 = JOptionPane.showInputDialog(null,
                "What is the name of team 2? ",
                "Content 06 | Exercise 11",
                JOptionPane.QUESTION_MESSAGE);

        set1Str = JOptionPane.showInputDialog(null,
                "How many sets did team 1 win (e.g. 3)? ",
                "Content 06 | Exercise 11",
                JOptionPane.QUESTION_MESSAGE);

        set2Str = JOptionPane.showInputDialog(null,
                "How many sets did team 2 win (e.g. 3)? ",
                "Content 06 | Exercise 11",
                JOptionPane.QUESTION_MESSAGE);

        set1 = Double.valueOf(set1Str);
        set2 = Double.valueOf(set2Str);

        // Processing: Award 3–0 points for 3–0 or 3–1 set scores and 2–1 points for a 3–2 score,
        // with symmetric cases.
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

        // Output: display the message for the current result.
        JOptionPane.showMessageDialog(null,
                "Points for " + team1 + ": " + points1 + "\nPoints for " + team2 + ": " + points2);
    }
}
