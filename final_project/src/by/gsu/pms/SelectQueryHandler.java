package by.gsu.pms;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class SelectQueryHandler {
    public static final String ACCOUNTING_RECORDS_QUERY = "SELECT * FROM ledger";
    public static final String CARS_QUERY = "SELECT * FROM car";
    public static final String CAR_QUERY = "SELECT car_brand, car_model FROM car WHERE carId = ?";
    public static final String SERVICES_QUERY = "SELECT * FROM service";
    public static final String SERVICE_QUERY = "SELECT car_brand, car_model FROM service WHERE serviceId = ?";

    private SelectQueryHandler() { }

    public static ArrayList<AccountingRecord> selectAccountingRecords(Connection connection) throws SQLException {
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<AccountingRecord> accountingRecords = new ArrayList<>();

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(ACCOUNTING_RECORDS_QUERY);

            int recordId = resultSet.getInt("record_id");
            int carId = resultSet.getInt("car_id");
            int serviceId = resultSet.getInt("service_id");
            Date dueDate = resultSet.getDate("due_date");

            accountingRecords.add(new AccountingRecord(recordId, carId, serviceId, dueDate));
        } catch (SQLException sqlException) {
            System.out.println(">>> Select query execution failed.");
            sqlException.printStackTrace();
        } finally {
            assert statement != null;
            statement.close();
            assert resultSet != null;
            resultSet.close();
        }
        return accountingRecords;
    }

    public static ArrayList<Car> selectCars(Connection connection) throws SQLException {
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<Car> cars = new ArrayList<>();

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(CARS_QUERY);

            int carId = resultSet.getInt("car_id");
            String carBrand = resultSet.getString("car_brand");
            String carModel = resultSet.getString("car_model");

            cars.add(new Car(carId, carBrand, carModel));
        } catch (SQLException sqlException) {
            System.out.println(">>> Select query execution failed.");
            sqlException.printStackTrace();
        } finally {
            assert statement != null;
            statement.close();
            assert resultSet != null;
            resultSet.close();
        }
        return cars;
    }

    public static Car selectCarByCarId(int carId, Connection connection) throws SQLException {
        Car car;

        try (PreparedStatement preparedStatement = connection.prepareStatement(CAR_QUERY)) {
            preparedStatement.setInt(1, carId);
            ResultSet resultSet = null;
            car = null;

            try {
                resultSet = preparedStatement.executeQuery();

                String carBrand = resultSet.getString("car_brand");
                String carModel = resultSet.getString("car_model");

                car = new Car(carId, carBrand, carModel);
            } catch (SQLException sqlException) {
                System.out.println(">>> Select query execution failed.");
                sqlException.printStackTrace();
            } finally {
                assert resultSet != null;
                resultSet.close();
            }
        }
        return car;
    }

    public static ArrayList<Service> selectServices(Connection connection) throws SQLException {
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<Service> services = new ArrayList<>();

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SERVICES_QUERY);

            int serviceId = resultSet.getInt("service_id");
            String serviceName = resultSet.getString("service_name");
            String serviceCost = resultSet.getString("service_cost");

            services.add(new Service(serviceId, serviceName, serviceCost));
        } catch (SQLException sqlException) {
            System.out.println(">>> Select query execution failed.");
            sqlException.printStackTrace();
        } finally {
            assert statement != null;
            statement.close();
            assert resultSet != null;
            resultSet.close();
        }
        return services;
    }

    public static Service selectServiceByServiceId(int serviceId, Connection connection) throws SQLException {
        Service service;

        try (PreparedStatement preparedStatement = connection.prepareStatement(SERVICE_QUERY)) {
            preparedStatement.setInt(1, serviceId);
            ResultSet resultSet = null;
            service = null;

            try {
                resultSet = preparedStatement.executeQuery();

                String serviceName = resultSet.getString("service_name");
                String serviceCost = resultSet.getString("service_cost");

                service = new Service(serviceId, serviceName, serviceCost);
            } catch (SQLException sqlException) {
                System.out.println(">>> Select query execution failed.");
                sqlException.printStackTrace();
            } finally {
                assert resultSet != null;
                resultSet.close();
            }
        }
        return service;
    }
}