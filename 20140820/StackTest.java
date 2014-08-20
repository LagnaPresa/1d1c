package net.n39i.dsaa;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class StackTest {

    private Stack<String> stack;

    @Before
    public void setUp() throws Exception {
        stack = new Stack<>();
    }

    @Test
    public void test() {
        stack.push("a");
        stack.push("b");
        assertThat(stack.pop(), is("b"));
        assertThat(stack.pop(), is("a"));
        
        try {
            stack.pop();
            fail();
        } catch(NoSuchElementException e) {
            ;
        }
    }

}
