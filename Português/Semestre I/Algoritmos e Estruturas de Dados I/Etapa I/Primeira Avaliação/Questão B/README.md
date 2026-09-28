<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/First%20Assessment/Question%20B">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Primeira%20Avalia%C3%A7%C3%A3o">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Questão B · Número Armstrong

## Descrição

Resumo do código fornecido: testar se um inteiro positivo de três dígitos é igual à soma dos cubos de seus dígitos. O enunciado original da avaliação não está disponível.

**Código fornecido:** [D30912B.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/FirstStage/FirstTest/D30912B.java).

## Solução

Validar 100–999, extrair centenas, dezenas e unidades e comparar a soma de seus cubos com o número original.

### Observações da implementação

A mensagem pede até três dígitos, mas a validação aceita exatamente três dígitos positivos.

[Arquivo fonte: D30912B.java](https://github.com/guihn/Academic-Projects/blob/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Primeira%20Avalia%C3%A7%C3%A3o/Quest%C3%A3o%20B/src/D30912B.java) · [Baixar](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Primeira%20Avalia%C3%A7%C3%A3o/Quest%C3%A3o%20B/src/D30912B.java)

<details>
<summary>💻 | Código Java</summary>

```java
package FirstTest;

import javax.swing.JOptionPane;

/**
 * Validar 100–999, extrair centenas, dezenas e unidades e comparar a soma de seus cubos com o
 * número original.
 *
 * Atividade: D30912B.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class D30912B {
    static void main() {
        int receivedNumber;
        String numberArmstrongStr;
        double firstNumb, secondNumb, thirdNumb, testing;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        numberArmstrongStr = JOptionPane.showInputDialog(null,
                "Informe um número de até 3 digitos a ser testado: ",
                "Primeira Avaliação | Questão B",
                JOptionPane.INFORMATION_MESSAGE);

        receivedNumber = Integer.valueOf(numberArmstrongStr);

        // Processamento: Validar 100–999, extrair centenas, dezenas e unidades e comparar a soma de
        // seus cubos com o número original.
        if (receivedNumber >= 100 && receivedNumber < 1000) {

            firstNumb = receivedNumber / 100 % 10;
            secondNumb = receivedNumber / 10 % 10;
            thirdNumb = receivedNumber % 10;

            testing = Math.pow(firstNumb, 3) + Math.pow(secondNumb, 3) + Math.pow(thirdNumb, 3);
            if (testing == receivedNumber) {
                // Saída: apresentar a mensagem correspondente ao resultado atual.
                JOptionPane.showMessageDialog(null,
                        "Esse número é um numero Armstrong!",
                        "Primeira Avaliação | Questão B",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(null,
                        "Esse número não é um numero Armstrong!",
                        "Primeira Avaliação | Questão B",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        else {
            JOptionPane.showMessageDialog(null,
                    "Você não inseriu um número válido de até 3 digitos!",
                    "Primeira Avaliação | Questão B",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
```

</details>
