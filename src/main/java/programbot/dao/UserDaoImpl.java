package programbot.dao;

import org.hibernate.HibernateException;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import programbot.entities.User;
import programbot.utils.HibernateSessionFactory;

public class UserDaoImpl implements Dao<User> {
    @Override
    public void save(User user) throws HibernateException {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    @Override
    public User findById(Long id) throws ObjectNotFoundException {
        User user = HibernateSessionFactory.getSessionFactory().openSession().get(User.class, id);
        return user;
    }

    @Override
    public void update(User user) throws HibernateException {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(User user) throws HibernateException {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }
}
