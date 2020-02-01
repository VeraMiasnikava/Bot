package programbot.dao;

import lombok.extern.log4j.Log4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import programbot.entities.ProgrammingLab;
import programbot.entities.ProgrammingLesson;
import programbot.utils.HibernateSessionFactory;

import java.util.Iterator;
import java.util.List;

@Log4j
public class ProgrammingLessonDaoImpl implements Dao<ProgrammingLesson> {

    @Override
    public void save(ProgrammingLesson lesson) throws HibernateException {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(lesson);
        tx1.commit();
        session.close();
    }

    @Override
    public ProgrammingLesson findById(Long id) throws HibernateException {
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

    public void deleteLessonsBySemestr(int semestr) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Query query = session.createQuery("From ProgrammingLab WHERE semestr = :semestr");
        query.setParameter("semestr", semestr);
        List<ProgrammingLab> programmingLabList = (List<ProgrammingLab>) query.list();
        for (Iterator<ProgrammingLab> it = programmingLabList.iterator(); it.hasNext(); ) {
            Transaction tx1 = session.beginTransaction();
            ProgrammingLab programmingLab = (ProgrammingLab) it.next();
            query = session.createQuery("DELETE ProgrammingLesson WHERE programmingLab.idLab = :idLab");
            query.setParameter("idLab", programmingLab.getIdLab());
            int rows = query.executeUpdate();
            log.info("удалено записей из Programminglessons:" + rows);
            tx1.commit();
            tx1 = session.beginTransaction();
            query = session.createQuery("DELETE ProgrammingCalendar WHERE programmingLab.idLab = :idLab");
            query.setParameter("idLab", programmingLab.getIdLab());
            rows = query.executeUpdate();
            System.out.println("удалено записей из programmingCalendar:" + rows);
            tx1.commit();
        }
        session.close();
    }

}
