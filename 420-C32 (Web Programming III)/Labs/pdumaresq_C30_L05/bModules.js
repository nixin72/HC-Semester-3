exports.areaCircle = (r) => Math.PI * r * r;
exports.areaRect = (l,w) => l * w;
exports.perimRect = (l,w) => 2*(l+w);

exports.isTriangle = function(s1,s2,s3) {
	var isValid = true;
	if (s1 < s2+s3 && s2 < s1+s3 && s3 < s1+s2) {
		
	}
	else {
		isValid = false;
	}
	return isValid;
}