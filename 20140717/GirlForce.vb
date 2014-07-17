Public Class GirlForce

	Public Function SubSweetsList(menu As List(Of Food)) As List(Of Food)
		Return From f In menu Where f.IsSweet And f.IsCute
	End Function

	'Java という井戸で暮らしていると世界が眩しく見える

End Class
