var cycle = [];
var index = 0;
var added = [];

updateChildren();
$("#search").on("change", function () {
    var list = $("#search").val();
    if (list == "Good") {
        $("#content").css("border-color", "green");
    }
    if (list == "Bad") {
        $("#content").css("border-color", "red");
    }
    if (list == "Limbo") {
        $("#content").css("border-color", "yellow");
    }
    if (list == "Unknown") {
        $("#content").css("border-color", "black");
    }

    updateChildren();
});

function updateChildren() {
    var list = $("#search").val();
    $.get("/", {"file": "getListInfo.php", "which": list}, function (data) {
        displayChildren(data);
    });
    setTimeout(updateChildren, 5000);
}

function displayChildren(data) {
    data = JSON.parse(data);
    var people = "";
    for (var q = 0; q < data['Person'].length; q++) {
        people += "<div id='" + data['Person'][q]['-id'] + "' class='child'>";
        for (var attr in data['Person'][q]) {
            people += attr + ": " + data['Person'][q][attr] + "<br />";
        }
        people += "</div><br />";
    }

    $("#results").html(people);
    $(".child").on("click", function () {
        if (window.innerWidth > 768) {
            $("#results").css("width", "50%");
            $("#output").css("display", "flex");
        }

        var id = $(this).attr('id');
        $.get("/", {"file": "getDetailInfo.php", "id": id}, function (data) {
            showSpecificChild(data);
        });
    });

    for (var k in cycle) {
        showSpecificChild(cycle[k]);
    }
}

function showSpecificChild(data) {
    if (typeof data == "string") {
        data = JSON.parse(data);
    }

    if (!added.includes(data['Person'][0]['-id'])) {
        cycle.push(data);
        added.push(data['Person'][0]['-id']);
    }

    if (window.innerWidth > 768) {
        $("#specific").css("display", "inline");
        $("#progress").text(index + 1 + " / " + cycle.length);

        if (cycle.length == 0) {
            getChild(0);
        }
        else
            getChild(cycle.length - 1);
    }
    else {
        var id = data['Person'][0]['-id'];
        if ($.inArray(data, cycle)) {
            var foundIndex = cycle.indexOf(data);
            cycle.splice(foundIndex, 1);
            added.splice(foundIndex, 1);

            var list = $("#search").val();
            $.get("/", {"file": "getListInfo.php", "which": list}, function (data) {
                displayChildren(data);
            });
        }
        else {
            var info = "";
            for (var attr in data['Person'][0]) {
                info += "<strong>" + attr + ":</strong> " + data['Person'][0][attr] + "<br />";
            }
            $("#" + id).html("<p>" + info + "</p>");
            $("#all").on("click", updateChildren);
        }
    }
}

$("#back").on("click", function () {
    if (index > 0) {
        index--;
    }
    $("#progress").text(index + 1 + " / " + cycle.length);
    getChild(index);
});

$("#forward").on("click", function () {
    if (index < cycle.length - 1) {
        index++;
    }
    $("#progress").text(index + 1 + " / " + cycle.length);
    getChild(index);
});

$("#clear").on("click", function () {
    $("#results").css("width", "95%");
    $("#output").css("display", "inline");
    cycle = [];
    index = 0;
    added = [];
    $("#specific").css("display", "none");
});

function getChild(index) {
    var info = "";
    for (var person in cycle[index]['Person'][0]) {
        info += "<strong>" + person + ":</strong> " + cycle[index]['Person'][0][person] + "<br />";
    }
    $("#display").html("<p>" + info + "</p>");
    $("#all").on("click", updateChildren);
}