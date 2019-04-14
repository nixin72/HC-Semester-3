<!Doctype html>
<html>
<head>
    <title>Palindrome test</title>
    <style> .error { border: solid thin red } </style>
</head>
<body>
<?php
$displayForm = true;
$values = ["fName"=>"", "lName"=>"", "sales"=>""];
$errors = ["fName"=>"", "lName"=>"", "sales"=>""];

if (isset($_POST["sub"])) {
    $displayForm = $displayForm && validate($_POST["fname"], '/\w{2,20}/', "fName", "There's an error in the first name");
    $displayForm = $displayForm && validate($_POST["lname"], '/\w{2,20}/', "lName", "There's an error in the last name");
    $displayForm = $displayForm && validate($_POST["tsale"], '/[1-9]{1}|[0-9]{1,}/', "sales", "There's an error in the total sales");
}

function validate($val, $regex, $errKey, $errVal) {
    global $errors;
    if (!preg_match($regex, $val))
        $errors[$errKey] = $errVal;

    $values[$errKey] = $val;
    return preg_match($regex, $val);
}

if ($displayForm) {
    ?>
    <form method="POST">
        <?php echo $errors['fName'] . "<br />"; ?>
        <label>First Name: </label>
        <input type="text" name="fname" class="<?php if ($errors["fName"] != "") {echo "error";} ?>" value="<?php echo $values['fName']; ?>"/><br/>

        <?php echo $errors['lName'] . "<br />"; ?>
        <label>Last Name: </label>
        <input type="text" name="lname" class="<?php if ($errors["lName"] != "") {echo "error";} ?>" value="<?php echo $values['lName']; ?>"/><br/>

        <?php echo $errors['sales'] . "<br />"; ?>
        <label>Total Sales: </label>
        <input type="text" name="tsale" class="<?php if ($errors["sales"] != "") {echo "error";} ?>" value="<?php echo $values['sales']; ?>"/><br/><br/>

        <input type="submit" value="Submit" name="sub"/>
    </form><?php
}
else {
    $total = $_POST['tsale'];
    switch (true) {
        case $total < 200: echo $total * 1;
            break;
        case $total >= 200 && $total <= 499: echo $total * 1.2;
            break;
        case $total >= 500 && $total <= 749: echo $total * 1.3;
            break;
        case $total >= 750 && $total <= 999: echo $total * 1.5;
            break;
        case $total >= 1000 && $total <= 1499: echo $total * 1.7;
            break;
        case $total <= 1500: echo $total * 1.11;
            break;
    }
}
?>
</body>
</html>