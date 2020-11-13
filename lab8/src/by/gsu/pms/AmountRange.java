package by.gsu.pms;

import java.math.BigInteger;

public class AmountRange {
    private int minAmount;
    private BigInteger maxAmount;
    private double buyPrice;
    private double sellPrice;

    public AmountRange() {}

    public AmountRange(int minAmount, BigInteger maxAmount, double buyPrice, double sellPrice) {
        this.minAmount= minAmount;
        this.maxAmount = maxAmount;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
    }

    public int getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(int minAmount) {
        this.minAmount = minAmount;
    }

    public BigInteger getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(BigInteger maxAmount) {
        this.maxAmount = maxAmount;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }
}
