package net.n39i.dsaa;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class MyLinkedListTest {

    private MyLinkedList<String> list;

    @Before
    public void setUp() throws Exception {
        list = new MyLinkedList<>();
    }

    @Test
    public void test() {
        assertThat(list.size(), is(0));
        list.add("a");
        assertThat(list.size(), is(1));
        list.add("b");
        assertThat(list.size(), is(2));
        assertThat(list.get(0), is("a"));
        assertThat(list.get(1), is("b"));

        try {
            list.get(2);
            fail();
        } catch (IndexOutOfBoundsException e) {
            ;
        }
    }

}
