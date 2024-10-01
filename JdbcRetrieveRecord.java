import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcRetrieveRecord {
    // JDBC URL, username, and password of the database
    private static final String DB_URL = "jdbc:mysql://localhost:3306/LUCDatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "Admin@1234";

    // JDBC driver name
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // Open a connection
            System.out.println("Connecting to the database...");
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Get the ID of the record to retrieve from the user
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter student ID to retrieve: ");
            int studentId = scanner.nextInt();

            // Prepare the SQL query
            String sql = "SELECT id, name, age, grade FROM students WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, studentId);

            // Execute the query
            resultSet = preparedStatement.executeQuery();

            // Display the record if found
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String grade = resultSet.getString("grade");

                System.out.println("Student Record:");
                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println("Grade: " + grade);
            } else {
                System.out.println("No record found with ID: " + studentId);
            }

            // Clean up
            resultSet.close();
            preparedStatement.close();
            connection.close();
            scanner.close();
        } catch (SQLException se) {
            // Handle JDBC errors
            se.printStackTrace();
        } catch (Exception e) {
            // Handle other errors
            e.printStackTrace();
        } finally {
            // Clean up the resources
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

        System.out.println("Retrieved data successfully!");
    }
}
