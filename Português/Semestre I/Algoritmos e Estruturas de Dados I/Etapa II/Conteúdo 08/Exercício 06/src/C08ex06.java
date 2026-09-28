package SecondStage;

import javax.swing.JOptionPane;

/**
 * Usar restos para classificar cada número e manter a soma e a contagem dentro do laço.
 *
 * Atividade: C08ex06.
 */
public class C08ex06 {
    static void main() {
        String numberStr;
        int number, oddoreven, div4, div3, rep, div4sum, ifdiv3;
        rep = 10;
        div4sum = 0;
        div3 = 0;

        // Processamento: Usar restos para classificar cada número e manter a soma e a contagem
        // dentro do laço.
        for (int i = 1; i <= rep; i++) {
            // Entrada: coletar os valores solicitados por caixas de diálogo.
            numberStr = JOptionPane.showInputDialog(null,
                    "Informe um número inteiro: ",
                    "Conteúdo 08 | Exercício 06",
                    JOptionPane.QUESTION_MESSAGE);
            number = Integer.parseInt(numberStr);

            oddoreven = number % 2;
            div4 = number % 4;
            ifdiv3 = number % 3;

            if (oddoreven == 0) {
                // Saída: apresentar a mensagem correspondente ao resultado atual.
                JOptionPane.showMessageDialog(null,
                        "O número informado é par!",
                        "Conteúdo 08 | Exercício 06",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null,
                        "O número informado é ímpar!",
                        "Conteúdo 08 | Exercício 06",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            if (div4 == 0) {
                div4sum += number;
            }
            // Este else if original exclui múltiplos de 4 da contagem de múltiplos de 3.
            else if (ifdiv3 == 0) {
                div3++;
            }
        }
            JOptionPane.showMessageDialog(null,
                    "A soma dos números divisíveis por 4 é: " + div4sum + "\nA quantidade de números divisíveis por 3 é: " + div3 + " números.",
                    "Conteúdo 08 | Exercício 06",
                    JOptionPane.QUESTION_MESSAGE);
    }
}
