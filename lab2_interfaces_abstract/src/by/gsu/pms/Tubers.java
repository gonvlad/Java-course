package by.gsu.pms;

abstract class Tubers implements Vegetables, Printable {
    private String vegetableName;
    private int calPer100Grams;
    private float weight;

    public Tubers() { }

    public Tubers(String vegetableName, float weight) {
        this.vegetableName = vegetableName;
        this.weight = weight;
    }

    public Tubers(String vegetableName, float weight, int calPer100Grams) {
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
        return "Tuberous crops are modified shoots in which plants store nutrients, mainly starch. From tubers, " +
                "potatoes and sweet potatoes (in tropical countries) are used for food, and Jerusalem artichoke " +
                "(earthen pear) for livestock feed.";
    }

    public void writerInfo() {
        System.out.println(vegetableName + ";" + weight + ";" + calPer100Grams);
    }

    @Override
    public int compareTo(Vegetables compareVegetable) {
        return this.calPer100Grams - compareVegetable.getCalPer100Grams();
    }
}
