package my.app.dao;

import my.app.entity.Car;


import my.app.entity.TehPassport;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TehpassportHibernateDao {
    public static void main(String[] args) {
     Car car = new Car(1, "buba", 50);
        TehPassport tehPassport = new TehPassport();
        tehPassport.setSerialNumber("sdag23");
        tehPassport.setCreateDate("12/123/545");

        Car car1 = new CarHibernateDao().readCarById(1);
        tehPassport.setCar(car1);

        TehpassportHibernateDao tehpassportHibernateDao = new TehpassportHibernateDao();
        tehpassportHibernateDao.create(tehPassport);
    }

    public void create(TehPassport tehPassport) {
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();


            try {
                session.save(tehPassport);
                transaction.commit();
            } catch (Exception e) {
                e.printStackTrace();
                transaction.rollback();

            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }

    }
}
