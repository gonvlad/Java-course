package by.gsu.pms;

public class PunctuationMark {
    private int numberOfDots = 0;
    private int numberOfQuestionPoints = 0;
    private int numberOfExclamationPoints = 0;

    PunctuationMark() { }

    PunctuationMark(int numberOfDots, int numberOfQuestionPoints, int numberOfExclamationPoints) {
        this.numberOfDots = numberOfDots;
        this.numberOfQuestionPoints = numberOfQuestionPoints;
        this.numberOfExclamationPoints = numberOfExclamationPoints;
    }

    public int getNumberOfDots() {
        return numberOfDots;
    }

    public int getNumberOfQuestionPoints() {
        return numberOfQuestionPoints;
    }

    public int getNumberOfExclamationPoints() {
        return numberOfExclamationPoints;
    }

    public void setNumberOfDots(int numberOfDots) {
        this.numberOfDots = numberOfDots;
    }

    public void setNumberOfQuestionPoints(int numberOfQuestionPoints) {
        this.numberOfQuestionPoints = numberOfQuestionPoints;
    }

    public void setNumberOfExclamationPoints(int numberOfExclamationPoints) {
        this.numberOfExclamationPoints = numberOfExclamationPoints;
    }
}
