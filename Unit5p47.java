import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OracleDeleteExample {
    public static void main(String[] args) {

        // Oracle DB connection details
        String url = "jdbc:oracle:thin:@localhost:1521:xe"; // format: @host:port:SID
        String username = "system";        // replace with your Oracle username
        String password = "your_password"; // replace with your Oracle password

        String deleteQuery = "DELETE FROM employee WHERE emp_id = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Step 1: Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Step 2: Establish connection
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to Oracle database successfully!");

            // Step 3: Prepare the delete statement
            pstmt = conn.prepareStatement(deleteQuery);

            // Step 4: Set the condition value (emp_id to delete)
            int empIdToDelete = 101;
            pstmt.setInt(1, empIdToDelete);

            // Step 5: Execute the delete
            int rowsDeleted = pstmt.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Record deleted successfully!");
                System.out.println("Deleted Emp ID: " + empIdToDelete);
            } else {
                System.out.println("No record found with Emp ID: " + empIdToDelete);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database connection/deletion error.");
            e.printStackTrace();
        } finally {
            // Step 6: Close resources
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
                System.out.println("Connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

