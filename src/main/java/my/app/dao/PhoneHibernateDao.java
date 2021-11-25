package my.app.dao;

import my.app.entity.Person;
import my.app.entity.Phone;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class PhoneHibernateDao {
    public static void main(String[] args) {
        Person person = new PersonHibernateDao().readPersonById(4);
        Phone phone = new Phone();
        phone.setCode(44);
        phone.setNumber(55555);
        phone.setPerson(person);
        new PhoneHibernateDao().create(phone);

    }
    public void create(Phone phone) {
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();


            try {
                session.save(phone);
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
