package programbot.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import programbot.entities.ProgrammingLesson;
import programbot.utils.HibernateSessionFactory;

public class ProgrammingLessonDaoImpl implements Dao<ProgrammingLesson> {
    @Override
    public void create(ProgrammingLesson lesson) throws HibernateException {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(lesson);
        tx1.commit();
        session.close();
    }

    @Override
    public ProgrammingLesson findById(int id) throws HibernateException {
        return HibernateSessionFactory.getSessionFactory().openSession().get(ProgrammingLesson.class, id);
    }

    @Override
    public void update(ProgrammingLesson lesson) throws HibernateException {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(lesson);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(ProgrammingLesson lesson) throws HibernateException {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(lesson);
        tx1.commit();
        session.close();
    }
}
