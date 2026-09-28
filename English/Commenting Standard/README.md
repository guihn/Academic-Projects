<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Padr%C3%A3o%20de%20Coment%C3%A1rios">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English">Parent&nbsp;folder</a></td>
</tr>
</table>

# Commenting standard

This standard guides comments in the supplied programs and future code contributions. Comments explain the implemented behavior and help the reader understand the decisions behind each calculation.

## Class or file description

Use a short Javadoc block above a Java class to state its purpose and assignment identifier. Keep an author attribution only when it is present in the supplied source. For other languages, use the equivalent documentation comment supported by the language.

## Explanations within the solution

Use // comments before meaningful blocks. Input, Processing and Output are useful labels when these responsibilities form distinct blocks. Describe formulas, units, boundary conditions, sentinel values, counters, accumulators and resource requirements where they need explanation. A loop or branch may combine several responsibilities. Avoid a comment for every assignment or closing brace.

## Methods and contracts

Document reusable methods with their purpose and relevant assumptions. Add @param, @return and @throws only when they clarify an actual parameter, result or exception. Do not describe the main method as accepting or returning data that it does not use.

## Language equivalence

Write comments and user-facing messages in the language of the containing version. Keep identifiers, formulas, operators, option indexes, resource paths and operational input tokens unchanged. Translate both versions together. Names such as Masculino used as accepted input remain literal tokens and must be explained to the reader.

## Accuracy and maintenance

Describe what the code currently does. When the supplied implementation differs from its statement, record the difference explicitly instead of describing a correction that has not been made. Remove redundant separators and obsolete commented-out examples during comment cleanup. Avoid invented authors, dates, versions or claims of successful execution. Keep the complete code block in the activity README identical to its source file, updating both in the same language commit.

## Comment example

```java
// Round up because a partly filled box still needs to be purchased.
necessaryBoxes = Math.ceil(goodBalls / 10);
```

[General standards](https://github.com/guihn/repo-rules/tree/main) · [Academic Projects rules](https://github.com/guihn/repo-rules/tree/main/Academic%20Projects)
