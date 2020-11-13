package by.gsu.pms;

import java.util.ArrayList;

public class Bank {
    private String bankName;
    private ArrayList<Currency> currencies;

    public Bank() {}

    public Bank(String bankName, ArrayList<Currency> currencies) {
        this.bankName = bankName;
        this.currencies = currencies;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public ArrayList<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(ArrayList<Currency> currencies) {
        this.currencies = currencies;
    }
}
