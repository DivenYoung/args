package ink.barista.tdd.args;


public abstract class Flag {
    private final String flagName;

    public Flag(String flagName) {
        this.flagName = flagName;
    }

    public static Flag of(String flagName, String type) {
        if (type.equals("bool")) return new BooleanFlag(flagName);

        if (type.equals("int")) return new IntegerFlag(flagName);

        if (type.equals("string")) return new StringFlag(flagName);

        throw new UnSupportTypeException(type);
    }

    public abstract Object getValue(String valueAsString);

    public String getFlagName() {
        return this.flagName;
    }
}
