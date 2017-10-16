import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SumServlet", urlPatterns = "/sum")
public class Sum extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        int a=0, b=0;
        a = Integer.parseInt(req.getParameter("num1"));
        b = Integer.parseInt(req.getParameter("num2"));
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<h3> Sum res: " + (a + b) + "</h3>");
    }
}
