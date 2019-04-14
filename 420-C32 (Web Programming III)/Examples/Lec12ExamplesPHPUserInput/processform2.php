<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Process Form</title>
</head>

<body>
<?php

if (empty($_POST["fName"]) == TRUE) {
    echo "No first name<br />";
}
else {
    echo "Your first name is" . $_POST["fName"] . "<br/>";
}

if (empty($_POST["citizen"]) == FALSE) {
    echo "You are a Canadian Citizen<br/>";
}
else {
    echo "You are not a Canadian Citizen<br />";
    echo $_POST["citizen"] . "<br/>";
}

if (empty($_POST["ageCategory"])) {
    echo "Please select an age range <br/>";
}
else {
    echo "Your age range is: " . $_POST["ageCategory"];
}

?>
</body>
</html>