package by.gsu.pms;

import java.io.*;

public class Deserialization {
    public static void deserialize() {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("products.dat"))) {
            while (true) {
                Product product = (Product) ois.readObject();
                System.out.println(product);
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
        catch (ClassNotFoundException ex) {
            System.out.println("=> Class not found!");
        }
    }
}
