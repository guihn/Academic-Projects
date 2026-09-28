<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20II/Content%2008/Exercise%2006">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20II/Conte%C3%BAdo%2008">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 06 · Paridade e totais de divisibilidade

## Descrição

**Resumo do enunciado:** Ler dez inteiros, informar a paridade de cada um, somar os múltiplos de 4 e contar os múltiplos de 3.

**Fonte do enunciado:** [slides originais da aula](https://github.com/guihn/academic-materials/blob/5a9473bbf24a271032a41b141ab6bd435076c1d5/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20II/Contents/Content%2008/Algoritmos%20-%20Aulas%20-%20Conte%C3%BAdo%208%20-%20Comando%20de%20Repeti%C3%A7%C3%A3o%20%E2%80%93%20FOR.pptx), slide(s) 60. [Pasta do material](https://github.com/guihn/academic-materials/tree/main/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20II/Contents/Content%2008).

**Código fornecido:** [C08ex06.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/SecondStage/C08ex06.java).

## Solução

Usar restos para classificar cada número e manter a soma e a contagem dentro do laço.

### Observações da implementação

O else if original torna exclusivas as verificações de divisibilidade. Números divisíveis por 4 e por 3 entram na soma, mas ficam fora da contagem de múltiplos de 3.

[Arquivo fonte: C08ex06.java](https://github.com/guihn/Academic-Projects/blob/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20II/Conte%C3%BAdo%2008/Exerc%C3%ADcio%2006/src/C08ex06.java) · [Baixar](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20II/Conte%C3%BAdo%2008/Exerc%C3%ADcio%2006/src/C08ex06.java)

<details>
<summary>💻 | Código Java</summary>

```java
package SecondStage;

import javax.swing.JOptionPane;

/**
 * Usar restos para classificar cada número e manter a soma e a contagem dentro do laço.
 *
 * Atividade: C08ex06.
 */
public class C08ex06 {
    static void main() {
        String numberStr;
        int number, oddoreven, div4, div3, rep, div4sum, ifdiv3;
        rep = 10;
        div4sum = 0;
        div3 = 0;

        // Processamento: Usar restos para classificar cada número e manter a soma e a contagem
        // dentro do laço.
        for (int i = 1; i <= rep; i++) {
            // Entrada: coletar os valores solicitados por caixas de diálogo.
            numberStr = JOptionPane.showInputDialog(null,
                    "Informe um número inteiro: ",
                    "Conteúdo 08 | Exercício 06",
                    JOptionPane.QUESTION_MESSAGE);
            number = Integer.parseInt(numberStr);

            oddoreven = number % 2;
            div4 = number % 4;
            ifdiv3 = number % 3;

            if (oddoreven == 0) {
                // Saída: apresentar a mensagem correspondente ao resultado atual.
                JOptionPane.showMessageDialog(null,
                        "O número informado é par!",
                        "Conteúdo 08 | Exercício 06",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null,
                        "O número informado é ímpar!",
                        "Conteúdo 08 | Exercício 06",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            if (div4 == 0) {
                div4sum += number;
            }
            // Este else if original exclui múltiplos de 4 da contagem de múltiplos de 3.
            else if (ifdiv3 == 0) {
                div3++;
            }
        }
            JOptionPane.showMessageDialog(null,
                    "A soma dos números divisíveis por 4 é: " + div4sum + "\nA quantidade de números divisíveis por 3 é: " + div3 + " números.",
                    "Conteúdo 08 | Exercício 06",
                    JOptionPane.QUESTION_MESSAGE);
    }
}
```

</details>
