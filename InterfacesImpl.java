//Interfaces->User Registration Form
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


public class InterfacesImpl {
    public static void main(String[]args){

        UserService userService = new UserServiceImpl();
        String[][] userData = {
            {"Alice", "alice@example.com", "AlicE@123", "25"},
            {"Bob", "bob@example.com", "Bob@456!", "30"},
            {"Charlie", "charlie@domain.com", "CharL1e$", "28"}
        };
        for (String[] data : userData) {
            try {
                // Convert string age to integer
                int age = Integer.parseInt(data[3]);

                // Create a new user object
                User user = new User(data[0], data[1], data[2], age);

                // Register the user
                userService.registerUser(user);
            } catch (IllegalArgumentException e) {
                // Print validation error message
                System.out.println("Registration Error: " + e.getMessage());
            }
        }
        System.out.println("\nRegistered Users:");
        for (User user : userService.getUsers()) {
            System.out.println(user);
        }

    }

    
}

//interfaces
interface UserService{
    boolean registerUser(User user);
    List<User> getUsers();

}
//normal class for body
class User{
    private String  name;
    private String email;
    private String password;
    private int age;
    //Regular Expression / Regex
    private static final Pattern Email_Pattern=Pattern.compile("[_a-zA-Z0-9]+(\\.[A-Za-z0-9]*)*@[a-zA-Z0-9]+(\\.[A-Za-z0-9]*)*");
    private static final Pattern Password_Pattern = Pattern.compile("^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$");
    public User(String name, String email, String password, int age) {
        // Validate email
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid Email Format");
        }

        // Validate password
        if (!isValidPassword(password)) {
            throw new IllegalArgumentException("Invalid Password");
        }

        // Validate age
        if (age < 18 || age > 100) {
            throw new IllegalArgumentException("Invalid Age");
        }
        this.name=name;
        this.email=email;
        this.password=password;
        this.age=age;


}
private static boolean isValidEmail(String email) {
    return Email_Pattern.matcher(email).matches();
}

// Method to validate password using regex
private static boolean isValidPassword(String password) {
    return Password_Pattern.matcher(password).matches();}
    @Override
    public String toString() {
        return "User{name='" + name + "', email='" + email + "', age=" + age + "}";
    }
}


class UserServiceImpl implements UserService {
  
    private List<User> users = new ArrayList<>();


    @Override
    public boolean registerUser(User user) {
        return users.add(user); // Adds user to the list
    }

    // Method to retrieve all registered users
    @Override
    public List<User> getUsers() {
        return users;
    }
}
