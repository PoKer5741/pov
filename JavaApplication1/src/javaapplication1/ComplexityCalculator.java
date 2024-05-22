/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

/**
 *
 * @author poker
 */
public class ComplexityCalculator {
    private String procedureContent;

    public ComplexityCalculator(String procedureContent) {
        this.procedureContent = procedureContent;
    }
//chat
    public String calculateComplexity() {
        int loops = countOccurrences("for") + countOccurrences("while");
        if (loops == 0) {
            return "O(1)";
        } else if (loops == 1) {
            return "O(n)";
        } else {
            return "O(n^" + loops + ")";
        }
    }

    private int countOccurrences(String word) {
        int count = 0;
        int index = 0;
        while ((index = procedureContent.indexOf(word, index)) != -1) {
            count++;
            index += word.length();
        }
        return count;
    }
}
