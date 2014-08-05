package net.n39i.ltx1d1c.d20140805

import org.junit.Test

import java.util.regex.Matcher
import java.util.regex.Pattern

import static org.hamcrest.CoreMatchers.*
import static org.junit.Assert.*

// スクリプト言語といえば強力な文字列操作
class RegularExpressionLiteral {

    @Test
    void thisIsString() {
        // Groovy のスラッシュくくりは正規表現リテラルではなく「正規表現に便利な文字列リテラル」
        assertThat(/abc/, is(instanceOf(String.class)))
        assertThat(/ab\c/, is("ab\\c"))
    }

    @Test
    void regexOperators() {
        // ただし、文字列の正規表現演算子が強力
        assertThat(~/abc/, is(instanceOf(Pattern.class)));

        Matcher m = "bat" =~ /b(.)t/
        assertTrue(m.matches())
        assertThat(m.group(1), is("a"))

        assertTrue("bat" ==~ /b.t/)
    }

    @Test
    void patternMatch() {
        // java.util.regex.Pattern を case に書ける
        switch ("book") {
            case ~/b..k/:
                break
            default:
                fail()
        }
    }

}
