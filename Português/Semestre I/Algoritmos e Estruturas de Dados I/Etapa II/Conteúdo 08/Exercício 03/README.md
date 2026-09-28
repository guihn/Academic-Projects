<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20II/Content%2008/Exercise%2003">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20II/Conte%C3%BAdo%2008">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 03 · Totais de aprovados e reprovados

## Descrição

**Resumo do enunciado:** Avaliar 50 alunos por nota e frequência e informar os totais de aprovados e reprovados.

**Código fornecido:** [C08ex03.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/SecondStage/C08ex03.java).

## Solução

Manter contadores separados ao aplicar a condição nota ≥ 65 e faltas ≤ 16 a cada registro.

### Observações da implementação

O laço processa três alunos, correspondendo ao exemplo reduzido do slide, em vez da turma completa de 50.

[Arquivo fonte: C08ex03.java](https://github.com/guihn/Academic-Projects/blob/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20II/Conte%C3%BAdo%2008/Exerc%C3%ADcio%2003/src/C08ex03.java) · [Baixar](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20II/Conte%C3%BAdo%2008/Exerc%C3%ADcio%2003/src/C08ex03.java)

<details>
<summary>💻 | Código Java</summary>

```java
package SecondStage;

import javax.swing.JOptionPane;

/**
 * Manter contadores separados ao aplicar a condição nota ≥ 65 e faltas ≤ 16 a cada registro.
 *
 * Atividade: C08ex03.
 */
public class C08ex03 {
    static void main() {
        String finalNoteStr, abscensesStr;
        int  approved = 0, disapproved = 0;
        double finalNote, abscenses;

        // Processamento: Manter contadores separados ao aplicar a condição nota ≥ 65 e faltas ≤ 16
        // a cada registro.
        for (int i = 1; i <=3; i ++) {
            // Entrada: coletar os valores solicitados por caixas de diálogo.
            finalNoteStr = JOptionPane.showInputDialog(null,
                    "Informe a nota final do aluno: ",
                    "Conteúdo 08 | Exercício 03",
                    JOptionPane.QUESTION_MESSAGE);

            finalNote = Double.valueOf(finalNoteStr);

            if (finalNote <= -1) {
                // Saída: apresentar a mensagem correspondente ao resultado atual.
                JOptionPane.showMessageDialog(null,
                        "Programa encerrado devido a utilização de números negativos.",
                        "Conteúdo 08 | Exercício 03",
                        JOptionPane.ERROR_MESSAGE);
                break;
            } else {
                abscensesStr = JOptionPane.showInputDialog(null,
                        "Informe o número de faltas do aluno: ",
                        "Conteúdo 08 | Exercício 03",
                        JOptionPane.QUESTION_MESSAGE);

                abscenses = Double.valueOf(abscensesStr);

                if (abscenses <= -1) {
                    JOptionPane.showMessageDialog(null,
                            "Programa encerrado devido a utilização de números negativos.",
                            "Conteúdo 08 | Exercício 03",
                            JOptionPane.ERROR_MESSAGE);
                    break;
                } else {

                    if (finalNote >= 65 && abscenses <= 16) {
                        JOptionPane.showMessageDialog(null,
                                "Aluno aprovado!",
                                "Conteúdo 08 | Exercício 03",
                                JOptionPane.INFORMATION_MESSAGE);

                        approved++;

                        } else {
                        JOptionPane.showMessageDialog(null,
                                "Aluno reprovado!",
                                "Conteúdo 08 | Exercício 03",
                                JOptionPane.ERROR_MESSAGE);

                        disapproved++;
                    }
                }
            }
        }

        JOptionPane.showMessageDialog(null,
                "Aprovados: " + approved + "\nReprovados: " + disapproved,
                "Conteúdo 08 | Exercício 03",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
```

</details>
