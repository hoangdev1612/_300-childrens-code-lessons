package regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DuplicateWordRegex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String sentence = scanner.nextLine();
            String modifiedSentence = removeRepeatedWords(sentence);
            System.out.println(modifiedSentence);
        }
        scanner.close();
    }

    public static String removeRepeatedWords(String input) {
        String regex = "\\b(\\w+)(\\b\\s+\\1)+\\b";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String repeatedWord = matcher.group(1);
            String repeatedPattern = "\\b(" + repeatedWord + ")(?i)(\\b\\s+\\1)+";
            input = input.replaceAll(repeatedPattern, repeatedWord);
        }

        return input;
    }
}

/*
In this challenge, we use regular expressions (RegEx) to remove instances of words that are repeated more than once,
        but retain the first occurrence of any case-insensitive repeated word. For example,
        the words love and to are repeated in the sentence I love Love to To tO code. Can you complete
        the code in the editor so it will turn I love Love to To tO code into I love to code?*/
