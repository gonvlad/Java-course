package by.gsu.pms;
import by.gsu.pms.Converter;

public class BusinessTrip {
    public final int DAILY_RATE = 25000;
    private String account;
    private int expenses;
    private int daysInTrip;

    public BusinessTrip() {}

    public BusinessTrip(String account, int expenses, int numberOfDays) {
        this.account         = account;
        this.expenses        = expenses;
        this.daysInTrip      = numberOfDays;
    }

    public String getAccount() {
        return account;
    }

    public int getExpenses() {
        return expenses;
    }

    public int getDaysInTrip() {
        return daysInTrip;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setExpenses(int expenses) {
        this.expenses = expenses;
    }

    public void setDaysInTrip(int daysInTrip) {
        this.daysInTrip = daysInTrip;
    }

    public int getTotal() {
        if (daysInTrip == 1) {
            return expenses;
        } else if (daysInTrip > 1) {
            return daysInTrip * DAILY_RATE + expenses;
        } else {
            return 0;
        }
    }

    public void show() {
        System.out.printf("rate = %d\n" +
                        "name = %s\n" +
                        "transport = %d\n" +
                        "days = %d\n" +
                        "total = %d\n\n",
                DAILY_RATE, account, expenses, daysInTrip, this.getTotal());
    }

    @Override
    public String toString() {
        return DAILY_RATE + ";" + account + ";" + Converter.convert((double) expenses, 10000, 2) + ";" +
                daysInTrip + ";" + Converter.convert(this.getTotal(), 10000, 2);
    }
}