var maths = {
    areaCircle: function(r, done){
        process.nextTick(function(){
            done(null, Math.PI*r*r);
        });
    },
	areaRect: function(l,w,done) {
		process.nextTick(function() {
			done(null, l*w);
		});
	},
	perimRect: function(l,w,done) {
		process.nextTick(function() {
			done(null, 2*(l+w));
		});
	},
	isTriangle: function(s1,s2,s3,done) {
		process.nextTick(function() {
			if (s1 < s2+s3 && s2 < s1+s3 && s3 < s1+s2) 
				{ done(null, true); }
			else 
				{ done(null, false); }
			
		});
	}
};
module.exports = maths;