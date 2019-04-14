<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Process Form</title>
</head>

<body>
<?php
$firstName = $_POST["fName"];
$lastName = $_POST["lName"];
$email = $_POST["emailAddr"];
echo "<p>Thank you for registering, $firstName $lastName. Your email address is $email.</p>";

?>
</body>
</html>