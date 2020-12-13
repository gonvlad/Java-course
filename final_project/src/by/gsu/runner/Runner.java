package by.gsu.runner;

import by.gsu.pms.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int userMenuChoice;
        boolean isProgramRunning = true;

        Connection connection = ConnectionHandler.openConnection();

        if (connection != null) {
            while (isProgramRunning) {
                showMenu();
                System.out.print("\nChoose menu item: ");
                userMenuChoice = scanner.nextInt();
                switch (userMenuChoice) {
                    case 1:
                        ArrayList<AccountingRecord> accountingRecords = SelectQueryHandler.selectAccountingRecords(connection);
                        for (AccountingRecord accountingRecord: accountingRecords) {
                            Car car = SelectQueryHandler.selectCarByCarId(accountingRecord.getCarId(), connection);
                            Service service = SelectQueryHandler.selectServiceByServiceId(accountingRecord.getServiceId(), connection);
                        }
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        System.out.println("\n>>> Exiting program...");
                        isProgramRunning = false;
                        connection.close();
                        break;
                    default:
                        System.out.println(">>> Unknown menu item! Choose another one.");
                        break;
                }
            }
        }
    }

    public static void showMenu() {
        System.out.println("\n\t\tUSER MENU");
        System.out.println("------------------------------");
        System.out.println("1. SELECT accounting records");
        System.out.println("2. SELECT cars list");
        System.out.println("3. SELECT services list");
        System.out.println("4. INSERT accounting record");
        System.out.println("5. INSERT car");
        System.out.println("6. DELETE accounting record");
        System.out.println("7. DELETE car");
        System.out.println("8. EXIT program");
    }
}
