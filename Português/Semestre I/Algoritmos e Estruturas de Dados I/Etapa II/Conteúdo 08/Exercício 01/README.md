<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20II/Content%2008/Exercise%2001">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20II/Conte%C3%BAdo%2008">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 01 · Áreas de dez círculos

## Descrição

**Resumo do enunciado:** Ler os raios de dez círculos e calcular cada área usando π = 3.1416.

**Fonte do enunciado:** [slides originais da aula](https://github.com/guihn/academic-materials/blob/5a9473bbf24a271032a41b141ab6bd435076c1d5/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20II/Contents/Content%2008/Algoritmos%20-%20Aulas%20-%20Conte%C3%BAdo%208%20-%20Comando%20de%20Repeti%C3%A7%C3%A3o%20%E2%80%93%20FOR.pptx), slide(s) 25. [Pasta do material](https://github.com/guihn/academic-materials/tree/main/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20II/Contents/Content%2008).

**Código fornecido:** [C08ex01.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/SecondStage/C08ex01.java).

## Solução

Repetir a entrada e o cálculo da área dez vezes, apresentando cada resultado dentro do laço.

[Arquivo fonte: C08ex01.java](https://github.com/guihn/Academic-Projects/blob/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20II/Conte%C3%BAdo%2008/Exerc%C3%ADcio%2001/src/C08ex01.java) · [Baixar](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20II/Conte%C3%BAdo%2008/Exerc%C3%ADcio%2001/src/C08ex01.java)

<details>
<summary>💻 | Código Java</summary>

```java
package SecondStage;

import javax.swing.JOptionPane;

/**
 * Repetir a entrada e o cálculo da área dez vezes, apresentando cada resultado dentro do laço.
 *
 * Atividade: C08ex01.
 */
public class C08ex01 {
    static void main() {
        String rayStr;
        double ray, pi = 3.1416, area;

        // Processamento: Repetir a entrada e o cálculo da área dez vezes, apresentando cada
        // resultado dentro do laço.
        for (int i = 1; i <=10; i++) {
            // Entrada: coletar os valores solicitados por caixas de diálogo.
            rayStr = JOptionPane.showInputDialog(null,
                    "Informe o raio do círculo: ",
                    "Conteúdo 08 | Exercício 01",
                    JOptionPane.QUESTION_MESSAGE);
            ray = Double.valueOf(rayStr);

            area = pi * Math.pow(ray, 2);

            // Saída: apresentar a mensagem correspondente ao resultado atual.
            JOptionPane.showMessageDialog(null,
                    "Area: " + area,
                    "Conteúdo 08 | Exercício 01",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
```

</details>
