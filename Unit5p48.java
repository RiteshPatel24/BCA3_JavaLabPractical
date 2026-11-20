import java.sql.*;
import java.util.Scanner;

public class InsertEmployeeJDBC {

    // Oracle DB connection details — update these for your environment
    static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    static final String USER = "system";
    static final String PASS = "your_password";

    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        Scanner sc = new Scanner(System.in);

        try {
            // Step 1: Load Oracle JDBC Driver (optional for JDBC 4.0+, but good practice)
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Step 2: Establish connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected to Oracle database successfully!");

            // Step 3: Prepare INSERT SQL with placeholders
            String insertSQL = "INSERT INTO employee (emp_id, emp_name, emp_salary, emp_dept) VALUES (?, ?, ?, ?)";
            pstmt = conn.prepareStatement(insertSQL);

            // Step 4: Take input from user (or hardcode values)
            System.out.print("Enter Employee ID: ");
            int empId = sc.nextInt();
            sc.nextLine(); // consume newline

            System.out.print("Enter Employee Name: ");
            String empName = sc.nextLine();

            System.out.print("Enter Employee Salary: ");
            double empSalary = sc.nextDouble();
            sc.nextLine();

            System.out.print("Enter Employee Department: ");
            String empDept = sc.nextLine();

            // Step 5: Set values into PreparedStatement
            pstmt.setInt(1, empId);
            pstmt.setString(2, empName);
            pstmt.setDouble(3, empSalary);
            pstmt.setString(4, empDept);

            // Step 6: Execute the insert
            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("\nRecord inserted successfully!");
            }

            // Step 7: Display all records from the table
            displayRecords(conn);

        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database error occurred.");
            e.printStackTrace();
        } finally {
            // Step 8: Close resources
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
                sc.close();
                System.out.println("\nConnection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Method to display all records after insertion
    static void displayRecords(Connection conn) throws SQLException {
        String selectSQL = "SELECT * FROM employee";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(selectSQL);

        System.out.println("\n----- Employee Records -----");
        System.out.printf("%-10s%-20s%-15s%-15s%n", "EMP_ID", "EMP_NAME", "SALARY", "DEPARTMENT");
        System.out.println("---------------------------------------------------------");

        while (rs.next()) {
            int id = rs.getInt("emp_id");
            String name = rs.getString("emp_name");
            double salary = rs.getDouble("emp_salary");
            String dept = rs.getString("emp_dept");

            System.out.printf("%-10d%-20s%-15.2f%-15s%n", id, name, salary, dept);
        }

        rs.close();
        stmt.close();
    }
}

