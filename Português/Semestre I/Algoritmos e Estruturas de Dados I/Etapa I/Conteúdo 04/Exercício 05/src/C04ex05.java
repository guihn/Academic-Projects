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
