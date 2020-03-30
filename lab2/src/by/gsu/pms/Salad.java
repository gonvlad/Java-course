package by.gsu.pms;

public class Salad {
    String saladName;
    Vegetables[] saladComponents;

    public Salad() {
        this.saladComponents = new Vegetables[0];
    }

    public Salad(Vegetables[] saladComponents) {
        this.saladComponents = saladComponents;
    }

    public Salad(String saladName, Vegetables[] saladComponents) {
        this.saladName = saladName;
        this.saladComponents = saladComponents;
    }

    public String getSaladName() {
        return saladName;
    }

    public void setSaladName(String saladName) {
        this.saladName = saladName;
    }

    public Vegetables[] getSaladComponents() {
        return saladComponents;
    }

    public void setSaladComponents(Vegetables[] saladComponents) {
        this.saladComponents = saladComponents;
    }

    public float getSaladWeight() {
        float saladWeight = 0.0f;
        for (Vegetables vegetable: saladComponents) {
            saladWeight += vegetable.getWeight();
        }
        return saladWeight;
    }

    public int getSaladCalories() {
        int saladCalories = 0;
        for (Vegetables vegetable: saladComponents) {
            saladCalories += vegetable.getCalPer100Grams();
        }
        return saladCalories;
    }

    public int getSaladCaloriesPer100Grams() {
        return Math.round(getSaladCalories() * 100 / (getSaladWeight() * 1000));
    }
}
