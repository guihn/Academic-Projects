<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2005/Exercise%2005">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2005">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 05 · Conversão de temperaturas

## Descrição

A atividade converte uma temperatura de entrada para duas escalas diferentes. O usuário informa Celsius e recebe os valores correspondentes em Kelvin e Fahrenheit. O exercício exige reorganizar as relações entre as escalas para que ambas as saídas sejam calculadas diretamente a partir da mesma entrada.

## Enunciado

Leia uma temperatura em Celsius e apresente os valores equivalentes em Kelvin e Fahrenheit. As relações adotadas no enunciado são:

$$C = K - 273 \qquad C = \frac{5F - 160}{9}$$

## Solução

Somar 273.15 para Kelvin e calcular 1.8 vezes Celsius mais 32 para Fahrenheit.

### Observações da implementação

A implementação usa 273.15 na conversão para Kelvin. O exemplo do slide usa o deslocamento arredondado 273.

Arquivo fonte: [C05ex05.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2005/Exerc%C3%ADcio%2005/src/C05ex05.java)

<details>
<summary>💻 | Código Java</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Somar 273.15 para Kelvin e calcular 1.8 vezes Celsius mais 32 para Fahrenheit.
 *
 * Atividade: C05ex05.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C05ex05 {

    static void main() {

        String celsiusStr;

        double celsius, kelvin, farenheit;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        celsiusStr = JOptionPane.showInputDialog(null,
                "Informe a temperatura em °C:",
                "Conteúdo 05 | Exercício 05",
                JOptionPane.QUESTION_MESSAGE);

        celsius = Double.valueOf(celsiusStr);

        // Processamento: Somar 273.15 para Kelvin e calcular 1.8 vezes Celsius mais 32 para
        // Fahrenheit.
        kelvin = celsius + 273.15;

        farenheit = celsius * 1.8 + 32;

        // Saída: apresentar a mensagem correspondente ao resultado atual.
        JOptionPane.showMessageDialog(null,
                "Celsius: " + celsius + " -> Kelvin: " + kelvin + " e Fahrenheit: " + farenheit,
                "Conteúdo 05 | Exercício 05",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
```

</details>
