package programbot.dao;

import lombok.extern.log4j.Log4j;
import org.hibernate.HibernateException;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import programbot.entities.Group;
import programbot.entities.Student;
import programbot.utils.HibernateSessionFactory;


import java.util.Iterator;
import java.util.List;

@Log4j
public class GroupDaoImpl implements Dao<Group> {

    @Override
    public void save(Group group) throws HibernateException {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(group);
        tx1.commit();
        session.close();
    }

    @Override
    public Group findById(Long id) throws ObjectNotFoundException {
        Group group = HibernateSessionFactory.getSessionFactory().openSession().get(Group.class, id);
        return group;
    }

    @Override
    public void update(Group entity) throws HibernateException {

    }

    @Override
    public void delete(Group group) throws HibernateException {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT G FROM Group as G WHERE G.groupTitle =:groupTitle");
        query.setParameter("groupTitle", group.getGroupTitle());
        List<Group> groups = (List<Group>) query.list();
        if (groups.size() == 0) {
           log.info("данных для удаления не найдено");
            return;
        }
        Transaction tx1 = session.beginTransaction();
        query = session.createQuery("DELETE ProgrammingCalendar WHERE group.idGroup = :idGroup");
        query.setParameter("idGroup", groups.get(0).getIdGroup());
        int rows = query.executeUpdate();
        log.info("удалено записей из табл Programming_Calendar:" + rows);
        tx1.commit();
        query = session.createQuery("SELECT S FROM Student as S WHERE S.group.idGroup =:idGroup");
        query.setParameter("idGroup", groups.get(0).getIdGroup());
        List<Student> students = (List<Student>) query.list();
        for (Iterator<Student> it = students.iterator(); it.hasNext(); ) {
            Student student = (Student) it.next();
            tx1 = session.beginTransaction();
            query = session.createQuery("DELETE ProgrammingLesson WHERE student.idStudent = :idStudent");
            query.setParameter("idStudent", student.getIdStudent());
            rows = query.executeUpdate();
            log.info("удалено lessonsProgramming:" + rows);
            tx1.commit();
        }
        tx1 = session.beginTransaction();
        query = session.createQuery("DELETE Student WHERE group.idGroup = :idGroup");
        query.setParameter("idGroup", groups.get(0).getIdGroup());
        rows = query.executeUpdate();
        System.out.println("удалено students:" + rows);
        tx1.commit();
        tx1 = session.beginTransaction();
        query = session.createQuery("DELETE Group WHERE idGroup = :idGroup");
        query.setParameter("idGroup", groups.get(0).getIdGroup());
        rows = query.executeUpdate();
        System.out.println("удалено groups:" + rows);
        tx1.commit();

        session.close();
    }

    public List<Group> findAll() {
        List<Group> groups = (List<Group>) HibernateSessionFactory.getSessionFactory().openSession().createQuery("From Group ").list();
        return groups;
    }
}
