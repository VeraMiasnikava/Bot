package programbot.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import programbot.entities.Student;
import programbot.utils.HibernateSessionFactory;

public class StudentDaoImpl implements Dao<Student> {

// <mapping class="programbot.database.Student"/>

    @Override
    public void create(Student student) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(student);
        tx1.commit();
        session.close();
    }

    @Override
    public Student findById(int id) {
         return HibernateSessionFactory.getSessionFactory().openSession().get(Student.class, id);
    }

    @Override
    public void update(Student student) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(student);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Student student) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(student);
        tx1.commit();
        session.close();
    }
/*
    @Override
    public void rollback() {
        try {
            getSession().getTransaction().rollback();
        } catch (HibernateException e) {
            log.log(Level.WARNING, "Cannot rollback", e);
        }
        try {
            getSession().close();
        } catch (HibernateException e) {
            log.log(Level.WARNING, "Cannot close", e);
        }
        DAO.session.set(null);
    }*/

}
