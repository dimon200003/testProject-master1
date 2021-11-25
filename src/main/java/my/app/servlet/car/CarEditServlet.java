package my.app.servlet.car;

import my.app.dao.CarJdbcDao;
import my.app.entity.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/caredit")
public class CarEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String carIdParam = req.getParameter("CarIdParam");
        req.setAttribute("carOldId", carIdParam);

        String carCarNameParam = req.getParameter("CarCarNameParam");
        req.setAttribute("carOLdCarName", carCarNameParam);

        String carAgeParam = req.getParameter("CarIdParam");
        req.setAttribute("carOldAge", carAgeParam);

        req.getRequestDispatcher("/Car/carEditPage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String carUpdatedIdString = req.getParameter("CarUpdatedId");
        String carUpdatedCarName = req.getParameter("CarUpdatedCarName");
        String carUpdatedAgeString = req.getParameter("CarUpdatedAge");
        int carUpdatedId = Integer.parseInt(carUpdatedIdString);
        int carUpdatedAge = Integer.parseInt(carUpdatedAgeString);

        Car car = new Car(carUpdatedId, carUpdatedCarName, carUpdatedAge);

        CarJdbcDao carJdbcDao = new CarJdbcDao();
        carJdbcDao.updateCar(car);


        resp.sendRedirect("carlist");
    }
}
