package com.company.collections;

import by.gsu.pms.PricePurchase;
import by.gsu.pms.Purchase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws FileNotFoundException {

        String filepath = "input.csv";
        FileReader inputFile = new FileReader(filepath);
        Scanner scanner = new Scanner(inputFile);

        ArrayList<Purchase> purchases = new ArrayList<>();
        while (scanner.hasNext()) {
            String[] productRecord = scanner.nextLine().split(";");

            if (productRecord.length == 3) {
                purchases.add(new Purchase(productRecord[0],
                                            Integer.parseInt(productRecord[1]),
                                            Integer.parseInt(productRecord[2])));
            } else if (productRecord.length == 4) {
                purchases.add(new PricePurchase(productRecord[0],
                                                Integer.parseInt(productRecord[1]),
                                                Integer.parseInt(productRecord[2]),
                                                Integer.parseInt(productRecord[3])));
            }
        }

        System.out.print("\nProducts collection at start:");
        for (Purchase purchase: purchases) {
            System.out.println(purchase);
        }

        System.out.println("\nPurchase with the index 6: " + purchases.get(6));

        Iterator<Purchase> iter = purchases.iterator();
        while (iter.hasNext()) {
            if (iter.next().getProductPrice() < 10000) {
                iter.remove();
            }
        }

        Collections.sort(purchases);

        System.out.print("\nProducts collection after sort (increasing price):");
        for (Purchase purchase: purchases) {
            System.out.println(purchase);
        }

        System.out.print("\nProducts with the cost equaled 35000:");
        for (Purchase purchase: purchases) {
            if (purchase.getTotalPrice() == 35000) {
                System.out.println(purchase);
            }
        }

    }
}
