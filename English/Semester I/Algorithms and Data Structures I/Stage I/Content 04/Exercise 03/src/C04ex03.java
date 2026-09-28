package FirstStage;

import java.util.Scanner;

/**
 * Read the table parameters and display its three emission bands without calculating a fine for
 * a specific company.
 *
 * Assignment: C04ex03.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C04ex03 {

    static void main() {

        int poluentex, poluentey;

        double multadex, multaxatey, multadey;

        // Input: read the values supplied through the console.
        Scanner kb = new Scanner(System.in);

        System.out.print("Amount of pollutant X: ");
        poluentex = kb.nextInt();

        System.out.print("Fine for amount X: ");
        multadex = kb.nextDouble();

        System.out.print("Amount of pollutant Y (greater than X): ");
        poluentey = kb.nextInt();

        System.out.print("Fine for the amount between X and Y: ");
        multaxatey = kb.nextDouble();

        System.out.print("Fine for the amount above Y: ");
        multadey = kb.nextDouble();

        kb.close();

        // Processing: Read the table parameters and display its three emission bands without
        // calculating a fine for a specific company.
        // Output: display the message for the current result.
        System.out.println("Amount of Pollutant Emitted x Fine");

        System.out.println("\nUp to " + poluentex + " fine of R$" + multadex);

        System.out.println("Above " + poluentex + " up to " + poluentey + " fine of R$" + multaxatey);

        System.out.println("Above " + poluentey + " fine of R$" + multadey + " per unit of pollutant emitted.");
    }
}
