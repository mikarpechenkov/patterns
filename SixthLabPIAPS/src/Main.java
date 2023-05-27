import config.DatabaseMock;
import entities.DeanOffice;
import entities.observers.Observer;
import entities.observers.Teacher;
import entities.obsevable.Observable;
import entities.obsevable.UniversityChair;

public class Main {
    public static void main(String[] args) {
        DatabaseMock database = new DatabaseMock();
        Observable universityChair = new UniversityChair();
        DeanOffice deanOffice = new DeanOffice((UniversityChair) universityChair, database);
        Observer firstTeacher = new Teacher("Айрапетян Артем Арменович", database);
        Observer secondTeacher = new Teacher("Айрапетян Артем Арменович", database);
        Observer thirdTeacher = new Teacher("Махиборода Максим Александрович", database);
        Observer fourthTeacher = new Teacher("Мелёшин Юрий Михайлович", database);

        universityChair.attach(firstTeacher);
        universityChair.attach(secondTeacher);
        universityChair.attach(thirdTeacher);
        universityChair.attach(fourthTeacher);

        ((Teacher)firstTeacher).writeReport(1, "Успеваемость 2,55");
        ((Teacher)secondTeacher).writeReport(1, "Успеваемость 3,5");
        ((Teacher)thirdTeacher).writeReport(1, "Успеваемость 5,0");
        ((Teacher)fourthTeacher).writeReport(1, "");

        deanOffice.checkAcademicPerformance(1);
    }
}