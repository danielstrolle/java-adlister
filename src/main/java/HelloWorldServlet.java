import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorldServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String name;
        name = req.getParameter("name");
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        if (name == null || name.trim().isEmpty()) {
            out.println("<h1>Hello World</h1>");
        } else {
            out.println("<h1>Hello " + name + "</h1>");
        }
    }
}
