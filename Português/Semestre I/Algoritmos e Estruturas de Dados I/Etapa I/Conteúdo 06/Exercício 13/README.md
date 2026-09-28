<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006/Exercise%2013">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 13 · Duração de um jogo

## Descrição

**Resumo do enunciado:** Ler horas e minutos de início e fim de um jogo que começa e termina no mesmo dia.

**Código fornecido:** [C06ex13.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/FirstStage/C06ex13.java).

## Solução

Subtrair os horários e emprestar uma hora quando a diferença de minutos for negativa.

[Arquivo fonte: C06ex13.java](https://github.com/guihn/Academic-Projects/blob/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2013/src/C06ex13.java) · [Baixar](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2013/src/C06ex13.java)

<details>
<summary>💻 | Código Java</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Subtrair os horários e emprestar uma hora quando a diferença de minutos for negativa.
 *
 * Atividade: C06ex13.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex13 {

    static void main() {

        String initialHourStr, initialMinuteStr, finalHourStr, finalMinuteStr;

        int initialHour, initialMinute, finalHour, finalMinute, durationHour, durationMinute;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        initialHourStr = JOptionPane.showInputDialog(null,
                "Informe a hora inicial: ",
                "Conteúdo 06 | Exercício 13",
                JOptionPane.QUESTION_MESSAGE);

        initialMinuteStr = JOptionPane.showInputDialog(null,
                "Informe o minuto inicial: ",
                "Conteúdo 06 | Exercício 13",
                JOptionPane.QUESTION_MESSAGE);

        finalHourStr = JOptionPane.showInputDialog(null,
                "Informe a hora final: ",
                "Conteúdo 06 | Exercício 13",
                JOptionPane.QUESTION_MESSAGE);

        finalMinuteStr = JOptionPane.showInputDialog(null,
                "Informe o minuto final: ",
                "Conteúdo 06 | Exercício 13",
                JOptionPane.QUESTION_MESSAGE);

        initialHour = Integer.valueOf(initialHourStr);
        initialMinute = Integer.valueOf(initialMinuteStr);
        finalHour = Integer.valueOf(finalHourStr);
        finalMinute = Integer.valueOf(finalMinuteStr);

        // Processamento: Subtrair os horários e emprestar uma hora quando a diferença de minutos
        // for negativa.
        durationHour = finalHour - initialHour;
        durationMinute = finalMinute - initialMinute;

        // Emprestar uma hora e convertê-la em 60 minutos.
        if (durationMinute < 0) {
            durationHour = durationHour - 1;
            durationMinute = durationMinute + 60;
        }

        else {
            durationHour = durationHour;
            durationMinute = durationMinute;
        }

        // Saída: apresentar a mensagem correspondente ao resultado atual.
        JOptionPane.showMessageDialog(null,
                "Duração: " + durationHour + " horas e " + durationMinute + " minutos.");
    }
}
```

</details>
