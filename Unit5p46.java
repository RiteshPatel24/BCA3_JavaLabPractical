import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OracleUpdateExample {
    public static void main(String[] args) {

        // Oracle DB connection details
        String url = "jdbc:oracle:thin:@localhost:1521:xe"; // format: @host:port:SID
        String username = "system";        // replace with your Oracle username
        String password = "your_password"; // replace with your Oracle password

        String updateQuery = "UPDATE employee SET emp_salary = ?, emp_dept = ? WHERE emp_id = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Step 1: Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Step 2: Establish connection
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to Oracle database successfully!");

            // Step 3: Prepare the update statement
            pstmt = conn.prepareStatement(updateQuery);

            // Step 4: Set values for placeholders
            pstmt.setDouble(1, 65000.00);  // new salary
            pstmt.setString(2, "Sales");   // new department
            pstmt.setInt(3, 101);          // condition: emp_id to update

            // Step 5: Execute the update
            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Record updated successfully!");
                System.out.println("Emp ID: 101 | New Salary: 65000.00 | New Dept: Sales");
            } else {
                System.out.println("No record found with the given Emp ID.");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database connection/update error.");
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
