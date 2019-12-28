package programbot;

import lombok.extern.log4j.Log4j;
import org.hibernate.SessionFactory;
import programbot.utils.HibernateSessionFactory;

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
*/ SessionFactory session = HibernateSessionFactory.getSessionFactory();
     /*  try {
        StudentService studentService = new StudentService();
        Student student = new Student(6,"Юля","Жукова","ПО000");
           // ProgrammingLesson lesson=new ProgrammingLesson(student, 1 );
        studentService.createStudent(student);
        student=studentService.findStudent(6);
        student.setGroupa("go999");
           // studentService.updateStudent(student);
        System.out.println(student);
       // bot.setMessage(student.toString());
            String snm=new String(student.getName().getBytes("UTF-8"), "cp1251");
            System.out.println(snm);
            LabProgrammingService labProgrammingService=new LabProgrammingService();
            LabProgramming labWorkProgramming=new LabProgramming(1,"интегрированная среда разработки", 1);
            labProgrammingService.createLab(labWorkProgramming);

        } catch (UnsupportedEncodingException ex) {

        }*/



        System.out.println("Работа программы завершена");



    }
    }
