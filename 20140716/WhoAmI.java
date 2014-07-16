package net.n39i.ltx1d1c.d140716;

// 今日はクイズをしよう。
// 以下にシンプルなプログラムがある。
// このプログラムが何を表示するか考えてみてほしい。
// true だろうか、 false だろうか。

public class WhoAmI {

	public static boolean notReflective(Object o) {
		return o != o;
	}
	
	public static void main(String[] args) {
		System.out.println(notReflective(Double.NaN));
	}

}
