var Owner = function (){
    this.data = {
        firstName: null,
        lastName: null,
        emailAddress: null,
        phoneNumber: null,
    };

    this.fill = function (info) {
        for(var curr in this.data) {
            if(info[curr] !== undefined) {
                this.data[curr] = info[curr];
            }
        }
    };

    this.setFirstName = function(fN) {
        this.data.firstName = fN;
    }

    this.setLastName = function(lN) {
        this.data.lastName = lN;
    }

    this.setEmailAddress = function (e) {
        this.data.emailAddress = e;
    }

    this.setPhoneNumber = function (pN) {
        this.data.phoneNumber = pN;
    }

    this.getFirstName = function() {
        return this.data.firstName;
    }

    this.getLastName = function() {
        return this.data.lastName;
    }

    this.getEmailAddress = function() {
        return this.data.emailAddress;
    }

    this.getPhoneNumber = function() {
        return this.data.phoneNumber;
    }

    this.getAllData = function() {
        var data = "";
        for (var curr in this.data) {
            if (curr != undefined) {
                data += curr;
            }
        }
        return data;
    }

};

function getOwner() {
    return Owner;
}

exports.create = function (info) {
    var instance = new Owner();

    instance.fill(info);

    return instance;
};