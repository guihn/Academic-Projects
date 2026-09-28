<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2005/Exercise%2011">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2005">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 11 · Campos de um número de cheque

## Descrição

**Resumo do enunciado:** Separar um número de cheque de nove dígitos em códigos de banco, agência e sequência, cada um com três dígitos.

## Solução

Extrair os três grupos com operações de divisão inteira e resto.

Arquivo fonte: [C05ex11.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2005/Exerc%C3%ADcio%2011/src/C05ex11.java)

<details>
<summary>💻 | Código Java</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Extrair os três grupos com operações de divisão inteira e resto.
 *
 * Atividade: C05ex11.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C05ex11 {

    static void main() {

        String numberStr;

        int number, bank, agency, sequencial;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        numberStr = JOptionPane.showInputDialog(null,
                "Informe o número (9 dígitos):",
                "Conteúdo 05 | Exercício 11",
                JOptionPane.QUESTION_MESSAGE);

        number = Integer.valueOf(numberStr);

        // Processamento: Extrair os três grupos com operações de divisão inteira e resto.
        bank = number / 1000000;

        agency = number / 1000 % 1000;

        sequencial = number % 1000;

        // Saída: apresentar a mensagem correspondente ao resultado atual.
        JOptionPane.showMessageDialog(null,
                "Banco: " + bank + "\nAgência: " + agency + "\nSequencial: " + sequencial,
                "Conteúdo 05 | Exercício 11",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
```

</details>
