package com.car.car.dao;

import com.car.car.models.*;
import com.car.car.utils.HibernateSessionFactoryUtil;
import org.hibernate.*;

import java.util.List;

public class UsersDao {
    public User findById(int id) {
        return HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .get(User.class, id);
    }

    public void save(User user) {
        Session session = HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession();

        Transaction transaction = session
                .beginTransaction();

        session.save(user);
        transaction.commit();
        session.close();
    }

    public void delete(User user) {
        Session session = HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession();
        Transaction transaction = session
                .beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }

    public void update(User user) {
        Session session = HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession();
        Transaction transaction = session.beginTransaction();

        session.update(user);
        transaction.commit();
        session.close();
    }

    public Car findCarById(int id) {
        return HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .get(Car.class, id);
    }

    public List<User> findAll() {
        List<User> users = (List<User>) HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery("from User ")
                .list();
         return  users;
    }
}
