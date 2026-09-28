<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2005/Exercise%2002">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2005">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 02 · Área e volume da esfera

## Descrição

A partir de um único raio, o programa calcula duas medidas de uma esfera: a área de sua superfície e seu volume. Cada resultado depende de uma potência diferente do raio, ao quadrado para a área e ao cubo para o volume. A atividade usa o valor de π definido no enunciado e apresenta as duas medidas separadamente.

## Enunciado

Leia o raio R de uma esfera e calcule e imprima sua área superficial e seu volume. Use π = 3,1416 e as fórmulas:

$$A = 4\pi R^2 \qquad V = \frac{4}{3}\pi R^3$$

## Solução

Aplicar 4πr² para a área da superfície e (4/3)πr³ para o volume, com divisão em ponto flutuante.

Arquivo fonte: [C05ex02.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2005/Exerc%C3%ADcio%2002/src/C05ex02.java)

<details>
<summary>💻 | Código Java</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Aplicar 4πr² para a área da superfície e (4/3)πr³ para o volume, com divisão em ponto
 * flutuante.
 *
 * Atividade: C05ex02.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C05ex02 {

    static void main() {

        String raiostr;

        double pi = 3.1416, raio, area, volume;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        raiostr = JOptionPane.showInputDialog(null,
                "Informe o valor do raio:",
                "Conteúdo 05 | Exercício 02",
                JOptionPane.QUESTION_MESSAGE);

        raio = Double.valueOf(raiostr);

        // Processamento: Aplicar 4πr² para a área da superfície e (4/3)πr³ para o volume, com
        // divisão em ponto flutuante.
        area = 4 * pi * Math.pow(raio, 2);

        volume = 4.0 / 3.0 * pi * Math.pow(raio, 3);

        // Saída: apresentar a mensagem correspondente ao resultado atual.
        JOptionPane.showMessageDialog(null,
                "Área: " + area + "\nVolume: " + volume,
                "Conteúdo 05 | Exercício 02",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
```

</details>
