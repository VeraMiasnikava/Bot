package programbot.services;

import programbot.dao.LabProgrammingDaoImpl;
import programbot.entities.LabProgramming;

public class LabProgrammingService {
    private LabProgrammingDaoImpl labProgrammingDao = new LabProgrammingDaoImpl();

    public LabProgrammingService() {
    }

    public LabProgramming findLab(int id) {
        return labProgrammingDao.findById(id);
    }

    public void createLab(LabProgramming student) {
        labProgrammingDao.create(student);
    }

    public void deleteSLab(LabProgramming student) {
        labProgrammingDao.delete(student);
    }

    public void updateLab(LabProgramming student) {
        labProgrammingDao.update(student);
    }

}
