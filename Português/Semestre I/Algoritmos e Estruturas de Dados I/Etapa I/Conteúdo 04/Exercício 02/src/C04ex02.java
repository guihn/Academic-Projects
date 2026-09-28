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
