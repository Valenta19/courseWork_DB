import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAOImpl();
        RoleDAO roleDAO = new RoleDAOImpl();


        Role role1 = new Role();
        role1.setRoleType(TypeRole.DEVELOPER);
        Role role2 = new Role();
        role2.setRoleType(TypeRole.ANALYST);
        Role role3 = new Role();
        role3.setRoleType(TypeRole.MANAGER);
        Role role4 = new Role();
        role4.setRoleType(TypeRole.TESTER);
        Role role5 = new Role();
        role5.setRoleType(TypeRole.DESIGNER);
        Role role6 = new Role();
        role6.setRoleType(TypeRole.DEFAULT);

        roleDAO.createRole(role1);
        roleDAO.createRole(role2);
        roleDAO.createRole(role3);
        roleDAO.createRole(role4);
        roleDAO.createRole(role5);
        roleDAO.createRole(role6);

        Set<Role> roles = new HashSet<>();
        roles.add(roleDAO.getRoleById(1));
        roles.add(roleDAO.getRoleById(2));
        roles.add(roleDAO.getRoleById(3));
        roles.add(roleDAO.getRoleById(4));
        roles.add(roleDAO.getRoleById(5));
        roles.add(roleDAO.getRoleById(6));


        User user = new User();
        user.setUserName("Valentin");
        user.setLogin("login");
        user.setPassword("password");
        user.setCreationDate(LocalDateTime.now());
        user.setDateOfChange(LocalDateTime.now());
        user.setRoleSet(roles);

        User userDAOUser = userDAO.createUser(user);
        userDAOUser.setRoleSet(roles);
        userDAO.updateUser(userDAOUser);
        userDAO.deleteUser(userDAOUser);
    }
}