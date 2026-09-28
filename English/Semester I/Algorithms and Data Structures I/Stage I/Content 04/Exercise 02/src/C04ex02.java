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
