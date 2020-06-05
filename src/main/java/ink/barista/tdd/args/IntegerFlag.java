package ink.barista.tdd.args;

public class IntegerFlag extends Flag {
    public IntegerFlag(String flagName) {
        super(flagName);
    }

    @Override
    public Object getValue(String valueAsString) {
        return Integer.parseInt(valueAsString);
    }
}
