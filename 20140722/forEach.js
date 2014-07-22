// Array.prototype.forEach
function forEach() {
	var sum = 0;
	[1, 2, 3].forEach(function(e) {
		sum += e;
	});
	assert('forEach is so good!', sum === 6);
}

function forEachForArguments() {
	assert('arguments has no forEach', arguments.forEach === undefined);
	// but...

	var juice = (function() {
		var result = '';
		[].forEach.call(arguments, function(e) {
			result += (e + e);
		});
		return result;
	})('Apple', 'Banana', 'Cherry');

	assert('arguments can use forEach!', juice === 'AppleAppleBananaBananaCherryCherry')
}

function assert(name, maybe, onError) {
	$('h1').after('<p>' + name + ' : ' + ((maybe === true) ? 'OK!' : 'NG') + '</p>');
}


