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
function sumOfNumbers(int ...$ints) {
    var_dump($ints);
    return count($ints);
}
?>
<h2>Types of Variables</h2>
<pre>
<?php
$theSum = sumOfNumbers(1,2,3,4);
var_dump($theSum);
$theSum = sumOfNumbers(1,2,3,4.8,5.6,"7");
var_dump($theSum);
$theSum = sumOfNumbers(1,2,"3",6);
var_dump($theSum);
$theSum = sumOfNumbers(1,2,"dog",4,5);
var_dump($theSum);
?>
</pre>
</body>
</html>