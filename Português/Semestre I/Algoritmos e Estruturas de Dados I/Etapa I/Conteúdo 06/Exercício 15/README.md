<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006/Exercise%2015">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 15 · Conta de televisão por assinatura

## Descrição

**Resumo do enunciado:** Calcular mensalidade do pacote, diárias de pay-per-view, serviços extras e imposto da cidade usando as tabelas do exercício.

**Fonte do enunciado:** [slides originais da aula](https://github.com/guihn/academic-materials/blob/5a9473bbf24a271032a41b141ab6bd435076c1d5/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2006/Algoritmos%20-%20Aulas%20-%20Conte%C3%BAdo%206%20-%20Comando%20Condicional%20%E2%80%93%20IF%2C%20Express%C3%B5es%20Booleanas.pptx), slide(s) 57. [Pasta do material](https://github.com/guihn/academic-materials/tree/main/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2006).

**Código fornecido:** [C06ex15.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/FirstStage/C06ex15.java).

## Solução

Selecionar as taxas por cidade e pacote, limitar o pay-per-view Basic a R$65 e aplicar o imposto da cidade sobre o subtotal.

[Arquivo fonte: C06ex15.java](https://github.com/guihn/Academic-Projects/blob/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2015/src/C06ex15.java) · [Baixar](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2015/src/C06ex15.java)

<details>
<summary>💻 | Código Java</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Selecionar as taxas por cidade e pacote, limitar o pay-per-view Basic a R$65 e aplicar o
 * imposto da cidade sobre o subtotal.
 *
 * Atividade: C06ex15.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex15 {

    static void main() {

        int packageCode, daysQuantity;

        String packageCodeStr, daysQuantityStr, extrasServicesPriceStr, city;

        double extrasServicesPrice, monthFinalCost, fixedValue, payperview, incometax;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        packageCodeStr = JOptionPane.showInputDialog(null,
                "Informe o código do seu pacote: ",
                "Conteúdo 06 | Exercício 15",
                JOptionPane.QUESTION_MESSAGE);

        daysQuantityStr = JOptionPane.showInputDialog(null,
                "Informe a quantidade de dias de consumo de canais pay-per-view: ",
                "Conteúdo 06 | Exercício 15",
                JOptionPane.QUESTION_MESSAGE);

        extrasServicesPriceStr = JOptionPane.showInputDialog(null,
                "Informe valor dos serviços extras: ",
                "Conteúdo 06 | Exercício 15",
                JOptionPane.QUESTION_MESSAGE);

        city = JOptionPane.showInputDialog(null,
                "Informe a sua cidade: ",
                "Conteúdo 06 | Exercício 15",
                JOptionPane.QUESTION_MESSAGE);

        packageCode = Integer.valueOf(packageCodeStr);
        daysQuantity = Integer.valueOf(daysQuantityStr);
        extrasServicesPrice = Double.valueOf(extrasServicesPriceStr);

        // Processamento: Selecionar as taxas por cidade e pacote, limitar o pay-per-view Basic a
        // R$65 e aplicar o imposto da cidade sobre o subtotal.
        fixedValue = 0;
        payperview = 0;
        incometax = 0;

        if (city.equalsIgnoreCase("Belo Horizonte")) {
            incometax = 0;
        }
        
        else if (city.equalsIgnoreCase("Rio de Janeiro")) {
            incometax = 0.015;
        }
        
        else if (city.equalsIgnoreCase("São paulo")) {
            incometax = 0.01;
        }
        
        else
            incometax = 0.02;

        switch (packageCode) {
            case 1 -> {
                
                fixedValue = 65.00;
                payperview = 1.20;

                payperview *= daysQuantity;

                if (payperview > 65) {
                    payperview = 65.00;
                }
            }
            case 2 -> {
                
                fixedValue = 104.00;
                payperview = 2.10;
                payperview *= daysQuantity;
            }
            case 3 -> {
                
                fixedValue = 137.00;
                payperview = 0;
            }
            default -> {
                
                // Saída: apresentar a mensagem correspondente ao resultado atual.
                JOptionPane.showMessageDialog(null,
                        "Você não informou um código válido para algum pacote!",
                        "Conteúdo 06 | Exercício 15",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        monthFinalCost = fixedValue + payperview + extrasServicesPrice;

        monthFinalCost += monthFinalCost * incometax;

        JOptionPane.showMessageDialog(null,
                "Conta: " + monthFinalCost,
                "Sua conta",
                JOptionPane.INFORMATION_MESSAGE);

    }
}
```

</details>
