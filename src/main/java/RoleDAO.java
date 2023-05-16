import java.util.List;

public interface  RoleDAO {
    List<Role> getAllRoles();

    Role getRoleById(int id);

    Role createRole(Role role);

    void updateRole(Role role);

    void deleteRole(Role role);
}


