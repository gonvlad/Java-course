package by.gsu.pms;

import java.sql.*;
import java.util.ArrayList;

public class InsertQueryHandler {
    public static final String ACCOUNTING_RECORD_QUERY = "INSERT INTO ledger (record_id, car_id, service_id, due_date) VALUES (?, ?, ?, ?);";
    public static final String CAR_QUERY = "INSERT INTO car (car_id, car_brand, car_model) VALUES (?, ?, ?);";

    private InsertQueryHandler() { }

    public static void insertAccountingRecord(ArrayList<Object> queryParameters, Connection connection) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(ACCOUNTING_RECORD_QUERY)) {
            preparedStatement.setInt(1, (Integer) queryParameters.get(0));
            preparedStatement.setInt(2, (Integer) queryParameters.get(1));
            preparedStatement.setInt(3, (Integer) queryParameters.get(2));
            preparedStatement.setDate(4, new Date(((java.util.Date) queryParameters.get(4)).getTime()));

            preparedStatement.execute();
            System.out.println(">>> Insert query executed...");
        } catch (SQLException sqlEx) {
            System.out.println(">>> Insert query execution failed.");
            sqlEx.printStackTrace();
        }
    }

    public static void insertCar(ArrayList<Object> queryParameters, Connection connection) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(CAR_QUERY)) {
            preparedStatement.setInt(1, (Integer) queryParameters.get(0));
            preparedStatement.setString(2, (String) queryParameters.get(1));
            preparedStatement.setString(3, (String) queryParameters.get(2));

            preparedStatement.execute();
            System.out.println(">>> Insert query executed...");
        } catch (SQLException sqlEx) {
            System.out.println(">>> Insert query execution failed.");
            sqlEx.printStackTrace();
        }
    }
}