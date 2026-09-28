<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2004/Exerc%C3%ADcio%2002">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2004">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 02 · Employee record in the console

## Description

**Statement summary:** Read personal document numbers, company and salary and present an employee record.

## Solution

Read the record fields and format the salary with the default currency formatter.

Source file: [C04ex02.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2004/Exercise%2002/src/C04ex02.java)

<details>
<summary>💻 | Java code</summary>

```java
package FirstStage;

import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Read the record fields and format the salary with the default currency formatter.
 *
 * Assignment: C04ex02.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C04ex02 {
    static void main() {

        String name, cpf, ci, company, formatSalary;
        long voterLicense, driverLicense;
        float salary;

        // Input: read the values supplied through the console.
        Scanner kb = new Scanner(System.in);

        System.out.print("Enter your full name: ");
        name = kb.nextLine();

        System.out.print("Enter your CPF: ");
        cpf = kb.nextLine();

        System.out.print("Enter your identity card number: ");
        ci = kb.nextLine();

        System.out.print("Enter your company name: ");
        company = kb.nextLine();

        System.out.print("Enter your voter registration number: ");
        voterLicense = kb.nextLong();

        System.out.print("Enter your driver's license number: ");
        driverLicense = kb.nextLong();

        System.out.print("Enter your salary: ");
        salary = kb.nextFloat();

        kb.close();

        // Processing: Read the record fields and format the salary with the default currency
        // formatter.
        formatSalary = NumberFormat.getCurrencyInstance().format(salary);

        // Output: display the message for the current result.
        System.out.println("Employee record for: " + name);
        System.out.println("Documents: ");
        System.out.println("CPF: ............... " + cpf);
        System.out.println("CI: .................... " + ci);
        System.out.println("Voter registration: .................... " + voterLicense);
        System.out.println("Driver's license: .................... " + driverLicense + "\n");
        System.out.println("Company: .................... " + company);
        System.out.println("Salary: .................... " + formatSalary );
    }
}
```

</details>
