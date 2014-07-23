package net.n39i.ltx1d1c.d20140723

import static org.junit.Assert.*

// モダンな言語は反復処理を行うために、ループ構文の他に反復メソッドが用意されていることが多い。
class IterativeMethods {

    public static void main(String[] args) {

        def tri = [];
        ['a', 'b', 'c'].each { tri.add(it + it + it) } // it は暗黙に渡される要素
        assertEquals(['aaa', 'bbb', 'ccc'], tri)

        // コレクションの要素がメソッドのレシーバになるような反復処理なら *. 演算子が使える
        // （同時にマップ処理としても使える）
        assertEquals(['A', 'B', 'C'], ['a', 'b', 'c']*.toUpperCase())

    }

}
