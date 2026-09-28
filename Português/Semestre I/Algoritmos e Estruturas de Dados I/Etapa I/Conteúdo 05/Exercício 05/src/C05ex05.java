package FirstStage;

import javax.swing.JOptionPane;

/**
 * Somar 273.15 para Kelvin e calcular 1.8 vezes Celsius mais 32 para Fahrenheit.
 *
 * Atividade: C05ex05.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C05ex05 {

    static void main() {

        String celsiusStr;

        double celsius, kelvin, farenheit;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        celsiusStr = JOptionPane.showInputDialog(null,
                "Informe a temperatura em °C:",
                "Conteúdo 05 | Exercício 05",
                JOptionPane.QUESTION_MESSAGE);

        celsius = Double.valueOf(celsiusStr);

        // Processamento: Somar 273.15 para Kelvin e calcular 1.8 vezes Celsius mais 32 para
        // Fahrenheit.
        kelvin = celsius + 273.15;

        farenheit = celsius * 1.8 + 32;

        // Saída: apresentar a mensagem correspondente ao resultado atual.
        JOptionPane.showMessageDialog(null,
                "Celsius: " + celsius + " -> Kelvin: " + kelvin + " e Fahrenheit: " + farenheit,
                "Conteúdo 05 | Exercício 05",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
