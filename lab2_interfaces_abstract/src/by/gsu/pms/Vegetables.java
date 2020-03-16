package by.gsu.pms;

public interface Vegetables extends Comparable<Vegetables> {

    String getVegetableName();
    int getCalPer100Grams();
    float getWeight();

    void setVegetableName(String vegetableName);
    void setCalPer100Grams(int calPer100Grams);
    void setWeight(float weight);

    String showInfo();

    int compareTo(Vegetables compareVegetable);
}

