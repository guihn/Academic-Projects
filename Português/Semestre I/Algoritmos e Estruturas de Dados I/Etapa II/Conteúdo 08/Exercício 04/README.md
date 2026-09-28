<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20II/Content%2008/Exercise%2004">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20II/Conte%C3%BAdo%2008">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 04 · Alunos por faixa etária

## Descrição

**Resumo do enunciado:** Ler nomes e idades de 50 alunos e contar os que têm até 18 anos e os que têm mais de 18.

**Fonte do enunciado:** [slides originais da aula](https://github.com/guihn/academic-materials/blob/5a9473bbf24a271032a41b141ab6bd435076c1d5/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20II/Contents/Content%2008/Algoritmos%20-%20Aulas%20-%20Conte%C3%BAdo%208%20-%20Comando%20de%20Repeti%C3%A7%C3%A3o%20%E2%80%93%20FOR.pptx), slide(s) 40. [Pasta do material](https://github.com/guihn/academic-materials/tree/main/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20II/Contents/Content%2008).

**Código fornecido:** [C08ex04.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/SecondStage/C08ex04.java).

## Solução

Incrementar um de dois contadores conforme cada idade informada.

### Observações da implementação

O laço original processa cinco alunos, como no exemplo reduzido do slide.

[Arquivo fonte: C08ex04.java](https://github.com/guihn/Academic-Projects/blob/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20II/Conte%C3%BAdo%2008/Exerc%C3%ADcio%2004/src/C08ex04.java) · [Baixar](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20II/Conte%C3%BAdo%2008/Exerc%C3%ADcio%2004/src/C08ex04.java)

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
