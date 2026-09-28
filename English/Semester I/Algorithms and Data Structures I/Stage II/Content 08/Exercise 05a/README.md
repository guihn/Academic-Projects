<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20II/Conte%C3%BAdo%2008/Exerc%C3%ADcio%2005a">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20II/Content%2008">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 05a · Election with ties and invalid votes

## Description

**Statement summary:** Extend the election program to handle two or three tied candidates through a second round. Cancel any round where invalid votes outnumber valid votes.

## Solution

Count and confirm invalid votes, check cancellation and run a new vote count for a leading pair of tied candidates.

### Implementation notes

A three-way tie displays a message about electing the oldest candidate instead of holding the requested second round. A repeated tie also uses that message, without reading ages or identifying an oldest candidate.

Source file: [C08ex05a.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20II/Content%2008/Exercise%2005a/src/C08ex05a.java)

<details>
<summary>💻 | Java code</summary>

```java
package SecondStage;

import javax.swing.JOptionPane;

/**
 * Count and confirm invalid votes, check cancellation and run a new vote count for a leading
 * pair of tied candidates.
 *
 * Assignment: C08ex05a.
 */
public class C08ex05a {
    static void main() {
        String votesStr;
        int votes, votes1C, votes2C, votes3C, nullVotes, voteConfirm, validVotes, rep;

        // Processing: Count and confirm invalid votes, check cancellation and run a new vote count
        // for a leading pair of tied candidates.
        votes1C = 0;
        votes2C = 0;
        votes3C = 0;
        nullVotes = 0;
        rep = 100;

        // Each round accepts 100 counted ballots, including confirmed invalid votes.
        for (int i = 1; i <= rep; i ++) {

            // Input: collect the requested values through dialog boxes.
            votesStr = JOptionPane.showInputDialog(null,
                    "Enter the candidate number: ",
                    "Content 08 | Exercise 05a",
                    JOptionPane.QUESTION_MESSAGE);
            votes = Integer.parseInt(votesStr);

            // Count votes only for candidates present in this round.
            switch (votes) {
                case 1 -> {
                    votes1C++;
                    // Output: display the message for the current result.
                    JOptionPane.showMessageDialog(null,
                            "Vote counted!",
                            "Content 08 | Exercise 05a",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                case 2 -> {
                    votes2C++;
                    JOptionPane.showMessageDialog(null,
                            "Vote counted!",
                            "Content 08 | Exercise 05a",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                case 3 -> {
                    votes3C++;
                    JOptionPane.showMessageDialog(null,
                            "Vote counted!",
                            "Content 08 | Exercise 05a",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                default -> {
                    
                    Object[] buttons = {"Yes", "No"};
                    voteConfirm = JOptionPane.showOptionDialog(null,
                            "You entered a number other than 1, 2 or 3! Your vote will be counted as invalid. Are you sure? ",
                            "Content 08 | Exercise 05a",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            buttons,
                            buttons[1]);
                    // No cancels this ballot and repeats the current iteration.
                    if (voteConfirm == 1) {
                        i--;
                        JOptionPane.showMessageDialog(null,
                                "Vote not counted!",
                                "Content 08 | Exercise 05a",
                                JOptionPane.ERROR_MESSAGE);
                        break;
                    } else
                        nullVotes++;
                    JOptionPane.showMessageDialog(null,
                            "Vote counted!",
                            "Content 08 | Exercise 05a",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }

        // Add the candidate counts before comparing them with invalid votes.
        validVotes = votes1C + votes2C + votes3C;
        
        // Cancel this round when invalid votes exceed the sum of candidate votes.
        if (nullVotes > validVotes) {
            JOptionPane.showMessageDialog(null,
                    "Election cancelled because invalid votes outnumbered valid votes!",
                    "Content 08 | Exercise 05a",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        else {
            
            // The original three-way tie branch only displays an age-based tie-break message.
            if (votes1C == votes2C && votes1C == votes3C) {
                JOptionPane.showMessageDialog(null,
                        "Candidates 'Fulano', 'Ciclano' and 'Beltrano' tied! They received " + votes1C + " votes each! There will be no second round because the OLDEST candidate will be elected!",
                        "Content 08 | Exercise 05a",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            
            else if (votes1C == votes2C && votes1C > votes3C) {
                JOptionPane.showMessageDialog(null,
                        "Candidates 'Fulano' and 'Ciclano' tied! They received " + votes1C + " votes each! \n'Beltrano' received " + votes3C + " votes\nMoving to the second round!",
                        "Content 08 | Exercise 05a",
                        JOptionPane.INFORMATION_MESSAGE);

                // Start the second round with cleared counters.
                votes = 0;
                votes1C = 0;
                votes2C = 0;
                votes3C = 0;
                nullVotes = 0;

                // Each round accepts 100 counted ballots, including confirmed invalid votes.
                for (int i = 1; i <= rep; i ++) {

                    votesStr = JOptionPane.showInputDialog(null,
                            "Enter the candidate number: ",
                            "Content 08 | Exercise 05",
                            JOptionPane.QUESTION_MESSAGE);
                    votes = Integer.parseInt(votesStr);

                    // Count votes only for candidates present in this round.
                    switch (votes) {
                        case 1 -> {
                            votes1C++;
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
                        default -> {
                            
                            Object[] buttons = {"Yes", "No"};
                            voteConfirm = JOptionPane.showOptionDialog(null,
                                    "You entered a number other than 1 or 2! Your vote will be counted as invalid. Are you sure? ",
                                    "Content 08 | Exercise 05a",
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE,
                                    null,
                                    buttons,
                                    buttons[1]);
                            // No cancels this ballot and repeats the current iteration.
                            if (voteConfirm == 1) {
                                i--;
                                JOptionPane.showMessageDialog(null,
                                        "Vote not counted!",
                                        "Content 08 | Exercise 05a",
                                        JOptionPane.ERROR_MESSAGE);
                                break;
                            } else
                                nullVotes++;
                            JOptionPane.showMessageDialog(null,
                                    "Vote counted!",
                                    "Content 08 | Exercise 05a",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }

                // Add the candidate counts before comparing them with invalid votes.
                validVotes = votes1C + votes2C + votes3C;
                
                // Cancel this round when invalid votes exceed the sum of candidate votes.
                if (nullVotes > validVotes) {
                    JOptionPane.showMessageDialog(null,
                            "Election cancelled because invalid votes outnumbered valid votes!",
                            "Content 08 | Exercise 05a",
                            JOptionPane.ERROR_MESSAGE);
                }
                
                else {
                    if (votes1C > votes2C) {
                        JOptionPane.showMessageDialog(null,
                                "Candidate 'Fulano' won! Number of votes: " + votes1C + " votes.\n'Ciclano' received " + votes2C + " votes.",
                                "Content 08 | Exercise 05",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    else if (votes1C < votes2C) {
                        JOptionPane.showMessageDialog(null,
                                "Candidate 'Ciclano' won! Number of votes: " + votes2C + " votes.\n'Fulano' received " + votes1C + " votes.",
                                "Content 08 | Exercise 05",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    else {
                        JOptionPane.showMessageDialog(null,
                                "Candidates 'Fulano' and 'Ciclano' tied again! They received " + votes1C + " votes each!" + "\nThere will be no third round, so the oldest candidate will be elected!",
                                "Content 08 | Exercise 05a",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
            
            else if (votes1C == votes3C && votes1C > votes2C) {
                JOptionPane.showMessageDialog(null,
                        "Candidates 'Fulano' and 'Beltrano' tied! They received " + votes1C + " votes each! \n'Ciclano' received " + votes2C + " votes.\nMoving to the second round!",
                        "Content 08 | Exercise 05a",
                        JOptionPane.INFORMATION_MESSAGE);

                // Start the second round with cleared counters.
                votes = 0;
                votes1C = 0;
                votes2C = 0;
                votes3C = 0;
                nullVotes = 0;

                // Each round accepts 100 counted ballots, including confirmed invalid votes.
                for (int i = 1; i <= rep; i ++) {

                    votesStr = JOptionPane.showInputDialog(null,
                            "Enter the candidate number: ",
                            "Content 08 | Exercise 05a",
                            JOptionPane.QUESTION_MESSAGE);
                    votes = Integer.parseInt(votesStr);

                    // Count votes only for candidates present in this round.
                    switch (votes) {
                        case 1 -> {
                            votes1C++;
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
                            
                            Object[] buttons = {"Yes", "No"};
                            voteConfirm = JOptionPane.showOptionDialog(null,
                                    "You entered a number other than 1 or 3! Your vote will be counted as invalid. Are you sure? ",
                                    "Content 08 | Exercise 05a",
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE,
                                    null,
                                    buttons,
                                    buttons[1]);
                            // No cancels this ballot and repeats the current iteration.
                            if (voteConfirm == 1) {
                                i--;
                                JOptionPane.showMessageDialog(null,
                                        "Vote not counted!",
                                        "Content 08 | Exercise 05a",
                                        JOptionPane.ERROR_MESSAGE);
                                break;
                            } else
                                nullVotes++;
                            JOptionPane.showMessageDialog(null,
                                    "Vote counted!",
                                    "Content 08 | Exercise 05a",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }

                // Add the candidate counts before comparing them with invalid votes.
                validVotes = votes1C + votes2C + votes3C;
                
                // Cancel this round when invalid votes exceed the sum of candidate votes.
                if (nullVotes > validVotes) {
                    JOptionPane.showMessageDialog(null,
                            "Election cancelled because invalid votes outnumbered valid votes!",
                            "Content 08 | Exercise 05a",
                            JOptionPane.ERROR_MESSAGE);
                }
                
                else {
                    if (votes1C > votes3C) {
                        JOptionPane.showMessageDialog(null,
                                "Candidate 'Fulano' won! Number of votes: " + votes1C + " votes.\n'Beltrano' received " + votes3C + " votes.",
                                "Content 08 | Exercise 05a",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    else if (votes1C < votes3C) {
                        JOptionPane.showMessageDialog(null,
                                "Candidate 'Beltrano' won! Number of votes: " + votes3C + " votes.\n'Fulano' received " + votes1C + " votes.",
                                "Content 08 | Exercise 05",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    else {
                        JOptionPane.showMessageDialog(null,
                                "Candidates 'Fulano' and 'Beltrano' tied again! They received " + votes1C + " votes each!\nThere will be no third round, so the oldest candidate will be elected!",
                                "Content 08 | Exercise 05a",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
            
            else if (votes2C == votes3C && votes2C > votes1C) {
                JOptionPane.showMessageDialog(null,
                        "Candidates 'Ciclano' and 'Beltrano' tied! They received " + votes2C + " votes each!  \n'Fulano' received " + votes1C +" votes\nMoving to the second round!",
                        "Content 08 | Exercise 05a",
                        JOptionPane.INFORMATION_MESSAGE);

                // Start the second round with cleared counters.
                votes = 0;
                votes1C = 0;
                votes2C = 0;
                votes3C = 0;
                nullVotes = 0;

                // Each round accepts 100 counted ballots, including confirmed invalid votes.
                for (int i = 1; i <= rep; i ++) {

                    votesStr = JOptionPane.showInputDialog(null,
                            "Enter the candidate number: ",
                            "Content 08 | Exercise 05a",
                            JOptionPane.QUESTION_MESSAGE);
                    votes = Integer.parseInt(votesStr);

                    // Count votes only for candidates present in this round.
                    switch (votes) {
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
                            
                            Object[] buttons = {"Yes", "No"};
                            voteConfirm = JOptionPane.showOptionDialog(null,
                                    "You entered a number other than 2 or 3! Your vote will be counted as invalid. Are you sure? ",
                                    "Content 08 | Exercise 05a",
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE,
                                    null,
                                    buttons,
                                    buttons[1]);
                            // No cancels this ballot and repeats the current iteration.
                            if (voteConfirm == 1) {
                                i--;
                                JOptionPane.showMessageDialog(null,
                                        "Vote not counted!",
                                        "Content 08 | Exercise 05a",
                                        JOptionPane.ERROR_MESSAGE);
                                break;
                            } else
                                nullVotes++;
                            JOptionPane.showMessageDialog(null,
                                    "Vote counted!",
                                    "Content 08 | Exercise 05a",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }

                // Add the candidate counts before comparing them with invalid votes.
                validVotes = votes1C + votes2C + votes3C;
                
                // Cancel this round when invalid votes exceed the sum of candidate votes.
                if (nullVotes > validVotes) {
                    JOptionPane.showMessageDialog(null,
                            "Election cancelled because invalid votes outnumbered valid votes!",
                            "Content 08 | Exercise 05a",
                            JOptionPane.ERROR_MESSAGE);
                }
                
                else {
                    if (votes2C > votes3C) {
                        JOptionPane.showMessageDialog(null,
                                "Candidate 'Ciclano' won! Number of votes: " + votes2C + " votes.\n'Beltrano' received " + votes3C + " votes.",
                                "Content 08 | Exercise 05a",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    else if (votes2C < votes3C) {
                        JOptionPane.showMessageDialog(null,
                                "Candidate 'Beltrano' won! Number of votes: " + votes3C + " votes.\n'Ciclano' received " + votes2C + " votes.",
                                "Content 08 | Exercise 05",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    else {
                        JOptionPane.showMessageDialog(null,
                                "Candidates 'Ciclano' and 'Beltrano' tied again! They received " + votes2C + " votes each! \nThere will be no third round, so the oldest candidate will be elected!",
                                "Content 08 | Exercise 05a",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
            
            else if (votes1C > votes2C && votes1C > votes3C) {
                JOptionPane.showMessageDialog(null,
                        "Candidate 'Fulano' won! Number of votes: " + votes1C + " votes.\n'Ciclano' received " + votes2C + " votes.\n'Beltrano' received " + votes3C + " votes.",
                        "Content 08 | Exercise 05a",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            
            else if (votes2C > votes1C && votes2C > votes3C) {
                JOptionPane.showMessageDialog(null,
                        "Candidate 'Ciclano' won! Number of votes: " + votes2C + " votes.\n'Fulano' received " + votes1C + " votes.\n'Beltrano' received " + votes3C + " votes.",
                        "Content 08 | Exercise 05a",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            
            else {
                JOptionPane.showMessageDialog(null,
                        "Candidate 'Beltrano' won! Number of votes: " + votes3C + " votes.\n'Fulano' received " + votes1C + " votes.\n'Ciclano' received " + votes2C + " votes.",
                        "Content 08 | Exercise 05a",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
```

</details>
