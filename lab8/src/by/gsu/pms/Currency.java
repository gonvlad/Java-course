package by.gsu.pms;

import java.util.ArrayList;

public class Currency {
    private String currencyName;
    private int numberOfUnits;
    private ArrayList<AmountRange> amountRanges;

    public Currency() {}

    public Currency(String currencyName, int numberOfUnits, ArrayList<AmountRange> amountRanges) {
        this.currencyName = currencyName;
        this.numberOfUnits = numberOfUnits;
        this.amountRanges = amountRanges;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public int getNumberOfUnits() {
        return numberOfUnits;
    }

    public void setNumberOfUnits(int numberOfUnits) {
        this.numberOfUnits = numberOfUnits;
    }

    public ArrayList<AmountRange> getAmountRanges() {
        return amountRanges;
    }

    public void setAmountRanges(ArrayList<AmountRange> amountRanges) {
        this.amountRanges = amountRanges;
    }
}
