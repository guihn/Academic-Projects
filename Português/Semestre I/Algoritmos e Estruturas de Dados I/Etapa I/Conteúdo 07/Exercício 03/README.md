<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2007/Exercise%2003">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2007">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 03 · Multa por atraso

## Descrição

**Resumo do enunciado:** Ler o valor de um imposto e os dias de atraso e calcular a multa pelas faixas do exercício.

## Solução

Usar switch para selecionar isenção, 2%, 10% mais 0.5% por dia ou 150% mais R$1 por dia.

Arquivo fonte: [C07ex03.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2007/Exerc%C3%ADcio%2003/src/C07ex03.java)

<details>
<summary>💻 | Código Java</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Usar switch para selecionar isenção, 2%, 10% mais 0.5% por dia ou 150% mais R$1 por dia.
 *
 * Atividade: C07ex03.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C07ex03 {

    static void main() {

        String taxStr, lateDaysStr;

        int lateDays;

        double tax, fee, percentualFee;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        taxStr = JOptionPane.showInputDialog(null,
                "Informe o valor do imposto: ",
                "Conteúdo 07 | Exercício 03",
                JOptionPane.QUESTION_MESSAGE);

        lateDaysStr = JOptionPane.showInputDialog(null,
                "Informe a quantidade de dias atrasados: ",
                "Conteúdo 07 | Exercício 03",
                JOptionPane.QUESTION_MESSAGE);

        tax = Double.valueOf(taxStr);
        lateDays = Integer.valueOf(lateDaysStr);

        // Processamento: Usar switch para selecionar isenção, 2%, 10% mais 0.5% por dia ou 150%
        // mais R$1 por dia.
        switch (lateDays) {
            case 0, 1, 2, 3, 4, 5 -> {
                
                percentualFee = 0;
                fee = tax * percentualFee;
            }
            case 6, 7, 8 -> {
                
                percentualFee = 0.02;
                fee = tax * percentualFee;
            }
            case 9, 10 -> {

                percentualFee = 0.10 + 0.005 * lateDays;
                fee = tax * percentualFee;
            }
            default -> {

                percentualFee = 1.50;
                fee = (tax * percentualFee) + (1 * lateDays);
            }
        }

        // Saída: apresentar a mensagem correspondente ao resultado atual.
        JOptionPane.showMessageDialog(null,
                "Multa: R$" + fee,
                "Conteúdo 07 | Exercício 03",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
```

</details>
