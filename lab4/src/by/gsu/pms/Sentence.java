package by.gsu.pms;

import java.util.Arrays;

public class Sentence {
    private String sentence = "";
    private char endingSymbol = '.';
    private int numberOfCommas = 0;
    private Word[] words;

    Sentence() { }

    Sentence(String sentence, Word[] words, char endingSymbol, int numberOfCommas) {
        this.sentence = sentence;
        this.endingSymbol = endingSymbol;
        this.numberOfCommas = numberOfCommas;
        this.words = words;
    }

    public int getNumberOfCommas() {
        return numberOfCommas;
    }

    public void setNumberOfCommas(int numberOfCommas) {
        this.numberOfCommas = numberOfCommas;
    }

    public char getEndingSymbol() {
        return endingSymbol;
    }

    public void setEndingSymbol(char endingSymbol) {
        this.endingSymbol = endingSymbol;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public Word[] getWords() {
        return words;
    }

    public void setWords(Word[] words) {
        this.words = words;
    }

    @Override
    public String toString() {
        return "Sentence: " + sentence +
                "\nWords: " + Arrays.toString(words) +
                "\nNumber of commas: " + numberOfCommas +
                "\nEnding symbol: '" + endingSymbol + "'\n";
    }
}
