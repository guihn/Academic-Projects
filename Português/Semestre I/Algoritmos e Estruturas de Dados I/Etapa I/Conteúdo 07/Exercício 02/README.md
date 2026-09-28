<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2007/Exercise%2002">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2007">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 02 · Conceitos das notas

## Descrição

**Resumo do enunciado:** Ler três notas inteiras, obter a parte inteira da média e atribuir o conceito da tabela do slide.

**Fonte do enunciado:** [slides originais da aula](https://github.com/guihn/academic-materials/blob/5a9473bbf24a271032a41b141ab6bd435076c1d5/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2007/Algoritmos%20-%20Aulas%20-%20Conte%C3%BAdo%207%20-%20Comando%20Condicional%20%E2%80%93%20SWITCH.pptx), slide(s) 18. [Pasta do material](https://github.com/guihn/academic-materials/tree/main/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2007).

**Código fornecido:** [C07ex02.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/FirstStage/C07ex02.java).

## Solução

Usar divisão inteira na média e selecionar o texto de saída com switch.

### Observações da implementação

O código contém uma mensagem adicional para média zero e valida a média final em vez de cada nota de entrada. A mensagem para zero não está definida na tabela do slide.

[Arquivo fonte: C07ex02.java](https://github.com/guihn/Academic-Projects/blob/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2007/Exerc%C3%ADcio%2002/src/C07ex02.java) · [Baixar](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2007/Exerc%C3%ADcio%2002/src/C07ex02.java)

<details>
<summary>💻 | Código Java</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Usar divisão inteira na média e selecionar o texto de saída com switch.
 *
 * Atividade: C07ex02.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C07ex02 {

    static void main() {

        String parcialNoteOneStr, parcialNoteTwoStr, parcialNoteThreeStr, concept;

        int parcialNoteOne, parcialNoteTwo, parcialNoteThree, finalNote, media;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        parcialNoteOneStr = JOptionPane.showInputDialog(null,
                "Informe sua 1° nota: ",
                "Conteúdo 07 | Exercício 02",
                JOptionPane.QUESTION_MESSAGE);

        parcialNoteTwoStr = JOptionPane.showInputDialog(null,
                "Informe sua 2° nota: ",
                "Conteúdo 07 | Exercício 02",
                JOptionPane.QUESTION_MESSAGE);

        parcialNoteThreeStr = JOptionPane.showInputDialog(null,
                "Informe sua 3° nota: ",
                "Conteúdo 07 | Exercício 02",
                JOptionPane.QUESTION_MESSAGE);

        parcialNoteOne = Integer.valueOf(parcialNoteOneStr);
        parcialNoteTwo = Integer.valueOf(parcialNoteTwoStr);
        parcialNoteThree = Integer.valueOf(parcialNoteThreeStr);

        // Processamento: Usar divisão inteira na média e selecionar o texto de saída com switch.
        finalNote = (parcialNoteOne + parcialNoteTwo + parcialNoteThree) / 3;

        switch (finalNote) {
            
            case 9, 10 ->
                    concept = "A";
            
            case 8 ->
                    concept = "B";
            
            case 7 ->
                    concept = "C";
            
            case 5, 6 ->
                    concept = "D";
            
            case 1, 2, 3, 4 ->
                    concept = "E";
            case 0 ->
                concept = "Desiste da sua vida";
            
            default ->
                    concept = "Você não inseriu notas até 10.";
        }

        // Saída: apresentar a mensagem correspondente ao resultado atual.
        JOptionPane.showMessageDialog(null,
                "Conceito: " + concept,
                "Conteúdo 07 | Exercício 02",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
```

</details>
