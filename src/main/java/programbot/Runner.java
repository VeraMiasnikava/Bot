package programbot;

import lombok.extern.log4j.Log4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import programbot.entities.LabProgramming;
import programbot.entities.ProgrammingLesson;
import programbot.entities.Student;
import programbot.services.LabProgrammingService;
import programbot.services.ProgrammingLessonService;
import programbot.services.StudentService;
import programbot.utils.HibernateSessionFactory;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Log4j
public class Runner {
    public static void main(String[] args) {
/*
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi=new TelegramBotsApi();

        Bot bot=new Bot();
        try{
            telegramBotsApi.registerBot(bot);
        }catch (TelegramApiRequestException e){
            e.printStackTrace();
        }
*/
//SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
//Session session= HibernateSessionFactory.getSession();
     try {
        StudentService studentService = new StudentService();
        int n=3, m=4;
        Student student = new Student(n,"Юля","Жукова","ПО000");
         // studentService.saveStudent(student);
         //session= HibernateSessionFactory.getSession();
          Student student2 = new Student(m,"Паша","Внуков","ПО000");
          //studentService.saveStudent(student2);
         System.out.println(studentService.findAllStudents().toString());
       /*  List<Student> students=studentService.findAllStudents();
         System.out.println("students.size = " + students.size());
         for (Iterator<Student> it = students.iterator(); it.hasNext();) {
             Student student11 = (Student) it.next();
             System.out.println(student11.toString());
             System.out.println(student11.getLessons().toString());
         }*/
       // student.setGroupa("go999");
         // student2.setGroupa("go999");
       // studentService.updateStudent(student);
        //  studentService.updateStudent(student2);
         System.out.println(studentService.findAllStudents().toString());
         student=studentService.findStudent(1);
         System.out.println("нашли:"+student);
       //  ArrayList<ProgrammingLesson> programmingLessonArrayList=new ArrayList<>(student.getLessons());
        //System.out.println( student.getLessons().toString());
         //for(ProgrammingLesson lesson:student.getLessons()) {
              //  System.out.println(lesson.getLabProgramming().toString()+ "     " + lesson.isWasPresent());
           //  lesson.getLabProgramming();
             // lesson.isWasPresent();
         //}
        // Student student3 = new Student(n,"Юля","Жукова","ПО000");
        // studentService.deleteStudent(student3);
        // System.out.println(studentService.findAllStudents().toString());

       // bot.setMessage(student.toString());
          //  String snm=new String(student.getName().getBytes("UTF-8"), "cp1251");
           // System.out.println(snm);

            LabProgrammingService labProgrammingService=new LabProgrammingService();
            LabProgramming labWorkProgramming=new LabProgramming(3,"интегрированная среда разработки", 1);
           // labProgrammingService.saveLab(labWorkProgramming);
          LabProgramming labWorkProgramming2=new LabProgramming(4,"ввод-вывод данных", 1);
          //labProgrammingService.saveLab(labWorkProgramming2);
         System.out.println( labProgrammingService.findAllLabs().toString());

         Student student5 = new Student(10,"Юля","Жукова","ПО000");

         LabProgramming labWorkProgramming3=new LabProgramming(1,"интегрированная среда разработки", 1);
        // LabProgramming labWorkProgramming4=new LabProgramming(2,"ввод-вывод данных", 1);
          ProgrammingLessonService programmingLessonService=new ProgrammingLessonService();
         ProgrammingLesson programmingLesson=new ProgrammingLesson(student5,labWorkProgramming3);
         student5.addProgrammingLesson(programmingLesson);
         studentService.saveStudent(student5);
        programmingLessonService.saveLesson(programmingLesson);
         // ProgrammingLesson programmingLesson2=new ProgrammingLesson(student3,labWorkProgramming4);
         // programmingLessonService.saveLesson(programmingLesson2);
      //   student5.addProgrammingLesson(programmingLesson);
      //  studentService.updateStudent(student5);
       //  programmingLessonService.saveLesson(programmingLesson);



        } catch (UnsupportedEncodingException ex) {

        }



        System.out.println("Работа программы завершена");



    }
    }
