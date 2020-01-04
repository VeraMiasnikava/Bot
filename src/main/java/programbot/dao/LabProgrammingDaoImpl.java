package programbot.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import programbot.entities.LabProgramming;
import programbot.utils.HibernateSessionFactory;

import java.util.List;

public class LabProgrammingDaoImpl implements Dao<LabProgramming> {
   /* Session session;
    public void setSession(Session session) {
        this.session = session;
    }
    @Override
    public void save(LabProgramming labWork) throws HibernateException {
      // session = HibernateSessionFactory.getSession();
        Transaction tx1 = session.beginTransaction();
        session.save(labWork);
        tx1.commit();
      //  session.close();
    }

    @Override
    public LabProgramming findById(int id) throws HibernateException {
        return HibernateSessionFactory.getSession().get(LabProgramming.class, id);
    }

    @Override
    public void update(LabProgramming labWork) throws HibernateException {
       // session = HibernateSessionFactory.getSession();
        Transaction tx1 = session.beginTransaction();
        session.update(labWork);
        tx1.commit();
       // session.close();
    }

    @Override
    public void delete(LabProgramming labWork) throws HibernateException {
       // session = HibernateSessionFactory.getSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(labWork);
        tx1.commit();
       // session.close();
    }

    public List<LabProgramming> findAll() {
       // List<LabProgramming> labProgrammingList = (List<LabProgramming>)  HibernateSessionFactory.getSessionFactory().openSession().createQuery("From LabProgramming ").list();
        List<LabProgramming> labProgrammingList = (List<LabProgramming>)  session.createQuery("From LabProgramming ").list();
        return labProgrammingList;
    }
*/
     @Override
    public void save(LabProgramming labWork) throws HibernateException {
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

    public List<LabProgramming> findAll() {
        List<LabProgramming> labProgrammingList = (List<LabProgramming>)  HibernateSessionFactory.getSessionFactory().openSession().createQuery("From LabProgramming ").list();
        return labProgrammingList;
    }
}
