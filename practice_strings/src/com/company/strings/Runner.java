package com.company.strings;
import by.gsu.pms.BusinessTrip;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws FileNotFoundException {

        String filename = "input.txt";
        FileReader inputFile = new FileReader(filename);
        Scanner scanner = new Scanner(inputFile);

        int dailyRate = Integer.parseInt(scanner.nextLine().split("=")[1].strip());
        String tripsData = "";

        while (scanner.hasNext()) {
            tripsData += scanner.nextLine() + "\n";
        }

        String[] bufferIndices = tripsData.split("\n")[0].split("=")[1].split(";");
        int[] indices = new int[bufferIndices.length];

        for (int i = 0; i < bufferIndices.length; ++i) {
            indices[i] = Integer.parseInt(bufferIndices[i].strip());
        }

        String[] tripsDataArray = tripsData.split("\n");
        BusinessTrip[] businessTrips = new BusinessTrip[indices.length];
        for (int i = 0; i < indices.length; ++i) {
            String searchName = "";
            if (indices[i] < 10) {
                searchName = "account0" + indices[i];
            } else {
                searchName = "account" + indices[i];
            }

            String account = "";
            for (int j = 0; j < tripsDataArray.length; ++j) {
                if (tripsDataArray[j].startsWith(searchName)) {
                    account = tripsDataArray[j].split("=")[1].strip();
                }
            }

            if (indices[i] < 10) {
                searchName = "transport0" + indices[i];
            } else {
                searchName = "transport" + indices[i];
            }
            int expenses = 0;
            for (int j = 0; j < tripsDataArray.length; ++j) {
                if (tripsDataArray[j].startsWith(searchName)) {
                    expenses = Integer.parseInt(tripsDataArray[j].split("=")[1].strip());
                }
            }

            if (indices[i] < 10) {
                searchName = "days0" + indices[i];
            } else {
                searchName = "days" + indices[i];
            }
            int days = 0;
            for (int j = 0; j < tripsDataArray.length; ++j) {
                if (tripsDataArray[j].startsWith(searchName)) {
                    days = Integer.parseInt(tripsDataArray[j].split("=")[1].strip());
                }
            }

            businessTrips[i] = new BusinessTrip(account, expenses, days);
        }

        for (int i = 0; i < businessTrips.length; ++i) {
            businessTrips[i].show();
        }

        Arrays.sort(businessTrips, Comparator.comparing(BusinessTrip::getTotal).reversed());

        for (int i = 0; i < businessTrips.length; ++i) {
            System.out.println(businessTrips[i]);
        }
    }
}