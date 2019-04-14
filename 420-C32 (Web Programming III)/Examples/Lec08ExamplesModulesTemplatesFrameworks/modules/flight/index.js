var number, origin, destination;

exports.setNumber = (num) => {number = num;};

exports.setOrigin = (o) =>	{origin = o;};

exports.setDestination = (d) => {destination = d;};

exports.getInfo = () => {
	return {
		number: number,
		origin: origin,
		destination: destination
	};
};