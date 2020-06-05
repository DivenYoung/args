package ink.barista.tdd.args;

public class NoSuchDefinitionException extends RuntimeException {
    public NoSuchDefinitionException(String flagName) {
        super(String.format("No Such Definition of '%s' ",flagName));
    }
}
