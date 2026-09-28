package FirstStage;

import javax.swing.JOptionPane;

/**
 * Aplicar 4πr² para a área da superfície e (4/3)πr³ para o volume, com divisão em ponto
 * flutuante.
 *
 * Atividade: C05ex02.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C05ex02 {

    static void main() {

        String raiostr;

        double pi = 3.1416, raio, area, volume;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        raiostr = JOptionPane.showInputDialog(null,
                "Informe o valor do raio:",
                "Conteúdo 05 | Exercício 02",
                JOptionPane.QUESTION_MESSAGE);

        raio = Double.valueOf(raiostr);

        // Processamento: Aplicar 4πr² para a área da superfície e (4/3)πr³ para o volume, com
        // divisão em ponto flutuante.
        area = 4 * pi * Math.pow(raio, 2);

        volume = 4.0 / 3.0 * pi * Math.pow(raio, 3);

        // Saída: apresentar a mensagem correspondente ao resultado atual.
        JOptionPane.showMessageDialog(null,
                "Área: " + area + "\nVolume: " + volume,
                "Conteúdo 05 | Exercício 02",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
