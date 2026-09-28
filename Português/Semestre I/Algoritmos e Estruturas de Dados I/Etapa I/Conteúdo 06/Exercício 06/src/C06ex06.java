package FirstStage;

import javax.swing.JOptionPane;

/**
 * Calcular o discriminante e informar ausência de raízes reais, uma raiz repetida ou duas raízes
 * distintas.
 *
 * Atividade: C06ex06.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex06 {

    static void main() {

        String aStr, bStr, cStr;

        double a, b, c, fx, delta, c1, c2;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        aStr = JOptionPane.showInputDialog(null,
                "Informe o valor de A:",
                "Conteúdo 06 | Exercício 06",
                JOptionPane.QUESTION_MESSAGE);

        bStr = JOptionPane.showInputDialog(null,
                "Informe o valor de B:",
                "Conteúdo 06 | Exercício 06",
                JOptionPane.QUESTION_MESSAGE);

        cStr = JOptionPane.showInputDialog(null,
                "Informe o valor de C:",
                "Conteúdo 06 | Exercício 06",
                JOptionPane.QUESTION_MESSAGE);

        a = Double.valueOf(aStr);
        b = Double.valueOf(bStr);
        c = Double.valueOf(cStr);

        // Processamento: Calcular o discriminante e informar ausência de raízes reais, uma raiz
        // repetida ou duas raízes distintas.
        delta = Math.pow(b, 2) - (4 * a * c);

        if (delta < 0) {
            // Saída: apresentar a mensagem correspondente ao resultado atual.
            JOptionPane.showMessageDialog(null,
                    "Não teremos raízes",
                    "Conteúdo 06 | Exercício 06",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {

            c1 = (-b + Math.sqrt(delta)) / (2 * a);
            c2 = (-b - Math.sqrt(delta)) / (2 * a);

            if (c1 == c2) {
                JOptionPane.showMessageDialog(null,
                        "Teremos 1 raiz = " + c1,
                        "Conteúdo 06 | Exercício 06",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                
                JOptionPane.showMessageDialog(null,
                        "Teremos 2 raízes = " + c1 + " e " + c2,
                        "Conteúdo 06 | Exercício 06",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
