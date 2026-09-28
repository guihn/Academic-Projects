<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20II/Content%2008/Exercise%2008">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20II/Conte%C3%BAdo%2008">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 08 · Estatísticas de notas e frequência

## Descrição

**Resumo do enunciado:** Avaliar 50 alunos e informar a média das notas dos aprovados e a quantidade com mais de 16 faltas.

**Código fornecido:** [C08ex08.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/SecondStage/C08ex08.java).

## Solução

Classificar cada registro, atualizar as variáveis de nota e frequência fornecidas e dividir o valor de nota armazenado pela quantidade de aprovados.

### Observações da implementação

O original usa três registros. A atribuição allNotesApproved =+ finalNote substitui o valor anterior em vez de acumulá-lo. A divisão final é inteira e falha quando ninguém é aprovado.

[Arquivo fonte: C08ex08.java](https://github.com/guihn/Academic-Projects/blob/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20II/Conte%C3%BAdo%2008/Exerc%C3%ADcio%2008/src/C08ex08.java) · [Baixar](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20II/Conte%C3%BAdo%2008/Exerc%C3%ADcio%2008/src/C08ex08.java)

<details>
<summary>💻 | Código Java</summary>

```java
package SecondStage;

import javax.swing.JOptionPane;

/**
 * Classificar cada registro, atualizar as variáveis de nota e frequência fornecidas e dividir o
 * valor de nota armazenado pela quantidade de aprovados.
 *
 * Atividade: C08ex08.
 */
public class C08ex08 {
    static void main() {
        String finalNoteStr, absensesStr;
        int rep, finalNote, absenses, approved, allNotesApproved, mediaOfAllNotesApproved, over16Absenses;

        rep = 3;
        approved = 0;
        allNotesApproved = 0;
        over16Absenses = 0;

        int i;
        // Processamento: Classificar cada registro, atualizar as variáveis de nota e frequência
        // fornecidas e dividir o valor de nota armazenado pela quantidade de aprovados.
        for (i = 1; i <= rep; i++) {
            // Entrada: coletar os valores solicitados por caixas de diálogo.
            finalNoteStr = JOptionPane.showInputDialog(null,
                    "Informe o número da nota final do " + i + "° aluno: ",
                    "Conteúdo 08 | Exercício 08",
                    JOptionPane.QUESTION_MESSAGE);
            absensesStr = JOptionPane.showInputDialog(null,
                    "Informe o número de faltas do " + i + "° aluno: ",
                    "Conteúdo 08 | Exercício 08",
                    JOptionPane.QUESTION_MESSAGE);

            finalNote = Integer.parseInt(finalNoteStr);
            absenses = Integer.parseInt(absensesStr);

            if (finalNote >= 65 && absenses <= 16) {
                approved++;
                // Saída: apresentar a mensagem correspondente ao resultado atual.
                JOptionPane.showMessageDialog(null,
                        "Você foi APROVADO!",
                        "Conteúdo 08 | Exercício 08",
                        JOptionPane.INFORMATION_MESSAGE);
                // O =+ original aplica o mais unário e atribui o valor; não acumula como +=.
                allNotesApproved =+ finalNote;
            }
            else if (absenses > 16) {
                over16Absenses++;
                JOptionPane.showMessageDialog(null,
                        "Você foi REPROVADO!",
                        "Conteúdo 08 | Exercício 08",
                        JOptionPane.ERROR_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog(null,
                        "Você foi REPROVADO!",
                        "Conteúdo 08 | Exercício 08",
                        JOptionPane.ERROR_MESSAGE);
        }

        // Esta divisão inteira não verifica se a quantidade de aprovados é zero.
        mediaOfAllNotesApproved = allNotesApproved / approved;
        JOptionPane.showMessageDialog(null,
                "Média das notas dos aprovados: " + mediaOfAllNotesApproved + "\nQuantidade de alunos com mais de 16 faltas: " + over16Absenses);
    }
}
```

</details>
