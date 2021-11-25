package my.app.servlet.manufactory;
import my.app.entity.Manufactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/maddmanufactory")
public class ManufactoryAddServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("manufactoryAddPage.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String manufactoryIdInput = req.getParameter("manufactoryIdInput");
        String manufactoryNameInput = req.getParameter("manufactoryNameInput");
        String manufactoryProfitInput = req.getParameter("manufactoryProfitInput");
        int id = Integer.parseInt(manufactoryIdInput);
        int profit = Integer.parseInt(manufactoryProfitInput);
        Manufactory manufactory = new Manufactory(id, manufactoryNameInput, profit);
        ManufactoryListServlet.manufactory.add(manufactory);
        resp.sendRedirect("mlistmanufactory");
    }
}
