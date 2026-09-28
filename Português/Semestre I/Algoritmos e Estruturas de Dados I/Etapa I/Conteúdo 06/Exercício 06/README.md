<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006/Exercise%2006">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 06 · Raízes da equação do segundo grau

## Descrição

A atividade calcula as raízes reais de uma equação do segundo grau a partir dos coeficientes A, B e C. O discriminante determina se existem duas raízes distintas, uma raiz repetida ou nenhuma raiz real. O programa deve apresentar apenas o resultado adequado ao caso identificado.

## Enunciado

Solicite A, B e C da função $f(x)=Ax^2+Bx+C$ e calcule e imprima suas raízes reais pela fórmula de Bhaskara:

$$\Delta=B^2-4AC \qquad x=\frac{-B\pm\sqrt{\Delta}}{2A}$$

Distinga os casos de discriminante negativo, nulo e positivo.

## Solução

Calcular o discriminante e informar ausência de raízes reais, uma raiz repetida ou duas raízes distintas.

### Observações da implementação

O programa pressupõe A diferente de zero e não valida essa condição.

Arquivo fonte: [C06ex06.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2006/src/C06ex06.java)

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
