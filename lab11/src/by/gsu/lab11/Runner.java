package by.gsu.lab11;

import by.gsu.pms.ConnectionHandler;
import by.gsu.pms.InsertQueryHandler;
import by.gsu.pms.SelectQueryHandler;
import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws SQLException, FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        int userMenuChoice;
        boolean isProgramRunning = true;

        Connection connection = ConnectionHandler.openConnection();

        ScriptRunner scriptRunner = new ScriptRunner(connection);
        Reader reader = new BufferedReader(new FileReader("./resources/index.html"));
        scriptRunner.runScript(reader);

        if (connection != null) {
            while (isProgramRunning)
            {
                showMenu();
                System.out.print("\nChoose menu item: ");
                userMenuChoice = scanner.nextInt();
                switch (userMenuChoice) {
                    case 1:
                        String result = "";
                        System.out.println("\n>>> Selecting data process started...");
                        String task1SelectQuery = "SELECT * FROM Person WHERE person_id = (SELECT sender " +
                                                    "FROM Letter ORDER BY CHAR_LENGTH(letter_text) LIMIT 1);";
                        result += SelectQueryHandler.executeSelectQuery(1, task1SelectQuery, connection);
                        String task2SelectQuery = "SELECT first_name, last_name, COUNT(sended.sender) as number_of_sended, " +
                                                    "COUNT(recieved.recipient) as number_of_received FROM Person " +
                                                    "LEFT JOIN Letter sended ON (Person.person_id = sended.sender) " +
                                                    "LEFT JOIN Letter recieved ON (Person.person_id = recieved.recipient) " +
                                                    "GROUP BY first_name, last_name;";
                        result += SelectQueryHandler.executeSelectQuery(2, task2SelectQuery, connection);
                        String task3SelectQuery = "SELECT * FROM Person WHERE person_id IN " +
                                                    "(SELECT recipient FROM Letter WHERE letter_subject = 'Дай списать матешу');";
                        result += SelectQueryHandler.executeSelectQuery(3, task3SelectQuery, connection);
                        String task4SelectQuery = "SELECT * FROM Person WHERE person_id NOT IN (SELECT recipient FROM Letter " +
                                                    "WHERE letter_subject = 'Дай списать матешу')";
                        result += SelectQueryHandler.executeSelectQuery(4, task4SelectQuery, connection);
                        reportToHTML(result);
                        break;
                    case 2:
                        System.out.println("\n>>> Inserting data process started...");
                        ArrayList<Object> queryParameters = new ArrayList<>();
                        queryParameters.add(1);
                        queryParameters.add(2);
                        queryParameters.add("Белорусский язык");
                        queryParameters.add("Привет! Помоги пожалуйста решить упражнение по белорусскому языку. Заранее спасибо.");
                        queryParameters.add(new java.util.Date());
                        InsertQueryHandler.executeInsertQuery(queryParameters, connection);
                        break;
                    case 3:
                        System.out.println("\n>>> Exiting program...");
                        isProgramRunning = false;
                        connection.close();
                        break;
                    default:
                        System.out.println(">>> Unknown menu item! Choose another one.");
                        break;
                }
            }
        } else {
            System.out.println("\n>>> Exiting program...");
        }
    }

    public static void showMenu() {
        System.out.println("\n\t\tUSER MENU");
        System.out.println("------------------------------");
        System.out.println("1. SELECT data");
        System.out.println("2. INSERT data");
        System.out.println("3. EXIT program");
    }

    public static void reportToHTML(String result) {
        File f = new File("./resources/index.html");
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f))) {
            System.out.println(">>> Creating report index.html file...");
            bufferedWriter.write(
                    "<!DOCTYPE html>" +
                            "<html lang=\"en\">" +
                            "   <head>" +
                            "       <meta charset=\"UTF-8\">" +
                            "       <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">" +
                            "       <title>Результаты работы программы</title>" +
                            "   </head>" +
                            "   <body>" +
                            "       <h1>Результат работы программы:</h1>" +
                            "       <p>" + result + "</p>" +
                            "   </body>" +
                            "</html>"
            );
            System.out.println(">>> File saved to ./resources/index.html");
        } catch (Exception ex) {
            System.out.println(">>> Error occurred during markup save");
            ex.printStackTrace();
        }
    }
}
