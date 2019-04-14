var count = 0, 
	destinations = [];

var Flight = function () {
	this.data = {
		number: null,
		origin: null,
		destination: null,
		departs: null,
		arrives: null,
		actualDepart: null,
		actualArrive: null
	};

	this.fill = function (info) {
		var defaults = ["unknown","unknown","unknown","unknown","unknown","unknown","unknown"];
		var index = 0;
		for(var prop in this.data) {
			if(info[prop] !== undefined)
				this.data[prop] = info[prop];
			else
				this.data[prop] = defaults[index];
			index++;
		}
	};
	
	this.triggerDepart = function () {
		this.data.actualDepart = new Date().toISOString().replace('T', ' ').substr(0, 19);
	};

	this.triggerArrive = function () {
		this.data.actualArrive = new Date().toISOString().replace('T', ' ').substr(0, 19);
	};

	this.getInformation = function () {
		return this.data;
	};
	
	this.setNumber = function(n) {
		this.data.number = n;
	};
	
	this.setOrigin = function(o) {
		this.data.origin = o;
	};
	
	this.setDestination = function(d) {
		this.data.destination = d;
	};
	
	this.getOrigin = function() {
		return this.data.origin;
	};
	
	this.getDestination = function() {
		return this.data.destination;
	};
};

function formatDate(d) {
     return d.format("%Y-%m-%d %H:%M:%S");	
}

exports.create = function (info) {
	var instance = new Flight();

	instance.fill(info);

	count++;
	if (destinations.indexOf(info['destination']) < 0) {
		destinations.push(info['destination']);
	}

	return instance;
};

exports.getCount = function () {
	return count;
};

exports.getDestinations = function () {
	return destinations;
}