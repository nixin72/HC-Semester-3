<?php
$myClass = simplexml_load_file("data/albums.xml");
print_r($myClass);

foreach ($myClass->children() as $records) {
    echo $records->attributes() . " <==for attributes<br/>";
    echo "<pre>";
    echo $records->asXML() . " <==for items<br/>";
    echo "</pre>";
}
echo "<br/>";
foreach ($myClass->children() as $keys => $values) {
    echo "$keys is $values<br/>";
}

echo "<br/>";
foreach ($myClass->children() as $eachRec) {
//    echo "new album" . $eachRec->albumName . "<br/>";
    foreach ($eachRec->children() as $keys => $values) {
        echo "$keys is $values<br/>";
    }
}