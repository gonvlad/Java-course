package by.gsu.pms;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Serialization {
    public static void serialize(Product[] products) {

        try (ObjectOutputStream oos = new ObjectOutputStream((new FileOutputStream("products.dat"))))
        {

            for (int i = 0; i < products.length; ++i) {
                oos.writeObject(products[i]);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
