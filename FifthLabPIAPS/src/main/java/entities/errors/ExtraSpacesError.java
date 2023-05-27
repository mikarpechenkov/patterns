package entities.errors;

public class ExtraSpacesError extends TextError{
    public ExtraSpacesError(String text) {
        super(text);
    }
    @Override
    public String fix() {
        return text.replaceAll("\\(\\s+", "(")
                .replaceAll("\\s+\\)", ")")
                .replaceAll("\\s+,", ",")
                .replaceAll("\\s+\\.", ".");
    }
}
