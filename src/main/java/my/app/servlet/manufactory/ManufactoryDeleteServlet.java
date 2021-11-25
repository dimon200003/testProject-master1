package my.app.servlet.manufactory;

import my.app.entity.Manufactory;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deletemanufactory")
public class ManufactoryDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String manufactoryIdString = req.getParameter("ManufactoryId");
        int manufactoryId = Integer.parseInt(manufactoryIdString);

        for (Manufactory manufactory : ManufactoryListServlet.manufactory) {
            if (manufactoryId == manufactory.getId()) {
                ManufactoryListServlet.manufactory.remove(manufactory);
                break;
            }
        }

        resp.sendRedirect("mlistmanufactory");
    }
}
