package by.gsu.pms;

public class Roots implements Vegetables, Printable {
    private String vegetableName;
    private int calPer100Grams;
    private float weight;

    public Roots() { }

    public Roots(String vegetableName, float weight) {
        this.vegetableName = vegetableName;
        this.weight = weight;
    }

    public Roots(String vegetableName, float weight, int calPer100Grams) {
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
        return "Root crop - part of the plant that stores nutrients, most often associated with the root system, " +
                "where the first part of the name comes from. The fruits are not, the second part of the name is " +
                "biologically incorrect, but traditional.";
    }

    @Override
    public int compareTo(Vegetables compareVegetable) {
        return this.calPer100Grams - compareVegetable.getCalPer100Grams();
    }

    public void writerInfo() {
        System.out.println(vegetableName + ";" + weight + ";" + calPer100Grams);
    }
}
