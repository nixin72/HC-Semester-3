module.exports = function (info) {

	var values = {
		number: null,
		origin: null,
		destination: null,
		departs: null,
		arrives: null,
		actualDepart: null,
		actualArrive: null
	};

	for(var prop in values) {
		if(info[prop] !== undefined) {
			values[prop] = info[prop];
		}
	}

	var functions = {
		triggerDepart: function () {
			values.actualDepart = Date.now().toString();
		},
		triggerArrive: function () {
			values.actualArrive = Date.now().toString();
		},
		getInformation: function () {
			return values;
		}
	};

	return functions;

};