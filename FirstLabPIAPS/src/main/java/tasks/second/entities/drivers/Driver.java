package tasks.second.entities.drivers;

public abstract class Driver {
    protected DrivingLicenseCategory drivingLicenseCategory;

    public Driver() {
        System.out.println("Используется конструктор абстрактного класса Driver");
    }

    public abstract DrivingLicenseCategory getDrivingLicenseCategory();

    public abstract boolean getOn();
}
