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

        // Input: read the employee record in field order.
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
