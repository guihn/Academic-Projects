<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006/Exercise%2003">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 03 · Comissão sobre vendas

## Descrição

**Resumo do enunciado:** Calcular o salário de R$240 acrescido de comissão: zero até R$1000 em vendas, 10% até R$10000 ou R$1000 acima desse valor.

**Código fornecido:** [C06ex03.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/FirstStage/C06ex03.java).

## Solução

Selecionar uma expressão de salário conforme a faixa de vendas mensais.

### Observações da implementação

Para vendas acima de R$10000, o código original atribui salário total de R$1000 e omite a parcela fixa de R$240.

[Arquivo fonte: C06ex03.java](https://github.com/guihn/Academic-Projects/blob/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2003/src/C06ex03.java) · [Baixar](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2003/src/C06ex03.java)

<details>
<summary>💻 | Código Java</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Selecionar uma expressão de salário conforme a faixa de vendas mensais.
 *
 * Atividade: C06ex03.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex03 {

    static void main() {

        String monthlySaleStr;

        double monthlySale, fixedValor, salary;

        fixedValor = 240;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        monthlySaleStr = JOptionPane.showInputDialog(null,
                "Informe o total mensal vendido:",
                "Conteúdo 06 | Exercício 03",
                JOptionPane.QUESTION_MESSAGE);

        monthlySale = Double.valueOf(monthlySaleStr);

        // Processamento: Selecionar uma expressão de salário conforme a faixa de vendas mensais.
        if (monthlySale <= 1000)
            salary = fixedValor;

        else if (monthlySale > 1000 && monthlySale <= 10000)
            salary = fixedValor + (monthlySale * 0.10);
            
        else
            // Este ramo original omite a parcela fixa de 240.
            salary = 1000;

        // Saída: apresentar a mensagem correspondente ao resultado atual.
        JOptionPane.showMessageDialog(null,
                "Salário: " + salary,
                "Conteúdo 06 | Exercício 03",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
```

</details>
