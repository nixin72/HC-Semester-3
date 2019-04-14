<!Doctype html>
<html>
<head>
    <title>Password test</title>
</head>
<body>
<?php
    $passwords = ["Abcdefg!", "ABCDEF9!", "abcdef9!", "Abcd e9!", "Abcdefg9"
                , "Abcdefgh98765432!", "Abcde9!", "Abcdef9!", "Abcdefg9876543!!", "!9fedcbA"];

    foreach ($passwords as $pass) {
        echo $pass . "<br />";
        $test = validPassword($pass);
        echo $test . "<br />";
    }

    function validPassword(string $pass) {
        $errMsg = "";

        $errMsg .= preg_match('/[0-9]+/', $pass) == 0 ? " Password must contain a number.<br />" : "";
        $errMsg .= preg_match('/[a-z]+/', $pass) == 0 ? " Password must contain lowercase letter.<br />" : "";
        $errMsg .= preg_match('/[A-Z]+/', $pass) == 0 ? " Password must contain uppercase letter.<br />" : "";
        $errMsg .= preg_match('/[#?!@$%^&*-]+/', $pass) == 0 ? " Password must contain a special character<br />" : "";
        $errMsg .= (!(strlen($pass) <= 16 && strlen($pass) >= 8)) ? " Password must be between 8 and 16 characters.<br />" : "";
        $errMsg .= preg_match('/[\s]+/', $pass) != 0 ? " Password must not contain any whitespaces.<br />" : "";
        $errMsg .= $errMsg === "" ? "The password is valid<br />" : "";
        
        return $errMsg;
    }

?>
</body>
</html>