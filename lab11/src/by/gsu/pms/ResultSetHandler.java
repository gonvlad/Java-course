package by.gsu.pms;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetHandler {
    private ResultSetHandler() { }

    public static String parseResultSet(int taskNumber, ResultSet resultSet) throws SQLException {
        StringBuilder taskResult = new StringBuilder("<h3>Task number: " + taskNumber + "</h3>");
        while (resultSet.next()) {
            int personId = resultSet.getInt(1);
            String firstName = resultSet.getString(2);
            String lastName = resultSet.getString(3);
            String birthDate = resultSet.getString(4);
            taskResult.append(String.format("person_id: %-5d | first_name: %-10s | last_name: %-10s | birth_date %-10s<br>", personId, firstName, lastName, birthDate));
        }
        return taskResult.toString();
    }

    public static String parseResultSetExtended(int taskNumber, ResultSet resultSet) throws SQLException {
        StringBuilder taskResult = new StringBuilder("<h3>Task number: " + taskNumber + "</h3>");
        while (resultSet.next()) {
            String firstName = resultSet.getString(1);
            String lastName = resultSet.getString(2);
            int numberOfSended = resultSet.getInt(3);
            int numberOfReceived = resultSet.getInt(4);
            taskResult.append(String.format("first_name: %-10s | last_name: %-10s | number_of_sended %-10d | number_of_received %-10d<br>", firstName, lastName, numberOfSended, numberOfReceived));
        }
        return taskResult.toString();
    }
}
