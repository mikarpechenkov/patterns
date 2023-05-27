package entities.errors;

public class IncorrectQuotesError extends TextError{

    public IncorrectQuotesError(String text) {
        super(text);
    }

    @Override
    public String fix() {
        return text.replaceAll("“([^“”]*)”", "«$1»"); //Захватывающая группа 1
    }
}
