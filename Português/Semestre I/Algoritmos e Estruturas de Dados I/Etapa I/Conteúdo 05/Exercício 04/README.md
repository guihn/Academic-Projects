<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2005/Exercise%2004">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2005">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 04 · Distância entre dois pontos

## Descrição

**Resumo do enunciado:** Ler as coordenadas de dois pontos no plano cartesiano e calcular a distância entre eles.

## Solução

Calcular a raiz quadrada da soma dos quadrados das diferenças entre as coordenadas correspondentes.

Arquivo fonte: [C05ex04.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2005/Exerc%C3%ADcio%2004/src/C05ex04.java)

<details>
<summary>💻 | Código Java</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Calcular a raiz quadrada da soma dos quadrados das diferenças entre as coordenadas
 * correspondentes.
 *
 * Atividade: C05ex04.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C05ex04 {

    static void main() {

        String x1Str, y1Str, x2Str, y2Str;

        double x1, y1, x2, y2, distance;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        x1Str = JOptionPane.showInputDialog(null,
                "Informe o X do ponto 1:",
                "Conteúdo 05 | Exercício 04",
                JOptionPane.QUESTION_MESSAGE);

        y1Str = JOptionPane.showInputDialog(null,
                "Informe o Y do ponto 1:",
                "Conteúdo 05 | Exercício 04",
                JOptionPane.QUESTION_MESSAGE);

        x2Str = JOptionPane.showInputDialog(null,
                "Informe o X do ponto 2:",
                "Conteúdo 05 | Exercício 04",
                JOptionPane.QUESTION_MESSAGE);

        y2Str = JOptionPane.showInputDialog(null,
                "Informe o Y do ponto 2:",
                "Conteúdo 05 | Exercício 04",
                JOptionPane.QUESTION_MESSAGE);

        x1 = Double.valueOf(x1Str);
        y1 = Double.valueOf(y1Str);
        x2 = Double.valueOf(x2Str);
        y2 = Double.valueOf(y2Str);

        // Processamento: Calcular a raiz quadrada da soma dos quadrados das diferenças entre as
        // coordenadas correspondentes.
        distance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));

        // Saída: apresentar a mensagem correspondente ao resultado atual.
        JOptionPane.showMessageDialog(null,
                "Distância: " + distance,
                "Conteúdo 05 | Exercício 04",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
```

</details>
