package my.app.controller;

import my.app.dao.PersonDao;
import my.app.dao.PersonJdbcDao;
import my.app.dao.PersonSpringDataJpaDao;
import my.app.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {

    PersonJdbcDao personJdbcDao;
    PersonSpringDataJpaDao personSpringDataJpaDao;

    @Autowired
    public RestController(PersonJdbcDao personJdbcDao, PersonSpringDataJpaDao personSpringDataJpaDao) {
        this.personJdbcDao = personJdbcDao;
        this.personSpringDataJpaDao = personSpringDataJpaDao;
    }

    @RequestMapping(value = "/person/list")
    public List<Person> getPersonListPage() {
        List<Person> personList = personJdbcDao.readAllPersons();
        return personList;
    }

    @RequestMapping(value = "/person/{id}")
    public Person getPersonById(@PathVariable("id") String personId) {
        int id = Integer.parseInt(personId);
        Person person = personJdbcDao.readPersonById(id);
        return person;
    }


    @RequestMapping(value = "/person/list/age/between/{min}/{max}")
    public List<Person> getPersonListPageWhereAgeBetween(@PathVariable("min") String min, @PathVariable("max") String max) {
        List<Person> personList = personSpringDataJpaDao.getPersonsWhereAgeBetween(min, max);
        return personList;
    }

    @RequestMapping(value = "/person/list/name/like/{likePattern}/or/age/lessthanequal/{lessthanequal}")
    public List<Person> getPersonListPageWhereNameLikeOrAgeLessThan(@PathVariable("likePattern") String likePattern, @PathVariable("lessthanequal") String lessthanequal) {
        List<Person> personList = personSpringDataJpaDao.getPersonsWhereNameLikeOrAgeLessThanEqual(likePattern, lessthanequal);
        return personList;
    }


}
