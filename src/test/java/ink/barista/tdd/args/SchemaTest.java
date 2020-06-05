package ink.barista.tdd.args;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class SchemaTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    @Test
    public void should_convert_bool_value_by_flag_type() {
        Schema schema = new Schema("l:bool");
        assertThat((boolean) schema.convert("true", "l")).isTrue();
        assertThat((boolean) schema.convert("false", "l")).isFalse();
    }

    @Test
    public void should_convert_int_value_by_flag_type() {
        Schema schema = new Schema("p:int");
        assertThat( schema.convert("8080", "p")).isEqualTo(8080);
        assertThat(schema.convert("010", "p")).isEqualTo(10);
    }

    @Test
    public void should_convert_string_value_by_flag_type() {
        Schema schema = new Schema("d:string");
        assertThat( schema.convert("/usr/logs", "d")).isEqualTo("/usr/logs");
    }

    @Test
    public void should_throw_exception_when_type_not_support() {
        expectedException.expect(UnSupportTypeException.class);
        expectedException.expectMessage("Type 'array' Is Not Support");
        Schema schema = new Schema("q:array");
    }

    @Test
    public void should_throw_exception_when_flag_not_exist() {
        expectedException.expect(NoSuchDefinitionException.class);
        expectedException.expectMessage("No Such Definition of 'm' ");
        Schema schema = new Schema("l:bool");
        schema.getFlag("m");
    }
}