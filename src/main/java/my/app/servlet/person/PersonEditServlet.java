package my.app.servlet.person;

import my.app.dao.PersonJdbcDao;
import my.app.entity.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit")
public class PersonEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String personIdParam = req.getParameter("PersonIdParam");
        req.setAttribute("personOldId", personIdParam);

        String personNameParam = req.getParameter("PersonNameParam");
        req.setAttribute("personOldName", personNameParam);

        String personAgeParam = req.getParameter("PersonAgeParam");
        req.setAttribute("personOldAge", personAgeParam);



        req.getRequestDispatcher("personEditPage.jsp").forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String personUpdatedIdString = req.getParameter("personUpdatedId");
        String personUpdatedName = req.getParameter("personUpdatedName");
        String personUpdatedAgeString = req.getParameter("personUpdatedAge");
        int personUpdatedId = Integer.parseInt(personUpdatedIdString);
        int personUpdatedAge = Integer.parseInt(personUpdatedAgeString);


        Person person = new Person(personUpdatedId, personUpdatedName, personUpdatedAge);

        PersonJdbcDao personJdbcDao = new PersonJdbcDao();
        personJdbcDao.updatePerson(person);


        resp.sendRedirect("list");
    }

}
