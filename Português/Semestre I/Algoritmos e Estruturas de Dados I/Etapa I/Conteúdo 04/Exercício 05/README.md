<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2004/Exercise%2005">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2004">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 05 · Ficha funcional de um arquivo texto

## Descrição

**Resumo do enunciado:** Ler uma ficha funcional de um arquivo texto e apresentar os dados em uma caixa de diálogo.

## Solução

Ler o recurso do classpath na ordem dos campos, consumir a quebra de linha pendente antes da empresa e formatar o salário.

### Observações da implementação

O recurso necessário é /FirstStage/fichafuncionaldeGuilherme.txt. O conteúdo e o nome foram preservados. A formatação monetária e a leitura decimal dependem da localidade do ambiente.

Arquivo fonte: [C04ex05.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2004/Exerc%C3%ADcio%2005/src/C04ex05.java)

<details>
<summary>💻 | Código Java</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Ler o recurso do classpath na ordem dos campos, consumir a quebra de linha pendente antes da
 * empresa e formatar o salário.
 *
 * Atividade: C04ex05.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C04ex05 {

    static void main() {

        String name, cpf, ci, company, formatSalary;

        long voterLicense, driverLicense;

        float salary;

        // Entrada: ler a ficha funcional fornecida na ordem original dos campos.
        Scanner archive = new Scanner(C04ex05.class.getResourceAsStream("/FirstStage/fichafuncionaldeGuilherme.txt"));

        name = archive.nextLine();
        cpf = archive.nextLine();
        ci = archive.nextLine();

        voterLicense = archive.nextLong();
        driverLicense = archive.nextLong();

        // Processamento: Ler o recurso do classpath na ordem dos campos, consumir a quebra de linha
        // pendente antes da empresa e formatar o salário.
        // Consumir a quebra de linha deixada pela leitura numérica anterior.
        archive.nextLine();
        company = archive.nextLine();

        salary = archive.nextFloat();

        archive.close();

        formatSalary = NumberFormat.getCurrencyInstance().format(salary);

        // Saída: apresentar a mensagem correspondente ao resultado atual.
        JOptionPane.showMessageDialog(null,
                "Ficha funcional de: " + name +
                        "\nDocumentos:" +
                        "\nCPF: " + cpf +
                        "\nCI: " + ci +
                        "\nTítulo de eleitor: " + voterLicense +
                        "\nCarteira de motorista: " + driverLicense +
                        "\n\nEmpresa: " + company +
                        "\nSalário: " + formatSalary,
                "Conteúdo 04 | Exercício 05",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
```

</details>

## Recurso necessário

[fichafuncionaldeGuilherme.txt](https://github.com/guihn/Academic-Projects/blob/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2004/Exerc%C3%ADcio%2005/src/FirstStage/fichafuncionaldeGuilherme.txt)

O arquivo texto contém os campos da ficha consumidos pelo programa. Sua localização em FirstStage corresponde ao nome absoluto do recurso no código.
