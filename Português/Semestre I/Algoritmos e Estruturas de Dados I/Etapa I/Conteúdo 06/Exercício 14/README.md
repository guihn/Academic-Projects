<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006/Exercise%2014">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 14 · Inversão de quatro dígitos

## Descrição

**Resumo do enunciado:** Validar se um inteiro tem quatro dígitos e apresentar esses dígitos na ordem inversa.

**Fonte do enunciado:** [slides originais da aula](https://github.com/guihn/academic-materials/blob/5a9473bbf24a271032a41b141ab6bd435076c1d5/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2006/Algoritmos%20-%20Aulas%20-%20Conte%C3%BAdo%206%20-%20Comando%20Condicional%20%E2%80%93%20IF%2C%20Express%C3%B5es%20Booleanas.pptx), slide(s) 56. [Pasta do material](https://github.com/guihn/academic-materials/tree/main/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2006).

**Código fornecido:** [C06ex14.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/FirstStage/C06ex14.java).

## Solução

Rejeitar valores fora de 1000–9999, extrair os dígitos e concatená-los das unidades aos milhares.

### Observações da implementação

A mensagem original de entrada pede cinco dígitos e alguns títulos indicam Conteúdo 05, embora a validação e a atividade correspondam a quatro dígitos e ao Conteúdo 06.

[Arquivo fonte: C06ex14.java](https://github.com/guihn/Academic-Projects/blob/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2014/src/C06ex14.java) · [Baixar](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2014/src/C06ex14.java)

<details>
<summary>💻 | Código Java</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Rejeitar valores fora de 1000–9999, extrair os dígitos e concatená-los das unidades aos
 * milhares.
 *
 * Atividade: C06ex14.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex14 {

    static void main() {

        String numberStr;

        int number, d1, d2, d3, d4;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        numberStr = JOptionPane.showInputDialog(null,
                "Informe um número em sequência (5 dígitos):",
                "Conteúdo 05 | Exercício 14",
                JOptionPane.QUESTION_MESSAGE);

        number = Integer.valueOf(numberStr);

        // Processamento: Rejeitar valores fora de 1000–9999, extrair os dígitos e concatená-los das
        // unidades aos milhares.
        if (number < 1000 || number > 9999) {
            // Saída: apresentar a mensagem correspondente ao resultado atual.
            JOptionPane.showMessageDialog(null,
                    "NÚMERO TEM QUE TER 4 DÍGITOS",
                    "Conteúdo 06 | Exercício 14",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        d1 = number / 1000 % 10;

        d2 = number / 100 % 10;

        d3 = number / 10 % 10;

        d4 = number % 10;

        JOptionPane.showMessageDialog(null,
                "Número impresso: " + d4 + d3 + d2 + d1,
                "Conteúdo 05 | Exercício 14",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
```

</details>
