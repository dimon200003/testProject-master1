package my.app.servlet.manufactory;
import my.app.entity.Manufactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
@WebServlet("/mlistmanufactory")
public class ManufactoryListServlet extends HttpServlet{
    private int counter;
    static ArrayList<Manufactory> manufactory = new ArrayList<>();

    @Override
    public  void init() throws ServletException {
        manufactory.add(new Manufactory(10, "shokoladki", 50));
        manufactory.add(new Manufactory(130, "tapochki", 503));
        manufactory.add(new Manufactory(120, "Kek", 50123));
        manufactory.add(new Manufactory(140, "Cheburek", 50123));
        manufactory.add(new Manufactory(160, "Abibas", 50123));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        counter++;
        req.setAttribute("sometext", counter);

        req.setAttribute("manufactoryList", manufactory);

        req.getRequestDispatcher("manufactoryListPage.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

