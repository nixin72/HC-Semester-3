<!Doctype HTML>
<html>
<head>
    <title>Part B2</title>
</head>
<body>
<?php
    include 'myFunctions.php';

    echo "<br />";
    $arr = checkRange(10, 3, 2);
    foreach ($arr as $num) {
        echo $num .", ";
    }

    echo "<br />";
    $arr = checkRange(100, 1, 7);
    foreach ($arr as $num) {
        echo $num .", ";
    }

    echo "<br />";
    $arr = checkRange(5, 1, 1);
    foreach ($arr as $num) {
        echo $num .", ";
    }

    echo "<br />";
    $arr = checkRange("cat", "dog", "horse");
    foreach ($arr as $num) {
        echo $num .", ";
    }

?>
</body>
</html>