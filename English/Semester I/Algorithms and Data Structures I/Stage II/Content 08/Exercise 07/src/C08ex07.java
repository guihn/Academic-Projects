package SecondStage;

import javax.swing.JOptionPane;
import java.awt.*;

/**
 * Accumulate all ages, maintain age band counters and divide the total age by the record count.
 *
 * Assignment: C08ex07.
 */
public class C08ex07 {
    static void main() {
        String name, ageStr;
        int age, allages, untiltwelve, higherthirty, rep;
        float mediaOfAllAges;

        allages = 0;
        untiltwelve = 0;
        higherthirty = 0;
        rep = 50;

        // Processing: Accumulate all ages, maintain age band counters and divide the total age by
        // the record count.
        for (int i = 1; i <= rep; i ++) {
            // Input: collect the requested values through dialog boxes.
            name = JOptionPane.showInputDialog(null,
                    "Enter your name:",
                    "Content 08 | Exercise 07",
                    JOptionPane.QUESTION_MESSAGE);
            ageStr = JOptionPane.showInputDialog(null,
                    "Enter your age:",
                    "Content 08 | Exercise 07",
                    JOptionPane.QUESTION_MESSAGE);
            age = Integer.parseInt(ageStr);

            if (age <=12) {
                untiltwelve++;
                allages += age;
            }
            // The original comparison includes age 30 in this group.
            else if (age >=30) {
                higherthirty++;
                allages += age;
            }
            else {
                allages += age;
            }
        }

        mediaOfAllAges = (float) allages / rep;
        // Output: display the message for the current result.
        JOptionPane.showMessageDialog(null,
                "Students aged up to 12: " + untiltwelve + "\nStudents aged above 30: " + higherthirty + "\nAverage of the reported ages: " + mediaOfAllAges );
    }
}
