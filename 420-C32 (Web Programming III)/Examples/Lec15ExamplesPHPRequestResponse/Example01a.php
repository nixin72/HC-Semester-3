<?php
/**
 * Created by PhpStorm.
 * User: Allan
 * Date: 2016-11-22
 * Time: 1:14 AM
 */
$whichFile = $_GET["file"];
header("Content-Type: text/xml");
$whichFile = "data/" . $whichFile;
header("Content-Length: " . strlen(file_get_contents($whichFile)));
header("My-Header: Allan");
readfile($whichFile);