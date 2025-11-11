import dao.UserDAO;
import model.User;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserDAO dao = new UserDAO();
        List<User> users = dao.getAllUsers();

        System.out.println("✅ Connected to MySQL successfully!");
        System.out.println("📋 User Data:");
        for (User u : users) {
            System.out.println(u);
        }
    }
}
