function LegalFunctionCall() {

	assert('As Function', func() === window);

	assert('As Method', receiver.func() === receiver);

	assert('As Constructor', new func() instanceof func);

	assert('As Delegate', func.call({name:'Miku'}).name === 'Miku');
	
}

function func() {
	return this;
}

var receiver = { func: function() { return this; } }

function assert(name, maybe, onError) {
	$('h1').after('<p>' + name + ' : ' + ((maybe === true) ? 'OK!' : 'NG') + '</p>');
}


