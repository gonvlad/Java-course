package com.company.lab2_interfaces_abstract;

import java.util.concurrent.TimeUnit;

public class UserMenu {
    private static final String ANSI_RESET   = "\u001B[0m";
    private static final String ANSI_GREEN   = "\u001B[32m";
    private static final String	ANSI_MAGENTA = "\u001B[35m";

    public static void printInitialGreeting() {
        System.out.println("\t\t***   " + ANSI_MAGENTA + "CHEF MASTER 1.0" + ANSI_RESET + "   ***\n");
    }

    public static void printMainMenu() {
        System.out.println("\n\t  USER MENU:     ");
        System.out.println("\t------------------------------------");
        System.out.println("\t  1. Подсчитать калорийность;\n" +
                            "\t  2. Сортировать продукты в салате;\n" +
                            "\t  3. Поиск овощей по калорийности;\n" +
                            "\t  4. Выход.\n");
    }
}
