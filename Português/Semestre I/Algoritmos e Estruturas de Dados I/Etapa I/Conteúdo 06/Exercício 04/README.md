<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Content%2006/Exercise%2004">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 04 · Exercício de classificação por IMC

## Descrição

**Resumo do enunciado:** Ler nome, altura e peso, calcular o IMC e classificá-lo pelas faixas definidas neste exercício didático.

**Fonte do enunciado:** [slides originais da aula](https://github.com/guihn/academic-materials/blob/5a9473bbf24a271032a41b141ab6bd435076c1d5/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2006/Algoritmos%20-%20Aulas%20-%20Conte%C3%BAdo%206%20-%20Comando%20Condicional%20%E2%80%93%20IF%2C%20Express%C3%B5es%20Booleanas.pptx), slide(s) 45. [Pasta do material](https://github.com/guihn/academic-materials/tree/main/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20I/Contents/Content%2006).

**Código fornecido:** [C06ex04.java](https://github.com/guihn/tasks/blob/0711e6064e059fbd110bb9d329f433c6f187bd03/src/FirstStage/C06ex04.java).

## Solução

Dividir o peso pelo quadrado da altura e escolher a mensagem correspondente por comparações sucessivas.

### Observações da implementação

A classificação e as mensagens pertencem ao programa didático fornecido. Para IMC acima de 27, a mensagem difere do rótulo do slide.

[Arquivo fonte: C06ex04.java](https://github.com/guihn/Academic-Projects/blob/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2004/src/C06ex04.java) · [Baixar](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20I/Conte%C3%BAdo%2006/Exerc%C3%ADcio%2004/src/C06ex04.java)

<details>
<summary>💻 | Código Java</summary>

```java
package FirstStage;

import javax.swing.JOptionPane;

/**
 * Dividir o peso pelo quadrado da altura e escolher a mensagem correspondente por comparações
 * sucessivas.
 *
 * Atividade: C06ex04.
 *
 * @author Guilherme Henrique Moura dos Santos
 */
public class C06ex04 {

    static void main() {

        String name, heightStr, weightStr;

        double height, weight, imc;

        // Entrada: coletar os valores solicitados por caixas de diálogo.
        name = JOptionPane.showInputDialog(null,
                "Informe seu nome:",
                "Conteúdo 06 | Exercício 04",
                JOptionPane.QUESTION_MESSAGE);

        heightStr = JOptionPane.showInputDialog(null,
                "Informe sua altura (em metros):",
                "Conteúdo 06 | Exercício 04",
                JOptionPane.QUESTION_MESSAGE);

        weightStr = JOptionPane.showInputDialog(null,
                "Informe seu peso (em Kg):",
                "Conteúdo 06 | Exercício 04",
                JOptionPane.QUESTION_MESSAGE);

        height = Double.valueOf(heightStr);
        weight = Double.valueOf(weightStr);

        // Processamento: Dividir o peso pelo quadrado da altura e escolher a mensagem
        // correspondente por comparações sucessivas.
        imc = weight / Math.pow(height, 2);

        if (imc < 18)
            // Saída: apresentar a mensagem correspondente ao resultado atual.
            JOptionPane.showMessageDialog(null,
                    name + ", você está desnutrida. " + imc,
                    "Conteúdo 06 | Exercício 04",
                    JOptionPane.INFORMATION_MESSAGE);
            
        else if (imc < 20)
            JOptionPane.showMessageDialog(null,
                    name + ", você está abaixo do peso.",
                    "Conteúdo 06 | Exercício 04",
                    JOptionPane.INFORMATION_MESSAGE);
            
        else if (imc >= 20 && imc <= 25)
            JOptionPane.showMessageDialog(null,
                    name + ", você está no peso ideal.",
                    "Conteúdo 06 | Exercício 04",
                    JOptionPane.INFORMATION_MESSAGE);
            
        else if (imc > 25 && imc <= 27)
            JOptionPane.showMessageDialog(null,
                    name + ", você está acima do peso.",
                    "Conteúdo 06 | Exercício 04",
                    JOptionPane.INFORMATION_MESSAGE);
            
        else if (imc > 27)
            JOptionPane.showMessageDialog(null,
                    name + ", você está gigaaaanta",
                    "Conteúdo 06 | Exercício 04",
                    JOptionPane.INFORMATION_MESSAGE);
    }
}
```

</details>
