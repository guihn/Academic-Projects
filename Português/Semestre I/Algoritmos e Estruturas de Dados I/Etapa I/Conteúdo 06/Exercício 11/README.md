<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006/Exercise%2011">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 11 · Pontos de uma partida de vôlei

## Descrição

**Resumo do enunciado:** Ler os nomes das equipes e o placar de sets e distribuir os pontos conforme a tabela do enunciado.

**Fonte do enunciado:** [slides originais da aula](https://github.com/guihn/academic-materials/blob/5a9473bbf24a271032a41b141ab6bd435076c1d5/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2006/Algoritmos%20-%20Aulas%20-%20Conte%C3%BAdo%206%20-%20Comando%20Condicional%20%E2%80%93%20IF%2C%20Express%C3%B5es%20Booleanas.pptx), slide(s) 53. [Pasta do material](https://github.com/guihn/academic-materials/tree/main/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2006).

**Código fornecido:** [C06ex11.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/FirstStage/C06ex11.java).

## Solução

Atribuir 3–0 pontos para placares de sets 3–0 ou 3–1 e 2–1 pontos para placar 3–2, incluindo os casos simétricos.

### Observações da implementação

Placares não reconhecidos atribuem 69 pontos a cada equipe na implementação fornecida.

[Arquivo fonte: C06ex11.java](https://github.com/guihn/Academic-Projects/blob/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2011/src/C06ex11.java) · [Baixar](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2011/src/C06ex11.java)

<details>
<summary>💻 | Código Java</summary>

```java
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
```

</details>
