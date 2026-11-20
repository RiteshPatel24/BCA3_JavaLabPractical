import java.sql.*;
import java.util.Scanner;

public class UpdateDeleteEmployeeJDBC {

    // Oracle DB connection details — update these for your environment
    static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    static final String USER = "system";
    static final String PASS = "your_password";

    public static void main(String[] args) {

        Connection conn = null;
        Scanner sc = new Scanner(System.in);

        try {
            // Step 1: Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Step 2: Establish connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected to Oracle database successfully!");

            // Display menu
            System.out.println("\n1. Update Record");
            System.out.println("2. Delete Record");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    updateRecord(conn, sc);
                    break;
                case 2:
                    deleteRecord(conn, sc);
                    break;
                default:
                    System.out.println("Invalid choice.");
                    return;
            }

            // Display records after operation
            displayRecords(conn);

        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database error occurred.");
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) conn.close();
                sc.close();
                System.out.println("\nConnection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Method to update a record
    static void updateRecord(Connection conn, Scanner sc) throws SQLException {
        System.out.print("Enter Employee ID to update: ");
        int empId = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter New Salary: ");
        double newSalary = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter New Department: ");
        String newDept = sc.nextLine();

        String updateSQL = "UPDATE employee SET emp_salary = ?, emp_dept = ? WHERE emp_id = ?";
        PreparedStatement pstmt = conn.prepareStatement(updateSQL);

        pstmt.setDouble(1, newSalary);
        pstmt.setString(2, newDept);
        pstmt.setInt(3, empId);

        int rowsUpdated = pstmt.executeUpdate();

        if (rowsUpdated > 0) {
            System.out.println("\nRecord updated successfully! (" + rowsUpdated + " row affected)");
        } else {
            System.out.println("\nNo record found with EMP_ID = " + empId);
        }

        pstmt.close();
    }

    // Method to delete a record
    static void deleteRecord(Connection conn, Scanner sc) throws SQLException {
        System.out.print("Enter Employee ID to delete: ");
        int empId = sc.nextInt();

        String deleteSQL = "DELETE FROM employee WHERE emp_id = ?";
        PreparedStatement pstmt = conn.prepareStatement(deleteSQL);

        pstmt.setInt(1, empId);

        int rowsDeleted = pstmt.executeUpdate();

        if (rowsDeleted > 0) {
            System.out.println("\nRecord deleted successfully! (" + rowsDeleted + " row affected)");
        } else {
            System.out.println("\nNo record found with EMP_ID = " + empId);
        }

        pstmt.close();
    }

    // Method to display all records
    static void displayRecords(Connection conn) throws SQLException {
        String selectSQL = "SELECT * FROM employee ORDER BY emp_id";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(selectSQL);

        System.out.println("\n----- Employee Records -----");
        System.out.printf("%-10s%-20s%-15s%-15s%n", "EMP_ID", "EMP_NAME", "SALARY", "DEPARTMENT");
        System.out.println("---------------------------------------------------------");

        boolean hasRecords = false;
        while (rs.next()) {
            hasRecords = true;
            int id = rs.getInt("emp_id");
            String name = rs.getString("emp_name");
            double salary = rs.getDouble("emp_salary");
            String dept = rs.getString("emp_dept");

            System.out.printf("%-10d%-20s%-15.2f%-15s%n", id, name, salary, dept);
        }

        if (!hasRecords) {
            System.out.println("No records found.");
        }

        rs.close();
        stmt.close();
    }
}


