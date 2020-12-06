package by.gsu.pms;

import java.sql.*;
import java.util.ArrayList;

public class InsertQueryHandler {
    public static final String INSERT_QUERY = "INSERT INTO Letter (sender, recipient, letter_subject, letter_text, departure_date) VALUES (?, ?, ?, ?, ?);";
    private static PreparedStatement preparedStatement;

    private InsertQueryHandler() { }

    public static void executeInsertQuery(ArrayList<Object> queryParameters, Connection connection) throws SQLException {
        try {
            preparedStatement = connection.prepareStatement(INSERT_QUERY);

            preparedStatement.setInt(1, (Integer) queryParameters.get(0));
            preparedStatement.setInt(2, (Integer) queryParameters.get(1));
            preparedStatement.setString(3, (String) queryParameters.get(2));
            preparedStatement.setString(4, (String) queryParameters.get(3));
            preparedStatement.setDate(5, new java.sql.Date(((java.util.Date) queryParameters.get(4)).getTime()));

            preparedStatement.execute();
            System.out.println("Insert query executed...");
        } catch (SQLException sqlEx) {
            System.out.println(">>> Insert query execution failed.");
            sqlEx.printStackTrace();
        } finally {
            preparedStatement.close();
        }
    }
}
