
// 2要素のカッコの値のみ抽出して配列にして返す
function explore(src) {
	var result = [];
	src.replace(/\([^(),]+?,[^(),]+?\)/g, function(_) {
		result.push(_);
	});
	return result.join("");
}

// String.replace が強力すぎて置換に使うだけでは勿体無い
