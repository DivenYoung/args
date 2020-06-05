package ink.barista.tdd.args;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArgsTest {
    @Test
    public void should_parse_bool_flag_without_value() {
        Schema schema = new Schema("l:bool");
        String[] argsArray = new String[]{"-l"};
        Args args = new Args(schema, argsArray);
        String value = args.valueStringOf(Flag.of("l","bool"));
        assertThat(value).isEqualTo("true");
    }

    @Test
    public void should_parse_flag_with_value() {
        Schema schema = new Schema("p:int");
        String[] argsArray = new String[]{"-p","8080"};
        Args args = new Args(schema, argsArray);
        String value = args.valueStringOf(Flag.of("p", "int"));
        assertThat(value).isEqualTo("8080");
    }

    @Test
    public void should_parse_multi_flag_with_value() {
        Schema schema = new Schema("p:int l:bool");
        String[] argsArray = new String[]{"-p","8080","-l"};
        Args args = new Args(schema, argsArray);
        assertThat(args.valueStringOf(Flag.of("p", "int"))).isEqualTo("8080");
        assertThat(args.valueStringOf(Flag.of("l", "bool"))).isEqualTo("true");
    }

}