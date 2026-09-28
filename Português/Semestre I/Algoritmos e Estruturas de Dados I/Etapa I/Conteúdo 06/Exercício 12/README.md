<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006/Exercise%2012">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 12 · Custos de embalagem e armazenagem

## Descrição

**Resumo do enunciado:** Descartar bolas defeituosas, embalar até 10 por caixa e alugar galpões com capacidade de até 850 caixas até o evento. Incluir caixas e galpões incompletos no custo.

**Fonte do enunciado:** [slides originais da aula](https://github.com/guihn/academic-materials/blob/5a9473bbf24a271032a41b141ab6bd435076c1d5/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2006/Algoritmos%20-%20Aulas%20-%20Conte%C3%BAdo%206%20-%20Comando%20Condicional%20%E2%80%93%20IF%2C%20Express%C3%B5es%20Booleanas.pptx), slide(s) 54. [Pasta do material](https://github.com/guihn/academic-materials/tree/main/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2006).

**Código fornecido:** [C06ex12.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/FirstStage/C06ex12.java).

## Solução

Arredondar as quantidades de caixas e galpões para cima com Math.ceil e somar os custos de embalagem e aluguel.

[Arquivo fonte: C06ex12.java](https://github.com/guihn/Academic-Projects/blob/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2012/src/C06ex12.java) · [Baixar](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2012/src/C06ex12.java)

<details>
<summary>💻 | Código Java</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Arredondar as quantidades de caixas e galpões para cima com Math.ceil e somar os custos de
 * embalagem e aluguel.
 *
 * Atividade: C06ex12.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex12 {

    static void main() {

        String fabricatedBallsStr, defectsballsStr, unitaryPriceBoxesStr, monthlyuntilCupStr, mensalvaluerentalStr;

        double fabricatedBalls, defectsballs, goodBalls, unitaryPriceBoxes, necessaryBoxes, boxesCost, necessaryWarehouses, monthswarehousePrices, warehouseCost, monthlyuntilCup, mensalvaluerental, totalCost;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        fabricatedBallsStr = JOptionPane.showInputDialog(null,
                "Informe o número de bolas fabricadas: ",
                "Conteúdo 06 | Exercício 12",
                JOptionPane.QUESTION_MESSAGE);

        defectsballsStr = JOptionPane.showInputDialog(null,
                "Informe o número de bolas defeituosas: ",
                "Conteúdo 06 | Exercício 12",
                JOptionPane.QUESTION_MESSAGE);

        unitaryPriceBoxesStr = JOptionPane.showInputDialog(null,
                "Informe o valor do preço unitário das caixas: ",
                "Conteúdo 06 | Exercício 12",
                JOptionPane.QUESTION_MESSAGE);

        monthlyuntilCupStr = JOptionPane.showInputDialog(null,
                "Informe o número de meses até a copa: ",
                "Conteúdo 06 | Exercício 12",
                JOptionPane.QUESTION_MESSAGE);

        mensalvaluerentalStr = JOptionPane.showInputDialog(null,
                "Informe o valor do aluguel: ",
                "Conteúdo 06 | Exercício 12",
                JOptionPane.QUESTION_MESSAGE);

        fabricatedBalls = Double.valueOf(fabricatedBallsStr);
        defectsballs = Double.valueOf(defectsballsStr);
        unitaryPriceBoxes = Double.valueOf(unitaryPriceBoxesStr);
        monthlyuntilCup = Double.valueOf(monthlyuntilCupStr);
        mensalvaluerental = Double.valueOf(mensalvaluerentalStr);

        // Processamento: Arredondar as quantidades de caixas e galpões para cima com Math.ceil e
        // somar os custos de embalagem e aluguel.
        goodBalls = fabricatedBalls - defectsballs;

        // Arredondar para cima, pois uma caixa parcialmente preenchida também precisa ser comprada.
        necessaryBoxes = Math.ceil(goodBalls / 10);

        boxesCost = unitaryPriceBoxes * necessaryBoxes;

        // Um galpão parcialmente ocupado também conta no custo do aluguel.
        necessaryWarehouses = Math.ceil(necessaryBoxes / 850);

        monthswarehousePrices = mensalvaluerental * necessaryWarehouses;

        warehouseCost = monthswarehousePrices * monthlyuntilCup;

        totalCost = boxesCost + warehouseCost;

        // Saída: apresentar a mensagem correspondente ao resultado atual.
        JOptionPane.showMessageDialog(null,
                "Custo total: " + totalCost);
    }
}
```

</details>
