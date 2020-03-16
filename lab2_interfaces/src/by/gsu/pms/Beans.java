package by.gsu.pms;

public class Beans implements Vegetables, Printable {
    private String vegetableName;
    private int calPer100Grams;
    private float weight;

    public Beans() { }

    public Beans(String vegetableName, float weight) {
        this.vegetableName = vegetableName;
        this.weight = weight;
    }

    public Beans(String vegetableName, float weight, int calPer100Grams) {
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
        return "Legumes - plants of the order Legumes, which are cultivated as crops. Conventionally emit vegetable " +
                "and fodder legumes.";
    }

    @Override
    public int compareTo(Vegetables compareVegetable) {
        return this.calPer100Grams - compareVegetable.getCalPer100Grams();
    }

    public void writerInfo() {
        System.out.println(vegetableName + ";" + weight + ";" + calPer100Grams);
    }
}
