var e = require('events');

var myAdd = function (num1, num2) {
    console.log(num1 + num2);
}

var mySubtract = function (num1, num2) {
    console.log(num1 - num2);
}

var myMultiply = function (num1, num2) {
    console.log(num1 * num2);
}

var myDivide = function (num1, num2) {
    console.log(num1 / num2);
}

var emitter = new e.EventEmitter();

emitter.on('myMath', function (num1, num2) {
    myAdd(num1, num2);
    mySubtract(num1, num2);
    myMultiply(num1, num2);
    myDivide(num1, num2);
});

emitter.emit('myMath', 2, 3);
