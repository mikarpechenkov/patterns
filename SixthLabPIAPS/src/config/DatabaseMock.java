package config;

import entities.observers.Observer;

import java.util.Map;
import java.util.TreeMap;

public class DatabaseMock {
    private Map<Integer, Map<Observer, String>> info = new TreeMap<>();
    public Map<Integer, Map<Observer, String>> getInfo() {
        return info;
    }
}
