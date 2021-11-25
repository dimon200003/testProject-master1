package my.app.dao;

import my.app.entity.Car;
import my.app.entity.Insurance;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InsuranceHibernateDao {
    public static void main(String[] args) {
        Car car = new CarHibernateDao().readCarById(2);
        Insurance insurance = new Insurance();
        insurance.setInsuranceclass("Perfect");
        insurance.setCar(car);
        new InsuranceHibernateDao().create(insurance);

    }
    public void create(Insurance insurance) {
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();


            try {
                session.save(insurance);
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
