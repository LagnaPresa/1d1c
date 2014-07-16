package net.n39i.ltx1d1c.d140716;

import static org.junit.Assert.*;

import org.junit.Test;

//
// 以下に解答が記載されている。
//

public class WhoAmITest {

	// さて、どう考えただろうか。
	// 「同じ値を比較演算子 != で比較して true になるわけが無い！だから false だ！」
	// 自明なことのように思える。しかし例外が存在する。
	// Float.NaN と （出題に使った） Double.NaN がその例外である。
	// これらの値は自分自身とすら等しくない（数値ではない）。奇妙に思えるが、
	// そもそもNaN(Not a number)とは演算中に数値として表せなくなってしまった値全般を指すのであり、
	// 特定の値を表しているわけではないことから数学的には正しい。
	// またこの概念は Java 独自のものではなく、IEEE 754で定義されるNaNを踏襲した実装である。
	@Test
	public void testNanReflectivity() {
		assertTrue(Float.NaN != Float.NaN);
		assertTrue(Double.NaN != Double.NaN);
	}
	
	// ということは正解は true ... 残念ながらそうではない。
	// 以下のJUnitテストを実行してみればわかるが、正解は false である。
	// NaNを全く知らない人であれば正解しているかもしれない。
	@Test
	public void testNotReflective() {
		assertFalse(WhoAmI.notReflective(Double.NaN));
	}
	
	// いったい何が起こったのか。
	// Double.NaN は Java 型としては double 型である。
	// よって WhoAmI#notReflective(Object) のシグネチャとはマッチしない。
	// にもかかわらず出題のコードがコンパイルできるのは、リリース5.0でサポートされた
	// ボクシング変換によるものである。
	// 基本データ型が参照型の変数に代入される際、暗黙的にラッパー型に変換されている。
	// double 型の値であれば、ラッパー型の Double オブジェクトに変換されている。
	@Test
	public void testAutoBoxing() {
		Object o = Double.NaN;
		assertTrue(o instanceof Double);
	}
	
	// 出題に立ち返ろう。
	// WhoAmI.notReflective(Double.NaN) の実引数 Double.NaN は double 型であるが、
	// Object 型の仮引数 o に代入された際、ボクシング変換によって Double 型に変換される。
	// そして、参照型に対する比較演算子 != は、両辺のオブジェクトの（同値性ではなく）同一性を検査する。
	// 同じ変数が参照するオブジェクトは同一なのであるから、 != の評価は false となる。
	// 
	// ちなみに、 Double#equals(Object) を使うとどうなっただろうか。
	@Test
	public void testEquivalence() {
		Object o = Double.NaN;
		assertTrue(o.equals(o));
	}
	
	// Object#equals(Object) の一般契約に則り、反射律を守っている。
	// NaNの定義とは矛盾するようだが、もし、equalsの一般契約に従わず反射律を破ると、
	// 同値性を根拠とした実装（ハッシュテーブル等）の不変律を破壊してしまう。
	
	// まとめると、 NaN はそれ自身とも等しくない。自動ボクシングには気をつけよう。
	// Double でラップされた NaN 同士は等しい。
	// しかし、わかりにくいので、これらの詳細に依存するようなコードは書かないことが望ましいだろう。

}
