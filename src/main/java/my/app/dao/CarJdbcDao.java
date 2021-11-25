package my.app.dao;


import my.app.entity.Car;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class CarJdbcDao implements CarDao {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/fermadb";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "hhizp5565";

    public static void main(String[] args) {
        CarJdbcDao carJdbcDao = new CarJdbcDao();
        Car car = new Car();
        car.setCarName("jaba");
        car.setAge(234);
        carJdbcDao.createCar(car);
    }
    @Override
    public void createCar(Car car) {

        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            Statement statement = connection.createStatement();
            String sql="INSERT INTO `fermadb`.`car` ( `car_name`, `age`) VALUES ( '"+car.getCarName()+"', "+car.getAge()+");";
            statement.execute(sql);
            System.out.println("5435");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Car readCarById(int id) {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (
                ClassNotFoundException e) {
            e.printStackTrace();
        }


        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM fermadb.car where id =" + id;

            ResultSet resultSet = statement.executeQuery(sql);
            if ( resultSet.next() ) {
                int id1 = resultSet.getInt("id");
                String name = resultSet.getString(2);
                int age = resultSet.getInt(3);

                Car car = new Car(id1, name, age);
                return car;

            }

            System.out.println("5435");
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Car> readAllCars() {
        List<Car> carList = new ArrayList<>();
        try {
            Class.forName(JDBC_DRIVER);
        } catch (
                ClassNotFoundException e) {
            e.printStackTrace();
        }


        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM fermadb.car ;";

            ResultSet resultSet = statement.executeQuery(sql);
            while ( resultSet.next() ) {
                int id1 = resultSet.getInt("id");
                String name = resultSet.getString(2);
                int age = resultSet.getInt(3);

                Car car = new Car(id1, name, age);
                carList.add(car);


            }
            return carList;

        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateCar(Car updatedCar) {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            Statement statement = connection.createStatement();

            int id = updatedCar.getId();
            String updatedName = updatedCar.getCarName();
            int updatedAge = updatedCar.getAge();


            String sql = "UPDATE `fermadb`.`car` SET `car_name` = '"+ updatedName +"', `age` = '" + updatedAge+"' WHERE (`id` = '"+ id +"');";
            statement.execute(sql);
            System.out.println("5435");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteCarById(int id) {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM `fermadb`.`car` WHERE (`id` = '" + id + "');";
            statement.execute(sql);
            System.out.println("5435");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }


