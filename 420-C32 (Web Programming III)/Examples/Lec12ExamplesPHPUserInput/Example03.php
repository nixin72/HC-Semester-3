<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>All In One</title>
</head>

<body>
<?php
$DisplayForm = TRUE;
$Number = "";
if (isset($_POST["b3"])) {
    $Number = $_POST["num"];
    if (is_numeric($Number)) {
        $DisplayForm = FALSE;
    } else {
        echo "<p>Number needed</p>";
        $DisplayForm = TRUE;
    }
}
if ($DisplayForm) {
    ?>
    <form id="myThird" name="myThird" method="post" action="Example03.php">
        <p>
            <label for="num">Enter a Number: </label>
            <input type="text" name="num" id="num" value="<?php echo $Number; ?>" />
        </p>
        <p>
            <input type="submit" name="b3" id="b3" value="Submit" />
            <br />
        </p>
    </form>
    <?php
}
else {
    echo "<p>Thank you for entering a number.</p>";
    echo "<p>Your number, $Number, squared is " . ($Number*$Number) . ".</p>";
    echo "<p>Your number, $Number, cubed is " . ($Number*$Number*$Number) . ".</p>";
    echo "<p><a href=\"Example03.php\">Try again?</a></p>";
}
?>
</body>
</html>