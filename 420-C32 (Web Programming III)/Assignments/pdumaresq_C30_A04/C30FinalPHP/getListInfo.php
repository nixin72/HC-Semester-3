<?php
$list=$_GET["which"];
$json = json_decode(file_get_contents("list/SantaList.json"), true);
$returnObj = $json;
$returnObj['Person'] = array();

foreach($json['Person'] as $child) 
	if ($child['currList'] == $list) {
		unset($child['details']);
		unset($child['age']);
		unset($child['currList']);
		array_push($returnObj['Person'], $child);
	}
	
header("Content-Type: application/json");
header("Cache-Control: no-cache");
header("Content-Length: " . strlen(json_encode($returnObj)));
header("List-Returned: " . $list);
echo json_encode($returnObj);