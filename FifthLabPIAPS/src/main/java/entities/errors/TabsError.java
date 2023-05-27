package entities.errors;

public class TabsError extends TextError{
    public TabsError(String text) {
        super(text);
    }
    @Override
    public String fix() {
        return text.replaceAll("\\t+", "    ");
    }
}
