package net.n39i.ltx1d1c.d20140806

class RepeatedParameters {

  println(method(-2, -1, 0, 1, 2))
  // 可変長引数に配列を渡す場合、 Java のようにそのまま println(method(Array(1, 2))) とはできない
  println(method(Array(1, 2): _*))

  // ちなみに仮引数 args の型は Seq[Int] （もし Java なら Integer[] ）
  def method(args: Int*) = args.filter(_ > 0)

}
