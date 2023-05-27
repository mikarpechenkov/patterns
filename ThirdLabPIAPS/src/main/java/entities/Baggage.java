package entities;

public record Baggage(int id, int weight) {
    @Override
    public String toString() {
        return "Baggage{" +
                "id=" + id +
                ", weight=" + weight +
                '}';
    }
}

