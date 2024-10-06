package springcourse.lesson.Lesson311Boot.service;

import springcourse.lesson.Lesson311Boot.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void saveUser(User user);
    User getUser(int id);
    void deleteUser(int id);

    User getUserById(int id);

    void update(int id, User user);
}
