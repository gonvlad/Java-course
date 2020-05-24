package by.gsu.pms;

import java.io.*;

public class Serialization {
    public static void serialize(Product[] products) {

        try (ObjectOutputStream oos = new ObjectOutputStream((new FileOutputStream("products.dat"))))
        {
            for (int i = 0; i < products.length; ++i) {
                oos.writeObject(products[i]);
            }
        }
        catch (EOFException ex) {
            System.out.println("=> End of file reached! Deserialization finished!");
        }
        catch (FileNotFoundException ex) {
            System.out.println("=> File not found!");
        }
        catch (IOException ex) {
            System.out.println("=> Error in Input/Output system!");
        }
    }
}
