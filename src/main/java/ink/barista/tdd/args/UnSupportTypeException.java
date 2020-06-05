package ink.barista.tdd.args;

public class UnSupportTypeException extends RuntimeException {
    public UnSupportTypeException(String type) {
        super(String.format("Type '%s' Is Not Support",type));
    }
}
