<?php
$id=$_GET["id"];
$json = json_decode(file_get_contents("list/SantaList.json"), true);
$returnObj = $json;
$returnObj['Person'] = array();

foreach($json['Person'] as $child) 
	if ($child['-id'] == $id) 
		array_push($returnObj['Person'], $child);
	
header("Content-Type: application/json");
header("Cache-Control: no-cache");
header("Content-Length: " . strlen(json_encode($returnObj)));
header("Child-Returned: " . $id);
echo json_encode($returnObj);