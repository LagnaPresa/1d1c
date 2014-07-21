' VB.NET で関数オブジェクトを扱ってみるあれこれ
' とりあえず今知っている3パターンをまとめてみました。

' まず関数を用意します。
Public Class Procedures

    Shared Sub AllINeedYourLove(love As String)
        ' but I do nothing.
    End Sub

    Shared Function LoveCanSaveU() As String
        Return "デッデッデデッデーデー"
    End Function

End Class


' 1. Action 型を使った場合
' Action デリゲートの引数に、プロシージャのアドレスを渡す。
' 関数が Sub プロシージャの場合で、かつ引数が0個か1個の場合にだけ使える。
' （2.の特別な場合とも言える）
Public Class ClientOfAction

    Public Sub Main()
        DoNotSoBad(New Action(Of String)(AddressOf Procedures.AllINeedYourLove))
    End Sub

    Private Sub DoNotSoBad(act As Action(Of String))
        act("Your Love")
    End Sub

End Class


' 2. デリゲートを自作する場合
' 1.の Action が使える場合に当てはまらない場合、デリゲートを自作する必要がある。
' Delegate キーワードで宣言できる。プロシージャと引数型、戻り値型が合ってる必要がある。
' （合ってる、とは語弊がありそうだけど）
' 1.の Action というのは、よく使いそうな、引数0,1個の Sub プロシージャのデリゲートだけ予め
' ライブラリが用意してくれているだけ、みたいなイメージだと思う。
Public Class ClientOfDelegate

    Delegate Function DoSomethingAndReturnString() As String

    Delegate Sub DoSomething(arg As String)

    Public Sub Main()
        DoNotSoBad(New DoSomething(AddressOf Procedures.AllINeedYourLove))
        DoNice(New DoSomethingAndReturnString(AddressOf Procedures.LoveCanSaveU))
    End Sub

    Private Sub DoNotSoBad(act As DoSomething)
        act("Your Love")
    End Sub

    Private Sub DoNice(act As DoSomethingAndReturnString)
        Dim rhythm = act()
    End Sub

End Class


' 3. ラムダ
' ラムダ式は漠然と関数リテラルという認識でいます。
' ここでは予め用意した Functions ではなくラムダ式で
' 関数とそのデリゲートを作ってます。
Public Class ClientOfLambda

    Delegate Function DoSomethingAndReturnString() As String

    Delegate Sub DoSomething(arg As String)

    Public Sub Main()
        DoNotSoBad(Sub(arg) arg.Split())
        DoNice(Function() "ポポッポッポポッポッポ")
    End Sub

    Private Sub DoNotSoBad(act As DoSomething)
        act("Your Love")
    End Sub

    Private Sub DoNice(act As DoSomethingAndReturnString)
        Dim rhythm = act()
    End Sub

End Class

' 余談ですがデリゲート型の変数名ってどういう命名規則にするのが普通なんでしょうか。
' ローカル変数はキャメルケースだと思うけど、
' プロシージャがパスカルケースだから act() みたいにすると違和感ある。( Java 系ならこれでいいんだけど)
