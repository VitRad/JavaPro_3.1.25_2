package ru.rad.service;

import org.springframework.stereotype.Service;
import ru.rad.entity.User;
import ru.rad.repository.UserDao;

import java.util.List;

@Service
public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void createUser(String userName) {
        User user = new User();
        user.setUserName(userName);
        userDao.createUser(user);
    }

    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    public List<User> getAllUsers() {
        return userDao.getAllusers();
    }

    public void deleteUserById(Long id) {
        userDao.deleteUserById(id);
    }
}
