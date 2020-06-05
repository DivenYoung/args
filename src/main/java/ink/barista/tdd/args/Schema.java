package ink.barista.tdd.args;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Schema {

    private final List<Flag> flags;

    public Schema(String schemaAsString) {
        flags = Stream
                .of(schemaAsString.split(" "))
                .map(definition -> definition.split(":"))
                .map(definition -> Flag.of(definition[0], definition[1]))
                .collect(Collectors.toList());
    }


    public Flag getFlag(String flagName) {
        return flags.stream()
                .filter(f -> f.getFlagName().equals(flagName))
                .findFirst()
                .orElseThrow(() -> new NoSuchDefinitionException(flagName));
    }

    public Object convert(String valueAsString, String flagName) {
        return getFlag(flagName).getValue(valueAsString);
    }
}
