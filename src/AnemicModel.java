import java.util.HashMap;
import java.util.Map;

public class AnemicModel {
    public static void main(String[] args) throws Exception {
        System.out.println(
                new UserService().authenticate("joao", "123"));
        System.out.println(
                new UserService().authenticate("maria", "123"));
    }
}

class UserService {
    UserRepository repository = new UserRepository();

    public User authenticate(String username, String password) {
        var user = repository.get(username);
        if (user != null && user.getPassword().equals(password)) {
            user.setAuthenticated(true);
            System.out.println("Authentication successful!");
        } else {
            user.setAuthenticated(false);
            System.out.println("Authentication failed. Invalid password.");
        }
        return user;
    }
}

class UserRepository {
    Map<String, User> users = new HashMap<>() {
        {
            put("joao", new User("joao", "123"));
            put("maria", new User("maria", "456"));
        }
    };

    User get(String username) {
        return users.get(username);
    }
}

class User {
    private String username;
    private String password;
    private boolean isAuthenticated;

    // Constructor
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        isAuthenticated = authenticated;
    }

    @Override
    public String toString() {
        return "User [username=" + username + ", password=" + password + ", isAuthenticated=" + isAuthenticated + "]";
    }

}