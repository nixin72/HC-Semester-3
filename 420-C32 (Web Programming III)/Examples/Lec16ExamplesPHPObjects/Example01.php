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
require("Person.php");

$person1 = new Person();
$person1->setFirstName("Allan");
$person1->setLastName("McDonald");

var_dump($person1);

//echo "<br/>Access as associative array " . $person1["firstName"];

//echo "<p>The person is " . $person1->getFirstName() . $person1->getLastName() . "</p>";
//echo "<p>Or in one call: " . $person1->getFullName() . "</p>";
//
//echo "<p>Person1 is instatiated from " . get_class($person1) . "</p>";

?>
</body>
</html>

