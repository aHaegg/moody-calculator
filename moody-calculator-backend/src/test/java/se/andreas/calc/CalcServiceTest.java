package se.andreas.calc;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import se.andreas.calc.model.CalcRes;
import se.andreas.calc.model.Message;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(MockitoExtension.class)
class CalcServiceTest {

    @InjectMocks
    private CalcService target;

    @Test
    void testCalculator() {

        CalcRes actual = target.calc("1+1");
        assertThat(actual.getResult(), is(2));

        actual = target.calc("6-3");
        assertThat(actual.getResult(), is(3));

        actual = target.calc("3*4");
        assertThat(actual.getResult(), is(12));

        actual = target.calc("12/2");
        assertThat(actual.getResult(), is(6));
    }

    @Test
    void testErrors() {

        CalcRes actual = target.calc("1/0");
        assertThat(actual.getMessages().size(), is(1));
        assertThat(actual.getMessages().get(0), is(Message.DIVIDE_BY_ZERO));

        actual = target.calc("1+3+4");
        assertThat(actual.getMessages().size(), is(1));
        assertThat(actual.getMessages().get(0), is(Message.COULD_NOT_UNDERSTAND_QUERY));

        actual = target.calc("1+a");
        assertThat(actual.getMessages().size(), is(1));
        assertThat(actual.getMessages().get(0), is(Message.COULD_NOT_UNDERSTAND_QUERY));

        actual = target.calc("123");
        assertThat(actual.getMessages().size(), is(1));
        assertThat(actual.getMessages().get(0), is(Message.NO_OPERATOR_FOUND));
    }

    @Test
    void returnsSuperstitionMessageWhenResultIs13() {

        CalcRes actual = target.calc("1+12");
        assertThat(actual.getMessages().size(), is(1));
        assertThat(actual.getMessages().get(0), is(Message.SUPERSTITION));
        assertThat(actual.getResult(), is(nullValue()));

    }
}