<?php
function validValue($key, &$errors, $regex, &$value, $errMsg, &$validForm):bool {
    $value[$key] = $_POST[$key];
    $valid = preg_match($regex[$key], $value[$key]);
    $validForm = $validForm && $valid;
    $errors[$key] = $valid ? "" : $errMsg;

    return $valid;
}

function checkPasswordError(&$errors, &$value) {
    $errors['pass'] = !preg_match('/[0-9]/', $value['pass']) ? "Password must have a number." : $errors['pass'];
    $errors['pass'] = !preg_match('/[a-z]/', $value['pass']) ? "Password must have a lowercase letter." : $errors['pass'];
    $errors['pass'] = !preg_match('/[A-Z]/', $value['pass']) ? "Password must have an uppercase letter." : $errors['pass'];
    $errors['pass'] = !preg_match('/[!#$%&\'*+-\/=?^_`{|}~]/', $value['pass']) ? "Password must have a special character." : $errors['pass'];
    $errors['pass'] = !(strlen($value['pass']) >= 8) ? "Password must be more than 8 characters." : $errors['pass'];
    $errors['pass'] = !(strlen($value['pass']) <= 16) ? "Password must be less than 16 characters." : $errors['pass'];
}

function writeToFile(&$values) {
    $write = "";
    $write .= $values['email'] . "~" . $values['pass'] . "~" . $values['fName'] . "~";
    $write .= $values['lName'] . "~" . $values['address'] . "~" . $values['city'] . "~";
    $write .= $values['province'] . "~" . $values['postal'] . "~" . $values['phone'];
    $write .= "\r\n";
    file_put_contents("CustomerAccounts.txt", $write, 8);
}

function displayErrors($key, &$errors) {
    if ($errors[$key] != "") {
        echo "&nbsp;-&nbsp;<span class='err'>" . $errors[$key] . "</span><br />";
    }
}

function changeCSS($key, $errors) {
    if ($errors[$key] != "")
        echo " error";
}

function chooseProvince($key, $values, $province) {
    if ($values[$key] == $province)
        echo "selected='selected'";
}
