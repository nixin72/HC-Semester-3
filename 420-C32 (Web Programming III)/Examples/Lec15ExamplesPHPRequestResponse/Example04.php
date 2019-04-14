<?php
/**
 * Created by PhpStorm.
 * User: amcdonald
 * Date: 11/23/2016
 * Time: 11:23 PM
 */
$myClass = file_get_contents("data/albums.json");
var_dump($myClass);
echo "<br/><br/>";

$myJson = json_decode($myClass, true);
var_dump($myJson);
echo "<br/><br/>";

foreach ($myJson["albums"]["album"] as $k => $v) {
    echo "Key is: " . $k . "<br/>";
    var_dump($v);
    echo "<br/><br/>";
    foreach ($v as $k1 => $v1) {
        echo "Key/Value Pair: " . $k1 . " => " . $v1 . "<br/>";
    }
    echo "<br/><br/>";
}
