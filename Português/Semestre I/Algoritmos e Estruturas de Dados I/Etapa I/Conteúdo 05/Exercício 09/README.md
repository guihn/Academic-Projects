<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2005/Exercise%2009">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2005">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 09 · Média ponderada

## Descrição

A atividade calcula uma nota final em que as três avaliações têm importâncias diferentes. As notas devem ser lidas na ordem dos pesos 2, 3 e 5, para que cada valor contribua corretamente para o resultado. A soma ponderada é dividida por 10, a soma dos pesos, e a média final é apresentada ao usuário.

## Enunciado

Leia as três notas de um aluno e calcule e imprima sua média ponderada. Use os pesos 2, 3 e 5, respectivamente:

$$M = \frac{2N_1+3N_2+5N_3}{10}$$

## Solução

Multiplicar cada nota por seu peso, somar os produtos e dividir pela soma dos pesos.

Arquivo fonte: [C05ex09.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2005/Exerc%C3%ADcio%2009/src/C05ex09.java)

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
