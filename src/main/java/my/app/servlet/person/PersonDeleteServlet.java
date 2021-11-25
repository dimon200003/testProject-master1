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
import java.util.Iterator;


@WebServlet("/delete")
public class PersonDeleteServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String personIdString = req.getParameter("PersonIdParam");
        int personId = Integer.parseInt(personIdString);
        PersonJdbcDao personJdbcDao = new PersonJdbcDao();
        personJdbcDao.deletePersonById(personId);
        resp.sendRedirect("list");
        }




    }

