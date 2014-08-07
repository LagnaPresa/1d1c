package net.n39i.ltx1d1c.d20140807

import org.junit.Test

import static org.hamcrest.CoreMatchers.is
import static org.junit.Assert.assertThat

class ElvisOperator {
    @Test
    void test() {
        assertThat(null ?: 0, is(0));
        assertThat("something" ?: 0, is("something"));
    }
}
