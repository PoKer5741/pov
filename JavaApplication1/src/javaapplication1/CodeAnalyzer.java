/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author poker
 */
//chat
public class CodeAnalyzer {
    private String fileContent;

    public CodeAnalyzer(String fileContent) {
        this.fileContent = fileContent;
    }

    public CircularLinkedList extractProcedures() {
        CircularLinkedList proceduresList = new CircularLinkedList();
        Pattern pattern = Pattern.compile("(public|private|protected)\\s+\\w+\\s+(\\w+)\\s*\\(.*?\\)\\s*\\{");
        Matcher matcher = pattern.matcher(fileContent);

        while (matcher.find()) {
            String name = matcher.group(2);
            int start = matcher.start();
            int end = findClosingBracket(fileContent, start);
            String content = fileContent.substring(start, end);
            proceduresList.addProcedure(new Procedure(name, content));
        }
        return proceduresList;
    }

    private int findClosingBracket(String str, int startIndex) {
        int openBrackets = 0;
        for (int i = startIndex; i < str.length(); i++) {
            if (str.charAt(i) == '{') {
                openBrackets++;
            } else if (str.charAt(i) == '}') {
                openBrackets--;
                if (openBrackets == 0) {
                    return i + 1;
                }
            }
        }
        return str.length();
    }
}
