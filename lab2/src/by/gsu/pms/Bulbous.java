package by.gsu.pms;

public class Bulbous extends Vegetables {
    public Bulbous() {
        super();
    }

    public Bulbous(String vegetableName, float weight) {
        super(vegetableName, weight);
    }

    public Bulbous(String vegetableName, float weight, int calPer100Grams) {
        super(vegetableName, weight, calPer100Grams);
    }

    @Override
    public String showInfo() {
        return "Bulb is a modified, usually underground shoot of plants with a thickened short flat stalk (bottom) " +
                "and sprouted fleshy or filmy colorless leaf bases (scales) that store water and nutrients, " +
                "which also serve as an organ of vegetative propagation.";
    }
}
