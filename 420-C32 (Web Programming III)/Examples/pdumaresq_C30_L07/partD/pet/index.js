var Pet = function (){
    this.data = {
        name: null,
        size: null,
        breed: null,
        gender: null
    };

    this.fill = function (info) {
        for(var curr in this.data) {
            if(info[curr] !== undefined) {
                this.data[curr] = info[curr];
            }
        }
    };

    this.setName = function(name) {
        this.data.name = name;
    }

    this.setSize = function(size) {
        this.data.size = size;
    }

    this.setBreed = function (breed) {
        this.data.breed = breed;
    }

    this.setGender = function (gender) {
        this.data.gender = gender;
    }

    this.getName = function() {
        return this.data.name;
    }

    this.getSize = function() {
        return this.data.size;
    }

    this.getBreed = function() {
        return this.data.breed;
    }

    this.getGender = function() {
        return this.data.gender;
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

function getPet() {
    return Pet;
}

exports.create = function (info) {
    var instance = new Pet();

    instance.fill(info);

    return instance;
};

