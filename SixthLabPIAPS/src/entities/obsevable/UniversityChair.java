package entities.obsevable;

import entities.observers.Observer;

import java.util.ArrayList;
import java.util.List;

public class UniversityChair implements Observable {
    private List<Observer> teachersList = new ArrayList<>();
    private List<Observer> offenders;

    @Override
    public void attach(Observer observer) {
        teachersList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        teachersList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        teachersList.forEach(teacher -> teacher.update(offenders));
    }

    public List<Observer> getOffenders() {
        return offenders;
    }

    public List<Observer> getTeachersList() {
        return teachersList;
    }

    public void setOffenders(List<Observer> offenders) {
        this.offenders = offenders;
        System.out.println("Кафедра получила от деканата список провинившихся преподов, начинается оповещение"+offenders);
        notifyObservers();
    }
}
