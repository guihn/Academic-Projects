<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2005/Exercise%2008">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2005">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 08 · Raio de um setor circular

## Descrição

O programa encontra o raio de um círculo a partir da área de um setor e de seu ângulo central. A área S e o ângulo α, em graus, são as duas entradas. Para obter o raio, a relação de área do setor é reorganizada e o resultado passa por uma raiz quadrada.

## Enunciado

Solicite a área S e o ângulo α de um setor circular. Calcule e imprima seu raio R usando π = 3,1416 e a relação:

$$S = \frac{\alpha\pi R^2}{360}$$

## Solução

Calcular a raiz quadrada de 360S dividido por απ, com o ângulo em graus.

Arquivo fonte: [C05ex08.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2005/Exerc%C3%ADcio%2008/src/C05ex08.java)

<details>
<summary>💻 | Código Java</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Calcular a raiz quadrada de 360S dividido por απ, com o ângulo em graus.
 *
 * Atividade: C05ex08.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C05ex08 {

    static void main() {

        String sStr, aStr;

        double s, a, pi, r;

        pi = 3.1416;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        sStr = JOptionPane.showInputDialog(null,
                "Informe o valor da área de um setor circular:",
                "Conteúdo 05 | Exercício 08",
                JOptionPane.QUESTION_MESSAGE);

        aStr = JOptionPane.showInputDialog(null,
                "Informe o valor do ângulo:",
                "Conteúdo 05 | Exercício 08",
                JOptionPane.QUESTION_MESSAGE);

        s = Double.valueOf(sStr);
        a = Double.valueOf(aStr);

        // Processamento: Calcular a raiz quadrada de 360S dividido por απ, com o ângulo em graus.
        r = Math.sqrt((360 * s) / (a * pi));

        // Saída: apresentar a mensagem correspondente ao resultado atual.
        JOptionPane.showMessageDialog(null,
                "S: " + s + " A: " + a + " R: " + r,
                "Conteúdo 05 | Exercício 08",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
```

</details>
