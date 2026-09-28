<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20II/Content%2008/Exercise%2002">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20II/Conte%C3%BAdo%2008">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 02 · Aprovação ou reprovação de alunos

## Descrição

**Resumo do enunciado:** Ler nota final e faltas de até 50 alunos. A aprovação exige nota de pelo menos 65 e no máximo 16 faltas. Encerrar quando a nota for −1.

## Solução

Ler cada registro em um laço, interromper nos limites negativos implementados e testar nota e frequência em conjunto.

### Observações da implementação

O código original encerra quando a nota ou as faltas são menores ou iguais a −1. O enunciado especifica −1 no campo de nota.

Arquivo fonte: [C08ex02.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20II/Conte%C3%BAdo%2008/Exerc%C3%ADcio%2002/src/C08ex02.java)

<details>
<summary>💻 | Código Java</summary>

```java
package SecondStage;

import javax.swing.JOptionPane;

/**
 * Ler cada registro em um laço, interromper nos limites negativos implementados e testar nota e
 * frequência em conjunto.
 *
 * Atividade: C08ex02.
 */
public class C08ex02 {
    static void main() {
        String finalNoteStr, abscensesStr;
        double finalNote, abscenses;

        // Processamento: Ler cada registro em um laço, interromper nos limites negativos
        // implementados e testar nota e frequência em conjunto.
        for (int i = 1; i <=50; i ++) {
        // Entrada: coletar os valores solicitados por caixas de diálogo.
        finalNoteStr = JOptionPane.showInputDialog(null,
                "Informe a nota final do aluno: ",
                "Conteúdo 08 | Exercício 02",
                JOptionPane.QUESTION_MESSAGE);

            finalNote = Double.valueOf(finalNoteStr);

            if (finalNote <= -1) {
                // Saída: apresentar a mensagem correspondente ao resultado atual.
                JOptionPane.showMessageDialog(null,
                        "Programa encerrado devido a utilização de números negativos.",
                        "Conteúdo 08 | Exercício 02",
                        JOptionPane.ERROR_MESSAGE);
                break;
            } else {
                abscensesStr = JOptionPane.showInputDialog(null,
                        "Informe o número de faltas do aluno: ",
                        "Conteúdo 08 | Exercício 02",
                        JOptionPane.QUESTION_MESSAGE);

                abscenses = Double.valueOf(abscensesStr);

                if (abscenses <= -1) {
                    JOptionPane.showMessageDialog(null,
                            "Programa encerrado devido a utilização de números negativos.",
                            "Conteúdo 08 | Exercício 02",
                            JOptionPane.ERROR_MESSAGE);
                    break;
                } else {

                    if (finalNote >= 65 && abscenses <= 16) {
                        JOptionPane.showMessageDialog(null,
                                "Aluno aprovado!",
                                "Conteúdo 08 | Exercício 02",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else
                        JOptionPane.showMessageDialog(null,
                                "Aluno reprovado!",
                                "Conteúdo 08 | Exercício 02",
                                JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
```

</details>
