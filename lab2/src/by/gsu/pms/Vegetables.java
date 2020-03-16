package by.gsu.pms;

public class Vegetables implements Comparable<Vegetables> {
    public String vegetableName;
    public int calPer100Grams;
    public float weight;

    public Vegetables() {}

    public Vegetables(String vegetableName, float weight) {
        this.vegetableName = vegetableName;
        this.weight = weight;
    }

    public Vegetables(String vegetableName, float weight, int calPer100Grams) {
        this.vegetableName = vegetableName;
        this.calPer100Grams = calPer100Grams;
        this.weight = weight;

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
        return "Vegetables - a culinary term for the edible part (for example, fruit or tuber) of certain plants, " +
                "as well as any solid plant food, with the exception of fruits, cereals, mushrooms, nuts and edible " +
                "algae.";
    }

    @Override
    public int compareTo(Vegetables compareVegetable) {
        return this.calPer100Grams - compareVegetable.getCalPer100Grams();
    }
}
