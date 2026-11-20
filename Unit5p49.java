import java.sql.*;
import java.util.Scanner;

public class DisplayEmployeeJDBC {

    // Oracle DB connection details — update these for your environment
    static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    static final String USER = "system";
    static final String PASS = "your_password";

    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);

        try {
            // Step 1: Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Step 2: Establish connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected to Oracle database successfully!");

            // Step 3: Ask user whether to filter by department or show all
            System.out.print("Enter Department to search (or press Enter for all records): ");
            String dept = sc.nextLine();

            String selectSQL;
            if (dept.trim().isEmpty()) {
                selectSQL = "SELECT * FROM employee ORDER BY emp_id";
                pstmt = conn.prepareStatement(selectSQL);
            } else {
                selectSQL = "SELECT * FROM employee WHERE emp_dept = ? ORDER BY emp_id";
                pstmt = conn.prepareStatement(selectSQL);
                pstmt.setString(1, dept);
            }

            // Step 4: Execute query
            rs = pstmt.executeQuery();

            // Step 5: Display results
            System.out.println("\n----- Employee Records -----");
            System.out.printf("%-10s%-20s%-15s%-15s%n", "EMP_ID", "EMP_NAME", "SALARY", "DEPARTMENT");
            System.out.println("---------------------------------------------------------");

            boolean hasRecords = false;
            while (rs.next()) {
                hasRecords = true;
                int id = rs.getInt("emp_id");
                String name = rs.getString("emp_name");
                double salary = rs.getDouble("emp_salary");
                String department = rs.getString("emp_dept");

                System.out.printf("%-10d%-20s%-15.2f%-15s%n", id, name, salary, department);
            }

            if (!hasRecords) {
                System.out.println("No records found.");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database error occurred.");
            e.printStackTrace();
        } finally {
            // Step 6: Close resources
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
                sc.close();
                System.out.println("\nConnection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

