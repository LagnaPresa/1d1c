package net.n39i.ltx1d1c.d20140730;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import org.junit.Test;

public class MyFirstJava8 {

	@Test
	public void IDontHaveAClueAboutRightAndLeft() {
		assertThat(
				Optional.of("123")
						.flatMap(v -> Optional.of(Integer.valueOf(v))),
				is(Optional.of(123)));
	}

	// むしろJUnitで戸惑った。org.junit.Assert.assertThat と
	// org.hamcrest.MatcherAssert.assertThat 紛らわしすぎるんですケド。
	
}
