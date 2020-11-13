package by.gsu.pms;

public class CalculatorThread extends Thread {
    private int startRangeValue;
    private int endRangeValue;
    private int result = 0;

    public CalculatorThread(int startRangeValue, int endRangeValue) {
        this.startRangeValue = startRangeValue;
        this.endRangeValue = endRangeValue;
    }

    public int getStartRangeValue() {
        return startRangeValue;
    }

    public void setStartRangeValue(int startRangeValue) {
        this.startRangeValue = startRangeValue;
    }

    public int getEndRangeValue() {
        return endRangeValue;
    }

    public void setEndRangeValue(int endRangeValue) {
        this.endRangeValue = endRangeValue;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        boolean b = true;
        if (startRangeValue == 1) {
            startRangeValue = 2;
        }

        for (int i = startRangeValue; i <= endRangeValue; ++i) {
            for (int j = 2; j < i; ++j) {
                if (i % j == 0) {
                    b = false;
                    break;
                }
            }
            if (b) {
                this.result += i;
            } else {
                b = true;
            }
        }
    }
}
