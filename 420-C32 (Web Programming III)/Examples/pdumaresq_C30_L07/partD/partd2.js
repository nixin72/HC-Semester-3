var owner = require("./owner2");

var anBlankOwner = {
};

var me = owner.create(anBlankOwner);

console.log("");
console.log(me.getFirstName());

console.log("");
console.log(me.getLastName());

console.log("");
console.log(me.getEmailAddress());

console.log("");
console.log(me.getPhoneNumber());