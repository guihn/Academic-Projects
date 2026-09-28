<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2005/Exercise%2009">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2005">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 09 · Média ponderada

## Descrição

**Resumo do enunciado:** Ler três notas e calcular a média com os respectivos pesos 2, 3 e 5.

**Fonte do enunciado:** [slides originais da aula](https://github.com/guihn/academic-materials/blob/5a9473bbf24a271032a41b141ab6bd435076c1d5/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2005/Algoritmos%20-%20Aulas%20-%20Conte%C3%BAdo%205%20-%20Comando%20de%20ATRIBUI%C3%87%C3%83O%2C%20Express%C3%B5es%20Aritm%C3%A9ticas.pptx), slide(s) 42. [Pasta do material](https://github.com/guihn/academic-materials/tree/main/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2005).

**Código fornecido:** [C05ex09.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/FirstStage/C05ex09.java).

## Solução

Multiplicar cada nota por seu peso, somar os produtos e dividir pela soma dos pesos.

[Arquivo fonte: C05ex09.java](https://github.com/guihn/Academic-Projects/blob/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2005/Exerc%C3%ADcio%2009/src/C05ex09.java) · [Baixar](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2005/Exerc%C3%ADcio%2009/src/C05ex09.java)

<details>
<summary>💻 | Código Java</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Multiplicar cada nota por seu peso, somar os produtos e dividir pela soma dos pesos.
 *
 * Atividade: C05ex09.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C05ex09 {

    static void main() {

        String note1Str, note2Str, note3Str;

        double note1, note2, note3, weightedAverage, weightedSum;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        note1Str = JOptionPane.showInputDialog(null,
                "Informe a 1ª nota:",
                "Conteúdo 05 | Exercício 09",
                JOptionPane.QUESTION_MESSAGE);

        note2Str = JOptionPane.showInputDialog(null,
                "Informe a 2ª nota:",
                "Conteúdo 05 | Exercício 09",
                JOptionPane.QUESTION_MESSAGE);

        note3Str = JOptionPane.showInputDialog(null,
                "Informe a 3ª nota:",
                "Conteúdo 05 | Exercício 09",
                JOptionPane.QUESTION_MESSAGE);

        note1 = Double.valueOf(note1Str);
        note2 = Double.valueOf(note2Str);
        note3 = Double.valueOf(note3Str);

        // Processamento: Multiplicar cada nota por seu peso, somar os produtos e dividir pela soma
        // dos pesos.
        weightedSum = (note1 * 2) + (note2 * 3) + (note3 * 5);

        weightedAverage = weightedSum / (2 + 3 + 5);

        // Saída: apresentar a mensagem correspondente ao resultado atual.
        JOptionPane.showMessageDialog(null,
                "Média: " + weightedAverage,
                "Conteúdo 05 | Exercício 09",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
```

</details>
