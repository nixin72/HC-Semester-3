<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Function Example</title>
</head>

<body>
<?php
function averageNumbers($num1, $num2, $num3) {
    $sumOfNumbers = $num1 + $num2 + $num3;
    $num1 = $num1 + 2;
    echo "In function num1 is: $num1<br/>";
    global $num1;
    $num1 *= 2;
    $sumOfNumbers = $num1 + $num2 + $num3;
    $average = $sumOfNumbers / 3;
    return $average;
}

$a = 2;
$b = 5;
$c = 8;
$num1 = 200;
?>
<h2>Number averages</h2>
<p>Before the call the numbers are: <br />
    <?php
    echo "$a <br />";
    echo "$b <br />";
    echo "$c <br />";
    echo "Num is: $num1</p>";
    ?>
    <?php
    $returnValue = averageNumbers($a, $b, $c);
    echo "<p>After the call the average is: $returnValue </p>";
    echo "Num is: $num1";
    ?>
<p>And the numbers are:<br/>
    <?php
    echo "$a <br />";
    echo "$b <br />";
    echo "$c </p>";
    ?>
<p>
</body>
</html>