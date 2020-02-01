package programbot.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import programbot.entities.ProgrammingLab;
import programbot.utils.HibernateSessionFactory;

import java.util.List;

public class ProgrammingLabDaoImpl implements Dao<ProgrammingLab> {

    @Override
    public void save(ProgrammingLab labWork) throws HibernateException {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(labWork);
        tx1.commit();
        session.close();
    }

    @Override
    public ProgrammingLab findById(Long id) throws HibernateException {
        return HibernateSessionFactory.getSessionFactory().openSession().get(ProgrammingLab.class, id);
    }

    @Override
    public void update(ProgrammingLab labWork) throws HibernateException {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(labWork);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(ProgrammingLab labWork) throws HibernateException {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(labWork);
        tx1.commit();
        session.close();
    }

    public List<ProgrammingLab> findAll() {
        List<ProgrammingLab> programmingLabList = (List<ProgrammingLab>) HibernateSessionFactory.getSessionFactory().openSession().createQuery("From ProgrammingLab ").list();
        return programmingLabList;
    }
}
