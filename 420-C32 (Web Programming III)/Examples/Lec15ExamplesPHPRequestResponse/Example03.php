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

$myJson = json_decode($myClass);
var_dump($myJson);
echo "<br/><br/>";

foreach ($myJson as $k => $v) {
    echo "Key is: " . $k . "<br/>";
    var_dump($v);
    echo "<br/><br/>";
    if (is_object($v)) {
        foreach ($v as $k1 => $v1) {
            echo "Key is: " . $k1 . "<br/>";
            var_dump($v1);
            echo "<br/><br/>";
            echo $v1[0]->albumName;
        }
    }
}
