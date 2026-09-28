<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/First%20Assessment/Question%20A">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Primeira%20Avalia%C3%A7%C3%A3o">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Questão A · Cálculo de função da avaliação

## Descrição

Descrição do código: ler x e combinar uma expressão com potência e duas variáveis intermediárias. O enunciado original da avaliação não está disponível.

**Código fornecido:** [D30912A.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/FirstStage/FirstTest/D30912A.java).

## Solução

Calcular c1 = 0.75x⁷ − 4, atribuir (5 + x)/2 a c3 e c2 e avaliar c1 × c2 + c3.

### Observações da implementação

As linhas originais c2 = e c3 = (5 + x) / 2 formam uma atribuição encadeada. Sem o enunciado da avaliação, não é possível confirmar a fórmula pretendida.

[Arquivo fonte: D30912A.java](https://github.com/guihn/Academic-Projects/blob/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Primeira%20Avalia%C3%A7%C3%A3o/Quest%C3%A3o%20A/src/D30912A.java) · [Baixar](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Primeira%20Avalia%C3%A7%C3%A3o/Quest%C3%A3o%20A/src/D30912A.java)

<details>
<summary>💻 | Código Java</summary>

```java
package FirstTest;

import javax.swing.JOptionPane;
import java.util.Scanner;

/**
 * Calcular c1 = 0.75x⁷ − 4, atribuir (5 + x)/2 a c3 e c2 e avaliar c1 × c2 + c3.
 *
 * Atividade: D30912A.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class D30912A {
    static void main() {
        String xStr;
        double x, fx, c1, c2, c3;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        xStr = JOptionPane.showInputDialog(null,
                "Informe o valor de X",
                "Primeira Avaliação | Questão A",
                JOptionPane.QUESTION_MESSAGE);

        x = Double.valueOf(xStr);

        // Processamento: Calcular c1 = 0.75x⁷ − 4, atribuir (5 + x)/2 a c3 e c2 e avaliar c1 × c2 +
        // c3.
        c1 = 3.0/4 * Math.pow(x, 7) - 4;
        // A próxima linha continua esta atribuição encadeada a c2 e c3.
        c2 =
        c3 = (5 + x) / 2;

        fx = c1 * c2 + c3;

        // Saída: apresentar a mensagem correspondente ao resultado atual.
        JOptionPane.showMessageDialog(null,
                "X: " + x + "\nf(x): " + fx,
                "Primeira Avaliação | Questão A",
                JOptionPane.INFORMATION_MESSAGE);

    }
}
```

</details>
