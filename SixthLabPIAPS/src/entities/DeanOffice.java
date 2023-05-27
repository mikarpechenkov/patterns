package entities;

import config.DatabaseMock;
import entities.observers.Observer;
import entities.obsevable.UniversityChair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DeanOffice {
    private DatabaseMock database;
    private UniversityChair universityChair;

    public DeanOffice(UniversityChair universityChair, DatabaseMock database) {
        this.database = database;
        this.universityChair = universityChair;
    }

    public void checkAcademicPerformance(int weekNumber) {
        System.out.println("Деканат осуществляет проверку отчетов за неделю");
        List<Observer> offenders = new ArrayList<>();
        Map<Observer, String> weekNotes;

        if ((weekNotes = database.getInfo().get(weekNumber)) != null) {
            for (Observer observer : universityChair.getTeachersList())
                if (weekNotes.get(observer) == null || weekNotes.get(observer).isBlank())
                    offenders.add(observer);
        } else
            offenders = new ArrayList<>(universityChair.getOffenders());
        universityChair.setOffenders(offenders);
    }
}
