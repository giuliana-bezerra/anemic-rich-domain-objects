import java.util.HashMap;
import java.util.Map;

public class RichModel {
  public static void main(String[] args) {
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
    user.authenticate(password);
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

  public void authenticate(String enteredPassword) {
    if (enteredPassword.equals(password)) {
      isAuthenticated = true;
      System.out.println("Authentication successful!");
    } else {
      isAuthenticated = false;
      System.out.println("Authentication failed. Invalid password.");
    }
  }

  @Override
  public String toString() {
    return "User [username=" + username + ", password=" + password + ", isAuthenticated=" + isAuthenticated + "]";
  }

}
