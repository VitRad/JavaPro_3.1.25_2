package ru.rad;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.rad.entity.User;
import ru.rad.service.UserService;

import java.util.List;

@Component
//@Service
public class Runner implements CommandLineRunner {

    private final UserService userService;

    public Runner(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) {
        String prefixName = "name_";
        long currentTime = System.currentTimeMillis();

        //Заполнение таблицы
        for (int i = 0; i < 3; i++) {
            userService.createUser(prefixName + currentTime + i);
        }

        //Получение всех записей
        List<User> users = userService.getAllUsers();
        System.out.println(users);
        System.out.println("----------------------------");

        //Получим id записи из таблицы
        Long userId = users.get(users.size() / 2).getId();
        System.out.println("get user by id:" + userId);
        System.out.println("----------------------------");

        //Получение пользователя по id
        User user = userService.getUserById(userId);
        System.out.println("found user:" + user);
        System.out.println("----------------------------");

        //Удаление пользователя, полученного ранее
        userService.deleteUserById(userId);

        //Получение всех записей для проверки, что удаленной записи нет в списке
        List<User> usersAfterDelete = userService.getAllUsers();
        System.out.println(usersAfterDelete);

    }
}
