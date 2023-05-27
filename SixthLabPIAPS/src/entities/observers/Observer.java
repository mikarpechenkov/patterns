package entities.observers;

import java.util.List;

public interface Observer {
    void update(List<Observer> offenders);
}
