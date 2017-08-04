import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Created by sauravkhatiwada on 7/28/17.
 */
public class SignUpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String n = request.getParameter("uname");
        String p = request.getParameter("upass");
        String e = request.getParameter("uemailId");
        String c = request.getParameter("ucountry");
        try {
//          Class.forName("com.mysql.jdbc.Driver"); 
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sys", "root", "root");
            PreparedStatement stmt = con.prepareStatement("insert into userlogin values(?,?,?,?)");
            stmt.setString(1, n);
            stmt.setString(2, p);
            stmt.setString(3, e);
            stmt.setString(4, c);
            int i = stmt.executeUpdate();
            if (i > 0) {
                out.println("You are successfully registered.....");
            }
        } catch (Exception ey) {
            System.out.println(ey);
        }
        out.close();
    }


}
