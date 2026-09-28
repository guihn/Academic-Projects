<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2005/Exercise%2001">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2005">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 01 · Função polinomial

## Descrição

**Resumo do enunciado:** Ler x e avaliar a função polinomial especificada no slide.

**Código fornecido:** [C05ex01.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/FirstStage/C05ex01.java).

## Solução

Calcular x³ + 4x + 10 usando Math.pow no termo cúbico.

[Arquivo fonte: C05ex01.java](https://github.com/guihn/Academic-Projects/blob/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2005/Exerc%C3%ADcio%2001/src/C05ex01.java) · [Baixar](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2005/Exerc%C3%ADcio%2001/src/C05ex01.java)

<details>
<summary>💻 | Código Java</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Calcular x³ + 4x + 10 usando Math.pow no termo cúbico.
 *
 * Atividade: C05ex01.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C05ex01 {

    static void main() {

        String xStr;

        int x;

        double fx;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        xStr = JOptionPane.showInputDialog(null,
                "Informe o valor de X:",
                "Conteúdo 05 | Exercício 01",
                JOptionPane.QUESTION_MESSAGE);

        x = Integer.valueOf(xStr);

        // Processamento: Calcular x³ + 4x + 10 usando Math.pow no termo cúbico.
        fx = 1 * Math.pow(x, 3) + 4 * x + 10;

        // Saída: apresentar a mensagem correspondente ao resultado atual.
        JOptionPane.showMessageDialog(null,
                "X = " + xStr + " -> f(x) = " + fx,
                "Conteúdo 05 | Exercício 01",
                JOptionPane.INFORMATION_MESSAGE);

    }
}
```

</details>
