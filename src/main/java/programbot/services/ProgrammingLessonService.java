package programbot.services;

import programbot.dao.ProgrammingLessonDaoImpl;
import programbot.entities.ProgrammingLesson;

public class ProgrammingLessonService {
    private ProgrammingLessonDaoImpl lessonDao = new ProgrammingLessonDaoImpl();

    public ProgrammingLessonService() {
    }

    public ProgrammingLesson findLesson(int id) {
        return lessonDao.findById(id);
    }

    public void createLesson(ProgrammingLesson lesson) {
        lessonDao.create(lesson);
    }

    public void deleteLesson(ProgrammingLesson lesson) {
        lessonDao.delete(lesson);
    }

    public void updateLesson(ProgrammingLesson lesson) {
        lessonDao.update(lesson);
    }
}
