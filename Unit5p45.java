import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleDisplayExample {
    public static void main(String[] args) {

        // Oracle DB connection details
        String url = "jdbc:oracle:thin:@localhost:1521:xe"; // format: @host:port:SID
        String username = "system";        // replace with your Oracle username
        String password = "your_password"; // replace with your Oracle password

        String selectQuery = "SELECT emp_id, emp_name, emp_salary, emp_dept FROM employee";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Step 2: Establish connection
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to Oracle database successfully!\n");

            // Step 3: Create statement and execute query
            stmt = conn.createStatement();
            rs = stmt.executeQuery(selectQuery);

            // Step 4: Print header
            System.out.println("Emp ID\tName\t\tSalary\t\tDept");
            System.out.println("---------------------------------------------------");

            // Step 5: Iterate through ResultSet and display each row
            boolean hasRows = false;
            while (rs.next()) {
                hasRows = true;
                int empId = rs.getInt("emp_id");
                String empName = rs.getString("emp_name");
                double empSalary = rs.getDouble("emp_salary");
                String empDept = rs.getString("emp_dept");

                System.out.println(empId + "\t" + empName + "\t\t" + empSalary + "\t\t" + empDept);
            }

            if (!hasRows) {
                System.out.println("No records found in the employee table.");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database connection/query error.");
            e.printStackTrace();
        } finally {
            // Step 6: Close resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
                System.out.println("\nConnection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

