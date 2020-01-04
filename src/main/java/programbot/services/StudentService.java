package programbot.services;

import org.hibernate.Session;
import programbot.dao.ProgrammingLessonDaoImpl;
import programbot.dao.StudentDaoImpl;
import programbot.entities.ProgrammingLesson;
import programbot.entities.Student;

import java.util.List;

public class StudentService {
    private StudentDaoImpl studentDao = new StudentDaoImpl();

    public StudentService() {
       // studentDao.setSession(session);
    }

    public Student findStudent(int id) {
        return studentDao.findById(id);
    }

    public void saveStudent(Student student) {
        studentDao.save(student);
    }

    public void deleteStudent(Student student) {
        studentDao.delete(student);
    }

    public void updateStudent(Student student) {
        studentDao.update(student);
    }

    public ProgrammingLesson findLessonById(int id) {
        return studentDao.findLessonById(id);
    }

    public List<Student> findAllStudents() {
        return studentDao.findAll();
    }


}
