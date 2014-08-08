package net.n39i.ltx1d1c.d20140808;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.function.Function;

import org.junit.Test;

public class MethodReferences {

    @Test
    // 関数インターフェースを引数に取るメソッドに、
    // ラムダ式等ではなく、メソッド参照というのを渡せる。
    public void test() {
        // これの代わりに
        assertThat(method(s -> String.valueOf(s)), is("123"));
        // こう
        assertThat(method(String::valueOf), is("123"));

        // インスタンスメソッドも渡せる
        assertThat(method(new Clazz()::convert), is("converted"));

        // ちなみに実装的にはラムダ式の一種らしい
        Function<Integer, String> f = String::valueOf;
        // f.getClass() =
        // net.n39i.ltx1d1c.d20140808.MethodReferences$$Lambda$1/648525677@29b5cd00
        
        // (String::valueOf).getClass() とかできないのはオーバーロードが解決できないからか。
    }

    private String method(Function<Integer, String> f) {
        return f.apply(123);
    }

    private static class Clazz {
        public String convert(Integer i) {
            return "converted";
        }
    }
}
