<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Algorithms%20and%20Data%20Structures%20I/Stage%20II/Content%2008/Exercise%2005a">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20II/Conte%C3%BAdo%2008">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Exercício 05a · Eleição com empates e votos nulos

## Descrição

A atividade amplia a eleição anterior para tratar votos nulos e empates. O programa deve comparar os votos válidos com os nulos e decidir se a votação pode produzir um resultado. Se houver empate entre líderes, um segundo turno restrito aos candidatos empatados deve continuar a apuração.

## Enunciado

Complemente a eleição de 100 eleitores e dos candidatos 1 — Fulano, 2 — Ciclano e 3 — Beltrano. Preveja empate duplo ou triplo; nesses casos, realize segundo turno apenas com os candidatos empatados. Conte como nulos os votos diferentes de 1, 2 ou 3. Se os nulos superarem a soma dos votos válidos, informe que a eleição está anulada; aplique também essa verificação ao segundo turno.

## Solução

Contar e confirmar votos nulos, verificar a anulação e realizar nova votação para dois candidatos empatados na liderança.

### Observações da implementação

O empate triplo exibe uma mensagem sobre eleger o candidato mais velho em vez de realizar o segundo turno solicitado. Um novo empate também usa essa mensagem, sem ler idades nem identificar o candidato mais velho.

Arquivo fonte: [C08ex05a.java](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Algoritmos%20e%20Estruturas%20de%20Dados%20I/Etapa%20II/Conte%C3%BAdo%2008/Exerc%C3%ADcio%2005a/src/C08ex05a.java)

<details>
<summary>💻 | Código Java</summary>

```java
package SecondStage;

import javax.swing.JOptionPane;

/**
 * Contar e confirmar votos nulos, verificar a anulação e realizar nova votação para dois
 * candidatos empatados na liderança.
 *
 * Atividade: C08ex05a.
 */
public class C08ex05a {
    static void main() {
        String votesStr;
        int votes, votes1C, votes2C, votes3C, nullVotes, voteConfirm, validVotes, rep;

        // Processamento: Contar e confirmar votos nulos, verificar a anulação e realizar nova
        // votação para dois candidatos empatados na liderança.
        votes1C = 0;
        votes2C = 0;
        votes3C = 0;
        nullVotes = 0;
        rep = 100;

        // Cada turno aceita 100 votos contabilizados, incluindo votos nulos confirmados.
        for (int i = 1; i <= rep; i ++) {

            // Entrada: coletar os valores solicitados por caixas de diálogo.
            votesStr = JOptionPane.showInputDialog(null,
                    "Informe o numero do candidato: ",
                    "Conteúdo 08 | Exercício 05a",
                    JOptionPane.QUESTION_MESSAGE);
            votes = Integer.parseInt(votesStr);

            // Contabilizar votos apenas dos candidatos presentes neste turno.
            switch (votes) {
                case 1 -> {
                    votes1C++;
                    // Saída: apresentar a mensagem correspondente ao resultado atual.
                    JOptionPane.showMessageDialog(null,
                            "Voto computado!",
                            "Conteúdo 08 | Exercício 05a",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                case 2 -> {
                    votes2C++;
                    JOptionPane.showMessageDialog(null,
                            "Voto computado!",
                            "Conteúdo 08 | Exercício 05a",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                case 3 -> {
                    votes3C++;
                    JOptionPane.showMessageDialog(null,
                            "Voto computado!",
                            "Conteúdo 08 | Exercício 05a",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                default -> {
                    
                    Object[] buttons = {"Sim", "Não"};
                    voteConfirm = JOptionPane.showOptionDialog(null,
                            "Você digitou um número que não é 1, 2 ou 3! Seu voto será computado como nulo, tem certeza que deseja isso? ",
                            "Conteúdo 08 | Exercício 05a",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            buttons,
                            buttons[1]);
                    // Não cancela este voto e repete a iteração atual.
                    if (voteConfirm == 1) {
                        i--;
                        JOptionPane.showMessageDialog(null,
                                "Voto descontabilizado!",
                                "Conteúdo 08 | Exercício 05a",
                                JOptionPane.ERROR_MESSAGE);
                        break;
                    } else
                        nullVotes++;
                    JOptionPane.showMessageDialog(null,
                            "Voto computado!",
                            "Conteúdo 08 | Exercício 05a",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }

        // Somar os votos dos candidatos antes de compará-los com os votos nulos.
        validVotes = votes1C + votes2C + votes3C;
        
        // Anular este turno quando os votos nulos superarem a soma dos votos dos candidatos.
        if (nullVotes > validVotes) {
            JOptionPane.showMessageDialog(null,
                    "Eleições anuladas devido ao número de votos nulos ser maior que o de votos válidos!",
                    "Conteúdo 08 | Exercício 05a",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        else {
            
            // O ramo original de empate triplo apenas exibe uma mensagem de desempate por idade.
            if (votes1C == votes2C && votes1C == votes3C) {
                JOptionPane.showMessageDialog(null,
                        "Os candidatos 'Fulano', 'Ciclano' e 'Beltrano' empataram! Foram " + votes1C + " votos para cada! Não teremos 2° turno, pois o candidato MAIS VELHO será eleito!",
                        "Conteúdo 08 | Exercício 05a",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            
            else if (votes1C == votes2C && votes1C > votes3C) {
                JOptionPane.showMessageDialog(null,
                        "Os candidatos 'Fulano' e 'Ciclano' empataram! Foram " + votes1C + " votos para cada! \n'Beltrano' teve " + votes3C + " votos\nVamos ao 2° turno!",
                        "Conteúdo 08 | Exercício 05a",
                        JOptionPane.INFORMATION_MESSAGE);

                // Iniciar o segundo turno com os contadores zerados.
                votes = 0;
                votes1C = 0;
                votes2C = 0;
                votes3C = 0;
                nullVotes = 0;

                // Cada turno aceita 100 votos contabilizados, incluindo votos nulos confirmados.
                for (int i = 1; i <= rep; i ++) {

                    votesStr = JOptionPane.showInputDialog(null,
                            "Informe o numero do candidato: ",
                            "Conteúdo 08 | Exercício 05",
                            JOptionPane.QUESTION_MESSAGE);
                    votes = Integer.parseInt(votesStr);

                    // Contabilizar votos apenas dos candidatos presentes neste turno.
                    switch (votes) {
                        case 1 -> {
                            votes1C++;
                            JOptionPane.showMessageDialog(null,
                                    "Voto computado!",
                                    "Conteúdo 08 | Exercício 05",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                        case 2 -> {
                            votes2C++;
                            JOptionPane.showMessageDialog(null,
                                    "Voto computado!",
                                    "Conteúdo 08 | Exercício 05",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                        default -> {
                            
                            Object[] buttons = {"Sim", "Não"};
                            voteConfirm = JOptionPane.showOptionDialog(null,
                                    "Você digitou um número que não é 1 ou 2! Seu voto será computado como nulo, tem certeza que deseja isso? ",
                                    "Conteúdo 08 | Exercício 05a",
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE,
                                    null,
                                    buttons,
                                    buttons[1]);
                            // Não cancela este voto e repete a iteração atual.
                            if (voteConfirm == 1) {
                                i--;
                                JOptionPane.showMessageDialog(null,
                                        "Voto descontabilizado!",
                                        "Conteúdo 08 | Exercício 05a",
                                        JOptionPane.ERROR_MESSAGE);
                                break;
                            } else
                                nullVotes++;
                            JOptionPane.showMessageDialog(null,
                                    "Voto computado!",
                                    "Conteúdo 08 | Exercício 05a",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }

                // Somar os votos dos candidatos antes de compará-los com os votos nulos.
                validVotes = votes1C + votes2C + votes3C;
                
                // Anular este turno quando os votos nulos superarem a soma dos votos dos
                // candidatos.
                if (nullVotes > validVotes) {
                    JOptionPane.showMessageDialog(null,
                            "Eleições anuladas devido ao número de votos nulos ser maior que o de votos válidos!",
                            "Conteúdo 08 | Exercício 05a",
                            JOptionPane.ERROR_MESSAGE);
                }
                
                else {
                    if (votes1C > votes2C) {
                        JOptionPane.showMessageDialog(null,
                                "O candidato 'Fulano' venceu! O número de votos dele foi de: " + votes1C + " votos.\n'Ciclano' teve " + votes2C + " votos.",
                                "Conteúdo 08 | Exercício 05",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    else if (votes1C < votes2C) {
                        JOptionPane.showMessageDialog(null,
                                "O candidato 'Ciclano' venceu! O número de votos dele foi de: " + votes2C + " votos.\n'Fulano' teve " + votes1C + " votos.",
                                "Conteúdo 08 | Exercício 05",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    else {
                        JOptionPane.showMessageDialog(null,
                                "Os candidatos 'Fulano' e 'Ciclano' empataram novamente! Foram " + votes1C + " votos para cada!" + "\nNão teremos 3° turno, então o candidato mais velho será eleito!",
                                "Conteúdo 08 | Exercício 05a",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
            
            else if (votes1C == votes3C && votes1C > votes2C) {
                JOptionPane.showMessageDialog(null,
                        "Os candidatos 'Fulano' e 'Beltrano' empataram! Foram " + votes1C + " votos para cada! \n'Ciclano' teve " + votes2C + " votos.\nVamos ao 2° turno!",
                        "Conteúdo 08 | Exercício 05a",
                        JOptionPane.INFORMATION_MESSAGE);

                // Iniciar o segundo turno com os contadores zerados.
                votes = 0;
                votes1C = 0;
                votes2C = 0;
                votes3C = 0;
                nullVotes = 0;

                // Cada turno aceita 100 votos contabilizados, incluindo votos nulos confirmados.
                for (int i = 1; i <= rep; i ++) {

                    votesStr = JOptionPane.showInputDialog(null,
                            "Informe o numero do candidato: ",
                            "Conteúdo 08 | Exercício 05a",
                            JOptionPane.QUESTION_MESSAGE);
                    votes = Integer.parseInt(votesStr);

                    // Contabilizar votos apenas dos candidatos presentes neste turno.
                    switch (votes) {
                        case 1 -> {
                            votes1C++;
                            JOptionPane.showMessageDialog(null,
                                    "Voto computado!",
                                    "Conteúdo 08 | Exercício 05",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                        case 3 -> {
                            votes3C++;
                            JOptionPane.showMessageDialog(null,
                                    "Voto computado!",
                                    "Conteúdo 08 | Exercício 05",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                        default -> {
                            
                            Object[] buttons = {"Sim", "Não"};
                            voteConfirm = JOptionPane.showOptionDialog(null,
                                    "Você digitou um número que não é 1 ou 3! Seu voto será computado como nulo, tem certeza que deseja isso? ",
                                    "Conteúdo 08 | Exercício 05a",
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE,
                                    null,
                                    buttons,
                                    buttons[1]);
                            // Não cancela este voto e repete a iteração atual.
                            if (voteConfirm == 1) {
                                i--;
                                JOptionPane.showMessageDialog(null,
                                        "Voto descontabilizado!",
                                        "Conteúdo 08 | Exercício 05a",
                                        JOptionPane.ERROR_MESSAGE);
                                break;
                            } else
                                nullVotes++;
                            JOptionPane.showMessageDialog(null,
                                    "Voto computado!",
                                    "Conteúdo 08 | Exercício 05a",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }

                // Somar os votos dos candidatos antes de compará-los com os votos nulos.
                validVotes = votes1C + votes2C + votes3C;
                
                // Anular este turno quando os votos nulos superarem a soma dos votos dos
                // candidatos.
                if (nullVotes > validVotes) {
                    JOptionPane.showMessageDialog(null,
                            "Eleições anuladas devido ao número de votos nulos ser maior que o de votos válidos!",
                            "Conteúdo 08 | Exercício 05a",
                            JOptionPane.ERROR_MESSAGE);
                }
                
                else {
                    if (votes1C > votes3C) {
                        JOptionPane.showMessageDialog(null,
                                "O candidato 'Fulano' venceu! O número de votos dele foi de: " + votes1C + " votos.\n'Beltrano' teve " + votes3C + " votos.",
                                "Conteúdo 08 | Exercício 05a",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    else if (votes1C < votes3C) {
                        JOptionPane.showMessageDialog(null,
                                "O candidato 'Beltrano' venceu! O número de votos dele foi de: " + votes3C + " votos.\n'Fulano' teve " + votes1C + " votos.",
                                "Conteúdo 08 | Exercício 05",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    else {
                        JOptionPane.showMessageDialog(null,
                                "Os candidatos 'Fulano' e 'Beltrano' empataram novamente! Foram " + votes1C + " votos para cada!\n Não teremos 3° turno, então o candidato mais velho será eleito!",
                                "Conteúdo 08 | Exercício 05a",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
            
            else if (votes2C == votes3C && votes2C > votes1C) {
                JOptionPane.showMessageDialog(null,
                        "Os candidatos 'Ciclano' e 'Beltrano' empataram! Foram " + votes2C + " votos para cada!  \n'Fulano' teve " + votes1C +" votos\n Vamos ao 2° turno!",
                        "Conteúdo 08 | Exercício 05a",
                        JOptionPane.INFORMATION_MESSAGE);

                // Iniciar o segundo turno com os contadores zerados.
                votes = 0;
                votes1C = 0;
                votes2C = 0;
                votes3C = 0;
                nullVotes = 0;

                // Cada turno aceita 100 votos contabilizados, incluindo votos nulos confirmados.
                for (int i = 1; i <= rep; i ++) {

                    votesStr = JOptionPane.showInputDialog(null,
                            "Informe o numero do candidato: ",
                            "Conteúdo 08 | Exercício 05a",
                            JOptionPane.QUESTION_MESSAGE);
                    votes = Integer.parseInt(votesStr);

                    // Contabilizar votos apenas dos candidatos presentes neste turno.
                    switch (votes) {
                        case 2 -> {
                            votes2C++;
                            JOptionPane.showMessageDialog(null,
                                    "Voto computado!",
                                    "Conteúdo 08 | Exercício 05",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                        case 3 -> {
                            votes3C++;
                            JOptionPane.showMessageDialog(null,
                                    "Voto computado!",
                                    "Conteúdo 08 | Exercício 05",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                        default -> {
                            
                            Object[] buttons = {"Sim", "Não"};
                            voteConfirm = JOptionPane.showOptionDialog(null,
                                    "Você digitou um número que não é 2 ou 3! Seu voto será computado como nulo, tem certeza que deseja isso? ",
                                    "Conteúdo 08 | Exercício 05a",
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE,
                                    null,
                                    buttons,
                                    buttons[1]);
                            // Não cancela este voto e repete a iteração atual.
                            if (voteConfirm == 1) {
                                i--;
                                JOptionPane.showMessageDialog(null,
                                        "Voto descontabilizado!",
                                        "Conteúdo 08 | Exercício 05a",
                                        JOptionPane.ERROR_MESSAGE);
                                break;
                            } else
                                nullVotes++;
                            JOptionPane.showMessageDialog(null,
                                    "Voto computado!",
                                    "Conteúdo 08 | Exercício 05a",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }

                // Somar os votos dos candidatos antes de compará-los com os votos nulos.
                validVotes = votes1C + votes2C + votes3C;
                
                // Anular este turno quando os votos nulos superarem a soma dos votos dos
                // candidatos.
                if (nullVotes > validVotes) {
                    JOptionPane.showMessageDialog(null,
                            "Eleições anuladas devido ao número de votos nulos ser maior que o de votos válidos!",
                            "Conteúdo 08 | Exercício 05a",
                            JOptionPane.ERROR_MESSAGE);
                }
                
                else {
                    if (votes2C > votes3C) {
                        JOptionPane.showMessageDialog(null,
                                "O candidato 'Ciclano' venceu! O número de votos dele foi de: " + votes2C + " votos.\n'Beltrano' teve " + votes3C + " votos.",
                                "Conteúdo 08 | Exercício 05a",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    else if (votes2C < votes3C) {
                        JOptionPane.showMessageDialog(null,
                                "O candidato 'Beltrano' venceu! O número de votos dele foi de: " + votes3C + " votos.\n'Ciclano' teve " + votes2C + " votos.",
                                "Conteúdo 08 | Exercício 05",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    else {
                        JOptionPane.showMessageDialog(null,
                                "Os candidatos 'Ciclano' e 'Beltrano' empataram novamente! Foram " + votes2C + " votos para cada! \nNão teremos 3° turno, então o candidato mais velho será eleito!",
                                "Conteúdo 08 | Exercício 05a",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
            
            else if (votes1C > votes2C && votes1C > votes3C) {
                JOptionPane.showMessageDialog(null,
                        "O candidato 'Fulano' venceu! O número de votos dele foi de: " + votes1C + " votos.\n'Ciclano' teve " + votes2C + " votos.\n'Beltrano' teve " + votes3C + " votos.",
                        "Conteúdo 08 | Exercício 05a",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            
            else if (votes2C > votes1C && votes2C > votes3C) {
                JOptionPane.showMessageDialog(null,
                        "O candidato 'Ciclano' venceu! O número de votos dele foi de: " + votes2C + " votos.\n'Fulano' teve " + votes1C + " votos.\n'Beltrano' teve " + votes3C + " votos.",
                        "Conteúdo 08 | Exercício 05a",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            
            else {
                JOptionPane.showMessageDialog(null,
                        "O candidato 'Beltrano' venceu! O número de votos dele foi de: " + votes3C + " votos.\n'Fulano' teve " + votes1C + " votos.\n'Ciclano' teve " + votes2C + " votos.",
                        "Conteúdo 08 | Exercício 05a",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
```

</details>
