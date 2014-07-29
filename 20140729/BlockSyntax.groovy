package net.n39i.ltx1d1c.d20140729

class BlockSyntax {

    // Groovy の構文に以下の特徴がある。
    // 1. 引数が1つ以上のメソッドはカッコを省略できる
    // 2. クロージャのリテラルがある
    // これらの特徴を組み合わせると、限定的だがブロック構文を自作するような強力な記述が可能になる。
    static void main(String[] args) {
        def me = new BlockSyntax()
        me.latency {
            // any high-cost calc
            (1..15).subsequences()
        }
        println "$me.elapsedTime ms"
    }

    // main メソッドを省略せずに書くと以下のようになる。
    static void detail() {
        def me = new BlockSyntax()
        // ブランケットのみのブロックがクロージャのリテラル
        Closure c = { (1..15).subsequences() }
        me.latency(c)
        println "$me.elapsedTime ms"
    }

    long elapsedTime = 0L

    long latency(Closure c) {
        long b = System.currentTimeMillis()
        c()
        elapsedTime += System.currentTimeMillis() - b
    }

}
