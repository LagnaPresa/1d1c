package net.n39i.ltx1d1c.d20140825;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.Optional;

import org.junit.Test;

public class FunctionalInterfaceThrowsExceptionTest {

    @Test
    public void test() throws Exception {
        Optional<String> s1 = Optional.of("str");
        Optional<String> s2 = Optional.empty();

        assertThat(clientMethod(() -> s1.orElseThrow(() -> new IOException())),
                is("str"));
        try {
            clientMethod(() -> s2.orElseThrow(() -> new InterruptedException()));
            fail();
        } catch (InterruptedException e) {
            ;
        }

    }

    private static <T, X extends Exception>
            T clientMethod(PresumablySupplier<T, X> t) throws X {
        return t.get();
    }

    @FunctionalInterface
    public interface PresumablySupplier<T, X extends Exception> {
        T get() throws X;
    }

}
