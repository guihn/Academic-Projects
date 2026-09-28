<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20II/Content%2008/Exercise%2005">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20II/Conte%C3%BAdo%2008">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 05 · Apuração de votos

## Descrição

**Resumo do enunciado:** Contar 100 votos para Fulano, Ciclano e Beltrano, com códigos 1, 2 e 3. O enunciado pressupõe ausência de votos nulos e empates.

**Fonte do enunciado:** [slides originais da aula](https://github.com/guihn/academic-materials/blob/5a9473bbf24a271032a41b141ab6bd435076c1d5/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20II/Contents/Content%2008/Algoritmos%20-%20Aulas%20-%20Conte%C3%BAdo%208%20-%20Comando%20de%20Repeti%C3%A7%C3%A3o%20%E2%80%93%20FOR.pptx), slide(s) 41. [Pasta do material](https://github.com/guihn/academic-materials/tree/main/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20II/Contents/Content%2008).

**Código fornecido:** [C08ex05.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/SecondStage/C08ex05.java).

## Solução

Contar cada código válido e comparar os totais. Decrementar o contador do laço para repetir uma entrada inválida.

[Arquivo fonte: C08ex05.java](https://github.com/guihn/Academic-Projects/blob/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20II/Conte%C3%BAdo%2008/Exerc%C3%ADcio%2005/src/C08ex05.java) · [Baixar](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20II/Conte%C3%BAdo%2008/Exerc%C3%ADcio%2005/src/C08ex05.java)

<details>
<summary>💻 | Código Java</summary>

```java
package SecondStage;

import javax.swing.JOptionPane;

/**
 * Contar cada código válido e comparar os totais. Decrementar o contador do laço para repetir
 * uma entrada inválida.
 *
 * Atividade: C08ex05.
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

        // Processamento: Contar cada código válido e comparar os totais. Decrementar o contador do
        // laço para repetir uma entrada inválida.
        for (int i = 1; i <= rep; i ++) {

            // Entrada: coletar os valores solicitados por caixas de diálogo.
            votesStr = JOptionPane.showInputDialog(null,
                    "Informe o numero do candidato: ",
                    "Conteúdo 08 | Exercício 05",
                    JOptionPane.QUESTION_MESSAGE);
            votes = Integer.parseInt(votesStr);

            switch (votes) {
                case 1 -> {
                    votes1C++;
                    // Saída: apresentar a mensagem correspondente ao resultado atual.
                    JOptionPane.showMessageDialog(null,
                            "Voto computado!",
                            "Conteúdo 08 | Exercício 05",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                case 2 -> {
                    votes2C++;
                    JOptionPane.showMessageDialog(null,
                            "Voto computado!",
                            "Conteúdo 08 | Exercício 05",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                case 3 -> {
                    votes3C++;
                    JOptionPane.showMessageDialog(null,
                            "Voto computado!",
                            "Conteúdo 08 | Exercício 05",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                default -> {
                    JOptionPane.showMessageDialog(null,
                            "Você digitou um número inválido! Tente: 1, 2 ou 3.",
                            "Conteúdo 08 | Exercício 05",
                            JOptionPane.ERROR_MESSAGE);
                    i--;
                }
            }
        }

        if (votes1C > votes2C && votes1C > votes3C) {
            JOptionPane.showMessageDialog(null,
                    "O candidato 'Fulano' venceu! O número de votos dele foi de: " + votes1C,
                    "Conteúdo 08 | Exercício 05",
                    JOptionPane.INFORMATION_MESSAGE);
        } else if (votes2C > votes1C && votes2C > votes3C) {
            JOptionPane.showMessageDialog(null,
                    "O candidato 'Ciclano' venceu! O número de votos dele foi de: " + votes2C,
                    "Conteúdo 08 | Exercício 05",
                    JOptionPane.INFORMATION_MESSAGE);
        } else if (votes3C > votes1C && votes3C > votes2C) {
            JOptionPane.showMessageDialog(null,
                    "O candidato 'Beltrano' venceu! O número de votos dele foi de: " + votes3C,
                    "Conteúdo 08 | Exercício 05",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Houve talvez um empate, porém esse programa não responderá a essa questão.",
                    "Conteúdo 08 | Exercício 05",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
```

</details>
