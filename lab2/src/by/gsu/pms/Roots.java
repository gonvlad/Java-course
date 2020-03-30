package by.gsu.pms;

public class Roots extends Vegetables {
    public Roots() {
        super();
    }

    public Roots(String vegetableName, float weight) {
        super(vegetableName, weight);
    }

    public Roots(String vegetableName, float weight, int calPer100Grams) {
        super(vegetableName, weight, calPer100Grams);
    }

    @Override
    public String showInfo() {
        return "Root crop - part of the plant that stores nutrients, most often associated with the root system, " +
                "where the first part of the name comes from. The fruits are not, the second part of the name is " +
                "biologically incorrect, but traditional.";
    }
}
