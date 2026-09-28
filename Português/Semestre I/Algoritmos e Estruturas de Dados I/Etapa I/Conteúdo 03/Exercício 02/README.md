<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2003/Exercise%2002">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2003">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 02 · Média aritmética

## Descrição

**Resumo do enunciado:** Adaptar o exemplo que lê três inteiros e calcula sua média aritmética.

**Código fornecido:** [C03ex02.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/FirstStage/C03ex02.java).

## Solução

Somar os três valores long e dividir a soma por 3.0 para preservar a parte fracionária.

[Arquivo fonte: C03ex02.java](https://github.com/guihn/Academic-Projects/blob/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2003/Exerc%C3%ADcio%2002/src/C03ex02.java) · [Baixar](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2003/Exerc%C3%ADcio%2002/src/C03ex02.java)

<details>
<summary>💻 | Código Java</summary>

```java
package FirstStage;

import java.util.Scanner;

/**
 * Somar os três valores long e dividir a soma por 3.0 para preservar a parte fracionária.
 *
 * Atividade: C03ex02.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C03ex02 {

    public static void main(String[] args) {

        long n1, n2, n3, soma;

        double media;

        // Entrada: ler os valores informados pelo console.
        Scanner teclado = new Scanner(System.in);

        System.out.print("Informe o primeiro número: ");
        n1 = teclado.nextLong();

        System.out.print("Informe o segundo número: ");
        n2 = teclado.nextLong();

        System.out.print("Informe o terceiro número: ");
        n3 = teclado.nextLong();

        // Processamento: Somar os três valores long e dividir a soma por 3.0 para preservar a parte
        // fracionária.
        soma = n1 + n2 + n3;

        media = soma / 3.0;

        // Saída: apresentar a mensagem correspondente ao resultado atual.
        System.out.println("A média é " + media);

        teclado.close();
    }
}
```

</details>
