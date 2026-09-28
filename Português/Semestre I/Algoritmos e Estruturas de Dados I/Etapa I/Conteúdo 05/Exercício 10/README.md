<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2005/Exercise%2010">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2005">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 10 · Dígitos na vertical

## Descrição

**Resumo do enunciado:** Ler um inteiro de cinco dígitos e apresentar um dígito por linha.

**Código fornecido:** [C05ex10.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/FirstStage/C05ex10.java).

## Solução

Usar divisão inteira e restos para extrair os dígitos da maior ordem até as unidades.

[Arquivo fonte: C05ex10.java](https://github.com/guihn/Academic-Projects/blob/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2005/Exerc%C3%ADcio%2010/src/C05ex10.java) · [Baixar](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2005/Exerc%C3%ADcio%2010/src/C05ex10.java)

<details>
<summary>💻 | Código Java</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Usar divisão inteira e restos para extrair os dígitos da maior ordem até as unidades.
 *
 * Atividade: C05ex10.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C05ex10 {

    static void main() {

        String numberStr;

        int number, d1, d2, d3, d4, d5;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        numberStr = JOptionPane.showInputDialog(null,
                "Informe um número em sequência (5 dígitos):",
                "Conteúdo 05 | Exercício 10",
                JOptionPane.QUESTION_MESSAGE);

        number = Integer.valueOf(numberStr);

        // Processamento: Usar divisão inteira e restos para extrair os dígitos da maior ordem até
        // as unidades.
        d1 = number / 10000;

        d2 = number / 1000 % 10;

        d3 = number / 100 % 10;

        d4 = number / 10 % 10;

        d5 = number % 10;

        // Saída: apresentar a mensagem correspondente ao resultado atual.
        JOptionPane.showMessageDialog(null,
                "Número impresso:\n" + d1 + "\n" + d2 + "\n" + d3 + "\n" + d4 + "\n" + d5,
                "Conteúdo 05 | Exercício 10",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
```

</details>
