package programbot.dao;

import lombok.extern.log4j.Log4j;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import org.hibernate.query.Query;
import programbot.entities.Group;
import programbot.entities.ProgrammingLesson;
import programbot.entities.Student;
import programbot.utils.HibernateSessionFactory;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Log4j
public class StudentDaoImpl implements Dao<Student> {

    @Override
    public void save(Student student) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(student);
        tx1.commit();
        session.close();
    }

    @Override
    public Student findById(Long id) {
        Student student = HibernateSessionFactory.getSessionFactory().openSession().get(Student.class, id);
        return student;
    }

    public String findProgrammingLessonsByStudentId(Long idStudent) throws UnsupportedEncodingException {
        String rezult = "";
        Student student = HibernateSessionFactory.getSessionFactory().openSession().load(Student.class, idStudent);
        try {
            rezult = rezult + String.format("%s  %s%n", student.getSurname(), student.getName());
        } catch (ObjectNotFoundException e) {
            log.error("учащийся с таким id не существует");
            log.error(e.getMessage());
            String text = new String("по вашему запросу ничего не найдено, проверьте id".getBytes("cp1251"), "UTF-8");
            return text;
        }
        String text = new String("   дата   |  лаб.раб.  |проп| зач|оценки ".getBytes("cp1251"), "UTF-8");
        rezult = rezult + String.format("----------------------------------------%n" + text +
                " ----------------------------------------%n");
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        List<ProgrammingLesson> programmingLessons = student.getProgrammingLessons();
        int summMarks = 0, countMarks = 0;
        int debtCount = 0;
        int pollCount = 0;
        int documentCount = 0;
        if (programmingLessons.size() == 0) {
            text = new String("по вашему запросу ничего не найдено, проверьте id".getBytes("cp1251"), "UTF-8");
            return text;
        }
        for (Iterator<ProgrammingLesson> it = programmingLessons.iterator(); it.hasNext(); ) {
            ProgrammingLesson programmingLesson = (ProgrammingLesson) it.next();
            if (programmingLesson.getPassTest().isEmpty() || programmingLesson.getPassTest().equals("z-")) {
                debtCount++;
            }
            if (programmingLesson.getMark1() != null) {
                if (programmingLesson.getMark1() < 4 && programmingLesson.getMark2() == null || programmingLesson.getMark1() < 4 && programmingLesson.getMark2() < 4) {
                    pollCount++;
                }
            }
            if (programmingLesson.getMark1() != null) {
                summMarks = summMarks + programmingLesson.getMark1();
                countMarks++;
            }
            if (programmingLesson.getMark2() != null) {
                summMarks = summMarks + programmingLesson.getMark2();
                countMarks++;
            }

            if (!programmingLesson.getPresence().isEmpty()) {
                if (programmingLesson.getPresence().equals("n-")) {
                    documentCount++;
                }
            }
            Query query = HibernateSessionFactory.getSessionFactory().openSession().createQuery("SELECT C.date FROM ProgrammingCalendar as C WHERE C.group =:group and C.programmingLab.idLab=:idLab");
            query.setParameter("group", student.getGroup());
            query.setParameter("idLab", programmingLesson.getProgrammingLab().getIdLab());
            List<Date> dates = (List<Date>) query.list();
            if (dates.size() == 0) {
                text = new String("данных не найдено".getBytes("cp1251"), "UTF-8");
                return text;
            }
            SimpleDateFormat formatForDate = new SimpleDateFormat("E dd.MM");
            rezult = rezult + formatForDate.format(dates.get(0)) + programmingLesson.toString();
            rezult = rezult + String.format("%n");
        }
        double avgMark = (double) summMarks / countMarks;
        text = new String("Количество задолженностей:".getBytes("cp1251"), "UTF-8");
        String text1 = new String("лаб.раб.".getBytes("cp1251"), "UTF-8");
        String text2 = new String("опросы:".getBytes("cp1251"), "UTF-8");
        String text3 = new String("принести справки:".getBytes("cp1251"), "UTF-8");
        String text4 = new String("Средний балл:".getBytes("cp1251"), "UTF-8");
        rezult = rezult + String.format("----------------------------------------%n" +
                        text + "%n" +
                        text1 + ": %d%n" +
                        text2 + " %d%n" +
                        text3 + " %d "+text1+"%n" +
                        text4 + " %f%n" +
                        " ----------------------------------------%n" ,
                debtCount, pollCount, documentCount, avgMark);

        tx1.commit();
        session.close();
        return rezult;

    }

    @Override
    public void update(Student student) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(student);
        tx1.commit();
        session.close();
    }

    public void merge(Student student) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.merge(student);
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


    public List<Student> findAll() {
        List<Student> students = (List<Student>) HibernateSessionFactory.getSessionFactory().openSession().createQuery("From Student ").list();
        return students;
    }

    public String findStudentsByGroup(String groupTitle) throws UnsupportedEncodingException {
        Query query = HibernateSessionFactory.getSessionFactory().openSession().createQuery("SELECT G FROM Group as G WHERE G.groupTitle =:groupTitle");
        query.setParameter("groupTitle", groupTitle);
        List<Group> groups = (List<Group>) query.list();
        if (groups.size() == 0) {
            String text = new String("данных не найдено, проверьте номер группы".getBytes("cp1251"), "UTF-8");
            return text;
        }
        query = HibernateSessionFactory.getSessionFactory().openSession().createQuery("SELECT S FROM Student as S WHERE S.group.idGroup =:idGroup ORDER BY S.surname ASC");
        query.setParameter("idGroup", groups.get(0).getIdGroup());
        List<Student> students = (List<Student>) query.list();
        if (students.size() == 0) {
            String text=new String("данных не найдено".getBytes("cp1251"), "UTF-8");
            return text;
        }
        String text = new String("     id      |      фамилия   |  имя".getBytes("cp1251"), "UTF-8");
        String rezult = String.format(text+" %n" +
                "-------------------------------------------%n");
        for (Iterator<Student> it = students.iterator(); it.hasNext(); ) {
            Student student = (Student) it.next();
            rezult = rezult + student.toString();
        }
        return rezult;
    }

    public String findDebtsProgrammingByGroup(String groupTitle) throws UnsupportedEncodingException {
        Query query = HibernateSessionFactory.getSessionFactory().openSession().createQuery("SELECT G FROM Group as G WHERE G.groupTitle =:groupTitle");
        query.setParameter("groupTitle", groupTitle);
        List<Group> groups = (List<Group>) query.list();
        if (groups.size() == 0) {
            String text = new String("по вашему запросу ничего не найдено, проверьте номер группы".getBytes("cp1251"), "UTF-8");
            return text;
        }
        query = HibernateSessionFactory.getSessionFactory().openSession().createQuery("SELECT S FROM Student as S WHERE S.group.idGroup =:idGroup ORDER BY S.surname ASC");
        query.setParameter("idGroup", groups.get(0).getIdGroup());
        List<Student> students = (List<Student>) query.list();
        if (students.size() == 0) {
            String text = new String("по вашему запросу ничего не найдено".getBytes("cp1251"), "UTF-8");
            return text;
        }
        String text = new String("Задолженности группы:".getBytes("cp1251"), "UTF-8");
        String rezult = String.format(text+"%s%n" +
                "-------------------------------------------%n", groupTitle);
        for (Iterator<Student> it = students.iterator(); it.hasNext(); ) {
            Student student = (Student) it.next();
            Session session = HibernateSessionFactory.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            List<ProgrammingLesson> programmingLessons = student.getProgrammingLessons();
            tx1.commit();
            session.close();
            int summMarks = 0, countMarks = 0;
            int debtCount = 0;
            int pollCount = 0;
            int documentCount = 0;
            if (programmingLessons.size() == 0) continue;
            for (Iterator<ProgrammingLesson> it1 = programmingLessons.iterator(); it1.hasNext(); ) {
                ProgrammingLesson programmingLesson = (ProgrammingLesson) it1.next();
                if (programmingLesson.getPassTest().isEmpty() || programmingLesson.getPassTest().equals("z-")) {
                    debtCount++;
                }
                if (programmingLesson.getMark1() != null) {
                    if (programmingLesson.getMark1() < 4 && programmingLesson.getMark2() == null || programmingLesson.getMark1() < 4 && programmingLesson.getMark2() < 4) {
                        pollCount++;
                    }
                }
                if (programmingLesson.getMark1() != null) {
                    summMarks = summMarks + programmingLesson.getMark1();
                    countMarks++;
                }
                if (programmingLesson.getMark2() != null) {
                    summMarks = summMarks + programmingLesson.getMark2();
                    countMarks++;
                }

                if (!programmingLesson.getPresence().isEmpty()) {
                    if (programmingLesson.getPresence().equals("n-")) {
                        documentCount++;
                    }
                }
            }
            double avgMark = (double) summMarks / countMarks;
            if (debtCount != 0 || pollCount != 0 || documentCount != 0 || avgMark < 4) {
                rezult = rezult + String.format("%s  %s%n", student.getSurname(), student.getName());
                text = new String("Количество задолженностей учащегося:".getBytes("cp1251"), "UTF-8");
                String text1 = new String("лаб.раб.".getBytes("cp1251"), "UTF-8");
                String text2 = new String("опросы:".getBytes("cp1251"), "UTF-8");
                String text3 = new String("принести справки:".getBytes("cp1251"), "UTF-8");
                String text4 = new String("Средний балл:".getBytes("cp1251"), "UTF-8");
                rezult = rezult + String.format("----------------------------------------%n" +
                                text + "%n" +
                                text1 + ": %d%n" +
                                text2 + " %d%n" +
                                text3 + " %d "+text1+"%n" +
                                text4 + " %f%n" +
                                "  ----------------------------------------%n",
                        debtCount, pollCount, documentCount, avgMark);
            }

        }
        return rezult;
    }


}
