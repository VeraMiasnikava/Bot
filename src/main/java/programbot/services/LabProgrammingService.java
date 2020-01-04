package programbot.services;

import org.hibernate.Session;
import programbot.dao.LabProgrammingDaoImpl;
import programbot.entities.LabProgramming;
import programbot.entities.Student;

import java.util.List;

public class LabProgrammingService {
    private LabProgrammingDaoImpl labProgrammingDao = new LabProgrammingDaoImpl();

    public LabProgrammingService() {
       // labProgrammingDao.setSession(session);
    }

    public LabProgramming findLab(int id) {
        return labProgrammingDao.findById(id);
    }

    public void saveLab(LabProgramming student) {
        labProgrammingDao.save(student);
    }

    public void deleteSLab(LabProgramming student) {
        labProgrammingDao.delete(student);
    }

    public void updateLab(LabProgramming student) {
        labProgrammingDao.update(student);
    }

    public List<LabProgramming> findAllLabs() {
        return labProgrammingDao.findAll();
    }

}
