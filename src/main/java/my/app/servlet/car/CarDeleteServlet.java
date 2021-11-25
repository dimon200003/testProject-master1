package my.app.servlet.car;

import my.app.dao.CarJdbcDao;
import my.app.dao.PersonJdbcDao;
import my.app.entity.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static my.app.servlet.car.CarListServlet.car;

@WebServlet("/cardelete")
public class CarDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String carIdString = req.getParameter("CarIdParam");
        int carId = Integer.parseInt(carIdString);
        CarJdbcDao carJdbcDao = new CarJdbcDao();
        carJdbcDao.deleteCarById(carId);
        resp.sendRedirect("carlist");

    }
}
