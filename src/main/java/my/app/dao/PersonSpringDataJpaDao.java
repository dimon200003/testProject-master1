package my.app.dao;

import my.app.entity.Person;
import my.app.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PersonSpringDataJpaDao implements PersonDao{

    @Autowired
    PersonRepository personRepository;

    public List<Person> getPersonsWhereAgeBetween(String minAge, String maxAge){
        int min = Integer.parseInt(minAge);
        int max = Integer.parseInt(maxAge);
        List<Person> byAgeBetween = personRepository.findByAgeBetween(min, max);
        return byAgeBetween;
    }

    public List<Person> getPersonsWhereNameLikeOrAgeLessThanEqual(String likePattern, String lessThanEqualAgeString){
        likePattern = "%" + likePattern + "%";
        int lessThanEqualAge =Integer.parseInt(lessThanEqualAgeString);
        List<Person> byAgeBetween = personRepository.findByNameLikeOrAgeLessThanEqual(likePattern, lessThanEqualAge);
        return byAgeBetween;
    }

    @Override
    public void createPerson(Person person) {
        personRepository.save(person);
    }

    @Override
    public Person readPersonById(int id) {
        Optional<Person> personOptional = personRepository.findById(id);
        Person person = personOptional.orElse(new Person());
        return person;
    }

    @Override
    public List<Person> readAllPersons() {
        List<Person> all = personRepository.findAll();
        return all;
    }

    @Override
    public void updatePerson(Person updatedPerson) {
        personRepository.save(updatedPerson);
    }

    @Override
    public void deletePersonById(int id) {
        personRepository.deleteById(id);
    }
}
