<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/First%20Assessment/Question%20C">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Primeira%20Avalia%C3%A7%C3%A3o">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Questão C · Exercício de desconto de IPVA

## Descrição

A questão contém uma simulação de desconto sobre um valor de IPVA. O programa lê o valor inicial, o combustível e o ano de fabricação; então seleciona uma isenção ou um percentual de desconto e apresenta o valor a pagar. As opções de combustível são A para álcool, G para gasolina e D para diesel. Esta descrição se baseia nas regras programadas para a atividade.

## Enunciado

O enunciado original desta questão não está disponível. A descrição e a solução abaixo apresentam a simulação implementada no código, sem confirmar os critérios originalmente pedidos pela avaliação.

## Solução

Selecionar o ramo do combustível e a faixa de ano e aplicar a isenção ou o percentual de desconto programado ao imposto original.

| Ano&nbsp;de&nbsp;fabricação | A:&nbsp;álcool | G:&nbsp;gasolina | D:&nbsp;diesel |
| --- | --- | --- | --- |
| Antes de 1960 | Isento | Isento | Isento |
| 1960–1970 | 55% de desconto | 50% de desconto | 50% de desconto |
| 1971–1980 | 25% de desconto | 20% de desconto | 20% de desconto |
| Após 1980 | 5% de desconto | Sem desconto | Sem desconto |

### Observações da implementação

Os percentuais descrevem este programa didático. Não há enunciado da avaliação disponível para confirmá-los.

Arquivo fonte: [D30912C.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Primeira%20Avalia%C3%A7%C3%A3o/Quest%C3%A3o%20C/src/D30912C.java)

<details>
<summary>💻 | Código Java</summary>

```java
package FirstTest;

import javax.swing.JOptionPane;

/**
 * Selecionar o ramo do combustível e a faixa de ano e aplicar a isenção ou o percentual de
 * desconto programado ao imposto original.
 *
 * Atividade: D30912C.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class D30912C {
    static void main() {
        String originalPriceIPVAStr, typeofOil, fabricatedYearStr;
        double originalPriceIPVA, fabricatedYear, descount, descountPercentage, ipvatoPay;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        originalPriceIPVAStr = JOptionPane.showInputDialog(null,
                "Informe o preço original do IPVA do veículo: ",
                "Primeira Avaliação | Questão C",
                JOptionPane.QUESTION_MESSAGE);
        typeofOil = JOptionPane.showInputDialog(null,
                "Informe o tipo de combustível usado no veículo ('A' para álcool, 'G' para Gasolina e 'D' para diesel: ",
                "Primeira Avaliação | Questão C",
                JOptionPane.QUESTION_MESSAGE);
        fabricatedYearStr = JOptionPane.showInputDialog(null,
                "Informe o ano de fabricação do veículo: ",
                "Primeira Avaliação | Questão C",
                JOptionPane.QUESTION_MESSAGE);

        originalPriceIPVA = Double.valueOf(originalPriceIPVAStr);
        fabricatedYear = Double.valueOf(fabricatedYearStr);
        typeofOil = typeofOil.toUpperCase();

        // Processamento: Selecionar o ramo do combustível e a faixa de ano e aplicar a isenção ou o
        // percentual de desconto programado ao imposto original.
        switch (typeofOil) {
            default -> {
                // Saída: apresentar a mensagem correspondente ao resultado atual.
                JOptionPane.showMessageDialog(null,
                        "Você não inseriu uma letra válida!",
                        "Primeira Avaliação | Questão C",
                        JOptionPane.ERROR_MESSAGE);
            }
            case "A" -> {
                if (fabricatedYear < 1960) {
                    JOptionPane.showMessageDialog(null,
                            "Não paga IPVA!",
                            "Primeira Avaliação | Questão C",
                            JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                else if (fabricatedYear >= 1960 && fabricatedYear <= 1970) {
                    descountPercentage = 0.55;
                    descount = originalPriceIPVA * descountPercentage;
                    ipvatoPay = originalPriceIPVA - descount;

                    JOptionPane.showMessageDialog(null,
                            "IPVA a pagar: R$" + ipvatoPay,
                            "Primeira Avaliação | Questão C",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else if (fabricatedYear >= 1971 && fabricatedYear <= 1980) {
                    descountPercentage = 0.25;
                    descount = originalPriceIPVA * descountPercentage;
                    ipvatoPay = originalPriceIPVA - descount;

                    JOptionPane.showMessageDialog(null,
                            "IPVA a pagar: R$" + ipvatoPay,
                            "Primeira Avaliação | Questão C",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    descountPercentage = 0.05;
                    descount = originalPriceIPVA * descountPercentage;
                    ipvatoPay = originalPriceIPVA - descount;

                    JOptionPane.showMessageDialog(null,
                            "IPVA a pagar: R$" + ipvatoPay,
                            "Primeira Avaliação | Questão C",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
            case "G" -> {
                if (fabricatedYear < 1960) {
                    JOptionPane.showMessageDialog(null,
                            "Não paga IPVA!",
                            "Primeira Avaliação | Questão C",
                            JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                else if (fabricatedYear >= 1960 && fabricatedYear <= 1970) {
                    descountPercentage = 0.50;
                    descount = originalPriceIPVA * descountPercentage;
                    ipvatoPay = originalPriceIPVA - descount;

                    JOptionPane.showMessageDialog(null,
                            "IPVA a pagar: R$" + ipvatoPay,
                            "Primeira Avaliação | Questão C",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else if (fabricatedYear >= 1971 && fabricatedYear <= 1980) {
                    descountPercentage = 0.20;
                    descount = originalPriceIPVA * descountPercentage;
                    ipvatoPay = originalPriceIPVA - descount;

                    JOptionPane.showMessageDialog(null,
                            "IPVA a pagar: R$" + ipvatoPay,
                            "Primeira Avaliação | Questão C",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    descountPercentage = 0.0;
                    descount = originalPriceIPVA * descountPercentage;
                    ipvatoPay = originalPriceIPVA - descount;

                    JOptionPane.showMessageDialog(null,
                            "IPVA a pagar: R$" + ipvatoPay,
                            "Primeira Avaliação | Questão C",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
            case "D" -> {
                if (fabricatedYear < 1960) {
                    JOptionPane.showMessageDialog(null,
                            "Não paga IPVA!",
                            "Primeira Avaliação | Questão C",
                            JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                else if (fabricatedYear >= 1960 && fabricatedYear <= 1970) {
                    descountPercentage = 0.50;
                    descount = originalPriceIPVA * descountPercentage;
                    ipvatoPay = originalPriceIPVA - descount;

                    JOptionPane.showMessageDialog(null,
                            "IPVA a pagar: R$" + ipvatoPay,
                            "Primeira Avaliação | Questão C",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else if (fabricatedYear >= 1971 && fabricatedYear <= 1980) {
                    descountPercentage = 0.20;
                    descount = originalPriceIPVA * descountPercentage;
                    ipvatoPay = originalPriceIPVA - descount;

                    JOptionPane.showMessageDialog(null,
                            "IPVA a pagar: R$" + ipvatoPay,
                            "Primeira Avaliação | Questão C",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    descountPercentage = 0.0;
                    descount = originalPriceIPVA * descountPercentage;
                    ipvatoPay = originalPriceIPVA - descount;

                    JOptionPane.showMessageDialog(null,
                            "IPVA a pagar: R$" + ipvatoPay,
                            "Primeira Avaliação | Questão C",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }
}
```

</details>
