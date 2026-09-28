<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006/Exercise%2008">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 08 · Intervalo de peso pelo IMC

## Descrição

A atividade usa a altura para encontrar os dois extremos de um intervalo de peso definido por uma tabela didática. Em vez de calcular o IMC de um peso conhecido, o programa isola o peso na fórmula e usa os índices 20 e 25. A saída identifica a pessoa e apresenta os limites mínimo e máximo em quilogramas.

## Enunciado

Leia o nome e a altura em metros. Calcule e imprima os pesos mínimo e máximo da faixa entre IMC 20 e 25 adotada pelo exercício, usando IMC = peso / altura². Na tabela da atividade, valores abaixo de 20 ficam abaixo da faixa e valores acima de 25 ficam acima dela.

## Solução

Multiplicar o quadrado da altura por 20 e 25 para obter os dois limites.

Arquivo fonte: [C06ex08.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2008/src/C06ex08.java)

<details>
<summary>💻 | Código Java</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Multiplicar o quadrado da altura por 20 e 25 para obter os dois limites.
 *
 * Atividade: C06ex08.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex08 {

    static void main() {

        String name, heightStr;

        double height, weight, weightMin, weightMax;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        name = JOptionPane.showInputDialog(null,
                "Informe seu nome:",
                "Conteúdo 06 | Exercício 08",
                JOptionPane.QUESTION_MESSAGE);

        heightStr = JOptionPane.showInputDialog(null,
                "Informe sua altura:",
                "Conteúdo 06 | Exercício 08",
                JOptionPane.QUESTION_MESSAGE);

        height = Double.valueOf(heightStr);

        // Processamento: Multiplicar o quadrado da altura por 20 e 25 para obter os dois limites.
        weightMin = 20 * Math.pow(height, 2);

        weightMax = 25 * Math.pow(height, 2);

        // Saída: apresentar a mensagem correspondente ao resultado atual.
        JOptionPane.showMessageDialog(null,
                "Peso mínimo: " + weightMin + "\nPeso máximo: " + weightMax,
                "Conteúdo 06 | Exercício 08",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
```

</details>
