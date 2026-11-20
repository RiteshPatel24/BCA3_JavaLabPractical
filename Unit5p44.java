import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OracleInsertExample {
    public static void main(String[] args) {

        // Oracle DB connection details
        String url = "jdbc:oracle:thin:@localhost:1521:xe"; // format: @host:port:SID
        String username = "system";       // replace with your Oracle username
        String password = "your_password"; // replace with your Oracle password

        String insertQuery = "INSERT INTO employee (emp_id, emp_name, emp_salary, emp_dept) VALUES (?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Step 1: Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Step 2: Establish connection
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to Oracle database successfully!");

            // Step 3: Prepare the insert statement
            pstmt = conn.prepareStatement(insertQuery);

            // Step 4: Set values for placeholders
            pstmt.setInt(1, 101);
            pstmt.setString(2, "John Smith");
            pstmt.setDouble(3, 55000.00);
            pstmt.setString(4, "IT");

            // Step 5: Execute the insert
            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("A new employee was inserted successfully!");
                System.out.println("Emp ID: 101 | Name: John Smith | Salary: 55000.00 | Dept: IT");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database connection/insertion error.");
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
