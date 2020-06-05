package ink.barista.tdd.args;

public class BooleanFlag extends Flag {

    public BooleanFlag(String flagName) {
        super(flagName);
    }

    @Override
    public Object getValue(String valueAsString) {
        return Boolean.parseBoolean(valueAsString);
    }
}
