package FirstStage;

import java.util.Scanner;

/**
 * Ler os campos de texto antes da idade inteira e reuni-los na mensagem do console.
 *
 * Atividade: C04ex01.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C04ex01 {

    public static void main() {

        String name, midname, surname;

        int age;

        // Entrada: ler os valores informados pelo console.
        Scanner kb = new Scanner(System.in);

        System.out.print("Informe o seu primeiro nome: ");
        name = kb.nextLine();

        System.out.print("Informe o seu segundo nome: ");
        midname = kb.nextLine();

        System.out.print("Informe o seu sobrenome: ");
        surname = kb.nextLine();

        System.out.print("Informe a sua idade: ");
        age = kb.nextInt();

        // Processamento: Ler os campos de texto antes da idade inteira e reuni-los na mensagem do
        // console.
        // Saída: apresentar a mensagem correspondente ao resultado atual.
        System.out.println(surname + ", " + name + " " + midname + "\nIdade: " + age);

        kb.close();
    }
}
