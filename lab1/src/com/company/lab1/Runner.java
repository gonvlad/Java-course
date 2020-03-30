package com.company.lab1;
import by.gsu.pms.Product;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        Product[] products = new Product[8];

        products[0] = new Product("Milk", true, 1.15);
        products[1] = new Product("Bread", true, 0.99);
        products[2] = new Product("Ice Cream", false, 1.37);
        products[3] = new Product("Soda", false, 1.43);
        products[4] = new Product("Pork", true, 10.99);
        products[5] = new Product("Cake", false, 8.49);
        products[6] = new Product("Cheese", true, 6.87);
        products[7] = new Product("Bubble Gum", true, 0.99);

        for (int i = 0; i < products.length; ++i) {
           System.out.println(products[i].toString());
        }

        Arrays.sort(products);
        System.out.println();

        for (int i = 0; i < products.length; ++i) {
            System.out.println(products[i]);
        }

        Arrays.sort(products, Product.ProductNameComparator);
        System.out.println();

        for (int i = 0; i < products.length; ++i) {
            System.out.println(products[i]);
        }

        double totalCost = 0.0;
        for (int i = 0; i < products.length; ++i) {
            totalCost += products[i].getProductPrice();
        }
        System.out.printf("\nTotal cost = %.2f\n", totalCost);

        int numberOfProductsInStock = 0;
        for (int i = 0; i < products.length; ++i) {
            if (products[i].getIsInStock()) {
                numberOfProductsInStock++;
            }
        }
        System.out.printf("\nThere are(is) %d products in stock.\n", numberOfProductsInStock);
    }
}
