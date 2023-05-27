package entities.errors;

public class MultipleLineBreaksError extends TextError{
    public MultipleLineBreaksError(String text) {
        super(text);
    }
    @Override
    public String fix() {
        return text.replaceAll("\\n{2,}", "\n");
    }
}
