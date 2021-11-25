package my.app.servlet.manufactory;

import my.app.entity.Manufactory;
import my.app.servlet.manufactory.ManufactoryListServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/manufactoryedit")
public class ManufactoryEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String manufactoryIdParam = req.getParameter("ManufactoryIdParam");
        req.setAttribute("manufactoryOldId", manufactoryIdParam);

        String manufactoryNameParam = req.getParameter("ManufactoryNameParam");
        req.setAttribute("manufactoryOldName", manufactoryNameParam);

        String manufactoryProfitParam = req.getParameter("ManufactoryProfitParam");
        req.setAttribute("manufactoryOldProfit", manufactoryProfitParam);



        req.getRequestDispatcher("manufactoryEditPage.jsp").forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String manufactoryUpdatedIdString = req.getParameter("manufactoryUpdatedId");
        String manufactoryUpdatedName = req.getParameter("manufactoryUpdatedName");
        String manufactoryUpdatedProfitString = req.getParameter("manufactoryUpdatedProfit");
        int manufactoryUpdatedId = Integer.parseInt(manufactoryUpdatedIdString);
        int manufactoryUpdatedProfit = Integer.parseInt(manufactoryUpdatedProfitString);

        for (Manufactory manufactory : ManufactoryListServlet.manufactory) {
            if (manufactoryUpdatedId == manufactory.getId()) {
                manufactory.setName(manufactoryUpdatedName);
                manufactory.setProfit(manufactoryUpdatedProfit);
                break;
            }
        }

        resp.sendRedirect("mlistmanufactory");
    }

}
