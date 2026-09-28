<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2003/Exercise%2003">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2003">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 03 · Hipotenusa

## Descrição

**Resumo do enunciado:** Usar o programa de hipotenusa fornecido como base do exercício e calcular a hipotenusa a partir dos dois catetos.

**Fonte do enunciado:** [slides originais da aula](https://github.com/guihn/academic-materials/blob/5a9473bbf24a271032a41b141ab6bd435076c1d5/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2003/Algoritmos%20-%20Aulas%20-%20Conte%C3%BAdo%203%20-%20Compiladores%2C%20Dados%20e%20Vari%C3%A1veis.pptx), slide(s) 69. [Pasta do material](https://github.com/guihn/academic-materials/tree/main/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2003).

**Código fornecido:** [C03ex03.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/FirstStage/C03ex03.java), [CalculaHipotenusa.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/FirstStage/CalculaHipotenusa.java).

## Solução

Elevar cada cateto ao quadrado, somar os quadrados e elevar a soma à potência 1/2.

### Hipotenusa

[Arquivo fonte: C03ex03.java](https://github.com/guihn/Academic-Projects/blob/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2003/Exerc%C3%ADcio%2003/src/C03ex03.java) · [Baixar](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2003/Exerc%C3%ADcio%2003/src/C03ex03.java)

<details>
<summary>💻 | Código Java</summary>

```java
package FirstStage;

import java.util.Scanner;

/**
 * Elevar cada cateto ao quadrado, somar os quadrados e elevar a soma à potência 1/2.
 *
 * Atividade: C03ex03.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C03ex03 {

  public static void main(String[] args) {

    double hipotenusa, cateto1, cateto2;

    // Entrada: ler os valores informados pelo console.
    Scanner teclado = new Scanner(System.in);

    System.out.print("Informe o valor do cateto 1: ");
    cateto1 = teclado.nextDouble();

    System.out.print("Informe o valor do cateto 2: ");
    cateto2 = teclado.nextDouble();

    teclado.close();

    // Processamento: Elevar cada cateto ao quadrado, somar os quadrados e elevar a soma à potência
    // 1/2.
    hipotenusa = Math.pow(Math.pow(cateto1, 2) + Math.pow(cateto2, 2), 1.0 / 2);

    // Saída: apresentar a mensagem correspondente ao resultado atual.
    System.out.print("Hipotenusa = " + hipotenusa);
  }
}
```

</details>

### Exemplo adicional de hipotenusa

Calcular a hipotenusa dentro de um bloco try que fecha o Scanner automaticamente.

A segunda mensagem ainda pede o cateto 1, embora a entrada seja armazenada em cateto2. O pacote original é Etapa1.Stage1.

[Arquivo fonte: CalculaHipotenusa.java](https://github.com/guihn/Academic-Projects/blob/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2003/Exerc%C3%ADcio%2003/src/CalculaHipotenusa.java) · [Baixar](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2003/Exerc%C3%ADcio%2003/src/CalculaHipotenusa.java)

<details>
<summary>💻 | Código Java</summary>

```java
package Etapa1.Stage1;

import java.util.Scanner;

/**
 * Calcular a hipotenusa dentro de um bloco try que fecha o Scanner automaticamente.
 *
 * Atividade: CalculaHipotenusa.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class CalculaHipotenusa {
   public static void main(String[] args) {
     double hipotenusa, cateto1, cateto2;
       // Entrada: ler os valores informados pelo console.
       try (Scanner teclado = new Scanner(System.in)) {
           System.out.print("Informe o valor do cateto 1: ");
           cateto1 = teclado.nextDouble();
           System.out.print("Informe o valor do cateto 1 : ");
           cateto2 = teclado.nextDouble();
           // Processamento: Calcular a hipotenusa dentro de um bloco try que fecha o Scanner
           // automaticamente.
           hipotenusa = Math.pow(Math.pow(cateto1,2)+Math.pow(cateto2,2),1.0/2);
           // Saída: apresentar a mensagem correspondente ao resultado atual.
           System.out.print("Hipotenusa = "+hipotenusa);
       }
   }
}
```

</details>
