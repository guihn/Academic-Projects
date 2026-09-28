<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20II/Content%2008/Exercise%2007">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20II/Conte%C3%BAdo%2008">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 07 · Estatísticas de idades

## Descrição

**Resumo do enunciado:** Ler 50 alunos e informar quantos têm até 12 anos, quantos têm mais de 30 e a média geral de idade.

**Fonte do enunciado:** [slides originais da aula](https://github.com/guihn/academic-materials/blob/5a9473bbf24a271032a41b141ab6bd435076c1d5/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20II/Contents/Content%2008/Algoritmos%20-%20Aulas%20-%20Conte%C3%BAdo%208%20-%20Comando%20de%20Repeti%C3%A7%C3%A3o%20%E2%80%93%20FOR.pptx), slide(s) 61. [Pasta do material](https://github.com/guihn/academic-materials/tree/main/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20II/Contents/Content%2008).

**Código fornecido:** [C08ex07.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/SecondStage/C08ex07.java).

## Solução

Acumular todas as idades, manter contadores por faixa e dividir a soma das idades pela quantidade de registros.

### Observações da implementação

A condição original inclui a idade de 30 anos na faixa superior, enquanto o enunciado pede idades acima de 30.

[Arquivo fonte: C08ex07.java](https://github.com/guihn/Academic-Projects/blob/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20II/Conte%C3%BAdo%2008/Exerc%C3%ADcio%2007/src/C08ex07.java) · [Baixar](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20II/Conte%C3%BAdo%2008/Exerc%C3%ADcio%2007/src/C08ex07.java)

<details>
<summary>💻 | Código Java</summary>

```java
package SecondStage;

import javax.swing.JOptionPane;
import java.awt.*;

/**
 * Acumular todas as idades, manter contadores por faixa e dividir a soma das idades pela
 * quantidade de registros.
 *
 * Atividade: C08ex07.
 */
public class C08ex07 {
    static void main() {
        String name, ageStr;
        int age, allages, untiltwelve, higherthirty, rep;
        float mediaOfAllAges;

        allages = 0;
        untiltwelve = 0;
        higherthirty = 0;
        rep = 50;

        // Processamento: Acumular todas as idades, manter contadores por faixa e dividir a soma das
        // idades pela quantidade de registros.
        for (int i = 1; i <= rep; i ++) {
            // Entrada: coletar os valores solicitados por caixas de diálogo.
            name = JOptionPane.showInputDialog(null,
                    "Informe seu nome:",
                    "Conteúdo 08 | Exercício 07",
                    JOptionPane.QUESTION_MESSAGE);
            ageStr = JOptionPane.showInputDialog(null,
                    "Informe sua idade:",
                    "Conteúdo 08 | Exercício 07",
                    JOptionPane.QUESTION_MESSAGE);
            age = Integer.parseInt(ageStr);

            if (age <=12) {
                untiltwelve++;
                allages += age;
            }
            // A comparação original inclui a idade de 30 anos neste grupo.
            else if (age >=30) {
                higherthirty++;
                allages += age;
            }
            else {
                allages += age;
            }
        }

        mediaOfAllAges = (float) allages / rep;
        // Saída: apresentar a mensagem correspondente ao resultado atual.
        JOptionPane.showMessageDialog(null,
                "Alunos que possuem idade de até 12 anos: " + untiltwelve + "\nAlunos que possuem idade acima de 30 anos: " + higherthirty + "\nMédia das idades informadas: " + mediaOfAllAges );
    }
}
```

</details>
