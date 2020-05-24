package by.gsu.pms;

public class Word {
    private String word;
    private int wordLength;

    Word() { }

    Word(String word) {
        this.word = word;
        this.wordLength = word.length();
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getWordLength() {
        return wordLength;
    }

    public void setWordLength(int wordLength) {
        this.wordLength = wordLength;
    }

    @Override
    public String toString() {
        return word;
    }
}
