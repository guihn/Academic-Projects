<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2004/Exerc%C3%ADcio%2005">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2004">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 05 · Employee record from a text file

## Description

**Statement summary:** Read an employee record from a text file and display the information in a dialog.

**Statement source:** [original lecture slides](https://github.com/guihn/academic-materials/blob/5a9473bbf24a271032a41b141ab6bd435076c1d5/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2004/Algoritmos%20-%20Aulas%20-%20Conte%C3%BAdo%204%20-%20Comandos%20de%20IO%20%E2%80%93%20SCANNER%2C%20PRINT.pptx), slide(s) 63. [Material folder](https://github.com/guihn/academic-materials/tree/main/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2004).

**Supplied source:** [C04ex05.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/FirstStage/C04ex05.java).

## Solution

Read the classpath resource in field order, consume the pending line break before the company name and format the salary.

### Implementation notes

The required resource is /FirstStage/fichafuncionaldeGuilherme.txt. Its contents and name are preserved. Currency formatting and decimal parsing depend on the runtime locale.

[Source file: C04ex05.java](https://github.com/guihn/Academic-Projects/blob/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2004/Exercise%2005/src/C04ex05.java) · [Download](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2004/Exercise%2005/src/C04ex05.java)

<details>
<summary>💻 | Java code</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Read the classpath resource in field order, consume the pending line break before the company
 * name and format the salary.
 *
 * Assignment: C04ex05.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C04ex05 {

    static void main() {

        String name, cpf, ci, company, formatSalary;

        long voterLicense, driverLicense;

        float salary;

        // Input: read the bundled employee record in its original field order.
        Scanner archive = new Scanner(C04ex05.class.getResourceAsStream("/FirstStage/fichafuncionaldeGuilherme.txt"));

        name = archive.nextLine();
        cpf = archive.nextLine();
        ci = archive.nextLine();

        voterLicense = archive.nextLong();
        driverLicense = archive.nextLong();

        // Processing: Read the classpath resource in field order, consume the pending line break
        // before the company name and format the salary.
        // Consume the newline left by the preceding numeric read.
        archive.nextLine();
        company = archive.nextLine();

        salary = archive.nextFloat();

        archive.close();

        formatSalary = NumberFormat.getCurrencyInstance().format(salary);

        // Output: display the message for the current result.
        JOptionPane.showMessageDialog(null,
                "Employee record for: " + name +
                        "\nDocuments:" +
                        "\nCPF: " + cpf +
                        "\nCI: " + ci +
                        "\nVoter registration: " + voterLicense +
                        "\nDriver's license: " + driverLicense +
                        "\n\nCompany: " + company +
                        "\nSalary: " + formatSalary,
                "Content 04 | Exercise 05",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
```

</details>

## Required resource

[fichafuncionaldeGuilherme.txt](https://github.com/guihn/Academic-Projects/blob/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2004/Exercise%2005/src/FirstStage/fichafuncionaldeGuilherme.txt)

The text file contains the record fields consumed by the program. Its location under FirstStage matches the absolute resource name in the source.
