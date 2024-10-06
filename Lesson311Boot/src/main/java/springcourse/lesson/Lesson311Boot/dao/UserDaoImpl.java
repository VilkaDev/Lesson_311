package springcourse.lesson.Lesson311Boot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import springcourse.lesson.Lesson311Boot.model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;


    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }


    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUser(int id) {
        return entityManager.getReference(User.class, id);
    }

    @Override
    public void deleteUser(int id) {
        User user = getUserById(id);
        if (user != null){
            entityManager.remove(user);
            entityManager.flush();
        }

    }

    @Override
    public User getUserById(int id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Override
    public void update(int id, User userUpdate) {
        User userToUpdate = getUserById(id);
        userToUpdate = entityManager.merge(userUpdate);

    }

}
