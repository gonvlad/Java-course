package by.gsu.pms;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Parser {

    public static StringBuilder parseFileForText(String filepath) throws FileNotFoundException {
        FileReader file = new FileReader(filepath);
        Scanner scanner = new Scanner(file);

        StringBuilder textStr = new StringBuilder();
        while (scanner.hasNext()) {
            textStr.append(scanner.nextLine()).append(" ");
        }

        return textStr;
    }

    public static void parseSpaces(StringBuilder str) {
        for (int i = 0; i < str.length() - 1; ++i) {
            if (str.charAt(i) == ' ' & str.charAt(i + 1) == ' ') {
                str.deleteCharAt(i);
                i -= 1;
            }
        }
    }

    public static Sentence[] parseSentences(StringBuilder str) {
        // preprocess string - count ending symbols
        int numberOfDots = 0;
        int numberOfQuestionPoints = 0;
        int numberOfExclamationPoints = 0;

        for (int i = 0; i < str.length() - 1; ++i) {
            if (str.charAt(i) == '.') {
                numberOfDots++;
            } else if (str.charAt(i) == '?') {
                numberOfQuestionPoints++;
            } else if (str.charAt(i) == '!') {
                numberOfExclamationPoints++;
            }
        }

        // create sentences array according to number of ending symbols
        int totalNumberOfEndingSymbols = numberOfDots + numberOfQuestionPoints + numberOfExclamationPoints;
        Sentence[] sentences = new Sentence[totalNumberOfEndingSymbols];

        // parse each sentence
        int j = 0;
        int numberOfCommas = 0;
        char endingSymbol;
        StringBuilder currentSentence = new StringBuilder();
        for (int i = 0; i < str.length(); ++i) {
            currentSentence.append(str.charAt(i));
            if (str.charAt(i) == '.' | str.charAt(i) == '?' | str.charAt(i) == '!') {
                endingSymbol = str.charAt(i);
                Word[] words = parseWords(currentSentence.toString().strip());
                sentences[j] = new Sentence(currentSentence.toString().strip(), words, endingSymbol, numberOfCommas);
                ++j;
                currentSentence.setLength(0);
                numberOfCommas = 0;
            } else if (str.charAt(i) == ',') {
                numberOfCommas++;
            }
        }

        return sentences;
    }

    public static Word[] parseWords(String sentence) {
        String[] wordsArray = sentence.split(" ");
        Word[] words = new Word[wordsArray.length];
        for (int i = 0; i < wordsArray.length; i++) {
            wordsArray[i] = wordsArray[i].replaceAll("[.,!?]", "");
            words[i] = new Word(wordsArray[i]);
        }

        return words;
    }
}
