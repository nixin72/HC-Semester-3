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
function medecineGoDown(string $person="Mary", string $meds="rum punch") {
    return "For $person a spoonful of $meds";
}
?>
<h2>Default Parameters</h2>
<pre>
<?php
$theResult = medecineGoDown("Jane", "lime cordial");
var_dump($theResult);
$theResult = medecineGoDown("Allan", "scotch");
var_dump($theResult);
$theResult = medecineGoDown("Robertson Ay");
var_dump($theResult);
$theResult = medecineGoDown();
var_dump($theResult);
$theResult = medecineGoDown("","Oxy");
var_dump($theResult);
?>
</pre>
</body>
</html>