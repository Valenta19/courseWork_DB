import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();

    User getUserById(int id);

    User createUser(User user);

    void updateUser(User user);

    void deleteUser(User user);

}