var owner = require("./owner");
var pet = require("./pet");

var philip = {
    firstName: "Philip",
    lastName: "Dumaresq",
    emailAddress: "1523066@cegep-heritage.qc.ca",
    phoneNumber: "6134474889",
}

var me = owner.create(philip);

console.log(me.getFirstName());
me.setFirstName("Oliver");
console.log(me.getFirstName());

console.log("");
console.log(me.getLastName());
me.setLastName("Grant");
console.log(me.getLastName());

console.log("");
console.log(me.getEmailAddress());
me.setEmailAddress("phdumaresq@gmail.com");
console.log(me.getEmailAddress());

console.log("");
console.log(me.getPhoneNumber());
me.setPhoneNumber("6132773045");
console.log(me.getPhoneNumber());

var fluff = {
    name: "fluff",
    size: "medium",
    breed: "dog",
    gender: "female",
}

var dog = pet.create(fluff);

console.log("");
console.log(dog.getName());
dog.setName("freckle");
console.log(dog.getName());

console.log("");
console.log(dog.getSize());
dog.setSize("small");
console.log(dog.getSize());

console.log("");
console.log(dog.getBreed());
dog.setBreed("Dog");
console.log(dog.getBreed());

console.log("");
console.log(dog.getGender());
dog.setGender("Male");
console.log(dog.getGender());