package by.gsu.pms;

public class Batata extends Tubers {
    public Batata() {
        super();
    }

    public Batata(String vegetableName, float weight) {
        super(vegetableName, weight);
    }

    public Batata(String vegetableName, float weight, int calPer100Grams) {
        super(vegetableName, weight, calPer100Grams);
    }

    @Override
    public String showInfo() {
        return "Batata is the word for sweet potato (Latin: Ipomoea batatas) in many languages " +
                "(e.g. Spanish, Hebrew, Egyptian Arabic, and Sanger), originally from the Taíno batata " +
                "(see Sweet potato → Names).";
    }
}
