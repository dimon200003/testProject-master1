package my.app.dao;

import my.app.entity.Person;

import java.util.List;

public interface PersonDao {

    void createPerson(Person person);

    Person readPersonById(int id);

    List<Person> readAllPersons();

    void updatePerson(Person updatedPerson);

    void deletePersonById(int id);


}
