package entities.errors;

public class MultipleSpacesError extends TextError {
    public MultipleSpacesError(String text) {
        super(text);
    }

    @Override
    public String fix() {
        return text.replaceAll("\\s{2,}", " ");
    }
}
