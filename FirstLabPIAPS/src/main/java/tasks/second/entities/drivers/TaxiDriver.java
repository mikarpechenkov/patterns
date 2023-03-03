package tasks.second.entities.drivers;

public class TaxiDriver extends Driver {
    public TaxiDriver() {
        super();
        drivingLicenseCategory = DrivingLicenseCategory.B;
        System.out.println("Создан объект типа TaxDriver");
    }

    @Override
    public boolean getOn() {
        System.out.println("Водитель сел за руль такси");
        return true;
    }

    @Override
    public DrivingLicenseCategory getDrivingLicenseCategory() {
        return drivingLicenseCategory;
    }
}
