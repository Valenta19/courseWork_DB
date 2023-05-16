import javax.persistence.*;
import java.util.List;

public class RoleDAOImpl implements RoleDAO {
    @Override
    public List<Role> getAllRoles() {
        EntityManager entityManager = createEntityManager();
        entityManager.getTransaction().begin();
        String jpqlQuery = " FROM Role";
        TypedQuery<Role> query = entityManager.createQuery(jpqlQuery, Role.class);
        List<Role> roles = query.getResultList();
        return roles;
    }

    @Override
    public Role getRoleById(int id) {
        EntityManager entityManager = createEntityManager();
        return entityManager.find(Role.class, id);
    }

    @Override
    public Role createRole(Role role) {
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(role);
        transaction.commit();
        entityManager.close();
        return role;
    }

    @Override
    public void updateRole(Role role) {
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(role);
        transaction.commit();
        entityManager.close();
    }

    @Override
    public void deleteRole(Role role) {
        EntityManager entityManager = createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(role);
        entityManager.getTransaction().commit();
        entityManager.close();
    }



    private static EntityManager createEntityManager() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");

        return entityManagerFactory.createEntityManager();
    }
}