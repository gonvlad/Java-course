package by.gsu.pms;

public class BusinessTrip {
    final double DAILY_RATE = 25000;
    String account;
    double expenses;
    int numberOfDays;

    public BusinessTrip(String _account, double _expenses, int _numberOfDays) {
        account         = _account;
        expenses        = _expenses;
        numberOfDays    = _numberOfDays;
    }

    public String getAccount() {
        return account;
    }

    public double getExpenses() {
        return expenses;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public double getTotal() {
        if (numberOfDays == 1) {
            return expenses;
        } else if (numberOfDays > 1) {
            return numberOfDays * DAILY_RATE + expenses;
        } else {
            System.out.println("Вы указали недопустимое количество дней!");
            return 0.0;
        }
    }

    public void show() {
        System.out.printf("rate = %f\n" +
                             "name = %s\n" +
                             "transport =%f\n" +
                             "days = %d\n" +
                             "total =%f\n\n",
                             DAILY_RATE, account, expenses, numberOfDays, this.getTotal());
    }

    @Override
    public void toString() {
        System.out.println();
    }

}

