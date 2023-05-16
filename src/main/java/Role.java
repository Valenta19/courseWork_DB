
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int roleId;
    @Column(name = "role_name")
    @Enumerated(EnumType.STRING)
    private TypeRole typeRole;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "users_roles",
            joinColumns = {@JoinColumn(name = "role_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private Set<User> userSet = new HashSet<>();

    public Role() {

    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public TypeRole getRoleType() {
        return typeRole;
    }

    public void setRoleType(TypeRole roleType) {
        this.typeRole = roleType;
    }

    @Override
    public String toString() {
        return "Role " +
                "id: " + roleId +
                ", Роль:" + typeRole +
                ", Пользователь:" + userSet;
    }
}



