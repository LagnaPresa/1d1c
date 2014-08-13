var foo = {};
var bar = {name:"Miku"};

alert(getUpperName(foo));
alert(getUpperName(bar));

function getUpperName(o) {
	// undefined.toUpperCase() はTypeErrorがスローされてしまう
	return o.name && o.name.toUpperCase();
}
