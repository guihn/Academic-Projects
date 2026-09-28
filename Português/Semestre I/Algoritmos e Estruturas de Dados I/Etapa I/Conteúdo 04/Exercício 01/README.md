<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2004/Exercise%2001">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2004">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 01 · Nome e idade no console

## Descrição

**Resumo do enunciado:** Ler primeiro nome, nome do meio, sobrenome e idade e apresentar o sobrenome antes dos demais nomes.

**Código fornecido:** [C04ex01.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/FirstStage/C04ex01.java).

## Solução

Ler os campos de texto antes da idade inteira e reuni-los na mensagem do console.

[Arquivo fonte: C04ex01.java](https://github.com/guihn/Academic-Projects/blob/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2004/Exerc%C3%ADcio%2001/src/C04ex01.java) · [Baixar](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2004/Exerc%C3%ADcio%2001/src/C04ex01.java)

<details>
<summary>💻 | Código Java</summary>

```java
package FirstStage;

import java.util.Scanner;

/**
 * Ler os campos de texto antes da idade inteira e reuni-los na mensagem do console.
 *
 * Atividade: C04ex01.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C04ex01 {

    public static void main() {

        String name, midname, surname;

        int age;

        // Entrada: ler os valores informados pelo console.
        Scanner kb = new Scanner(System.in);

        System.out.print("Informe o seu primeiro nome: ");
        name = kb.nextLine();

        System.out.print("Informe o seu segundo nome: ");
        midname = kb.nextLine();

        System.out.print("Informe o seu sobrenome: ");
        surname = kb.nextLine();

        System.out.print("Informe a sua idade: ");
        age = kb.nextInt();

        // Processamento: Ler os campos de texto antes da idade inteira e reuni-los na mensagem do
        // console.
        // Saída: apresentar a mensagem correspondente ao resultado atual.
        System.out.println(surname + ", " + name + " " + midname + "\nIdade: " + age);

        kb.close();
    }
}
```

</details>
