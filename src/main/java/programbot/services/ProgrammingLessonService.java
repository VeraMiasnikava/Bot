package programbot.services;

import org.hibernate.Session;
import programbot.dao.ProgrammingLessonDaoImpl;
import programbot.entities.ProgrammingLesson;

public class ProgrammingLessonService {
    private ProgrammingLessonDaoImpl lessonDao = new ProgrammingLessonDaoImpl();

    public ProgrammingLessonService() {
        //lessonDao.setSession(session);
    }

    public ProgrammingLesson findLesson(int id) {
        return lessonDao.findById(id);
    }

    public void saveLesson(ProgrammingLesson lesson) {
        lessonDao.save(lesson);
    }

    public void deleteLesson(ProgrammingLesson lesson) {
        lessonDao.delete(lesson);
    }

    public void updateLesson(ProgrammingLesson lesson) {
        lessonDao.update(lesson);
    }
}
