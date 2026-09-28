<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006/Exercise%2016">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 16 · Classificação da nota final

## Descrição

**Resumo do enunciado:** Usar as duas maiores notas de prova, trabalho final, faltas e idade para calcular e classificar a nota final conforme as tabelas do exercício.

**Fonte do enunciado:** [slides originais da aula](https://github.com/guihn/academic-materials/blob/5a9473bbf24a271032a41b141ab6bd435076c1d5/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2006/Algoritmos%20-%20Aulas%20-%20Conte%C3%BAdo%206%20-%20Comando%20Condicional%20%E2%80%93%20IF%2C%20Express%C3%B5es%20Booleanas.pptx), slide(s) 58. [Pasta do material](https://github.com/guihn/academic-materials/tree/main/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2006).

**Código fornecido:** [C06ex16.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/FirstStage/C06ex16.java).

## Solução

Descartar a menor nota de prova, escolher os dois pesos e classificar a expressão ponderada nas cinco faixas de nota.

[Arquivo fonte: C06ex16.java](https://github.com/guihn/Academic-Projects/blob/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2016/src/C06ex16.java) · [Baixar](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2016/src/C06ex16.java)

<details>
<summary>💻 | Código Java</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Descartar a menor nota de prova, escolher os dois pesos e classificar a expressão ponderada
 * nas cinco faixas de nota.
 *
 * Atividade: C06ex16.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex16 {

    static void main() {

        String absencesStr, firstTestStr, secondTestStr, thirdTestStr, finalWorkStr, studentAgeStr;

        int absences, weightOne, weightTwo, studentAge;

        double firstTest, secondTest, thirdTest, highestNoteOne, highestNoteTwo, finalWork, finalNote;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        absencesStr = JOptionPane.showInputDialog(null,
                "Informe a quantidade de faltas: ",
                "Conteúdo 06 | Exercício 16",
                JOptionPane.QUESTION_MESSAGE);

        firstTestStr = JOptionPane.showInputDialog(null,
                "Informe a nota da 1° prova: ",
                "Conteúdo 06 | Exercício 16",
                JOptionPane.QUESTION_MESSAGE);

        secondTestStr = JOptionPane.showInputDialog(null,
                "Informe a nota da 2° prova: ",
                "Conteúdo 06 | Exercício 16",
                JOptionPane.QUESTION_MESSAGE);

        thirdTestStr = JOptionPane.showInputDialog(null,
                "Informe a nota da 3° prova: ",
                "Conteúdo 06 | Exercício 16",
                JOptionPane.QUESTION_MESSAGE);

        finalWorkStr = JOptionPane.showInputDialog(null,
                "Informe a nota do trabalho final: ",
                "Conteúdo 06 | Exercício 16",
                JOptionPane.QUESTION_MESSAGE);

        studentAgeStr = JOptionPane.showInputDialog(null,
                "Informe sua idade: ",
                "Conteúdo 06 | Exercício 16",
                JOptionPane.QUESTION_MESSAGE);

        absences = Integer.valueOf(absencesStr);
        firstTest = Double.valueOf(firstTestStr);
        secondTest = Double.valueOf(secondTestStr);
        thirdTest = Double.valueOf(thirdTestStr);
        finalWork = Double.valueOf(finalWorkStr);
        studentAge = Integer.valueOf(studentAgeStr);

        // Processamento: Descartar a menor nota de prova, escolher os dois pesos e classificar a
        // expressão ponderada nas cinco faixas de nota.
        if (firstTest <= secondTest && firstTest <= thirdTest) {
            highestNoteOne = secondTest;
            highestNoteTwo = thirdTest;
        }
        
        else if (secondTest <= firstTest && secondTest <= thirdTest) {
            highestNoteOne = firstTest;
            highestNoteTwo = thirdTest;
        }
        
        else {
            highestNoteOne = firstTest;
            highestNoteTwo = secondTest;
        }

        if (absences <= 5)
            weightOne = 3;
            
        else if (absences <= 10)
            weightOne = 2;
            
        else
            weightOne = 1;

        if (studentAge <= 17)
            weightTwo = 1;
            
        else if (studentAge <= 50)
            weightTwo = 2;
            
        else
            weightTwo = 3;

        finalNote = (highestNoteOne + highestNoteTwo) / 2 * weightOne + finalWork * weightTwo;

        if (finalNote <= 50)
            // Saída: apresentar a mensagem correspondente ao resultado atual.
            JOptionPane.showMessageDialog(null,
                    "Reprovado!",
                    "Conteúdo 06 | Exercício 16",
                    JOptionPane.ERROR_MESSAGE);
            
        else if (finalNote <= 70)
            JOptionPane.showMessageDialog(null,
                    "Regular!",
                    "Conteúdo 06 | Exercício 16",
                    JOptionPane.INFORMATION_MESSAGE);
            
        else if (finalNote <= 80)
            JOptionPane.showMessageDialog(null,
                    "Bom!",
                    "Conteúdo 06 | Exercício 16",
                    JOptionPane.INFORMATION_MESSAGE);
            
        else if (finalNote <= 90)
            JOptionPane.showMessageDialog(null,
                    "Muito bom!",
                    "Conteúdo 06 | Exercício 16",
                    JOptionPane.INFORMATION_MESSAGE);
            
        else
            JOptionPane.showMessageDialog(null,
                    "Excelente!",
                    "Conteúdo 06 | Exercício 16",
                    JOptionPane.INFORMATION_MESSAGE);
    }
}
```

</details>
