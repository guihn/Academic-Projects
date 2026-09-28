package FirstStage;

import javax.swing.JOptionPane;

/**
 * Dividir |Ax + By + C| pela raiz quadrada de A² + B².
 *
 * Atividade: C05ex06.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C05ex06 {

    static void main() {

        String aRStr, bRStr, cRStr, xPStr, yPStr;

        double distance, c1, c2, aR, bR, cR, xP, yP;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        aRStr = JOptionPane.showInputDialog(null,
                "Informe o valor A da reta R:",
                "Conteúdo 05 | Exercício 06",
                JOptionPane.QUESTION_MESSAGE);

        bRStr = JOptionPane.showInputDialog(null,
                "Informe o valor B da reta R:",
                "Conteúdo 05 | Exercício 06",
                JOptionPane.QUESTION_MESSAGE);

        cRStr = JOptionPane.showInputDialog(null,
                "Informe o valor C da reta R:",
                "Conteúdo 05 | Exercício 06",
                JOptionPane.QUESTION_MESSAGE);

        xPStr = JOptionPane.showInputDialog(null,
                "Informe o valor da coordenada X do ponto P:",
                "Conteúdo 05 | Exercício 06",
                JOptionPane.QUESTION_MESSAGE);

        yPStr = JOptionPane.showInputDialog(null,
                "Informe o valor da coordenada Y do ponto P:",
                "Conteúdo 05 | Exercício 06",
                JOptionPane.QUESTION_MESSAGE);

        aR = Double.valueOf(aRStr);
        bR = Double.valueOf(bRStr);
        cR = Double.valueOf(cRStr);
        xP = Double.valueOf(xPStr);
        yP = Double.valueOf(yPStr);

        // Processamento: Dividir |Ax + By + C| pela raiz quadrada de A² + B².
        c1 = aR * xP + bR * yP + cR;

        c2 = Math.sqrt(Math.pow(aR, 2) + Math.pow(bR, 2));

        distance = Math.abs(c1) / c2;

        // Saída: apresentar a mensagem correspondente ao resultado atual.
        JOptionPane.showMessageDialog(null,
                "Distância: " + distance,
                "Conteúdo 05 | Exercício 06",
                JOptionPane.INFORMATION_MESSAGE);

    }
}
