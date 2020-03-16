package by.gsu.pms;

public class Potato extends Tubers {
    public Potato() {
        super();
    }

    public Potato(String vegetableName, float weight) {
        super(vegetableName, weight);
    }

    public Potato(String vegetableName, float weight, int calPer100Grams) {
        super(vegetableName, weight, calPer100Grams);
    }

    @Override
    public String showInfo() {
        return "The potato is a root vegetable native to the Americas, a starchy tuber of the plant " +
                "Solanum tuberosum, and the plant itself, a perennial in the family Solanaceae.";
    }
}
