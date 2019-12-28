package programbot.dao;


import org.hibernate.HibernateException;

public interface Dao<Type> {
    void create(Type entity)throws HibernateException;
    Type findById(int id)throws HibernateException;
    void update(Type entity)throws HibernateException;
    void delete(Type entity)throws HibernateException;
  //  void rollback()throws HibernateException;

}
