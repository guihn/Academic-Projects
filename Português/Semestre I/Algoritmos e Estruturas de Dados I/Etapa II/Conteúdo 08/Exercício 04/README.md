<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20II/Content%2008/Exercise%2004">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20II/Conte%C3%BAdo%2008">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 04 · Alunos por faixa etária

## Descrição

A atividade divide os alunos de uma turma em duas faixas de idade. Nome e idade são lidos para cada pessoa, e a idade determina qual contador deve ser incrementado. A fronteira de 18 anos pertence à primeira faixa, de modo que cada aluno seja contado uma única vez.

## Enunciado

Leia nome e idade de todos os 50 alunos de uma turma. Calcule e imprima a quantidade de alunos com até 18 anos e a quantidade com mais de 18 anos.

## Solução

Incrementar um de dois contadores conforme cada idade informada.

### Observações da implementação

O laço original processa cinco alunos, como no exemplo reduzido do slide.

Arquivo fonte: [C08ex04.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20II/Conte%C3%BAdo%2008/Exerc%C3%ADcio%2004/src/C08ex04.java)

<details>
<summary>💻 | Código Java</summary>

```java
package SecondStage;

import javax.swing.JOptionPane;

/**
 * Incrementar um de dois contadores conforme cada idade informada.
 *
 * Atividade: C08ex04.
 */
public class C08ex04 {
    static void main() {
        String name, ageStr;
        int age, lowerthan18 = 0, higherthan18 = 0;

        // Processamento: Incrementar um de dois contadores conforme cada idade informada.
        for (int students = 1; students <= 5; students ++) {
            // Entrada: coletar os valores solicitados por caixas de diálogo.
            name = JOptionPane.showInputDialog(null,
                    "Informe seu nome: ",
                    "Conteúdo 08 | Exercício 04",
                    JOptionPane.QUESTION_MESSAGE);
            ageStr = JOptionPane.showInputDialog(null,
                    "Informe sua idade: ",
                    "Conteúdo 08 | Exercício 04",
                    JOptionPane.QUESTION_MESSAGE);

            age = Integer.valueOf(ageStr);

            if (age <= 18) {
                lowerthan18++;
            }
            else {
                higherthan18++;
            }
        }
        // Saída: apresentar a mensagem correspondente ao resultado atual.
        JOptionPane.showMessageDialog(null,
                "Até 18: " + lowerthan18 + "\nAcima de 18: " + higherthan18,
                "Conteúdo 08 | Exercício 04",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
```

</details>
