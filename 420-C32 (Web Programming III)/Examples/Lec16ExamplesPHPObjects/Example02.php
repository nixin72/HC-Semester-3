<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Objects Step 1</title>
</head>
<body>
<?php
/**
 * Created by PhpStorm.
 * User: amcdonald
 * Date: 11/23/2016
 * Time: 4:36 PM
 */
require("Books.php");

//$book1 = new Books();    //will generate an error

$book2 = new Books("Lord of the Rings", 10);
?>
<pre>
<?php
var_dump($book2);
?>
</pre>
<?php

//$book3 = new Novel("Eragon", 15, "Wessex Publishing");
//?>
<!--<pre>-->
<?php
//var_dump($book3);
//?>
<!--</pre>-->
<?php
//
//
//echo "<p>The novel's price is " . $book3->getPrice() . "</p>";
//
?>
</body>
</html>

