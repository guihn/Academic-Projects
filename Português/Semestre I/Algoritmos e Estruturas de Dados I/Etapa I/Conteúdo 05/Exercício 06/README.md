<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2005/Exercise%2006">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2005">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 06 · Distância de um ponto a uma reta

## Descrição

**Resumo do enunciado:** Ler os coeficientes A, B e C de uma reta e as coordenadas de um ponto para calcular a distância entre eles.

**Fonte do enunciado:** [slides originais da aula](https://github.com/guihn/academic-materials/blob/5a9473bbf24a271032a41b141ab6bd435076c1d5/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2005/Algoritmos%20-%20Aulas%20-%20Conte%C3%BAdo%205%20-%20Comando%20de%20ATRIBUI%C3%87%C3%83O%2C%20Express%C3%B5es%20Aritm%C3%A9ticas.pptx), slide(s) 39. [Pasta do material](https://github.com/guihn/academic-materials/tree/main/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2005).

**Código fornecido:** [C05ex06.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/FirstStage/C05ex06.java).

## Solução

Dividir |Ax + By + C| pela raiz quadrada de A² + B².

### Observações da implementação

Não há verificação que impeça A e B de serem simultaneamente zero.

[Arquivo fonte: C05ex06.java](https://github.com/guihn/Academic-Projects/blob/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2005/Exerc%C3%ADcio%2006/src/C05ex06.java) · [Baixar](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2005/Exerc%C3%ADcio%2006/src/C05ex06.java)

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
