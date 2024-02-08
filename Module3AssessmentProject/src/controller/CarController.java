package controller;

/**
 * @author minh2 - meruse
 * CIS175 - Fall 2023
 * Feb 1, 2024
 */

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Car;

import java.util.List;

public class CarController {

    static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CarList");

    public void addCar(Car car) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(car);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteCar(int carId) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        Car car = em.find(Car.class, carId);
        if (car != null) {
            em.remove(car);
        }
        em.getTransaction().commit();
        em.close();
    }

    public void editCar(Car updatedCar) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        Car existingCar = em.find(Car.class, updatedCar.getId());
        if (existingCar != null) {
            existingCar.setMake(updatedCar.getMake());
            existingCar.setModel(updatedCar.getModel());
        }
        em.getTransaction().commit();
        em.close();
    }

    public void viewAllCars() {
        EntityManager em = emfactory.createEntityManager();
        List<Car> carList = em.createQuery("SELECT c FROM Car c", Car.class).getResultList();
        for (Car car : carList) {
            System.out.println(car.getId() + ": " + car.getMake() + " " + car.getModel());
        }
        em.close();
    }
}

