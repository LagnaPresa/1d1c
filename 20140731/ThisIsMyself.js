function ThisIsMyself() {

	this.myName = "Miku";

	this.anotherName = (function() {
		return this.myName;
	})();

}

var self = new ThisIsMyself();
alert(self.myName === "Miku");
alert(self.anotherName === undefined);
