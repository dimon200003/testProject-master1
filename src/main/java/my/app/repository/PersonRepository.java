package my.app.repository;

import my.app.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    List<Person> findByAgeBetween(int minAge, int maxAge);


    @Query(value = "SELECT * FROM person WHERE age between  ?1 and ?2", nativeQuery = true)
    List<Person> findByAgeBetweenYourVersion(int minAge, int maxAge);

    List<Person> findByNameLikeOrAgeLessThanEqual(String likePattern, int lessThanEqual);


}
