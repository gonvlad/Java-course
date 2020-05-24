package com.company.lab4;

import by.gsu.pms.Parser;
import by.gsu.pms.Sentence;
import by.gsu.pms.Word;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws FileNotFoundException {

        System.out.print("Enter any integer (required word length): ");
        Scanner scanStdIn = new Scanner(System.in);
        int desiredWordLength = scanStdIn.nextInt();

        // Open file and put file data to StringBuilder
        String filepath = "prog_book.txt";
        StringBuilder bookText = Parser.parseFileForText(filepath);

        // delete extra spaces
        Parser.parseSpaces(bookText);

        // parse text for sentences
        Sentence[] sentences = Parser.parseSentences(bookText);

        // Task
        for (int i = 0; i < sentences.length; ++i) {
            if (sentences[i].getEndingSymbol() == '?') {
                System.out.println("\nSentence: " + sentences[i].getSentence());
                System.out.print(desiredWordLength + " character words: ");
                StringBuilder wordsOfDesiredLength = new StringBuilder();
                for (Word word: sentences[i].getWords()) {
                    if (word.getWordLength() == desiredWordLength) {
                        wordsOfDesiredLength.append(word.getWord()).append(" ");
                    }
                }

                String[] wordsOfDesiredLengthArray = wordsOfDesiredLength.toString().split(" ");
                for (int j = 0; j < wordsOfDesiredLengthArray.length; ++j) {
                    for (int k = j + 1; k < wordsOfDesiredLengthArray.length; ++k) {
                        if (wordsOfDesiredLengthArray[j].equals(wordsOfDesiredLengthArray[k])) {
                            wordsOfDesiredLengthArray[k] = "";
                        }
                    }
                }

                for (int j = 0; j < wordsOfDesiredLengthArray.length; ++j) {
                    if (!wordsOfDesiredLengthArray[j].equals("")) {
                        System.out.print(wordsOfDesiredLengthArray[j] + " ");
                    }
                }
                System.out.println();
            }
        }
    }
}
