<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006/Exercise%2017">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 17 · Questionário para vaga de programação

## Descrição

**Resumo do enunciado:** Fazer nove perguntas e avaliar as condições de formação, experiência e preferências listadas no exercício.

**Fonte do enunciado:** [slides originais da aula](https://github.com/guihn/academic-materials/blob/5a9473bbf24a271032a41b141ab6bd435076c1d5/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2006/Algoritmos%20-%20Aulas%20-%20Conte%C3%BAdo%206%20-%20Comando%20Condicional%20%E2%80%93%20IF%2C%20Express%C3%B5es%20Booleanas.pptx), slide(s) 59–60. [Pasta do material](https://github.com/guihn/academic-materials/tree/main/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2006).

**Código fornecido:** [C06ex17.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/FirstStage/C06ex17.java).

## Solução

Armazenar as comparações das opções das janelas e combiná-las com E, OU, negação e uma comparação de preferências exclusivas.

### Observações da implementação

Os botões estão na ordem Sim/Não, mas toda resposta vira true quando o índice 1 (Não) é selecionado. Isso inverte o significado esperado pelos nomes das variáveis.

[Arquivo fonte: C06ex17.java](https://github.com/guihn/Academic-Projects/blob/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2017/src/C06ex17.java) · [Baixar](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2017/src/C06ex17.java)

<details>
<summary>💻 | Código Java</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Armazenar as comparações das opções das janelas e combiná-las com E, OU, negação e uma
 * comparação de preferências exclusivas.
 *
 * Atividade: C06ex17.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex17 {

    static void main() {

        boolean tecnicianCourse, higherCourse, threeYearsOfExp, criativePearson, leadOrBeLead, workLonelyorinTeam, selfTaught, initialSalary, onlyBH, apt, tecnicianCourseandExp;

        // O índice de opção 1 é Não. As comparações existentes invertem, portanto, as respostas
        // afirmativas.
        Object[] buttons = {"Sim", "Não"};

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        tecnicianCourse = JOptionPane.showOptionDialog(null,
                "1 | 9 - Você possui curso técnico?",
                "Conteúdo 06 | Exercício 17",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                buttons,
                buttons[1]) == 1;

        higherCourse = JOptionPane.showOptionDialog(null,
                "2 | 9 - Você possui curso superior?",
                "Conteúdo 06 | Exercício 17",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                buttons,
                buttons[1]) == 1;

        threeYearsOfExp = JOptionPane.showOptionDialog(null,
                "3 | 9 - Você possui menos de 3 anos de experiência?",
                "Conteúdo 06 | Exercício 17",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                buttons,
                buttons[1]) == 1;

        criativePearson = JOptionPane.showOptionDialog(null,
                "4 | 9 - Você se considera uma pessoa criativa?",
                "Conteúdo 06 | Exercício 17",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                buttons,
                buttons[1]) == 1;

        leadOrBeLead = JOptionPane.showOptionDialog(null,
                "5 | 9 - Você prefere liderar a ser liderado?",
                "Conteúdo 06 | Exercício 17",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                buttons,
                buttons[1]) == 1;

        workLonelyorinTeam = JOptionPane.showOptionDialog(null,
                "6 | 9 - Você prefere trabalhar sozinho?",
                "Conteúdo 06 | Exercício 17",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                buttons,
                buttons[1]) == 1;

        selfTaught = JOptionPane.showOptionDialog(null,
                "7 | 9 - Você é autodidata (aprende sozinho)?",
                "Conteúdo 06 | Exercício 17",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                buttons,
                buttons[1]) == 1;

        initialSalary = JOptionPane.showOptionDialog(null,
                "8 | 9 - Você aceitaria uma remuneração inicial de até R$1.500,00?",
                "Conteúdo 06 | Exercício 17",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                buttons,
                buttons[1]) == 1;

        onlyBH = JOptionPane.showOptionDialog(null,
                "9 | 9 - Você só aceitaria trabalhar em escritórios da empresa dentro da Grande BH?",
                "Conteúdo 06 | Exercício 17",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                buttons,
                buttons[1]) == 1;

        // Processamento: Armazenar as comparações das opções das janelas e combiná-las com E, OU,
        // negação e uma comparação de preferências exclusivas.
        tecnicianCourseandExp = tecnicianCourse && !threeYearsOfExp;

        if (higherCourse || tecnicianCourseandExp) {

            if (leadOrBeLead != initialSalary) {

                if (criativePearson && !workLonelyorinTeam && selfTaught && !onlyBH) {
                    apt = true;
                } else apt = false;
            } else apt = false;
        } else apt = false;

        if (apt == true) {
            // Saída: apresentar a mensagem correspondente ao resultado atual.
            JOptionPane.showMessageDialog(null,
                    "Essa pessoa está APTA!",
                    "Conteúdo 06 | Exercício 17",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            
            JOptionPane.showMessageDialog(null,
                    "Essa pessoa está INAPTA!",
                    "Conteúdo 06 | Exercício 17",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
```

</details>
