package by.gsu.pms;

public class ThreadGenerator {
    public final int minRangeValue = 1;

    private char operationType = '+';
    private int result;
    private int numberOfThreads;
    private int maxRangeValue;
    private CalculatorThread[] threads;

    public ThreadGenerator(int numberOfThreads, int maxRangeValue, char operationType) {
        this.numberOfThreads = numberOfThreads;
        this.maxRangeValue = maxRangeValue;
        this.operationType = operationType;

        threads = new CalculatorThread[numberOfThreads];
        int threadVolume = maxRangeValue / numberOfThreads;
        int startThreadValue;
        int endThreadValue;
        for (int i = 0; i < numberOfThreads; ++i) {
            startThreadValue = i * threadVolume + minRangeValue;
            endThreadValue =  i * threadVolume + threadVolume;
            if (maxRangeValue - endThreadValue < threadVolume) {
                 endThreadValue += maxRangeValue - endThreadValue;
            }
            threads[i] = new CalculatorThread(startThreadValue, endThreadValue);
        }
    }

    public int getNumberOfThreads() {
        return numberOfThreads;
    }

    public void setNumberOfThreads(int numberOfThreads) {
        this.numberOfThreads = numberOfThreads;
    }

    public int getMaxRangeValue() {
        return maxRangeValue;
    }

    public void setMaxRangeValue(int maxRangeValue) {
        this.maxRangeValue = maxRangeValue;
    }

    public CalculatorThread[] getThreads() {
        return threads;
    }

    public void setThreads(CalculatorThread[] threads) {
        this.threads = threads;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getResult() throws InterruptedException {
        for (CalculatorThread calculatorThread: threads) {
            calculatorThread.join();

            switch (operationType) {
                case '+':
                    this.result += calculatorThread.getResult();
                    break;
                case '-':
                    this.result -= calculatorThread.getResult();
                    break;
                case '*':
                    this.result *= calculatorThread.getResult();
                    break;
                case '/':
                    this.result /= calculatorThread.getResult();
                    break;
                default:
                    System.out.println("\n>>> Warning! Unknown operation type. Choose another one and reevaluate task.");
            }
        }

        return this.result;
    }

    public char getOperationType() {
        return operationType;
    }

    public void setOperationType(char operationType) {
        this.operationType = operationType;
    }

    public void execute() {
        for (CalculatorThread thread: this.threads)
        {
            thread.start();
        }
    }
}
