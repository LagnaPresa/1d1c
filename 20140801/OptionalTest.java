package net.n39i.ltx1d1c.d20140801;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.Test;

public class OptionalTest {

    static final Optional<String> EMPTY = Optional.empty();

    static final Optional<String> PRESENT = Optional.of("123");

    @Test
    public void get() {
        try {
            EMPTY.get();
            fail();
        } catch (NoSuchElementException e) {
            ;
        }

        assertThat(PRESENT.get(), is("123"));
    }

    @Test
    public void ifPresent() {
        EMPTY.ifPresent(s -> fail());

        String[] result = { "NG" };
        PRESENT.ifPresent(s -> result[0] = "OK");
        assertThat(result[0], is("OK"));
    }

    @Test
    public void isPresent() {
        assertFalse(EMPTY.isPresent());
        assertTrue(PRESENT.isPresent());
    }

    @Test
    public void orElse() {
        assertThat(EMPTY.orElse("abc"), is("abc"));
        assertThat(PRESENT.orElse("abc"), is("123"));
    }

    @Test
    public void orElseGet() {
        assertThat(EMPTY.orElseGet(() -> "a" + "b" + "c"), is("abc"));
        assertThat(PRESENT.orElseGet(() -> "a" + "b" + "c"), is("123"));
    }

    @Test
    public void orElseThrow() {
        try {
            EMPTY.orElseThrow(() -> new Exception("orElseThrow"));
            fail();
        } catch (Exception e) {
            assertThat(e.getMessage(), is("orElseThrow"));
        }

        try {
            assertThat(PRESENT.orElseThrow(() -> new Exception("orElseThrow")),
                    is("123"));
        } catch (Exception e) {
            fail();
        }

    }

    @Test
    public void filter() {
        assertThat(EMPTY.filter(s -> true), is(EMPTY));
        assertThat(EMPTY.filter(s -> false), is(EMPTY));
        assertThat(PRESENT.filter(s -> true), is(PRESENT));
        assertThat(PRESENT.filter(s -> false), is(EMPTY));
    }

    @Test
    public void flatMap() {
        assertThat(EMPTY.flatMap(s -> Optional.of(Integer.valueOf(s))),
                is(EMPTY));

        assertThat(PRESENT.flatMap(s -> Optional.of(Integer.valueOf(s))),
                is(Optional.of(123)));
    }

    @Test
    public void map() {
        assertThat(EMPTY.map(s -> Integer.parseInt(s)),
                is(EMPTY));

        assertThat(PRESENT.map(s -> Integer.parseInt(s)),
                is(Optional.of(123)));
    }
}
