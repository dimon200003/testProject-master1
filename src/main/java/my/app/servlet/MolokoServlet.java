package my.app.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MolokoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text = "<html>\n" +
                "<head>\n" +
                "    <title>My first page)</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>Welcome)1</h1>\n" +
                "<h2>Welcome)2</h2>\n" +
                "<h3>Welcome)3</h3>\n" +
                "<h4>Welcome)4</h4>\n" +
                "<h5>Welcome)5</h5>\n" +
                "<h6>Welcome)6</h6>\n" +
                "<i>PASkYDA</i>\n" +
                "<br>\n" +
                "<b><u>TVAR</u></b>\n" +
                "</body>\n" +
                "</html>\n";
        resp.getWriter().println(text);
    }
}
