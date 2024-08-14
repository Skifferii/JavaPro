package app.repository;

import app.model.Car;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static app.constans.Constans.*;

public class CarRepositoryDB implements CarRepository {
    private Connection getConnection() {

        //jdbc:postgresql://localhost:5432/g_44_cars?user=postgres&password=pos1234


        try {
            Class.forName(DB_DRIVER_PATH);
            String dbUrl = String.format("%s/%s?user=%s&password=%s",
                    DB_ADDRESS, DB_NAME, DB_USER, DB_PASSWORD);
            return DriverManager.getConnection(dbUrl);

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Car> getAll() {
        return List.of();
    }

    @Override
    public Car save(Car car) {
        return null;
    }

    @Override
    public Car findById(long id) {
        return null;
    }

    @Override
    public Car update(Car car) {
        return null;
    }

    @Override
    public void delete(Car car) {

    }
}
