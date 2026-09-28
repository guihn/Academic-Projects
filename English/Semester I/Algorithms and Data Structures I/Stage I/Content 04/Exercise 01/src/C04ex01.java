package FirstStage;

import java.util.Scanner;

/**
 * Read the text fields before the integer age and combine them in the console message.
 *
 * Assignment: C04ex01.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C04ex01 {

    public static void main() {

        String name, midname, surname;

        int age;

        // Input: read the values supplied through the console.
        Scanner kb = new Scanner(System.in);

        System.out.print("Enter your first name: ");
        name = kb.nextLine();

        System.out.print("Enter your middle name: ");
        midname = kb.nextLine();

        System.out.print("Enter your surname: ");
        surname = kb.nextLine();

        System.out.print("Enter your age: ");
        age = kb.nextInt();

        // Processing: Read the text fields before the integer age and combine them in the console
        // message.
        // Output: display the message for the current result.
        System.out.println(surname + ", " + name + " " + midname + "\nAge: " + age);

        kb.close();
    }
}
