package by.gsu.pms;

public class Beans extends Vegetables {
    public Beans() {
        super();
    }

    public Beans(String vegetableName, float weight) {
        super(vegetableName, weight);
    }

    public Beans(String vegetableName, float weight, int calPer100Grams) {
        super(vegetableName, weight, calPer100Grams);
    }

    @Override
    public String showInfo() {
        return "Legumes - plants of the order Legumes, which are cultivated as crops. Conventionally emit vegetable " +
                "and fodder legumes.";
    }
}
