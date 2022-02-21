package com.car.car.services;

import com.car.car.dao.UsersDao;
import com.car.car.models.Car;
import com.car.car.models.User;

import java.util.List;

public class UserService {
    private UsersDao usersDao = new UsersDao();

    public UserService() {
    }

    public User findUser(int id) {
        return usersDao.findById(id);
    }

    public void saveUser(User user) {
        usersDao.save(user);
    }

    public void deleteUser(User user) {
        usersDao.delete(user);
    }

    public void updateUser(User user) {
        usersDao.update(user);
    }

    public List<User> findAllUsers() {
        return usersDao.findAll();
    }

    public Car findCarById(int id) {
        return usersDao.findCarById(id);
    }
}
