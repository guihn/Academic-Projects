package SecondStage;

import javax.swing.JOptionPane;

/**
 * Acumular idades e contagens das opções M e F reconhecidas e calcular as duas médias em ponto
 * flutuante.
 *
 * Atividade: C08ex09.
 */
public class C08ex09 {
    static void main() {
        String repStr, name, ageStr, gender;
        int rep, age, mans, womens, mansAges, womensAges;
        float mansMedia, womensMedia;

        gender = "";
        // Processamento: Acumular idades e contagens das opções M e F reconhecidas e calcular as
        // duas médias em ponto flutuante.
        mans = 0;
        womens = 0;
        mansAges = 0;
        womensAges = 0;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        repStr = JOptionPane.showInputDialog(null,
                "Informe o número de pssoas que participarão da pesquisa: ",
                "Conteúdo 08 | Exercício 09",
                JOptionPane.QUESTION_MESSAGE);
        rep = Integer.parseInt(repStr);

        for (int i = 1; i <= rep; i ++) {
            name = JOptionPane.showInputDialog(null,
                    "Informe o nome da " + i + "° pessoa: ",
                    "Conteúdo 08 | Exercício 09",
                    JOptionPane.QUESTION_MESSAGE);
            ageStr = JOptionPane.showInputDialog(null,
                    "Informe a idade da " + i + "° pessoa: ",
                    "Conteúdo 08 | Exercício 09",
                    JOptionPane.QUESTION_MESSAGE);
            gender = JOptionPane.showInputDialog(null,
                    "Informe o gênero da " + i + "° pessoa: ",
                    "Conteúdo 08 | Exercício 09",
                    JOptionPane.QUESTION_MESSAGE);
            age = Integer.parseInt(ageStr);
            if (gender.equalsIgnoreCase("M") || gender.equalsIgnoreCase("Masculino")) {
                mansAges += age;
                mans++;
            } else if (gender.equalsIgnoreCase("F") || gender.equalsIgnoreCase("Feminino")) {
                womensAges += age;
                womens++;
            } else {
                // Saída: apresentar a mensagem correspondente ao resultado atual.
                JOptionPane.showMessageDialog(null,
                        "Você informou um caractére ou gênero inválido! Portanto, essa pessoa foi desconsiderada. Tente 'M' ou 'Masculino', 'F' ou 'Feminino'",
                        "Conteúdo 08 | Exercício 09",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

        mansMedia = (float) mansAges / mans;
        womensMedia = (float) womensAges / womens;

        JOptionPane.showMessageDialog(null,
                "A média das idades dos homens é: " + mansMedia + "\nA média das idades das mulheres é: " + womensMedia);
    }
}
