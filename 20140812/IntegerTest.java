package net.n39i.ltx1d1c.d20140812;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class IntegerTest {

    @Test
    public void test() {
        Integer i = new Integer(0);
        Integer j = new Integer(0);
        assertTrue(i <= j);
        assertTrue(j <= i);
        assertTrue(i != j);
    }

}
