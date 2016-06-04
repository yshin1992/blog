var countDown = (function() {
	var counter = 5;
	return function() {
		return --counter;
	}
}());
function onstart() {
	setInterval(function() {
		document.getElementById("seconds").innerHTML = countDown();
	}, 1000);
}
