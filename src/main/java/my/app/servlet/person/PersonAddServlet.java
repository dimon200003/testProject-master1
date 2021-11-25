package my.app.servlet.person;

import my.app.dao.PersonJdbcDao;
import my.app.entity.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/add")
public class PersonAddServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("personAddPage.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String personIdInput = req.getParameter("personIdInput");
        String personNameInput = req.getParameter("personNameInput");
        String personAgeInput = req.getParameter("personAgeInput");
        int age = Integer.parseInt(personAgeInput);
        Person person = new Person( personNameInput, age);
        PersonJdbcDao personJdbcDao = new PersonJdbcDao();
        personJdbcDao.createPerson(person);
        resp.sendRedirect("list");
    }
}

