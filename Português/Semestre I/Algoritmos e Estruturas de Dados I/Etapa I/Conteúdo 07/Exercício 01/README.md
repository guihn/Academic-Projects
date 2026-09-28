<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2007/Exercise%2001">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2007">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 01 · Prêmios de loteria esportiva

## Descrição

**Resumo do enunciado:** Ler o nome do apostador e a quantidade de acertos em 13 jogos e atribuir ausência de prêmio, outro cartão ou o prêmio em dinheiro previsto.

**Código fornecido:** [C07ex01.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/FirstStage/C07ex01.java).

## Solução

Tratar as faixas baixas de acertos com if e selecionar o prêmio de 11, 12 ou 13 acertos com switch.

[Arquivo fonte: C07ex01.java](https://github.com/guihn/Academic-Projects/blob/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2007/Exerc%C3%ADcio%2001/src/C07ex01.java) · [Baixar](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2007/Exerc%C3%ADcio%2001/src/C07ex01.java)

<details>
<summary>💻 | Código Java</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Tratar as faixas baixas de acertos com if e selecionar o prêmio de 11, 12 ou 13 acertos com
 * switch.
 *
 * Atividade: C07ex01.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C07ex01 {

    static void main() {

        String name, winsStr;

        int wins;

        double award;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        name = JOptionPane.showInputDialog(null,
                "Informe seu nome: ",
                "Conteúdo 07 | Exercício 01",
                JOptionPane.QUESTION_MESSAGE);

        winsStr = JOptionPane.showInputDialog(null,
                "Informe seu número de acertos: ",
                "Conteúdo 07 | Exercício 01",
                JOptionPane.QUESTION_MESSAGE);

        wins = Integer.valueOf(winsStr);

        // Processamento: Tratar as faixas baixas de acertos com if e selecionar o prêmio de 11, 12
        // ou 13 acertos com switch.
        if (wins <= 5) {
            // Saída: apresentar a mensagem correspondente ao resultado atual.
            JOptionPane.showMessageDialog(null,
                    name + ", você acertou muito pouco e não receberá nenhum prêmio!",
                    "Conteúdo 07 | Exercício 01",
                    JOptionPane.ERROR_MESSAGE);
        } else if (wins <= 10) {
            
            JOptionPane.showMessageDialog(null,
                    name + ", você acertou muito pouco, mas receberá um novo cartao!",
                    "Conteúdo 07 | Exercício 01",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {

            switch (wins) {
                case 11 -> {
                    
                    award = 100.00;
                }
                case 12 -> {
                    
                    award = 1000.00;
                }
                case 13 -> {
                    
                    award = 50000.00;
                }
                default -> {
                    
                    award = 0;
                    JOptionPane.showMessageDialog(null,
                            name + ", você não informou um número de acertos válidos! O seu prêmio foi zerado.",
                            "Conteúdo 07 | Exercício 01",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            JOptionPane.showMessageDialog(null,
                    name + ", você acertou " + wins + " e receberá o prêmio de: R$" + award,
                    "Conteúdo 07 | Exercício 01",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
```

</details>
