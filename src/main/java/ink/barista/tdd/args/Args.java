package ink.barista.tdd.args;

import java.util.List;

public class Args {

    private Schema schema;
    private final List<String> strings;

    public Args(Schema schema, String[] args) {
        this.schema = schema;
        strings = List.of(args);
    }

    public Object valueOf(String flagName) {
        Flag flag = schema.getFlag(flagName);
        return flag.getValue(valueStringOf(flag));
    }

    public String valueStringOf(Flag flag) {
        if (flag instanceof BooleanFlag) {
            return "true";
        }
        int i = strings.indexOf("-".concat(flag.getFlagName()));
        return strings.get(i + 1);
    }
}
