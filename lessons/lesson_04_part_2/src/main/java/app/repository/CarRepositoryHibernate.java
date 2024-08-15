package app.repository;

import app.model.Car;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
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
        //TODO HOMEWORK
        return List.of();
    }

    @Override
    public Car save(Car car) {
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(car);
        transaction.commit();
                return car;

    }

    @Override
    public Car findById(long id) {
        return entityManager.find(Car.class, id);
    }

    @Override
    public Car update(Car car) {
        //TODO HOMEWORK
        return null;
    }

    @Override
    public void delete(Car car) {

    }
}
