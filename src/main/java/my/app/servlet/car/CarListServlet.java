package my.app.servlet.car;

import my.app.dao.CarJdbcDao;
import my.app.entity.Car;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/carlist")
public class CarListServlet extends HttpServlet {
    private int counter;
    static ArrayList<Car> car = new ArrayList<>();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        counter++;
        CarJdbcDao carJdbcDao = new CarJdbcDao();
        List<Car> carList = carJdbcDao.readAllCars();

        req.setAttribute("carList", carList);

        req.getRequestDispatcher("/Car/carListPage.jsp").forward(req, resp);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
