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
import java.util.List;

@WebServlet("/list")
public class PersonListServlet extends HttpServlet {
    private int counter;
    static ArrayList<Person> people = new ArrayList<>();

   

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        counter++;
        req.setAttribute("sometext", counter);
        PersonJdbcDao personJdbcDao = new PersonJdbcDao();
        List<Person> personList = personJdbcDao.readAllPersons();

        req.setAttribute("personList", personList);



        req.getRequestDispatcher("personListPage.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
