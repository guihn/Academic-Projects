package FirstTest;

import javax.swing.JOptionPane;

/**
 * Validar 100–999, extrair centenas, dezenas e unidades e comparar a soma de seus cubos com o
 * número original.
 *
 * Atividade: D30912B.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class D30912B {
    static void main() {
        int receivedNumber;
        String numberArmstrongStr;
        double firstNumb, secondNumb, thirdNumb, testing;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        numberArmstrongStr = JOptionPane.showInputDialog(null,
                "Informe um número de até 3 digitos a ser testado: ",
                "Primeira Avaliação | Questão B",
                JOptionPane.INFORMATION_MESSAGE);

        receivedNumber = Integer.valueOf(numberArmstrongStr);

        // Processamento: Validar 100–999, extrair centenas, dezenas e unidades e comparar a soma de
        // seus cubos com o número original.
        if (receivedNumber >= 100 && receivedNumber < 1000) {

            firstNumb = receivedNumber / 100 % 10;
            secondNumb = receivedNumber / 10 % 10;
            thirdNumb = receivedNumber % 10;

            testing = Math.pow(firstNumb, 3) + Math.pow(secondNumb, 3) + Math.pow(thirdNumb, 3);
            if (testing == receivedNumber) {
                // Saída: apresentar a mensagem correspondente ao resultado atual.
                JOptionPane.showMessageDialog(null,
                        "Esse número é um numero Armstrong!",
                        "Primeira Avaliação | Questão B",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(null,
                        "Esse número não é um numero Armstrong!",
                        "Primeira Avaliação | Questão B",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        else {
            JOptionPane.showMessageDialog(null,
                    "Você não inseriu um número válido de até 3 digitos!",
                    "Primeira Avaliação | Questão B",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
