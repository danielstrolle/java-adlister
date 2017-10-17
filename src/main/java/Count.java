import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CountServlet", urlPatterns = "/count")
public class Count extends HttpServlet {

    int counter = 0;

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        counter += 1;
        PrintWriter out = res.getWriter();
        if (req.getParameter("reset") != null) {
            counter = 1;
        }
        out.println("<h1>Page Views: " + counter + "</h1>");
    }
}
