package my.app.dao;

import my.app.entity.Car;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import java.util.List;

public class CarHibernateDao implements CarDao {
    public static void main(String[] args) {
        new CarHibernateDao().createCar(new Car("Byhanka", 35));
        new CarHibernateDao().readCarById(5);
    }

    @Override
    public void createCar(Car car) {
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();


            try {
                session.save(car);
                transaction.commit();
            } catch (Exception e) {
                e.printStackTrace();
                transaction.rollback();

            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public Car readCarById(int id) {
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();


            try {
                Car car = session.get(Car.class, id);
                return car;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                session.close();
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Car> readAllCars() {
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();


            try {
                List<Car> carList = session.createQuery("FROM Car").list();
                return carList;
            } catch (Exception e) {
                e.printStackTrace();


            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public void updateCar(Car updatedCar) {
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();


            try {
                Car car = session.get(Car.class, updatedCar.getId());
                car.setCarName(updatedCar.getCarName());
                car.setAge(updatedCar.getAge());
                session.update(car);

                transaction.commit();

            } catch (Exception e) {
                e.printStackTrace();
                transaction.rollback();

            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void deleteCarById(int id) {
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();


            try {
                Car car = session.get(Car.class, id);
                session.delete(car);
                transaction.commit();
            } catch (Exception e) {
                e.printStackTrace();


            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }


    }
}
