<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006/Exercise%2006">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 06 · Raízes da equação do segundo grau

## Descrição

**Resumo do enunciado:** Ler A, B e C e calcular as raízes reais de uma equação do segundo grau pela fórmula de Bhaskara.

**Fonte do enunciado:** [slides originais da aula](https://github.com/guihn/academic-materials/blob/5a9473bbf24a271032a41b141ab6bd435076c1d5/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2006/Algoritmos%20-%20Aulas%20-%20Conte%C3%BAdo%206%20-%20Comando%20Condicional%20%E2%80%93%20IF%2C%20Express%C3%B5es%20Booleanas.pptx), slide(s) 48. [Pasta do material](https://github.com/guihn/academic-materials/tree/main/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2006).

**Código fornecido:** [C06ex06.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/FirstStage/C06ex06.java).

## Solução

Calcular o discriminante e informar ausência de raízes reais, uma raiz repetida ou duas raízes distintas.

### Observações da implementação

O programa pressupõe A diferente de zero e não valida essa condição.

[Arquivo fonte: C06ex06.java](https://github.com/guihn/Academic-Projects/blob/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2006/src/C06ex06.java) · [Baixar](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2006/src/C06ex06.java)

<details>
<summary>💻 | Código Java</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Calcular o discriminante e informar ausência de raízes reais, uma raiz repetida ou duas raízes
 * distintas.
 *
 * Atividade: C06ex06.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex06 {

    static void main() {

        String aStr, bStr, cStr;

        double a, b, c, fx, delta, c1, c2;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        aStr = JOptionPane.showInputDialog(null,
                "Informe o valor de A:",
                "Conteúdo 06 | Exercício 06",
                JOptionPane.QUESTION_MESSAGE);

        bStr = JOptionPane.showInputDialog(null,
                "Informe o valor de B:",
                "Conteúdo 06 | Exercício 06",
                JOptionPane.QUESTION_MESSAGE);

        cStr = JOptionPane.showInputDialog(null,
                "Informe o valor de C:",
                "Conteúdo 06 | Exercício 06",
                JOptionPane.QUESTION_MESSAGE);

        a = Double.valueOf(aStr);
        b = Double.valueOf(bStr);
        c = Double.valueOf(cStr);

        // Processamento: Calcular o discriminante e informar ausência de raízes reais, uma raiz
        // repetida ou duas raízes distintas.
        delta = Math.pow(b, 2) - (4 * a * c);

        if (delta < 0) {
            // Saída: apresentar a mensagem correspondente ao resultado atual.
            JOptionPane.showMessageDialog(null,
                    "Não teremos raízes",
                    "Conteúdo 06 | Exercício 06",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {

            c1 = (-b + Math.sqrt(delta)) / (2 * a);
            c2 = (-b - Math.sqrt(delta)) / (2 * a);

            if (c1 == c2) {
                JOptionPane.showMessageDialog(null,
                        "Teremos 1 raiz = " + c1,
                        "Conteúdo 06 | Exercício 06",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                
                JOptionPane.showMessageDialog(null,
                        "Teremos 2 raízes = " + c1 + " e " + c2,
                        "Conteúdo 06 | Exercício 06",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
```

</details>
