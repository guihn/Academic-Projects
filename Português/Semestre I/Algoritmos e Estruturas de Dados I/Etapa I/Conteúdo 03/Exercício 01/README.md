<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2003/Exercise%2001">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2003">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 01 · Fatorial

## Descrição

**Resumo do enunciado:** Adaptar o exemplo de fatorial ao nome da classe do exercício e conferir o cálculo para uma entrada inteira.

**Código fornecido:** [C03ex01.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/FirstStage/C03ex01.java).

## Solução

Inicializar o produto em 1 e multiplicá-lo por cada inteiro de 2 até o número informado.

### Observações da implementação

O programa não rejeita entradas negativas nem detecta estouro do tipo long.

[Arquivo fonte: C03ex01.java](https://github.com/guihn/Academic-Projects/blob/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2003/Exerc%C3%ADcio%2001/src/C03ex01.java) · [Baixar](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2003/Exerc%C3%ADcio%2001/src/C03ex01.java)

<details>
<summary>💻 | Código Java</summary>

```java
package FirstStage;

import java.util.Scanner;

/**
 * Inicializar o produto em 1 e multiplicá-lo por cada inteiro de 2 até o número informado.
 *
 * Atividade: C03ex01.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C03ex01 {

    public static void main(String[] args) {

        long numero, fatorial, contador;

        // Entrada: ler os valores informados pelo console.
        Scanner teclado = new Scanner(System.in);

        System.out.print("Informe um número: ");
        numero = teclado.nextLong();

        teclado.close();

        // Processamento: Inicializar o produto em 1 e multiplicá-lo por cada inteiro de 2 até o
        // número informado.
        fatorial = 1L;

        // O produto acumulado contém o fatorial até o valor anterior do contador.
        for (contador = 2; contador <= numero; contador++) {
            
            fatorial = fatorial * contador;
        }

        // Saída: apresentar a mensagem correspondente ao resultado atual.
        System.out.println("Fatorial = " + fatorial);
    }
}
```

</details>
