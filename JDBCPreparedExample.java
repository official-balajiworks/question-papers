import java.sql.*;

public class JDBCPreparedExample {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studentdb", "root", "password");

            // Insert record using PreparedStatement
            PreparedStatement ps = con.prepareStatement("INSERT INTO students VALUES(?, ?)");
            ps.setInt(1, 101);
            ps.setString(2, "Babe");
            ps.executeUpdate();

            System.out.println("Record inserted successfully!");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
