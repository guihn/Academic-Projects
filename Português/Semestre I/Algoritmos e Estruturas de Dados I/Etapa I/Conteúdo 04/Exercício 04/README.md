<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2004/Exercise%2004">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2004">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 04 · Nome e idade em caixas de diálogo

## Descrição

**Resumo do enunciado:** Ler as partes do nome e a idade e apresentá-las usando caixas de diálogo.

**Fonte do enunciado:** [slides originais da aula](https://github.com/guihn/academic-materials/blob/5a9473bbf24a271032a41b141ab6bd435076c1d5/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2004/Algoritmos%20-%20Aulas%20-%20Conte%C3%BAdo%204%20-%20Comandos%20de%20IO%20%E2%80%93%20SCANNER%2C%20PRINT.pptx), slide(s) 62. [Pasta do material](https://github.com/guihn/academic-materials/tree/main/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2004).

**Código fornecido:** [C04ex04.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/FirstStage/C04ex04.java).

## Solução

Converter a idade de texto para inteiro e exibir o sobrenome antes dos demais nomes.

[Arquivo fonte: C04ex04.java](https://github.com/guihn/Academic-Projects/blob/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2004/Exerc%C3%ADcio%2004/src/C04ex04.java) · [Baixar](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2004/Exerc%C3%ADcio%2004/src/C04ex04.java)

<details>
<summary>💻 | Código Java</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Converter a idade de texto para inteiro e exibir o sobrenome antes dos demais nomes.
 *
 * Atividade: C04ex04.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C04ex04 {

    static void main() {

        String name, midname, surname, agestr;

        int age;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        name = JOptionPane.showInputDialog(null,
                "Informe o seu primeiro nome:",
                "Conteúdo 04 | Exercício 04",
                JOptionPane.QUESTION_MESSAGE);

        midname = JOptionPane.showInputDialog(null,
                "Informe o seu segundo nome:",
                "Conteúdo 04 | Exercício 04",
                JOptionPane.QUESTION_MESSAGE);

        surname = JOptionPane.showInputDialog(null,
                "Informe o seu sobrenome:",
                "Conteúdo 04 | Exercício 04",
                JOptionPane.QUESTION_MESSAGE);

        agestr = JOptionPane.showInputDialog(null,
                "Informe a sua idade:",
                "Conteúdo 04 | Exercício 04",
                JOptionPane.QUESTION_MESSAGE);

        // Processamento: Converter a idade de texto para inteiro e exibir o sobrenome antes dos
        // demais nomes.
        age = Integer.valueOf(agestr);

        // Saída: apresentar a mensagem correspondente ao resultado atual.
        JOptionPane.showMessageDialog(null,
                surname + ", " + name + " " + midname + "\n" + age + " anos.",
                "Conteúdo 04 | Exercício 04",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
```

</details>
