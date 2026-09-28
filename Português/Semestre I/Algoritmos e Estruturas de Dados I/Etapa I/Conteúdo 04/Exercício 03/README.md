<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2004/Exercise%2003">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2004">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 03 · Tabela de multas por poluentes

## Descrição

O programa monta uma tabela de multas ambientais a partir de parâmetros definidos pelo usuário. São informados dois limites de emissão e três valores de multa, que compõem as faixas inferior, intermediária e superior. A saída apresenta a tabela completa; esta atividade não recebe a emissão de uma empresa para calcular uma multa individual.

## Enunciado

Uma secretaria ambiental aplica multas conforme a quantidade de poluentes emitidos. Solicite os dois limites e os três valores variáveis da tabela e apresente as regras:

| Quantidade&nbsp;emitida | Multa |
| --- | --- |
| Até o primeiro limite | Primeiro valor de multa |
| Acima do primeiro limite até o segundo | Segundo valor de multa |
| Acima do segundo limite | Terceiro valor por unidade de poluente emitida |

## Solução

Ler os parâmetros da tabela e exibir suas três faixas de emissão sem calcular a multa de uma empresa específica.

Arquivo fonte: [C04ex03.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2004/Exerc%C3%ADcio%2003/src/C04ex03.java)

<details>
<summary>💻 | Código Java</summary>

```java
package FirstStage;

import java.util.Scanner;

/**
 * Ler os parâmetros da tabela e exibir suas três faixas de emissão sem calcular a multa de uma
 * empresa específica.
 *
 * Atividade: C04ex03.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C04ex03 {

    static void main() {

        int poluentex, poluentey;

        double multadex, multaxatey, multadey;

        // Entrada: ler os valores informados pelo console.
        Scanner kb = new Scanner(System.in);

        System.out.print("Quantidade de poluente X: ");
        poluentex = kb.nextInt();

        System.out.print("Valor da multa para a quantidade X: ");
        multadex = kb.nextDouble();

        System.out.print("Quantidade de poluente Y (valor maior que X): ");
        poluentey = kb.nextInt();

        System.out.print("Valor da multa para a quantidade entre X e Y: ");
        multaxatey = kb.nextDouble();

        System.out.print("Valor da multa para a quantidade acima de Y: ");
        multadey = kb.nextDouble();

        kb.close();

        // Processamento: Ler os parâmetros da tabela e exibir suas três faixas de emissão sem
        // calcular a multa de uma empresa específica.
        // Saída: apresentar a mensagem correspondente ao resultado atual.
        System.out.println("Quantidade de Poluente Emitido x Valor da Multa");

        System.out.println("\nAté " + poluentex + " multa de R$" + multadex);

        System.out.println("Acima de " + poluentex + " até " + poluentey + " multa de R$" + multaxatey);

        System.out.println("Acima de " + poluentey + " multa de R$" + multadey + " por poluente emitido.");
    }
}
```

</details>
