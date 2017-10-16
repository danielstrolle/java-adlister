import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FillArrayServlet", urlPatterns = "/fillArray")
public class FillArray extends HttpServlet{
    protected void doGet (HttpServletRequest req, HttpServletResponse res) throws IOException {
        int size = 0;
        String value;
        size = Integer.parseInt(req.getParameter("size"));
        value = req.getParameter("value");
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String[] array = new String[size];
        out.println("<table border=1>");
        out.println("<tr>");
        for (int i = 0; i < array.length; i++) {
            array[i] = value;
        }
        for (String str : array) {
            out.println("<td>" + str + "</td>");
        }
        out.println("</tr>");
        out.println("</table>");
//        out.println("<table border=1>");
//        out.println("<tr>");
//        out.println("</tr>");
//        out.println("</table>");
    }
}


