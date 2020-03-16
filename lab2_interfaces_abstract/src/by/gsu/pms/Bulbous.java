package by.gsu.pms;

public class Bulbous implements Vegetables, Printable {
    private String vegetableName;
    private int calPer100Grams;
    private float weight;

    public Bulbous() { }

    public Bulbous(String vegetableName, float weight) {
        this.vegetableName = vegetableName;
        this.weight = weight;
    }

    public Bulbous(String vegetableName, float weight, int calPer100Grams) {
        this.vegetableName = vegetableName;
        this.weight = weight;
        this.calPer100Grams = calPer100Grams;
    }

    public String getVegetableName() {
        return vegetableName;
    }

    public int getCalPer100Grams() {
        return calPer100Grams;
    }

    public float getWeight() { return weight; }

    public void setVegetableName(String vegetableName) {
        this.vegetableName = vegetableName;
    }

    public void setCalPer100Grams(int calPer100Grams) {
        this.calPer100Grams = calPer100Grams;
    }

    public void setWeight(float weight) { this.weight = weight; }

    public String showInfo() {
        return "Bulb is a modified, usually underground shoot of plants with a thickened short flat stalk (bottom) " +
                "and sprouted fleshy or filmy colorless leaf bases (scales) that store water and nutrients, " +
                "which also serve as an organ of vegetative propagation.";
    }

    @Override
    public int compareTo(Vegetables compareVegetable) {
        return this.calPer100Grams - compareVegetable.getCalPer100Grams();
    }

    public void writerInfo() {
        System.out.println(vegetableName + ";" + weight + ";" + calPer100Grams);
    }
}
