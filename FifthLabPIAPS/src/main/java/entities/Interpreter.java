package entities;

import entities.errors.*;

public class Interpreter {
    private String data;

    public Interpreter(String data) {
        this.data = data;
    }

    public String interpret() {
        TextError error;
        String result;
        error = new MultipleSpacesError(data);
        data = error.fix();
        error = new DashError(data);
        data = error.fix();
        error = new ExtraSpacesError(data);
        data = error.fix();
        error = new MultipleLineBreaksError(data);
        data = error.fix();
        error = new IncorrectQuotesError(data);
        data=error.fix();
        error = new TabsError(data);
        data = error.fix();

        return data;
    }
}