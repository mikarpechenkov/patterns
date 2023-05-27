package entities.errors;

public class DashError extends TextError{
    public DashError(String text) {
        super(text);
    }
    @Override
    public String fix() {
        return text.replaceAll("([^\\p{L}\\d])-(?!\\s)", "$1 — ");
    }
}
