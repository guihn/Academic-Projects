<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006/Exercise%2002">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 02 · Multa por faixa de emissão

## Descrição

A atividade calcula uma multa ambiental pela faixa de emissão de uma empresa. O programa recebe a quantidade de poluentes e deve decidir entre isenção, multa fixa e multa proporcional à quantidade total emitida. Os limites das faixas precisam ser respeitados para que valores nas fronteiras recebam o tratamento previsto.

## Enunciado

Leia a quantidade de poluentes emitidos, em mg/(t·m²), e calcule e imprima a multa segundo a tabela do exercício:

| Quantidade | Multa |
| --- | --- |
| Até 1500 | Isento |
| Acima de 1500 até 3500 | R$3.000,00 |
| Acima de 3500 | R$5.000,00 × quantidade de poluentes |

## Solução

Preparar as multas fixa e proporcional e escolher a mensagem pelos limites de emissão do código.

### Observações da implementação

O código usa 3000 como limite superior da faixa intermediária. O enunciado usa 3500.

Arquivo fonte: [C06ex02.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2002/src/C06ex02.java)

<details>
<summary>💻 | Código Java</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Preparar as multas fixa e proporcional e escolher a mensagem pelos limites de emissão do
 * código.
 *
 * Atividade: C06ex02.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex02 {

    static void main() {

        String pollutantStr;

        double pollutant, fee15x35, fee35;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        pollutantStr = JOptionPane.showInputDialog(null,
                "Informe a quantidade de poluentes:",
                "Conteúdo 06 | Exercício 02",
                JOptionPane.QUESTION_MESSAGE);

        pollutant = Double.valueOf(pollutantStr);

        // Processamento: Preparar as multas fixa e proporcional e escolher a mensagem pelos limites
        // de emissão do código.
        fee15x35 = 3000;

        fee35 = 5000 * pollutant;

        if (pollutant <= 1500)
            // Saída: apresentar a mensagem correspondente ao resultado atual.
            JOptionPane.showMessageDialog(null,
                    "Multa isenta.",
                    "Conteúdo 06 | Exercício 02",
                    JOptionPane.INFORMATION_MESSAGE);

        // O limite superior no código é 3000; o enunciado usa 3500.
        else if (pollutant >= 1500 && pollutant <= 3000)
            JOptionPane.showMessageDialog(null,
                    "Multa: R$" + fee15x35,
                    "Conteúdo 06 | Exercício 02",
                    JOptionPane.INFORMATION_MESSAGE);
            
        else
            JOptionPane.showMessageDialog(null,
                    "Multa: R$" + fee35,
                    "Conteúdo 06 | Exercício 02",
                    JOptionPane.INFORMATION_MESSAGE);
    }
}
```

</details>
