<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2004/Exercise%2002">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2004">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 02 · Ficha funcional no console

## Descrição

A atividade reúne informações pessoais e profissionais em uma ficha funcional. O programa solicita o nome, quatro documentos, a empresa e o salário, organizando esses campos em grupos identificados. O objetivo é praticar diferentes tipos de entrada e compor uma saída legível no console, com o salário apresentado como valor monetário.

## Enunciado

Leia o nome da pessoa, CPF, identidade, título de eleitor, carteira de motorista, salário e nome da empresa em que trabalha. Imprima uma ficha funcional com o nome no cabeçalho, os quatro documentos identificados e, ao final, a empresa e o salário em reais.

## Solução

Ler os campos da ficha e formatar o salário com o formatador monetário padrão.

Arquivo fonte: [C04ex02.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2004/Exerc%C3%ADcio%2002/src/C04ex02.java)

<details>
<summary>💻 | Código Java</summary>

```java
package FirstStage;

import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Ler os campos da ficha e formatar o salário com o formatador monetário padrão.
 *
 * Atividade: C04ex02.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C04ex02 {
    static void main() {

        String name, cpf, ci, company, formatSalary;
        long voterLicense, driverLicense;
        float salary;

        // Entrada: ler os valores informados pelo console.
        Scanner kb = new Scanner(System.in);

        System.out.print("Informe o seu nome completo: ");
        name = kb.nextLine();

        System.out.print("Informe o seu CPF: ");
        cpf = kb.nextLine();

        System.out.print("Informe o seu CI: ");
        ci = kb.nextLine();

        System.out.print("Informe o nome da sua empresa: ");
        company = kb.nextLine();

        System.out.print("Informe o número do seu título de eleitor: ");
        voterLicense = kb.nextLong();

        System.out.print("Informe o número da sua CNH: ");
        driverLicense = kb.nextLong();

        System.out.print("Informe o seu salário: ");
        salary = kb.nextFloat();

        kb.close();

        // Processamento: Ler os campos da ficha e formatar o salário com o formatador monetário
        // padrão.
        formatSalary = NumberFormat.getCurrencyInstance().format(salary);

        // Saída: apresentar a mensagem correspondente ao resultado atual.
        System.out.println("Ficha funcional de: " + name);
        System.out.println("Documentos: ");
        System.out.println("CPF: ............... " + cpf);
        System.out.println("CI: .................... " + ci);
        System.out.println("Título de eleitor: .................... " + voterLicense);
        System.out.println("Carteira de motorista: .................... " + driverLicense + "\n");
        System.out.println("Empresa: .................... " + company);
        System.out.println("Salário: .................... " + formatSalary );
    }
}
```

</details>
