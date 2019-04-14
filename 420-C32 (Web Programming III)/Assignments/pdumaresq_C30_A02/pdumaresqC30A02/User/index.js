var User = function() {
    this.data = {
        firstName: null,
        lastName: null,
        username: null,
        emailAddress: null,
        phoneNum: null,
    }

    /*
     * Default constructor
     */
    this.fill = function(data) {
        for (var curr in this.data) {
            if (data[curr] !== undefined) {
                this.data[curr] = data[curr];
            }
        }
    }

    /*
     * Mutator methods
     */
    this.setFirstName = function(fN) {
        this.data.firstName = fN;
    }

    this.setLastName = function(lN) {
        this.data.lastName = lN;
    }

    this.setUsername = function(uN) {
        this.data.username = uN;
    }

    this.setEmailAddress = function(eA) {
        this.data.emailAddress = eA;
    }

    this.setPhoneNumber = function(pN) {
        this.data.phoneNum = pN;
    }

    /*
     * Accessor methods
     */
    this.getFirstName = function() {
        return this.data.firstName;
    }

    this.getLastName = function() {
        return this.data.lastName;
    }

    this.getUsername = function() {
        return this.data.username;
    }

    this.getEmailAddress = function() {
        return this.data.emailAddress;
    }

    this.getPhoneNumber = function() {
        return this.data.phoneNum;
    }

    this.getAllData = function() {
        return this.data;
    }
}

exports.create = function(data) {
    var user = new User();
    user.fill(data);
    return user;
}
