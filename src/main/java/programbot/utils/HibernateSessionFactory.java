package programbot.utils;

import lombok.extern.log4j.Log4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import programbot.entities.LabProgramming;
import programbot.entities.ProgrammingLesson;
import programbot.entities.Student;

@Log4j
public class HibernateSessionFactory {
    private static SessionFactory sessionFactory = null;
    private HibernateSessionFactory() {}

    public static SessionFactory getSessionFactory() {
        System.out.println("1");
        if (sessionFactory == null) {
            try {System.out.println("2");
                Configuration configuration = new Configuration().configure();
                System.out.println("3---"+configuration);
                configuration.addAnnotatedClass(Student.class);
                System.out.println("4---"+configuration);
                configuration.addAnnotatedClass(LabProgramming.class);
                System.out.println("5-----"+configuration);
                configuration.addAnnotatedClass(ProgrammingLesson.class);
                System.out.println("6---"+configuration);
                // configuration.addAnnotatedClass(ProgrammingLesson.ProgrLessonKey.class);
                System.out.println("7---");
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                System.out.println("8---"+builder.build());
                sessionFactory = configuration.buildSessionFactory(builder.build());
                System.out.println("9");
            } catch (Exception e) {
                log.error("исключение hibernate:" + e);
            }
        }
        System.out.println("10");
            return sessionFactory;
    }

    public static Session getSession() {
        System.out.println("11");
        sessionFactory=getSessionFactory();

        if(!sessionFactory.isOpen()) {
            return sessionFactory.openSession();
        }else return  sessionFactory.getCurrentSession();
    }
/*
    public static SessionFactory getSessionFactory() {
        System.out.println("1");
        if (sessionFactory == null) {
            try {System.out.println("2");
                Configuration configuration = new Configuration().configure();
                System.out.println("3---"+configuration);
               configuration.addAnnotatedClass(Student.class);
                System.out.println("4---"+configuration);
                configuration.addAnnotatedClass(LabProgramming.class);
                System.out.println("5-----"+configuration);
                configuration.addAnnotatedClass(ProgrammingLesson.class);
                System.out.println("6---"+configuration);
               // configuration.addAnnotatedClass(ProgrammingLesson.ProgrLessonKey.class);
                System.out.println("7---");
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                System.out.println("8---"+builder.build());
                sessionFactory = configuration.buildSessionFactory(builder.build());
                System.out.println("9");
            } catch (Exception e) {
                log.error("исключение hibernate:" + e);
            }
        }
        System.out.println("10");
        return sessionFactory;

    }
/*
    public static Session getSession() {
        System.out.println("11");
        return sessionFactory.openSession();
    }
*/

}

