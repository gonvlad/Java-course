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
        catch (EOFException | FileNotFoundException ex) {
            System.out.println("Deserialization finished!");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
