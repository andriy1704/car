package com.car.car;

import com.car.car.models.*;

import com.car.car.services.UserService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        userService.deleteUser(new User("user"));
        User user = new User("first_User");
        userService.saveUser(user);
        Car ferrari = new Car("ferrari",1987);
        user.addCar(ferrari);
        Car ford = new Car("ford", 1999);
        user.addCar(ford);
        Car lada = new Car("lada", 2008);
        lada.setUser(user);
        userService.updateUser(user);
        userService.deleteUser(user);


    }
}
