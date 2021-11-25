package my.app.dao;

import my.app.entity.Person;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonJdbcDao implements PersonDao {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/fermadb";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "hhizp5565";

    public static void main(String[] args) {
        PersonJdbcDao personJdbcDao = new PersonJdbcDao();
        Person person = new Person();
        person.setName("gena");
        person.setAge(234);
        personJdbcDao.createPerson(person);
        personJdbcDao.deletePersonById(1);
        personJdbcDao.readAllPersons();

        Person person1 = personJdbcDao.readPersonById(4);
        person1.setName("dgffs");
        person1.setAge(123123);
        personJdbcDao.updatePerson(person1);
    }

    @Override
    public void createPerson(Person person) {

        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO `fermadb`.`person` (`name`, `age`) VALUES ('"+person.getName()+"', '"+person.getAge()+"');";
            statement.execute(sql);
            System.out.println("5435");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Person readPersonById(int id) {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (
                ClassNotFoundException e) {
            e.printStackTrace();
        }


        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM fermadb.person where id =" + id;

            ResultSet resultSet = statement.executeQuery(sql);
            if ( resultSet.next() ) {
                int id1 = resultSet.getInt("id");
                String name = resultSet.getString(2);
                int age = resultSet.getInt(3);

                Person person = new Person(id1, name, age);
                return person;

            }

            System.out.println("5435");
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<Person> readAllPersons() {
        List<Person> personList = new ArrayList<>();
        try {
            Class.forName(JDBC_DRIVER);
        } catch (
                ClassNotFoundException e) {
            e.printStackTrace();
        }


        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM fermadb.person ;";

            ResultSet resultSet = statement.executeQuery(sql);
            while ( resultSet.next() ) {
                int id1 = resultSet.getInt("id");
                String name = resultSet.getString(2);
                int age = resultSet.getInt(3);

                Person person = new Person(id1, name, age);
                personList.add(person);


            }
            return personList;

        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updatePerson(Person updatedPerson) {

        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
//            Statement statement = connection.createStatement();


            int id = updatedPerson.getId();
            String updatedName = updatedPerson.getName();
            int updatedAge = updatedPerson.getAge();


//            String sql = "UPDATE `fermadb`.`person` SET `name` = '"+ updatedName +"', `age` = '" + updatedAge+"' WHERE (`id` = '"+ id +"');";
            String sql = "UPDATE `fermadb`.`person` SET `name` = ?, `age` = ? WHERE (`id` = ?);";
  //          statement.execute(sql);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, updatedName);
            preparedStatement.setInt(2, updatedAge);
            preparedStatement.setInt(3, id);
            preparedStatement.execute();

            System.out.println("5435");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void deletePersonById(int id) {

        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM `fermadb`.`person` WHERE (`id` = '" + id + "');";
            statement.execute(sql);
            System.out.println("5435");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
