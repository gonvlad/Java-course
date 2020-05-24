package com.company.lab5;

import by.gsu.pms.Deserialization;
import by.gsu.pms.Product;
import by.gsu.pms.Serialization;
import user.defined.exceptions.NumberOfProductsException;
import user.defined.exceptions.TotalCostException;

public class Runner {
    public static void main(String[] args) {
        Product[] products = new Product[8];

        try {
            products[0] = new Product("Milk", true, 1.15);
            products[1] = new Product("Bread", true, 0.99);
            products[2] = new Product("Ice Cream", false, 1.37);
            products[3] = new Product("Soda", false, 1.43);
            products[4] = new Product("Pork", true, 10.99);
            products[5] = new Product("Cake", false, 8.49);
            products[6] = new Product("Cheese", true, 6.87);
            products[7] = new Product("Bubble Gum", true, 0.99);
        } catch(ArrayIndexOutOfBoundsException ex){
            System.out.println("=> Array Index is Out Of Bounds");
        }

        try {
            for (int i = 0; i < products.length; ++i) {
                System.out.println(products[i].toString());
            }
        } catch (NullPointerException ex) {
            System.out.println("=> Bad pointer to object.");
        }

        System.out.println("\nSerialize...");
        Serialization.serialize(products);
        System.out.println("Product objects serialized!");

        System.out.println("\nDeserialize...");
        Deserialization.deserialize();

        double totalCost = 0.0;
        try {
            for (int i = 0; i < products.length; ++i) {
                totalCost += products[i].getProductPrice();
            }

            if (totalCost < 35) {
                TotalCostException ex = new TotalCostException("=> Products total cost less than 35");
                throw ex;
            }
        } catch (NullPointerException ex) {
            System.out.println("=> Bad pointer to object.");
        } catch (TotalCostException ex) {
            ex.printStackTrace();
        }
        System.out.printf("\nTotal cost = %.2f\n", totalCost);

        int numberOfProductsInStock = 0;
        try {
            for (int i = 0; i < products.length; ++i) {
                if (products[i].getIsInStock()) {
                    numberOfProductsInStock++;
                }
            }

            if (numberOfProductsInStock < 5) {
                NumberOfProductsException ex = new NumberOfProductsException("=> Number of products in stock less than 5");
                throw ex;
            }
        } catch (NullPointerException ex) {
            System.out.println("=> Bad pointer to object.");
        } catch (NumberOfProductsException ex) {
            ex.printStackTrace();
        }
        System.out.printf("\nThere are(is) %d products in stock.\n", numberOfProductsInStock);
    }
}