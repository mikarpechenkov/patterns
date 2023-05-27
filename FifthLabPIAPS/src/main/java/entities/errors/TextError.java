package entities.errors;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class TextError {
    protected String text;
    public TextError(String text) {
        this.text = text;
    }
    public abstract String fix();
}
