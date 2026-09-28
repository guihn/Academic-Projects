package FirstStage;

import javax.swing.JOptionPane;

/**
 * Convert the age text to an integer and display the surname before the given names.
 *
 * Assignment: C04ex04.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C04ex04 {

    static void main() {

        String name, midname, surname, agestr;

        int age;

        // Input: collect the requested values through dialog boxes.
        name = JOptionPane.showInputDialog(null,
                "Enter your first name:",
                "Content 04 | Exercise 04",
                JOptionPane.QUESTION_MESSAGE);

        midname = JOptionPane.showInputDialog(null,
                "Enter your middle name:",
                "Content 04 | Exercise 04",
                JOptionPane.QUESTION_MESSAGE);

        surname = JOptionPane.showInputDialog(null,
                "Enter your surname:",
                "Content 04 | Exercise 04",
                JOptionPane.QUESTION_MESSAGE);

        agestr = JOptionPane.showInputDialog(null,
                "Enter your age:",
                "Content 04 | Exercise 04",
                JOptionPane.QUESTION_MESSAGE);

        // Processing: Convert the age text to an integer and display the surname before the given
        // names.
        age = Integer.valueOf(agestr);

        // Output: display the message for the current result.
        JOptionPane.showMessageDialog(null,
                surname + ", " + name + " " + midname + "\n" + age + " years old.",
                "Content 04 | Exercise 04",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
