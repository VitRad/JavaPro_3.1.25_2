package ru.radionov.service;

import org.springframework.stereotype.Service;
import ru.radionov.entity.User;
import ru.radionov.repository.UserDao;

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
