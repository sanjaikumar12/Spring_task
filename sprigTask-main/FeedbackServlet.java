import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FeedbackServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String bookName = request.getParameter("bookName");
        String feedback = request.getParameter("feedback");

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/feedback_db", "username", "password");

            // Create a prepared statement to insert feedback data
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO feedback (name, book_name, feedback) VALUES (?, ?, ?)");
            pstmt.setString(1, name);
            pstmt.setString(2, bookName);
            pstmt.setString(3, feedback);

            // Execute the prepared statement
            pstmt.executeUpdate();

            // Close the connection
            conn.close();

            // Respond with "feedback saved!"
            response.getWriter().write("feedback saved!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
