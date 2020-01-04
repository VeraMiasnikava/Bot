package programbot.dao;


import org.hibernate.HibernateException;
import org.hibernate.ObjectNotFoundException;

public interface Dao<Type> {
    void save(Type entity)throws HibernateException;
    Type findById(int id)throws ObjectNotFoundException;
    void update(Type entity)throws HibernateException;
    void delete(Type entity)throws HibernateException;
  //  void rollback()throws HibernateException;

}
