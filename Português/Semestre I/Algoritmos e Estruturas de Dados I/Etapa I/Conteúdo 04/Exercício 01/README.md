<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2004/Exercise%2001">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2004">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 01 · Nome e idade no console

## Descrição

O programa organiza os dados de identificação de uma pessoa em uma apresentação de duas linhas no console. Primeiro nome, nome do meio, sobrenome e idade são lidos separadamente, permitindo rearranjar os nomes na saída. O sobrenome deve aparecer primeiro, seguido dos demais nomes; a idade ocupa a linha seguinte.

## Enunciado

Solicite o primeiro nome, o nome do meio, o sobrenome e a idade do usuário. Apresente os dados neste formato:

```text
Sobrenome, PrimeiroNome SegundoNome
Idade: 99 anos.
```

## Solução

Ler os campos de texto antes da idade inteira e reuni-los na mensagem do console.

Arquivo fonte: [C04ex01.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2004/Exerc%C3%ADcio%2001/src/C04ex01.java)

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
