package net.n39i.ltx1d1c.d20140811

import org.junit.Test

import static org.hamcrest.CoreMatchers.is
import static org.junit.Assert.assertThat

class NamedParameters {

    def name;

    def age;

    @Test
    void test() {
        def miku = new NamedParameters(age: 16, name: "Miku")
        assertThat(miku.name, is("Miku"))
        assertThat(miku.age, is(16))
    }

}
