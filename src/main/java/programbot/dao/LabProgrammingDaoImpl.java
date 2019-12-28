package programbot.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import programbot.entities.LabProgramming;
import programbot.utils.HibernateSessionFactory;

public class LabProgrammingDaoImpl implements Dao<LabProgramming> {
    @Override
    public void create(LabProgramming labWork) throws HibernateException {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(labWork);
        tx1.commit();
        session.close();
    }

    @Override
    public LabProgramming findById(int id) throws HibernateException {
        return HibernateSessionFactory.getSessionFactory().openSession().get(LabProgramming.class, id);
    }

    @Override
    public void update(LabProgramming labWork) throws HibernateException {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(labWork);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(LabProgramming labWork) throws HibernateException {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(labWork);
        tx1.commit();
        session.close();
    }
}
