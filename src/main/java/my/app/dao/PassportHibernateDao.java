package my.app.dao;

import my.app.entity.Passport;
import my.app.entity.Person;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class PassportHibernateDao implements PassportDao {
    public static void main(String[] args) {
//        Person person = new Person(1, "vova", 50);
        Passport passport = new Passport();
        passport.setIdPassport(10);
        passport.setSerialNumber("sdag23");
        passport.setActiveDate("12/123/545");

        Person person1 = new PersonHibernateDao().readPersonById(19);
        passport.setPerson(person1);

        PassportHibernateDao passportHibernateDao = new PassportHibernateDao();
        passportHibernateDao.create(passport);
    }
    @Override
    public void create(Passport passport) {
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();


            try {
                session.save(passport);
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
