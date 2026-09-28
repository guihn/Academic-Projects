<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2007/Exerc%C3%ADcio%2004">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2007">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 04 · Football teams and states

## Description

**Statement summary:** Read a football team from the supplied table and identify its Brazilian state.

## Solution

Convert the input to uppercase and match it against the grouped team names in switch.

Source file: [C07ex04.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2007/Exercise%2004/src/C07ex04.java)

<details>
<summary>💻 | Java code</summary>

```java
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
```

</details>
