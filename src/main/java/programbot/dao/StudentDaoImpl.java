package programbot.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import programbot.entities.ProgrammingLesson;
import programbot.entities.Student;
import programbot.utils.HibernateSessionFactory;

import java.util.List;

public class StudentDaoImpl implements Dao<Student> {
   /* Session session;

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void save(Student student) {
        // session = HibernateSessionFactory.getSession();
        Transaction tx1 = session.beginTransaction();
        session.save(student);
        tx1.commit();
       // session.close();
    }

    @Override
    public Student findById(int id) {
      // return HibernateSessionFactory.getSessionFactory().openSession().get(Student.class, id);
        return session.get(Student.class, id);
    }

    @Override
    public void update(Student student) {
        //session = HibernateSessionFactory.getSession();
        Transaction tx1 = session.beginTransaction();
        session.update(student);
        tx1.commit();
       // session.close();
    }

    @Override
    public void delete(Student student) {
      // session = HibernateSessionFactory.getSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(student);
        tx1.commit();
       // session.close();
    }

    public ProgrammingLesson findLessonById(int id) {
       // return HibernateSessionFactory.getSession().get(ProgrammingLesson.class, id);
       return session.get(ProgrammingLesson.class, id);
    }

    public List<Student> findAll() {
       // List<Student> students = (List<Student>)  HibernateSessionFactory.getSessionFactory().openSession().createQuery("From Student ").list();
        List<Student> students = (List<Student>)  session.createQuery("From Student ").list();
        return students;
    }
*/




    @Override
    public void save(Student student) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(student);
        tx1.commit();
        session.close();
    }

    @Override
    public Student findById(int id) {
         Student student= HibernateSessionFactory.getSessionFactory().openSession().get(Student.class, id);
      //  List<ProgrammingLesson> lessons = (List<ProgrammingLesson>)  HibernateSessionFactory.getSessionFactory().openSession().createQuery("From ProgrammingLesson ").list();
        //for (ProgrammingLesson lesson:lessons) {
         //student.addProgrammingLesson(lesson);
       // }
        return  student;
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

    public ProgrammingLesson findLessonById(int id) {
        return HibernateSessionFactory.getSessionFactory().openSession().get(ProgrammingLesson.class, id);
    }

    public List<Student> findAll() {
        List<Student> students = (List<Student>)  HibernateSessionFactory.getSessionFactory().openSession().createQuery("From Student ").list();
        return students;
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
