package ink.barista.tdd.args;

public class ArgsParser {
    private Args args;
    private final Schema schema;

    public ArgsParser(String schemaAsString) {
        schema = new Schema(schemaAsString);
    }

    public Object getValue(String flagName) {
        return args.valueOf(flagName);
    }

    public void parse(String[] args) {
        this.args = new Args(schema, args);
    }
}
