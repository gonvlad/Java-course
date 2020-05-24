package com.company.lab6;
import by.gsu.pms.Abiturient;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws FileNotFoundException {
        String filepath = "abiturients.txt";
        int PASSING_SCORE = 18;
        int SEMI_PASS_GRADE = 14;

        FileReader file = new FileReader(filepath);
        Scanner scanner = new Scanner(file);

        ArrayList<Abiturient> abiturients = new ArrayList<Abiturient>();
        while(scanner.hasNext()) {
            String[] abiturientData = scanner.nextLine().split(" ");
            int id = Integer.parseInt(abiturientData[0]);
            String surname = abiturientData[1];
            String name = abiturientData[2];
            String patronymic = abiturientData[3];
            String address = abiturientData[4] + " " + abiturientData[5] + " " + abiturientData[6];
            String mobilePhoneNumber = abiturientData[7];
            ArrayList<Integer> marks = new ArrayList<Integer>();
            marks.add(Integer.parseInt(abiturientData[8]));
            marks.add(Integer.parseInt(abiturientData[9]));
            marks.add(Integer.parseInt(abiturientData[10]));

            abiturients.add(new Abiturient(id, surname, name, patronymic, address, mobilePhoneNumber, marks));
        }

        try {
            File resultFile = new File("result.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(resultFile));

            System.out.print("\nList of applicants with unsatisfactory grades:");
            writer.write("\nList of applicants with unsatisfactory grades:");
            for (Abiturient abiturient: abiturients) {
                if (abiturient.getMarks().contains(3) | abiturient.getMarks().contains(2) | abiturient.getMarks().contains(1)) {
                    System.out.println(abiturient);
                    writer.write(abiturient.toString());
                }
            }

            System.out.print("\nList of applicants whose total score is higher than passing score:");
            writer.write("\nList of applicants whose total score is higher than passing score:");
            for (Abiturient abiturient: abiturients) {
                if (abiturient.getTotalMark() > PASSING_SCORE) {
                    System.out.println(abiturient);
                    writer.write(abiturient.toString());
                }
            }

            Collections.sort(abiturients);
            System.out.print("\nEnter n, where n - number of top-rated abiturients: ");
            Scanner intScanner = new Scanner(System.in);
            int n = intScanner.nextInt();
            int i = 0;
            System.out.print("\nList of " + n + " top-rated abiturients: ");
            writer.write("\nList of " + n + " top-rated abiturients: ");
            for (Abiturient abiturient: abiturients) {
                if (abiturient.getTotalMark() > SEMI_PASS_GRADE & i < n) {
                    System.out.println(abiturient);
                    writer.write(abiturient.toString());
                    i++;
                }
            }

            System.out.print("\nList of applicants whose total score is higher than semi-pass grade:");
            writer.write("\nList of applicants whose total score is higher than semi-pass grade:");
            for (Abiturient abiturient: abiturients) {
                if (abiturient.getTotalMark() > SEMI_PASS_GRADE) {
                    System.out.println(abiturient);
                    writer.write(abiturient.toString());
                }
            }

            writer.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
