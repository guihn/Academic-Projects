<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2005/Exerc%C3%ADcio%2011">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2005">Parent&nbsp;folder</a></td>
</tr>
</table>

# Exercise 11 · Cheque number fields

## Description

The program interprets a nine-digit cheque number as three fixed-size fields. The first three identify the bank, the next three identify the branch and the last three form the sequence number. The output must label each field, showing how a single numeric value can contain independent information.

## Statement

Read a cheque number composed of a bank code, branch code and sequence number, with three digits in each part. Extract and print the three fields separately. For example, 999888777 represents bank 999, branch 888 and sequence 777.

## Solution

Extract the three groups with integer division and remainder operations.

Source file: [C05ex11.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2005/Exercise%2011/src/C05ex11.java)

<details>
<summary>💻 | Java code</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Extract the three groups with integer division and remainder operations.
 *
 * Assignment: C05ex11.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C05ex11 {

    static void main() {

        String numberStr;

        int number, bank, agency, sequencial;

        // Input: collect the requested values through dialog boxes.
        numberStr = JOptionPane.showInputDialog(null,
                "Enter the number (9 digits):",
                "Content 05 | Exercise 11",
                JOptionPane.QUESTION_MESSAGE);

        number = Integer.valueOf(numberStr);

        // Processing: Extract the three groups with integer division and remainder operations.
        bank = number / 1000000;

        agency = number / 1000 % 1000;

        sequencial = number % 1000;

        // Output: display the message for the current result.
        JOptionPane.showMessageDialog(null,
                "Bank: " + bank + "\nBranch: " + agency + "\nSequence: " + sequencial,
                "Content 05 | Exercise 11",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
```

</details>
