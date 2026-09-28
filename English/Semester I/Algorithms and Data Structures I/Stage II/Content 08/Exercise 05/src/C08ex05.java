package SecondStage;

import javax.swing.JOptionPane;

/**
 * Count each valid candidate code and compare the totals. Decrement the loop counter to retry
 * invalid input.
 *
 * Assignment: C08ex05.
 */
public class C08ex05 {
    static void main() {
        String votesStr;
        int votes, votes1C, votes2C, votes3C, rep;

        votes = 0;
        votes1C = 0;
        votes2C = 0;
        votes3C = 0;
        rep = 100;

        // Processing: Count each valid candidate code and compare the totals. Decrement the loop
        // counter to retry invalid input.
        for (int i = 1; i <= rep; i ++) {

            // Input: collect the requested values through dialog boxes.
            votesStr = JOptionPane.showInputDialog(null,
                    "Enter the candidate number: ",
                    "Content 08 | Exercise 05",
                    JOptionPane.QUESTION_MESSAGE);
            votes = Integer.parseInt(votesStr);

            switch (votes) {
                case 1 -> {
                    votes1C++;
                    // Output: display the message for the current result.
                    JOptionPane.showMessageDialog(null,
                            "Vote counted!",
                            "Content 08 | Exercise 05",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                case 2 -> {
                    votes2C++;
                    JOptionPane.showMessageDialog(null,
                            "Vote counted!",
                            "Content 08 | Exercise 05",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                case 3 -> {
                    votes3C++;
                    JOptionPane.showMessageDialog(null,
                            "Vote counted!",
                            "Content 08 | Exercise 05",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                default -> {
                    JOptionPane.showMessageDialog(null,
                            "You entered an invalid number! Try 1, 2 or 3.",
                            "Content 08 | Exercise 05",
                            JOptionPane.ERROR_MESSAGE);
                    i--;
                }
            }
        }

        if (votes1C > votes2C && votes1C > votes3C) {
            JOptionPane.showMessageDialog(null,
                    "Candidate 'Fulano' won! Number of votes: " + votes1C,
                    "Content 08 | Exercise 05",
                    JOptionPane.INFORMATION_MESSAGE);
        } else if (votes2C > votes1C && votes2C > votes3C) {
            JOptionPane.showMessageDialog(null,
                    "Candidate 'Ciclano' won! Number of votes: " + votes2C,
                    "Content 08 | Exercise 05",
                    JOptionPane.INFORMATION_MESSAGE);
        } else if (votes3C > votes1C && votes3C > votes2C) {
            JOptionPane.showMessageDialog(null,
                    "Candidate 'Beltrano' won! Number of votes: " + votes3C,
                    "Content 08 | Exercise 05",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                    "There may have been a tie, but this program does not handle that case.",
                    "Content 08 | Exercise 05",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
