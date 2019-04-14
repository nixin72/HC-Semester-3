<?php
/**
 * Created by PhpStorm.
 * User: Allan
 * Date: 2016-11-22
 * Time: 12:14 AM
 */

header("Content-Type: text/plain");
header("Content-Length: " . strlen(file_get_contents("data/TestText.txt")));
header("My-Header: Allan");
readfile("data/TestText.txt");