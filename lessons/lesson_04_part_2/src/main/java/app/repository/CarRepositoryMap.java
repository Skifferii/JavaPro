package app.repository;

import app.model.Car;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarRepositoryMap implements CarRepository{
    private Map<Long, Car> database =new HashMap<>();
    private long currentId;


    public CarRepositoryMap() {
        initDatabase();
    }

    private void initDatabase (){
        save(new Car("VW", new BigDecimal(15000), 2015));
        save(new Car("Mazda", new BigDecimal(30000), 2021));
        save(new Car("Ford", new BigDecimal(40000), 2023));
    }


    @Override
    public List<Car> getAll() {

        //return database.values().stream().toList();

        return new ArrayList<>(database.values());


    }

    @Override
    public Car save(Car car) {
        car.setId((++currentId));
        database.put(car.getId(), car);
        return car;
    }

    @Override
    public Car findById(long id) {
        return database.getOrDefault(id, null);
    }

    @Override
    public Car update(Car car) {
        //TODO HOMEWORK
        return null;
    }

    @Override
    public void delete(Car car) {
        //TODO HOMEWORK

    }
}
