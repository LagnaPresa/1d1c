' VB.NET �Ŋ֐��I�u�W�F�N�g�������Ă݂邠�ꂱ��
' �Ƃ肠�������m���Ă���3�p�^�[�����܂Ƃ߂Ă݂܂����B

' �܂��֐���p�ӂ��܂��B
Public Class Procedures

    Shared Sub AllINeedYourLove(love As String)
        ' but I do nothing.
    End Sub

    Shared Function LoveCanSaveU() As String
        Return "�f�b�f�b�f�f�b�f�[�f�["
    End Function

End Class


' 1. Action �^���g�����ꍇ
' Action �f���Q�[�g�̈����ɁA�v���V�[�W���̃A�h���X��n���B
' �֐��� Sub �v���V�[�W���̏ꍇ�ŁA��������0��1�̏ꍇ�ɂ����g����B
' �i2.�̓��ʂȏꍇ�Ƃ�������j
Public Class ClientOfAction

    Public Sub Main()
        DoNotSoBad(New Action(Of String)(AddressOf Procedures.AllINeedYourLove))
    End Sub

    Private Sub DoNotSoBad(act As Action(Of String))
        act("Your Love")
    End Sub

End Class


' 2. �f���Q�[�g�����삷��ꍇ
' 1.�� Action ���g����ꍇ�ɓ��Ă͂܂�Ȃ��ꍇ�A�f���Q�[�g�����삷��K�v������B
' Delegate �L�[���[�h�Ő錾�ł���B�v���V�[�W���ƈ����^�A�߂�l�^�������Ă�K�v������B
' �i�����Ă�A�Ƃ͌ꕾ�����肻�������ǁj
' 1.�� Action �Ƃ����̂́A�悭�g�������ȁA����0,1�� Sub �v���V�[�W���̃f���Q�[�g�����\��
' ���C�u�������p�ӂ��Ă���Ă��邾���A�݂����ȃC���[�W���Ǝv���B
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


' 3. �����_
' �����_���͔��R�Ɗ֐����e�����Ƃ����F���ł��܂��B
' �����ł͗\�ߗp�ӂ��� Functions �ł͂Ȃ������_����
' �֐��Ƃ��̃f���Q�[�g������Ă܂��B
Public Class ClientOfLambda

    Delegate Function DoSomethingAndReturnString() As String

    Delegate Sub DoSomething(arg As String)

    Public Sub Main()
        DoNotSoBad(Sub(arg) arg.Split())
        DoNice(Function() "�|�|�b�|�b�|�|�b�|�b�|")
    End Sub

    Private Sub DoNotSoBad(act As DoSomething)
        act("Your Love")
    End Sub

    Private Sub DoNice(act As DoSomethingAndReturnString)
        Dim rhythm = act()
    End Sub

End Class

' �]�k�ł����f���Q�[�g�^�̕ϐ������Ăǂ����������K���ɂ���̂����ʂȂ�ł��傤���B
' ���[�J���ϐ��̓L�������P�[�X���Ǝv�����ǁA
' �v���V�[�W�����p�X�J���P�[�X������ act() �݂����ɂ���ƈ�a������B( Java �n�Ȃ炱��ł����񂾂���)
