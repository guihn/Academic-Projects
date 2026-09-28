<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006/Exercise%2015">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 15 · Conta de televisão por assinatura

## Descrição

O programa compõe uma conta mensal de TV a cabo com cobrança fixa, consumo diário, serviços extras e imposto municipal. O pacote determina o preço fixo e a regra do pay-per-view, enquanto a cidade determina o percentual de imposto. A atividade exige aplicar o limite de cobrança do pacote Basic antes de calcular o imposto sobre o subtotal.

## Enunciado

Solicite código do pacote, dias de pay-per-view, valor dos extras e cidade. Calcule a conta pelas tabelas:

| Pacote | Código | Mensalidade | Pay-per-view |
| --- | --- | --- | --- |
| Basic | 1 | R$65,00 | R$1,20 por dia, limitado a R$65,00 |
| Advanced | 2 | R$104,00 | R$2,10 por dia |
| Premium | 3 | R$137,00 | Isento |

| Cidade | Imposto |
| --- | --- |
| Belo Horizonte | Isento |
| São Paulo | 1% |
| Rio de Janeiro | 1,5% |
| Demais cidades | 2% |

Some mensalidade, pay-per-view e extras; aplique o imposto sobre essa soma e acrescente-o ao valor da conta.

## Solução

Selecionar as taxas por cidade e pacote, limitar o pay-per-view Basic a R$65 e aplicar o imposto da cidade sobre o subtotal.

Arquivo fonte: [C06ex15.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2015/src/C06ex15.java)

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
