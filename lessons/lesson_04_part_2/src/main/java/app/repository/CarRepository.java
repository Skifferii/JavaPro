package app.repository;

import app.model.Car;

import java.util.List;

public interface CarRepository {
    //CRUD  operation, Create, Read,Update, delete
    List<Car> getAll();

    Car save(Car car);

    Car findById(long id);

    Car update(Car car);

    void delete(Car car);


}
