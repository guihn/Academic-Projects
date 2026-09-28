package SecondStage;

import javax.swing.JOptionPane;

/**
 * Accumulate ages and counts for the recognized M and F options, then calculate the two floating
 * point averages.
 *
 * Assignment: C08ex09.
 */
public class C08ex09 {
    static void main() {
        String repStr, name, ageStr, gender;
        int rep, age, mans, womens, mansAges, womensAges;
        float mansMedia, womensMedia;

        gender = "";
        // Processing: Accumulate ages and counts for the recognized M and F options, then calculate
        // the two floating point averages.
        mans = 0;
        womens = 0;
        mansAges = 0;
        womensAges = 0;

        // Input: collect the requested values through dialog boxes.
        repStr = JOptionPane.showInputDialog(null,
                "Enter the number of people taking part in the survey: ",
                "Content 08 | Exercise 09",
                JOptionPane.QUESTION_MESSAGE);
        rep = Integer.parseInt(repStr);

        for (int i = 1; i <= rep; i ++) {
            name = JOptionPane.showInputDialog(null,
                    "Enter the name of person " + i + ": ",
                    "Content 08 | Exercise 09",
                    JOptionPane.QUESTION_MESSAGE);
            ageStr = JOptionPane.showInputDialog(null,
                    "Enter the age of person " + i + ": ",
                    "Content 08 | Exercise 09",
                    JOptionPane.QUESTION_MESSAGE);
            gender = JOptionPane.showInputDialog(null,
                    "Enter the sex of person " + i + ": ",
                    "Content 08 | Exercise 09",
                    JOptionPane.QUESTION_MESSAGE);
            age = Integer.parseInt(ageStr);
            if (gender.equalsIgnoreCase("M") || gender.equalsIgnoreCase("Masculino")) {
                mansAges += age;
                mans++;
            } else if (gender.equalsIgnoreCase("F") || gender.equalsIgnoreCase("Feminino")) {
                womensAges += age;
                womens++;
            } else {
                // Output: display the message for the current result.
                JOptionPane.showMessageDialog(null,
                        "You entered an invalid character or sex! This person was excluded. Try 'M' or 'Masculino', 'F' or 'Feminino'",
                        "Content 08 | Exercise 09",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

        mansMedia = (float) mansAges / mans;
        womensMedia = (float) womensAges / womens;

        JOptionPane.showMessageDialog(null,
                "The average age of men is: " + mansMedia + "\nThe average age of women is: " + womensMedia);
    }
}
