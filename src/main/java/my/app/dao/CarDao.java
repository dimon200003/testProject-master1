package my.app.dao;

import my.app.entity.Car;

import java.util.List;

public interface CarDao {
    void createCar(Car car);


    Car readCarById(int id);

    List<Car> readAllCars();

    void updateCar(Car updatedCar);

    void deleteCarById(int id);
}
