package FirstStage;

import javax.swing.JOptionPane;

/**
 * Converter a entrada para maiúsculas e compará-la com os nomes de equipes agrupados no switch.
 *
 * Atividade: C07ex04.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C07ex04 {

    static void main() {

        String teamName, country;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        teamName = JOptionPane.showInputDialog(null,
                "Informe o nome de uma equipe de futebol: ",
                "Conteúdo 07 | Exercício 04",
                JOptionPane.QUESTION_MESSAGE);

        // Processamento: Converter a entrada para maiúsculas e compará-la com os nomes de equipes
        // agrupados no switch.
        teamName = teamName.toUpperCase();

        switch (teamName) {
            case "AMÉRICA", "CRUZEIRO", "ATLÉTICO", "VILLA NOVA" -> {
                
                country = "Minas Gerais";
                // Saída: apresentar a mensagem correspondente ao resultado atual.
                JOptionPane.showMessageDialog(null,
                        "Seu time é o " + teamName + " do estado de " + country,
                        "Conteúdo 07 | Exercício 04",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            case "BOTAFOGO", "FLAMENGO", "FLUMINENSE", "VASCO" -> {
                
                country = "Rio de Janeiro";
                JOptionPane.showMessageDialog(null,
                        "Seu time é o " + teamName + " do estado do " + country,
                        "Conteúdo 07 | Exercício 04",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            case "CORINTHIANS", "PALMEIRAS", "SANTOS", "SÃO PAULO" -> {
                
                country = "São Paulo";
                JOptionPane.showMessageDialog(null,
                        "Seu time é o " + teamName + " do estado de " + country,
                        "Conteúdo 07 | Exercício 04",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            case "GRÊMIO", "INTERNACIONAL", "JUVENTUDE" -> {
                
                country = "Rio Grande do Sul";
                JOptionPane.showMessageDialog(null,
                        "Seu time é o " + teamName + " do estado do " + country,
                        "Conteúdo 07 | Exercício 04",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            case "NÁUTICO", "SANTA CRUZ", "SPORT" -> {
                
                country = "Pernambuco";
                JOptionPane.showMessageDialog(null,
                        "Seu time é o " + teamName + " do estado de " + country,
                        "Conteúdo 07 | Exercício 04",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            
            default ->
                    JOptionPane.showMessageDialog(null,
                            "Time não registrado e/ou digitação incorreta! (Não se esqueça dos acentos)",
                            "Conteúdo 07 | Exercício 04",
                            JOptionPane.ERROR_MESSAGE);
        }
    }
}
