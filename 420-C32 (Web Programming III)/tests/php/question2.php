<!doctype html>
<html>
<head><title>Question 2</title></head>
<body>
<?php
$_POST = array();
parse_str(file_get_contents('php://input'), $_POST);

$validPassword = true;
if (isset($_POST['submit'])) {
    $validPassword = validatePass($_POST['password']);
}

function validatePass($pass):bool {
    $val = true;
    $val = $val && preg_match("/^[A-Z]+/",$pass);
    $val = $val && preg_match("/[a-z]{2,}/", $pass);
    $val = $val && preg_match("/[0-9]+/", $pass);
    $val = $val && preg_match("/[^$*+%()]+/", $pass);
    $val = $val && !preg_match("/\\s/", $pass);
    $val = $val && (strlen($pass) >= 6 && strlen($pass) <= 12);
    return $val;
}

?>
<form method="POST" action="question1.php">
    first name<input type="text" name="firstname" /><br />
    last name<input type="text" name="lastname" /><br />
    email: <input type="text" name="email" />
    <br />
    <input type="submit" name="submit" />
</form>
<?php
?>
</body>
</html>