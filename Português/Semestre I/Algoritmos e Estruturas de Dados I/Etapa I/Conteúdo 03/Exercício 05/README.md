<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2003/Exercise%2005">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2003">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 05 · Idade em um ano informado

## Descrição

**Resumo do enunciado:** Adaptar o exemplo de idade, lendo nome, ano de nascimento e ano de referência.

## Solução

Subtrair o ano de nascimento do ano de referência para obter a idade completada naquele ano.

Arquivo fonte: [C03ex05.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2003/Exerc%C3%ADcio%2005/src/C03ex05.java)

<details>
<summary>💻 | Código Java</summary>

```java
package FirstStage;

import java.util.Scanner;

/**
 * Subtrair o ano de nascimento do ano de referência para obter a idade completada naquele ano.
 *
 * Atividade: C03ex05.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C03ex05 {

    public static void main(String[] args) {

        String nome;

        int anoNasc, anoAtual, idade;

        // Entrada: ler os valores informados pelo console.
        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite o seu nome: ");
        nome = teclado.nextLine();

        System.out.print("Digite o ano em que você nasceu: ");
        anoNasc = teclado.nextInt();

        System.out.print("Digite o ano atual: ");
        anoAtual = teclado.nextInt();

        // Processamento: Subtrair o ano de nascimento do ano de referência para obter a idade
        // completada naquele ano.
        idade = anoAtual - anoNasc;

        teclado.close();

        // Saída: apresentar a mensagem correspondente ao resultado atual.
        System.out.println(nome + ", você tem/terá " + idade + " anos em " + anoAtual);
    }
}
```

</details>
