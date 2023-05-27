package entities.obsevable;

import entities.observers.Observer;

import java.util.List;

public interface Observable {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers();
}
