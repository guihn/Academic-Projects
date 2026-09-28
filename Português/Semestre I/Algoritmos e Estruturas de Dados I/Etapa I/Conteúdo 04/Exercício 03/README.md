<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2004/Exercise%2003">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2004">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 03 · Tabela de multas por poluentes

## Descrição

**Resumo do enunciado:** Ler dois limites de emissão e três valores de multa e montar a tabela descrita nos slides.

**Fonte do enunciado:** [slides originais da aula](https://github.com/guihn/academic-materials/blob/5a9473bbf24a271032a41b141ab6bd435076c1d5/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2004/Algoritmos%20-%20Aulas%20-%20Conte%C3%BAdo%204%20-%20Comandos%20de%20IO%20%E2%80%93%20SCANNER%2C%20PRINT.pptx), slide(s) 37–38. [Pasta do material](https://github.com/guihn/academic-materials/tree/main/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2004).

**Código fornecido:** [C04ex03.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/FirstStage/C04ex03.java).

## Solução

Ler os parâmetros da tabela e exibir suas três faixas de emissão sem calcular a multa de uma empresa específica.

[Arquivo fonte: C04ex03.java](https://github.com/guihn/Academic-Projects/blob/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2004/Exerc%C3%ADcio%2003/src/C04ex03.java) · [Baixar](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2004/Exerc%C3%ADcio%2003/src/C04ex03.java)

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
