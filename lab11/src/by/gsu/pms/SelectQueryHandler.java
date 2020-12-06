package by.gsu.pms;

import java.sql.*;

public class SelectQueryHandler {
    private static Statement statement;
    private static ResultSet resultSet;

    private SelectQueryHandler() { }

    public static String executeSelectQuery(int taskNumber, String query, Connection connection) throws SQLException {
        String result = "";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            if (taskNumber == 2) {
                result += ResultSetHandler.parseResultSetExtended(taskNumber, resultSet);
            } else {
                result += ResultSetHandler.parseResultSet(taskNumber, resultSet);
            }
        } catch (SQLException sqlException) {
            System.out.println(">>> Select query execution failed.");
            sqlException.printStackTrace();
        } finally {
            statement.close();
            resultSet.close();
        }
        return result;
    }
}
