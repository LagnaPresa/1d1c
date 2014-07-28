using Microsoft.VisualStudio.TestTools.UnitTesting;

/// <summary>
/// Java プログラマに馴染みがない「参照渡し」。
/// C#では値渡しか参照渡しかだけが異なるメソッドをオーバーロードできるという話を見て
/// ( http://blogs.wankuma.com/jeanne/archive/2007/02/27/64217.aspx )
/// 一体どういうことなのか調べてみた。（そもそもどうやってディスパッチするんだ？）
/// </summary>
[TestClass]
public class Signature
{
    private static string arg = "DUMMY";

    /// <summary>値渡しのメソッド</summary>
    private string Method(string arg)
    {
        return "Yellow mellow Hello, Hello";
    }

    /// <summary>参照渡しのメソッド</summary>
    private string Method(ref string arg)
    {
        return "I'm so happy";
    }

    [TestMethod]
    public void CallByVal()
    {
        // 普通に呼び出すと値渡しのメソッドが呼び出される。
        Assert.AreEqual(Method(arg), "Yellow mellow Hello, Hello");
    }

    [TestMethod]
    public void CallByRef()
    {
        // 参照渡しのメソッドを呼び出すには実引数に ref キーワードが必要。
        Assert.AreEqual(Method(ref arg), "I'm so happy");
    }

    // なるほど。要するに値渡しか参照渡しかというのもメソッドのシグネチャに含まれるのであった。
    // VB.NETでは ref キーワードに相当するものがない（シグネチャに値渡し・参照渡しの区別はない）ので
    // そのようなオーバーロードはできない、と。
}
