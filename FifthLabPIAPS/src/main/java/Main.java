import entities.Interpreter;

public class Main {
    public static void main(String[] args) {
        String example = "Привет   это программа , yyy\t\t  \t\t.";
        Interpreter interpreter = new Interpreter(example);
        String result = interpreter.interpret();
        System.out.println(result);
    }
}
