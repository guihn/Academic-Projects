<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006/Exercise%2001">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 01 · Função definida por partes

## Descrição

**Resumo do enunciado:** Ler x e escolher a expressão de f(x) conforme sua posição em relação a 4.

**Código fornecido:** [C06ex01.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/FirstStage/C06ex01.java).

## Solução

Calcular as duas expressões e selecionar a primeira para x < 4, zero para x = 4 ou a segunda para x > 4.

### Observações da implementação

As duas expressões são avaliadas antes da condição. Algumas entradas produzem argumento negativo na raiz quadrada ou denominador zero.

[Arquivo fonte: C06ex01.java](https://github.com/guihn/Academic-Projects/blob/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2001/src/C06ex01.java) · [Baixar](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2001/src/C06ex01.java)

<details>
<summary>💻 | Código Java</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Calcular as duas expressões e selecionar a primeira para x &lt; 4, zero para x = 4 ou a
 * segunda para x &gt; 4.
 *
 * Atividade: C06ex01.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex01 {

    static void main() {

        String xStr;

        double x, fx, c1, c2;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        xStr = JOptionPane.showInputDialog(null,
                "Informe o valor de X:",
                "Conteúdo 06 | Exercício 01",
                JOptionPane.QUESTION_MESSAGE);

        x = Double.valueOf(xStr);

        // Processamento: Calcular as duas expressões e selecionar a primeira para x < 4, zero para
        // x = 4 ou a segunda para x > 4.
        c1 = (5 * x + 3) / Math.sqrt(16 - Math.pow(x, 2));

        c2 = (5 * x + 3) / Math.sqrt(Math.pow(x, 2) - 16);

        if (x < 4)
            fx = c1;
            
        else if (x == 4)
            fx = 0;
            
        else
            fx = c2;

        // Saída: apresentar a mensagem correspondente ao resultado atual.
        JOptionPane.showMessageDialog(null,
                "f(x): " + fx,
                "Conteúdo 06 | Exercício 01",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
```

</details>
