package ink.barista.tdd.args;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArgsParserTest {
    @Test
    public void should_parse_args() {
        ArgsParser argsParser = new ArgsParser("l:bool p:int d:string");
        String[] args = new String[]{"-l", "-p", "8080", "-d", "/usr/logs"};
        argsParser.parse(args);
        assertThat((boolean) argsParser.getValue("l")).isTrue();
    }
}
