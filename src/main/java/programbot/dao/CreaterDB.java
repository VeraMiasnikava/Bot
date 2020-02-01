package programbot.dao;

import programbot.entities.*;

import java.io.UnsupportedEncodingException;
import java.util.Date;

public class CreaterDB {

    public void create() {
        try {
            String groupTitle;
            groupTitle = new String("ПО000".getBytes("cp1251"), "UTF-8");
            Group group = new Group(groupTitle);
            groupTitle = new String("ПО999".getBytes("cp1251"), "UTF-8");
            Group group2 = new Group(groupTitle);

            StudentDaoImpl studentDao = new StudentDaoImpl();
            String name, surname;
            name = new String("Юля".getBytes("cp1251"), "UTF-8");
            surname = new String("Жукова".getBytes("cp1251"), "UTF-8");
            Student student = new Student(name, surname, group);
            name = new String("Паша".getBytes("cp1251"), "UTF-8");
            surname = new String("Внуков".getBytes("cp1251"), "UTF-8");
            Student student2 = new Student(name, surname, group);
            name = new String("Вася".getBytes("cp1251"), "UTF-8");
            surname = new String("Егоров".getBytes("cp1251"), "UTF-8");
            Student student3 = new Student(name, surname, group);
            name = new String("Даша".getBytes("cp1251"), "UTF-8");
            surname = new String("Лапина".getBytes("cp1251"), "UTF-8");
            Student student4 = new Student(name, surname, group);
            name = new String("Катя".getBytes("cp1251"), "UTF-8");
            surname = new String("Окунева".getBytes("cp1251"), "UTF-8");
            Student student5 = new Student(name, surname, group);

            name = new String("Марина".getBytes("cp1251"), "UTF-8");
            surname = new String("Павлова".getBytes("cp1251"), "UTF-8");
            Student student6 = new Student(name, surname, group2);
            name = new String("Угорь".getBytes("cp1251"), "UTF-8");
            surname = new String("Алексеев".getBytes("cp1251"), "UTF-8");
            Student student7 = new Student(name, surname, group2);
            name = new String("Виктор".getBytes("cp1251"), "UTF-8");
            surname = new String("Тихов".getBytes("cp1251"), "UTF-8");
            Student student8 = new Student(name, surname, group2);

            String labTitle;
            labTitle = new String("ЛР№1 Составление линейных, разветвляющихся и циклических алгоритмов".getBytes("cp1251"), "UTF-8");
            ProgrammingLab labWorkProgramming = new ProgrammingLab(labTitle, 1);
            labTitle = new String("ЛР№2 интегрированная среда разработки".getBytes("cp1251"), "UTF-8");
            ProgrammingLab labWorkProgramming2 = new ProgrammingLab(labTitle, 1);
            labTitle = new String("ЛР№3 Ввод-вывод данных ".getBytes("cp1251"), "UTF-8");
            ProgrammingLab labWorkProgramming3 = new ProgrammingLab(labTitle, 1);
            labTitle = new String("ЛР№4 Линейные вычислительные процессы".getBytes("cp1251"), "UTF-8");
            ProgrammingLab labWorkProgramming4 = new ProgrammingLab(labTitle, 1);

            ProgrammingCalendar programmingCalendar = new ProgrammingCalendar(group, labWorkProgramming, new Date(120, 1, 13));
            ProgrammingCalendar programmingCalendar2 = new ProgrammingCalendar(group, labWorkProgramming2, new Date(120, 1, 15));
            ProgrammingCalendar programmingCalendar3 = new ProgrammingCalendar(group, labWorkProgramming3, new Date(120, 1, 17));
            ProgrammingCalendar programmingCalendar4 = new ProgrammingCalendar(group, labWorkProgramming4, new Date(120, 1, 18));

            ProgrammingCalendar programmingCalendar5 = new ProgrammingCalendar(group2, labWorkProgramming, new Date(120, 1, 16));
            ProgrammingCalendar programmingCalendar6 = new ProgrammingCalendar(group2, labWorkProgramming2, new Date(120, 1, 17));
            ProgrammingCalendar programmingCalendar7 = new ProgrammingCalendar(group2, labWorkProgramming3, new Date(120, 1, 18));
            ProgrammingCalendar programmingCalendar8 = new ProgrammingCalendar(group2, labWorkProgramming4, new Date(120, 1, 19));

            ProgrammingLesson programmingLesson = new ProgrammingLesson(student, labWorkProgramming, "n+", "z+", 9);
            ProgrammingLesson programmingLesson2 = new ProgrammingLesson(student, labWorkProgramming2, "", "", 1, 6);
            ProgrammingLesson programmingLesson3 = new ProgrammingLesson(student, labWorkProgramming3, "n-", "", 2);
            ProgrammingLesson programmingLesson4 = new ProgrammingLesson(student, labWorkProgramming4, "", "z-");
            labWorkProgramming.addProgrammingLesson(programmingLesson);
            labWorkProgramming2.addProgrammingLesson(programmingLesson2);
            labWorkProgramming3.addProgrammingLesson(programmingLesson3);
            labWorkProgramming4.addProgrammingLesson(programmingLesson4);
            labWorkProgramming.addProgrammingCalendar(programmingCalendar);
            labWorkProgramming2.addProgrammingCalendar(programmingCalendar2);
            labWorkProgramming3.addProgrammingCalendar(programmingCalendar3);
            labWorkProgramming4.addProgrammingCalendar(programmingCalendar4);
            student.addProgrammingLesson(programmingLesson);
            student.addProgrammingLesson(programmingLesson2);
            student.addProgrammingLesson(programmingLesson3);
            student.addProgrammingLesson(programmingLesson4);

            programmingLesson = new ProgrammingLesson(student2, labWorkProgramming, "", "z+", 9);
            programmingLesson2 = new ProgrammingLesson(student2, labWorkProgramming2, "", "z+", 10);
            programmingLesson3 = new ProgrammingLesson(student2, labWorkProgramming3, "", "z+", 8);
            programmingLesson4 = new ProgrammingLesson(student2, labWorkProgramming4, "", "z+");
            labWorkProgramming.addProgrammingLesson(programmingLesson);
            labWorkProgramming2.addProgrammingLesson(programmingLesson2);
            labWorkProgramming3.addProgrammingLesson(programmingLesson3);
            labWorkProgramming4.addProgrammingLesson(programmingLesson4);
            labWorkProgramming.addProgrammingCalendar(programmingCalendar);
            labWorkProgramming2.addProgrammingCalendar(programmingCalendar2);
            labWorkProgramming3.addProgrammingCalendar(programmingCalendar3);
            labWorkProgramming4.addProgrammingCalendar(programmingCalendar4);
            student2.addProgrammingLesson(programmingLesson);
            student2.addProgrammingLesson(programmingLesson2);
            student2.addProgrammingLesson(programmingLesson3);
            student2.addProgrammingLesson(programmingLesson4);

            programmingLesson = new ProgrammingLesson(student3, labWorkProgramming, "n+", "z-", 9);
            programmingLesson2 = new ProgrammingLesson(student3, labWorkProgramming2, "n+", "", 10);
            programmingLesson3 = new ProgrammingLesson(student3, labWorkProgramming3, "", "z+", 3);
            programmingLesson4 = new ProgrammingLesson(student3, labWorkProgramming4, "", "z+");
            labWorkProgramming.addProgrammingLesson(programmingLesson);
            labWorkProgramming2.addProgrammingLesson(programmingLesson2);
            labWorkProgramming3.addProgrammingLesson(programmingLesson3);
            labWorkProgramming4.addProgrammingLesson(programmingLesson4);
            labWorkProgramming.addProgrammingCalendar(programmingCalendar);
            labWorkProgramming2.addProgrammingCalendar(programmingCalendar2);
            labWorkProgramming3.addProgrammingCalendar(programmingCalendar3);
            labWorkProgramming4.addProgrammingCalendar(programmingCalendar4);
            student3.addProgrammingLesson(programmingLesson);
            student3.addProgrammingLesson(programmingLesson2);
            student3.addProgrammingLesson(programmingLesson3);
            student3.addProgrammingLesson(programmingLesson4);

            programmingLesson = new ProgrammingLesson(student4, labWorkProgramming, "n+", "z-", 4);
            programmingLesson2 = new ProgrammingLesson(student4, labWorkProgramming2, "n+", "", 3, 7);
            programmingLesson3 = new ProgrammingLesson(student4, labWorkProgramming3, "n-", "z+", 1);
            programmingLesson4 = new ProgrammingLesson(student4, labWorkProgramming4, "", "z+");
            labWorkProgramming.addProgrammingLesson(programmingLesson);
            labWorkProgramming2.addProgrammingLesson(programmingLesson2);
            labWorkProgramming3.addProgrammingLesson(programmingLesson3);
            labWorkProgramming4.addProgrammingLesson(programmingLesson4);
            labWorkProgramming.addProgrammingCalendar(programmingCalendar);
            labWorkProgramming2.addProgrammingCalendar(programmingCalendar2);
            labWorkProgramming3.addProgrammingCalendar(programmingCalendar3);
            labWorkProgramming4.addProgrammingCalendar(programmingCalendar4);
            student4.addProgrammingLesson(programmingLesson);
            student4.addProgrammingLesson(programmingLesson2);
            student4.addProgrammingLesson(programmingLesson3);
            student4.addProgrammingLesson(programmingLesson4);

            group.addStudent(student);
            group.addStudent(student2);
            group.addStudent(student3);
            group.addStudent(student4);
            group.addStudent(student5);
            GroupDaoImpl groupDao = new GroupDaoImpl();
            groupDao.save(group);

            ProgrammingLesson programmingLesson5 = new ProgrammingLesson(student6, labWorkProgramming, "n+", "z+", 9);
            ProgrammingLesson programmingLesson6 = new ProgrammingLesson(student6, labWorkProgramming2, "", "", 1, 6);
            ProgrammingLesson programmingLesson7 = new ProgrammingLesson(student6, labWorkProgramming3, "n-", "", 2);
            ProgrammingLesson programmingLesson8 = new ProgrammingLesson(student6, labWorkProgramming4, "", "z-");
            labWorkProgramming.addProgrammingLesson(programmingLesson5);
            labWorkProgramming2.addProgrammingLesson(programmingLesson6);
            labWorkProgramming3.addProgrammingLesson(programmingLesson7);
            labWorkProgramming4.addProgrammingLesson(programmingLesson8);
            labWorkProgramming.addProgrammingCalendar(programmingCalendar5);
            labWorkProgramming2.addProgrammingCalendar(programmingCalendar6);
            labWorkProgramming3.addProgrammingCalendar(programmingCalendar7);
            labWorkProgramming4.addProgrammingCalendar(programmingCalendar8);
            student6.addProgrammingLesson(programmingLesson5);
            student6.addProgrammingLesson(programmingLesson6);
            student6.addProgrammingLesson(programmingLesson7);
            student6.addProgrammingLesson(programmingLesson8);

            programmingLesson5 = new ProgrammingLesson(student7, labWorkProgramming, "", "z+", 7);
            programmingLesson6 = new ProgrammingLesson(student7, labWorkProgramming2, "", "z+", 6);
            programmingLesson7 = new ProgrammingLesson(student7, labWorkProgramming3, "", "z+", 5);
            programmingLesson8 = new ProgrammingLesson(student7, labWorkProgramming4, "", "z+");
            labWorkProgramming.addProgrammingLesson(programmingLesson5);
            labWorkProgramming2.addProgrammingLesson(programmingLesson6);
            labWorkProgramming3.addProgrammingLesson(programmingLesson7);
            labWorkProgramming4.addProgrammingLesson(programmingLesson8);
            labWorkProgramming.addProgrammingCalendar(programmingCalendar5);
            labWorkProgramming2.addProgrammingCalendar(programmingCalendar6);
            labWorkProgramming3.addProgrammingCalendar(programmingCalendar7);
            labWorkProgramming4.addProgrammingCalendar(programmingCalendar8);
            student7.addProgrammingLesson(programmingLesson5);
            student7.addProgrammingLesson(programmingLesson6);
            student7.addProgrammingLesson(programmingLesson7);
            student7.addProgrammingLesson(programmingLesson8);

            programmingLesson5 = new ProgrammingLesson(student8, labWorkProgramming, "n-", "", 0);
            programmingLesson6 = new ProgrammingLesson(student8, labWorkProgramming2, "n-", "", 0);
            programmingLesson7 = new ProgrammingLesson(student8, labWorkProgramming3, "n-", "", 0);
            programmingLesson8 = new ProgrammingLesson(student8, labWorkProgramming4, "", "z+");
            labWorkProgramming.addProgrammingLesson(programmingLesson5);
            labWorkProgramming2.addProgrammingLesson(programmingLesson6);
            labWorkProgramming3.addProgrammingLesson(programmingLesson7);
            labWorkProgramming4.addProgrammingLesson(programmingLesson8);
            labWorkProgramming.addProgrammingCalendar(programmingCalendar5);
            labWorkProgramming2.addProgrammingCalendar(programmingCalendar6);
            labWorkProgramming3.addProgrammingCalendar(programmingCalendar7);
            labWorkProgramming4.addProgrammingCalendar(programmingCalendar8);
            student8.addProgrammingLesson(programmingLesson5);
            student8.addProgrammingLesson(programmingLesson6);
            student8.addProgrammingLesson(programmingLesson7);
            student8.addProgrammingLesson(programmingLesson8);

            group2.addStudent(student6);
            group2.addStudent(student7);
            group2.addStudent(student8);
            groupDao.save(group2);


        } catch (
                UnsupportedEncodingException ex) {

        }
    }
}
