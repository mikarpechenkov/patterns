package entities.observers;

import config.DatabaseMock;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Teacher implements Observer {
    String fullName;
    DatabaseMock database;

    public Teacher(String name, DatabaseMock database) {
        this.fullName = name;
        this.database = database;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Teacher)
            return Objects.equals(fullName,((Teacher) obj).fullName);
        return false;
    }

    public String getFullName() {
        return fullName;
    }

    public void writeReport(int weekNumber, String report) {
        if (!database.getInfo().containsKey(weekNumber))
            database.getInfo().put(weekNumber, new HashMap<>());
        database.getInfo().get(weekNumber).put(this, report);
        System.out.printf("%s добавляет отчет за %d неделю: %s%n", fullName, weekNumber, report.isBlank() ? "пустой" : report);
    }

    @Override
    public void update(List<Observer> offenders) {
        if (offenders != null && offenders.contains(this))
            System.out.printf("%s проинформирован кафедрой о том, что деканат НЕ получил его отчет%n", fullName);
        else
            System.out.printf("%s проинформирован кафедрой о том, что деканат получил его отчет%n", fullName);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "fullName='" + fullName + '\'' +
                '}';
    }
}
