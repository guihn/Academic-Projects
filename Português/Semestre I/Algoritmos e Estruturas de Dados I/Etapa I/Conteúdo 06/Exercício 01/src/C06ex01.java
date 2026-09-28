package FirstStage;

import javax.swing.JOptionPane;

/**
 * Calcular as duas expressões e selecionar a primeira para x &lt; 4, zero para x = 4 ou a
 * segunda para x &gt; 4.
 *
 * Atividade: C06ex01.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex01 {

    static void main() {

        String xStr;

        double x, fx, c1, c2;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        xStr = JOptionPane.showInputDialog(null,
                "Informe o valor de X:",
                "Conteúdo 06 | Exercício 01",
                JOptionPane.QUESTION_MESSAGE);

        x = Double.valueOf(xStr);

        // Processamento: Calcular as duas expressões e selecionar a primeira para x < 4, zero para
        // x = 4 ou a segunda para x > 4.
        c1 = (5 * x + 3) / Math.sqrt(16 - Math.pow(x, 2));

        c2 = (5 * x + 3) / Math.sqrt(Math.pow(x, 2) - 16);

        if (x < 4)
            fx = c1;
            
        else if (x == 4)
            fx = 0;
            
        else
            fx = c2;

        // Saída: apresentar a mensagem correspondente ao resultado atual.
        JOptionPane.showMessageDialog(null,
                "f(x): " + fx,
                "Conteúdo 06 | Exercício 01",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
