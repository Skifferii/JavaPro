package app.repository;

import app.model.Car;
import jakarta.persistence.EntityManager;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CarRepositoryHibernate implements CarRepository {

    private EntityManager entityManager;

    public CarRepositoryHibernate() {
        entityManager = new Configuration()
                .configure("hibernate/postgres.cfg.xml")
                .buildSessionFactory().createEntityManager();
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
