package by.gsu.pms;

public class Tubers extends Vegetables {
    public Tubers() {
        super();
    }

    public Tubers(String vegetableName, float weight) {
        super(vegetableName, weight);
    }

    public Tubers(String vegetableName, float weight, int calPer100Grams) {
        super(vegetableName, weight, calPer100Grams);
    }

    @Override
    public String showInfo() {
        return "Tuberous crops are modified shoots in which plants store nutrients, mainly starch. From tubers, " +
                "potatoes and sweet potatoes (in tropical countries) are used for food, and Jerusalem artichoke " +
                "(earthen pear) for livestock feed.";
    }
}
