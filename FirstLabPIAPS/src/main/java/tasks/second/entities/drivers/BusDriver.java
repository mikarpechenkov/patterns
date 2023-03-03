package tasks.second.entities.drivers;

public class BusDriver extends Driver{
    public BusDriver(){
        super();
        drivingLicenseCategory=DrivingLicenseCategory.D;
        System.out.println("Создан объект типа BusDriver");
    }

    @Override
    public boolean getOn(){
        System.out.println("Водитель сел за руль автобуса");
        return true;
    }

    @Override
    public DrivingLicenseCategory getDrivingLicenseCategory(){
        return drivingLicenseCategory;
    }
}
