<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2007/Exercise%2004">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2007">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 04 · Equipes de futebol e estados

## Descrição

A atividade associa o nome de uma equipe de futebol ao seu estado brasileiro. Vários nomes podem levar à mesma resposta, formando grupos de casos em uma seleção múltipla. O programa deve consultar a correspondência definida na tabela do exercício e apresentar o estado da equipe digitada.

## Enunciado

Leia o nome de uma equipe presente na tabela e informe seu estado:

| Equipes | Estado |
| --- | --- |
| América, Atlético, Cruzeiro, Villa Nova | Minas Gerais |
| Botafogo, Flamengo, Fluminense, Vasco | Rio de Janeiro |
| Corinthians, Palmeiras, Santos, São Paulo | São Paulo |
| Grêmio, Internacional, Juventude | Rio Grande do Sul |
| Náutico, Santa Cruz, Sport | Pernambuco |

## Solução

Converter a entrada para maiúsculas e compará-la com os nomes de equipes agrupados no switch.

Arquivo fonte: [C07ex04.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2007/Exerc%C3%ADcio%2004/src/C07ex04.java)

<details>
<summary>💻 | Código Java</summary>

```java
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
```

</details>
