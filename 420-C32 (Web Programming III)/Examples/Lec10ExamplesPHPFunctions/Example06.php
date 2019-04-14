<?php
//declare(strict_types=1);
?>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Function Example</title>
</head>

<body>
<?php
function sumOfNumbers(int $num1, int $num2, int $num3) :int {
//function sumOfNumbers(int $num1, int $num2, int $num3) {
    $sumOfNumbers = $num1 + $num2 + $num3;
    return "Hello Amir";
}
?>
<h2>Types of Variables</h2>
<?php
$a = 2;
$b = 5;
$c = 8;
?>
<p>Before the call the numbers are: <br />
<pre>
    <?php
    var_dump($a);
    var_dump($b);
    var_dump($c);
    ?>
</pre>
<p>After the call the sum is:
    <?php
    $returnValue = sumOfNumbers($a, $b, $c);
    echo "$returnValue </p>";
    ?>
<p>And the numbers are:<br/>
<pre>
    <?php
    var_dump($a);
    var_dump($b);
    var_dump($c);
    ?>
</pre>
    <?php
    $a = "2";
    $b = "5";
    $c = "8";
    ?>
<p>Second call the numbers are: </p>
<pre>
    <?php
    var_dump($a);
    var_dump($b);
    var_dump($c);
    ?>
</pre>
<p>After the second call the sum is:
    <?php
    $returnValue = sumOfNumbers($a, $b, $c);
    echo "$returnValue </p>";
    ?>
<p>And the numbers are:<br/>
<pre>
    <?php
    var_dump($a);
    var_dump($b);
    var_dump($c);
    ?>
</pre>
<?php
$a = "cat";
$b = "dog";
$c = "cow";
?>
<p>Third call the numbers are: </p>
<pre>
    <?php
    var_dump($a);
    var_dump($b);
    var_dump($c);
    ?>
</pre>
<p>After the third call the sum is:
    <?php
    $returnValue = sumOfNumbers($a, $b, $c);
    echo "$returnValue </p>";
    ?>
<p>And the numbers are:<br/>
<pre>
    <?php
    var_dump($a);
    var_dump($b);
    var_dump($c);
    ?>
</pre>

</body>
</html>