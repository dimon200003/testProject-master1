package my.app.controller;

import my.app.dao.PersonDao;
import my.app.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/mvc")
public class PersonController {

    @Autowired
    @Qualifier("personSpringDataJpaDao")
    PersonDao personDao;

    @RequestMapping(value = "/person/list")
    public String getPersonListPage(Model model) {
        List<Person> personList = personDao.readAllPersons();
        model.addAttribute("personList", personList);
        return "personListPage";
    }

    @RequestMapping(value = "/person/create", method = RequestMethod.GET)
    public String getPersonAddPage() {
        return "personAddPage";
    }

    @RequestMapping(value = "/person/create", method = RequestMethod.POST)
    public String saveNewPerson(@RequestParam("personIdInput") String personIdInput,
                                @RequestParam("personNameInput") String personNameInput,
                                @RequestParam("personAgeInput") String personAgeInput) {

        int age = Integer.parseInt(personAgeInput);
        Person person = new Person(personNameInput, age);

        personDao.createPerson(person);
        return "redirect:/mvc/person/list";
//        return "forward:/mvc/person/list";

    }


    @GetMapping(value = "/person/edit")
    public ModelAndView getPersonEditPage(@RequestParam("PersonIdParam") String personIdParam,
                                          @RequestParam("PersonNameParam") String personNameParam,
                                          @RequestParam("PersonAgeParam") String personAgeParam) {
        ModelAndView mav = new ModelAndView();

        mav.addObject("personOldId", personIdParam);
        mav.addObject("personOldName", personNameParam);
        mav.addObject("personOldAge", personAgeParam);

        mav.setViewName("personEditPage");

        return mav;
    }

    @PostMapping(value = "/person/edit")
    public String saveEditPerson(@RequestParam("personUpdatedId") String personUpdatedIdString,
                                 @RequestParam("personUpdatedName") String personUpdatedName,
                                 @RequestParam("personUpdatedAge") String personUpdatedAgeString) {

        int personUpdatedId = Integer.parseInt(personUpdatedIdString);
        int personUpdatedAge = Integer.parseInt(personUpdatedAgeString);
        Person person = new Person(personUpdatedId, personUpdatedName, personUpdatedAge);
        personDao.updatePerson(person);
        return "redirect:/mvc/person/list";
    }

}
