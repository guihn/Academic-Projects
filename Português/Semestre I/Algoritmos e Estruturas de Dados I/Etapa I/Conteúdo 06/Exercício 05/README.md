<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006/Exercise%2005">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 05 · Divisibilidade por 5 e 7

## Descrição

**Resumo do enunciado:** Determinar se um inteiro é divisível simultaneamente por 5 e 7 usando restos.

**Código fornecido:** [C06ex05.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/FirstStage/C06ex05.java).

## Solução

Comparar cada resto com zero e distinguir divisibilidade pelos dois valores, por apenas um ou por nenhum.

[Arquivo fonte: C06ex05.java](https://github.com/guihn/Academic-Projects/blob/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2005/src/C06ex05.java) · [Baixar](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2005/src/C06ex05.java)

<details>
<summary>💻 | Código Java</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Comparar cada resto com zero e distinguir divisibilidade pelos dois valores, por apenas um ou
 * por nenhum.
 *
 * Atividade: C06ex05.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex05 {

    static void main() {

        String numberStr;

        int number;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        numberStr = JOptionPane.showInputDialog(null,
                "Informe um número:",
                "Conteúdo 06 | Exercício 05",
                JOptionPane.QUESTION_MESSAGE);

        number = Integer.valueOf(numberStr);

        // Processamento: Comparar cada resto com zero e distinguir divisibilidade pelos dois
        // valores, por apenas um ou por nenhum.
        if (number % 5 == 0 && number % 7 == 0)
            // Saída: apresentar a mensagem correspondente ao resultado atual.
            JOptionPane.showMessageDialog(null,
                    "Este número é divisível por 5 e por 7.",
                    "Conteúdo 06 | Exercício 05",
                    JOptionPane.INFORMATION_MESSAGE);
            
        else if (number % 5 == 0 && number % 7 != 0)
            JOptionPane.showMessageDialog(null,
                    "Este número é divisível por 5 apenas.",
                    "Conteúdo 06 | Exercício 05",
                    JOptionPane.INFORMATION_MESSAGE);
            
        else if (number % 5 != 0 && number % 7 == 0)
            JOptionPane.showMessageDialog(null,
                    "Este número é divisível por 7 apenas.",
                    "Conteúdo 06 | Exercício 05",
                    JOptionPane.INFORMATION_MESSAGE);
            
        else if (number % 5 != 0 && number % 7 != 0)
            JOptionPane.showMessageDialog(null,
                    "Este número não é divisível por 5 nem por 7.",
                    "Conteúdo 06 | Exercício 05",
                    JOptionPane.INFORMATION_MESSAGE);
    }
}
```

</details>
