package FirstStage;

import javax.swing.JOptionPane;

/**
 * Convert the input to uppercase and match it against the grouped team names in switch.
 *
 * Assignment: C07ex04.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C07ex04 {

    static void main() {

        String teamName, country;

        // Input: collect the requested values through dialog boxes.
        teamName = JOptionPane.showInputDialog(null,
                "Enter the name of a football team: ",
                "Content 07 | Exercise 04",
                JOptionPane.QUESTION_MESSAGE);

        // Processing: Convert the input to uppercase and match it against the grouped team names in
        // switch.
        teamName = teamName.toUpperCase();

        switch (teamName) {
            case "AMÉRICA", "CRUZEIRO", "ATLÉTICO", "VILLA NOVA" -> {
                
                country = "Minas Gerais";
                // Output: display the message for the current result.
                JOptionPane.showMessageDialog(null,
                        "Your team is " + teamName + " from the state of " + country,
                        "Content 07 | Exercise 04",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            case "BOTAFOGO", "FLAMENGO", "FLUMINENSE", "VASCO" -> {
                
                country = "Rio de Janeiro";
                JOptionPane.showMessageDialog(null,
                        "Your team is " + teamName + " from the state of " + country,
                        "Content 07 | Exercise 04",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            case "CORINTHIANS", "PALMEIRAS", "SANTOS", "SÃO PAULO" -> {
                
                country = "São Paulo";
                JOptionPane.showMessageDialog(null,
                        "Your team is " + teamName + " from the state of " + country,
                        "Content 07 | Exercise 04",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            case "GRÊMIO", "INTERNACIONAL", "JUVENTUDE" -> {
                
                country = "Rio Grande do Sul";
                JOptionPane.showMessageDialog(null,
                        "Your team is " + teamName + " from the state of " + country,
                        "Content 07 | Exercise 04",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            case "NÁUTICO", "SANTA CRUZ", "SPORT" -> {
                
                country = "Pernambuco";
                JOptionPane.showMessageDialog(null,
                        "Your team is " + teamName + " from the state of " + country,
                        "Content 07 | Exercise 04",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            
            default ->
                    JOptionPane.showMessageDialog(null,
                            "Unregistered team and/or incorrect spelling! (Remember the accents)",
                            "Content 07 | Exercise 04",
                            JOptionPane.ERROR_MESSAGE);
        }
    }
}
