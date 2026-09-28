<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20II/Content%2008/Exercise%2009">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20II/Conte%C3%BAdo%2008">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 09 · Médias de idade por sexo

## Descrição

A atividade calcula duas médias de idade para um conjunto de pessoas de tamanho definido pelo usuário. Após a quantidade inicial, cada registro contém nome, idade e sexo. Somas e contagens separadas permitem apresentar a média do grupo feminino e a do masculino ao final da leitura.

## Enunciado

Solicite primeiro a quantidade de pessoas. Depois, leia nome, idade e sexo de cada uma, usando M para masculino e F para feminino. Ao final, imprima separadamente a idade média das mulheres e a idade média dos homens.

## Solução

Acumular idades e contagens das opções M e F reconhecidas e calcular as duas médias em ponto flutuante.

### Observações da implementação

Os valores de entrada aceitos permanecem M, Masculino, F e Feminino nas duas versões. Um grupo sem participantes produz NaN porque não há verificação de contagem zero.

Arquivo fonte: [C08ex09.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20II/Conte%C3%BAdo%2008/Exerc%C3%ADcio%2009/src/C08ex09.java)

<details>
<summary>💻 | Código Java</summary>

```java
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
```

</details>
