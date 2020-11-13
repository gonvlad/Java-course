package by.gsu.lab7;

import by.gsu.pms.ThreadGenerator;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        char operationType = '+';
        int numberOfThreads = 0;
        int maxRangeValue = 0;
        int userMenuChoice;
        boolean isProgramRunning = true;

        while (isProgramRunning)
        {
            System.out.println(getMenu(numberOfThreads, maxRangeValue, operationType));
            System.out.print("Choose user menu item: ");
            userMenuChoice = scanner.nextInt();

            switch (userMenuChoice)
            {
                case 1:
                    System.out.print("\nEnter number of threads: ");
                    numberOfThreads = scanner.nextInt();
                    System.out.println(">>> Number of threads saved.");
                    break;
                case 2:
                    System.out.print("\nEnter max range value: ");
                    maxRangeValue = scanner.nextInt();
                    System.out.println(">>> Max range value saved.");
                    break;
                case 3:
                    System.out.print("\nEnter operation type as sign (+, -, *, /): ");
                    operationType = scanner.next().charAt(0);
                    System.out.println(">>> Operation type saved.");
                    break;
                case 4:
                    if (numberOfThreads > 0 && maxRangeValue > 1 && checkOperationType(operationType)) {
                        ThreadGenerator calculator = new ThreadGenerator(numberOfThreads, maxRangeValue, operationType);
                        calculator.execute();
                        System.out.println("\n>>> Starting task evaluation...");
                        System.out.println("The evaluation result is: " + calculator.getResult());
                        System.out.println(">>> Task evaluated.");
                    } else {
                        System.out.println("\n>>> Warning! Config number of threads and max range value properly" +
                                            " and then return to task evaluation.");
                    }
                    break;
                case 5:
                    isProgramRunning = false;
                    System.out.println("\n>>> Goodbye. See You later.");
                    break;
                default:
                    System.out.println("\n>>> Warning! Unknown menu item! Choose another one.");
            }
        }
    }

    public static String getMenu(int numberOfThreads, int maxRangeValue, char operationType) {
        final String NOT_SET = "(Not set)";
        final String SETTED = "(Setted: ";

        return "\n\tUSER MENU\n" +
                "------------------------------------\n" +
                "1. Enter number of threads " +
                    (numberOfThreads == 0 ? NOT_SET : SETTED + numberOfThreads + ")")  + "\n" +
                "2. Enter right range value " +
                    (maxRangeValue == 0 ? NOT_SET : SETTED + maxRangeValue + ")")  + "\n" +
                "3. Enter operation type " +
                    (checkOperationType(operationType) ? SETTED + operationType + ")" : NOT_SET) + "\n" +
                "4. Evaluate task\n" +
                "5. Exit program\n";
    }

    public static boolean checkOperationType(char operationType) {
        return operationType == '+' || operationType == '-' || operationType == '*' || operationType == '/';
    }
}
