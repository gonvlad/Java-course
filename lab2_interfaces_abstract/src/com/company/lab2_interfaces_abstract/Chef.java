package com.company.lab2_interfaces_abstract;

import by.gsu.pms.*;

import java.util.Arrays;
import java.util.Scanner;

public class Chef {
    public static void main(String[ ] args) {
        Scanner scanner = new Scanner(System.in);

        Salad[] salads = new Salad[3];
        salads[0] = new Salad();
        salads[1] = new Salad(new Vegetables[] {
                new Batata("Sweet potato", 0.35f, 87),
                new Bulbous("Garlic", 0.13f),
                new Roots("Beet", 0.045f, 48)
        });
        salads[2] = new Salad("Greek", new Vegetables[] {
                new Potato("Potato", 0.3f, 83),
                new Beans("Peas", 0.15f, 72),
                new Roots("Carrot", 0.205f, 33),
                new Bulbous("Onion", 0.075f, 22)
        });

        UserMenu.printInitialGreeting();

        int userChoice;
        boolean isInputValid;
        while (true) {
            UserMenu.printMainMenu();
            do {
                System.out.print(">>> ");
                userChoice = scanner.nextInt();

                switch (userChoice) {
                    case 1:
                        System.out.println("\tCount calories (total and per 100 grams).");
                        System.out.println("\t-----------------------------------------");
                        System.out.printf("\tSalad: %s;\n\tCalories: %d cal in %.2f grams;" +
                                "\n\tCalories per 100 grams: %d cal.\n",
                                salads[2].getSaladName(), salads[2].getSaladCalories(),
                                salads[2].getSaladWeight(), salads[2].getSaladCaloriesPer100Grams());
                        isInputValid = true;
                        break;
                    case 2:
                        System.out.println("\tSorting salad components by calories per 100 grams.");
                        System.out.println("\t---------------------------------------------------");
                        Arrays.sort(salads[2].getSaladComponents());
                        for (Vegetables vegetable: salads[2].getSaladComponents()) {
                            System.out.println("\t" + vegetable.getVegetableName() + " : "
                                                    + vegetable.getCalPer100Grams() + " cal.");
                        }
                        isInputValid = true;
                        break;
                    case 3:
                        System.out.println("\tSearch salad components, which in specified calories range.");
                        System.out.println("\t-----------------------------------------------------------");
                        System.out.print("\tEnter minimum calorie: ");
                        int minCalories = scanner.nextInt();
                        System.out.print("\tEnter maximum calorie: ");
                        int maxCalories = scanner.nextInt();
                        for (Vegetables vegetable: salads[2].getSaladComponents()) {
                            if (minCalories < vegetable.getCalPer100Grams() &&
                                              vegetable.getCalPer100Grams() < maxCalories) {
                                System.out.println("\t" + vegetable.getVegetableName() + " : "
                                        + vegetable.getCalPer100Grams() + " cal.");
                            }
                        }
                        isInputValid = true;
                        break;
                    case 4:
                        System.out.println("\tСпасибо за использование программы! До свидания!");
                        System.exit(0);
                    default:
                        System.out.println("\tТакого пункта меню нет! Выберите существующий!");
                        isInputValid = false;
                        break;
                }
            } while (isInputValid);
        }
    }
}
