<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2007/Exercise%2002">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2007">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 02 · Conceitos das notas

## Descrição

A atividade transforma três notas parciais em um conceito por letra. Primeiro é calculada a média aritmética, cuja parte decimal deve ser descartada. A parte inteira determina uma das categorias da tabela, permitindo praticar seleção múltipla com valores discretos.

## Enunciado

Leia três notas inteiras entre 0 e 10. Calcule a nota final como a parte inteira da média aritmética e imprima o conceito:

| Nota&nbsp;final | Conceito |
| --- | --- |
| 9 ou 10 | A |
| 8 | B |
| 7 | C |
| 5 ou 6 | D |
| 1, 2, 3 ou 4 | E |

A tabela do enunciado não define conceito para a nota final zero.

## Solução

Usar divisão inteira na média e selecionar o texto de saída com switch.

### Observações da implementação

O código contém uma mensagem adicional para média zero e valida a média final em vez de cada nota de entrada. A mensagem para zero não está definida na tabela do slide.

Arquivo fonte: [C07ex02.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2007/Exerc%C3%ADcio%2002/src/C07ex02.java)

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
