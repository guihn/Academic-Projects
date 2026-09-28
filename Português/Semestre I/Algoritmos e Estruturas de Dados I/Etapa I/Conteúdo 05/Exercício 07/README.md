<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2005/Exercise%2007">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2005">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 07 · Função com raízes

## Descrição

**Resumo do enunciado:** Ler x e avaliar a função apresentada no slide.

## Solução

Calcular a raiz quadrada de (x/4 + 1)² mais a raiz quinta real de x, preservando o sinal da raiz quinta.

Arquivo fonte: [C05ex07.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2005/Exerc%C3%ADcio%2007/src/C05ex07.java)

<details>
<summary>💻 | Código Java</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Calcular a raiz quadrada de (x/4 + 1)² mais a raiz quinta real de x, preservando o sinal da
 * raiz quinta.
 *
 * Atividade: C05ex07.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C05ex07 {

    static void main() {

        String xStr;

        double x, fx, c1, c2;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        xStr = JOptionPane.showInputDialog(null,
                "Digite o valor de X:",
                "Conteúdo 05 | Exercício 07",
                JOptionPane.QUESTION_MESSAGE);

        x = Double.valueOf(xStr);

        // Processamento: Calcular a raiz quadrada de (x/4 + 1)² mais a raiz quinta real de x,
        // preservando o sinal da raiz quinta.
        c1 = Math.pow((x / 4 + 1), 2);

        // Manter real a raiz quinta de x negativo restaurando seu sinal.
        c2 = Math.copySign(Math.pow(Math.abs(x), 1.0 / 5), x);

        fx = Math.sqrt(c1 + c2);

        // Saída: apresentar a mensagem correspondente ao resultado atual.
        JOptionPane.showMessageDialog(null,
                "X: " + x + "\nf(x): " + fx,
                "Conteúdo 05 | Exercício 07",
                JOptionPane.INFORMATION_MESSAGE);

    }
}
```

</details>
