<!DOCTYPE html>
<html>
<head>
    <meta charset=utf-8" />
    <title>Pass By Reference Example</title>
</head>

<body>
<?php
function averageNumbers(&$num1, $num2, $num3) {
    $num1 = $num1 + 2;
    $sumOfNumbers = $num1 + $num2 + $num3;
    $average = $sumOfNumbers / 3;
    return $average;
}
?>
<h2>Number averages</h2>
<?php
$a = 2;
$b = 5;
$c = 8;
?>
<p>Before the call the numbers are: <br />
    <?php
    echo "$a <br />";
    echo "$b <br />";
    echo "$c </p>";
    ?>
<p>After the call the average is:
    <?php
    $returnValue = averageNumbers($a, $b, $c);
    echo "$returnValue </p>";
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