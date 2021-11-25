package my.app.dao;

import my.app.entity.Car;
import my.app.entity.Passport;
import my.app.entity.Person;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import java.util.List;

public class PersonHibernateDao implements PersonDao {
    public static void main(String[] args) {

//        Passport passport = new Passport();
//        passport.setIdPassport(10);
//        passport.setSerialNumber("sdag23");
//        passport.setActiveDate("12/123/545");
//
//        Person person1 = new Person("Vova", 35);
//        person1.setPassport(passport);
//        new PersonHibernateDao().createPerson(person1);

//        new PersonHibernateDao().createPerson(new Person("Vova", 35));
//        new PersonHibernateDao().readAllPersons();
        new PersonHibernateDao().readPersonById(19);
//        new PersonHibernateDao().deletePersonById(20);
//        new PersonHibernateDao().updatePerson(new Person( 30,"Vasa", 30));
    }

    @Override
    public void createPerson(Person person) {
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();


            try {
                session.save(person);
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
    public Person readPersonById(int id) {

        Session session = null;
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();


            try {
                Person person = session.get(Person.class, id);
                return person;
            } catch (Exception e) {
                e.printStackTrace();


            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            try {
                session.close();
            } catch (Exception e) {  /*do nothing...*/ }
        }
        return null;
    }

    @Override
    public List<Person> readAllPersons() {
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();


            try {
                List<Person> personList = session.createQuery("FROM Person ").list();
                return personList;
            } catch (Exception e) {
                e.printStackTrace();


            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updatePerson(Person updatedPerson) {
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();


            try {
                Person person = session.get(Person.class, updatedPerson.getId());
                person.setName(updatedPerson.getName());
                person.setAge(updatedPerson.getAge());
                session.update(person);

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
    public void deletePersonById(int id) {
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();


            try {
                Person person = session.get(Person.class, id);
                session.delete(person);
                transaction.commit();
            } catch (Exception e) {
                e.printStackTrace();


            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }


    }
}
