<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006/Exercise%2009">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 09 · Fórmulas de peso por sexo

## Descrição

O programa escolhe uma de duas fórmulas de peso previstas no exercício. As entradas são a altura em metros e o código de sexo M ou F. Depois de selecionar a expressão correspondente, o resultado é apresentado como a estimativa de peso usada nesta atividade didática.

## Enunciado

Leia altura e sexo, usando M para masculino e F para feminino. Calcule o peso pela fórmula correspondente:

- M: peso = 72,7 × altura − 58.
- F: peso = 62,1 × altura − 44,7.

## Solução

Usar 72.7h − 58 para M e 62.1h − 44.7 para F, informando que outras entradas são inválidas.

Arquivo fonte: [C06ex09.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2009/src/C06ex09.java)

<details>
<summary>💻 | Código Java</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Usar 72.7h − 58 para M e 62.1h − 44.7 para F, informando que outras entradas são inválidas.
 *
 * Atividade: C06ex09.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex09 {

    static void main() {

        String heightStr, genderStr;

        double height, idealHeightF, idealHeightM;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        heightStr = JOptionPane.showInputDialog(null,
                "Informe sua altura (em metros):",
                "Conteúdo 06 | Exercício 09",
                JOptionPane.QUESTION_MESSAGE);

        genderStr = JOptionPane.showInputDialog(null,
                "Informe seu gênero biológico (M ou F):",
                "Conteúdo 06 | Exercício 09",
                JOptionPane.QUESTION_MESSAGE);

        height = Double.valueOf(heightStr);

        // Processamento: Usar 72.7h − 58 para M e 62.1h − 44.7 para F, informando que outras
        // entradas são inválidas.
        if (genderStr.equals("M")) {
            idealHeightM = 72.7 * height - 58;

            // Saída: apresentar a mensagem correspondente ao resultado atual.
            JOptionPane.showMessageDialog(null,
                    "Peso ideal: " + idealHeightM,
                    "Conteúdo 06 | Exercício 09",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        
        else if (genderStr.equals("F")) {
            idealHeightF = 62.1 * height - 44.7;

            JOptionPane.showMessageDialog(null,
                    "Peso ideal: " + idealHeightF,
                    "Conteúdo 06 | Exercício 09",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        
        else
            JOptionPane.showMessageDialog(null,
                    "Gênero inválido.",
                    "Conteúdo 06 | Exercício 09",
                    JOptionPane.INFORMATION_MESSAGE);

    }
}
```

</details>
