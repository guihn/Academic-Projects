<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2005/Exercise%2006">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2005">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 06 · Distância de um ponto a uma reta

## Descrição

O programa calcula a menor distância entre um ponto e uma reta do plano. A reta é informada por seus coeficientes A, B e C, enquanto o ponto é definido por x e y. O cálculo combina o valor absoluto da expressão da reta no ponto com a norma dos coeficientes A e B.

## Enunciado

Solicite A, B e C da reta $Ax+By+C=0$ e as coordenadas x e y do ponto. Calcule e imprima:

$$d = \frac{\lvert Ax+By+C\rvert}{\sqrt{A^2+B^2}}$$

## Solução

Dividir |Ax + By + C| pela raiz quadrada de A² + B².

### Observações da implementação

Não há verificação que impeça A e B de serem simultaneamente zero.

Arquivo fonte: [C05ex06.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2005/Exerc%C3%ADcio%2006/src/C05ex06.java)

<details>
<summary>💻 | Código Java</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Dividir |Ax + By + C| pela raiz quadrada de A² + B².
 *
 * Atividade: C05ex06.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C05ex06 {

    static void main() {

        String aRStr, bRStr, cRStr, xPStr, yPStr;

        double distance, c1, c2, aR, bR, cR, xP, yP;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        aRStr = JOptionPane.showInputDialog(null,
                "Informe o valor A da reta R:",
                "Conteúdo 05 | Exercício 06",
                JOptionPane.QUESTION_MESSAGE);

        bRStr = JOptionPane.showInputDialog(null,
                "Informe o valor B da reta R:",
                "Conteúdo 05 | Exercício 06",
                JOptionPane.QUESTION_MESSAGE);

        cRStr = JOptionPane.showInputDialog(null,
                "Informe o valor C da reta R:",
                "Conteúdo 05 | Exercício 06",
                JOptionPane.QUESTION_MESSAGE);

        xPStr = JOptionPane.showInputDialog(null,
                "Informe o valor da coordenada X do ponto P:",
                "Conteúdo 05 | Exercício 06",
                JOptionPane.QUESTION_MESSAGE);

        yPStr = JOptionPane.showInputDialog(null,
                "Informe o valor da coordenada Y do ponto P:",
                "Conteúdo 05 | Exercício 06",
                JOptionPane.QUESTION_MESSAGE);

        aR = Double.valueOf(aRStr);
        bR = Double.valueOf(bRStr);
        cR = Double.valueOf(cRStr);
        xP = Double.valueOf(xPStr);
        yP = Double.valueOf(yPStr);

        // Processamento: Dividir |Ax + By + C| pela raiz quadrada de A² + B².
        c1 = aR * xP + bR * yP + cR;

        c2 = Math.sqrt(Math.pow(aR, 2) + Math.pow(bR, 2));

        distance = Math.abs(c1) / c2;

        // Saída: apresentar a mensagem correspondente ao resultado atual.
        JOptionPane.showMessageDialog(null,
                "Distância: " + distance,
                "Conteúdo 05 | Exercício 06",
                JOptionPane.INFORMATION_MESSAGE);

    }
}
```

</details>
