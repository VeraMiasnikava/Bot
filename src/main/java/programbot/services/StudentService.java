package programbot.services;

import programbot.dao.StudentDaoImpl;
import programbot.entities.Student;

public class StudentService {
    private StudentDaoImpl studentDao = new StudentDaoImpl();

    public StudentService() {
    }

    public Student findStudent(int id) {
        return studentDao.findById(id);
    }

    public void createStudent(Student student) {
        studentDao.create(student);
    }

    public void deleteStudent(Student student) {
        studentDao.delete(student);
    }

    public void updateStudent(Student student) {
        studentDao.update(student);
    }


}
