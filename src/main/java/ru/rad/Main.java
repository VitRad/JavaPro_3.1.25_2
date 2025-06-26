package ru.rad;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.rad.configuration.Config;
import ru.rad.entity.User;
import ru.rad.service.UserService;

import java.util.List;

@ComponentScan
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        UserService userService = context.getBean(UserService.class);
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
