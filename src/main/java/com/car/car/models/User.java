package com.car.car.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,orphanRemoval = true)
    private List <Car> cars;

    public User(){}
    public User( String name){
        this.name = name;
        cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        car.setUser(this);
        cars.add(car);
    }

    public void removeCar(Car car) {
        cars.remove(car);
    }

    public List<Car> getCars(){
        return cars;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cars=" + cars +
                '}';
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}