package my.app.servlet.car;

import my.app.dao.CarJdbcDao;
import my.app.entity.Car;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/caradd")
public class CarAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/webProject/Car/carAddPage.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String carIdInput = req.getParameter("carIdInput");
        String carCarNameInput = req.getParameter("carCarNameInput");
        String carAgeInput = req.getParameter("carAgeInput");
        int id = Integer.parseInt(carIdInput);
        int age = Integer.parseInt(carAgeInput);
        Car car = new Car( carCarNameInput, age);
        CarJdbcDao carJdbcDao = new CarJdbcDao();
        carJdbcDao.createCar(car);
        resp.sendRedirect("carlist");

    }
}
