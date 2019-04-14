<!doctype html>
<html>
<head>
    <title>manage list</title>
    <link rel="stylesheet" type="text/css" href="styles/styles.css" />
</head>
<body>
<canvas id="canvas"></canvas>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="javascript/snowAnimation.js"></script>

<div id="content">
<h1>Add new Child</h1>
<?php
    include "functions.php";
    $_POST = array();
    parse_str(file_get_contents('php://input'), $_POST);

    $validForm = true;
    $errMsg = "";
    if (isset($_POST['submit'])) {
        validate('lastName', "/^[A-Z\\'\\h,-]+$/i", $validForm, "Please enter a valid first name<br />", $errMsg);
        validate('firstName', "/^[A-Z\\'\\h,-]+$/i", $validForm, "Please enter a valid last name<br />", $errMsg);
        validate('age', "/^(?=.*[1-9]).{1}[0-9]{0,1}$/i", $validForm, "Please enter a valid age<br />", $errMsg);
    }

    $matches = [];
    if (isset($_POST['search'])) {
        $json = json_decode(file_get_contents("list/SantaList.json"), true);

		foreach ($json['Person'] as $per)
            if (($per['-id']) == $_POST['childList'])
                array_push($matches, $per);
        $validForm = false;
    }

    if (!$validForm || count($_POST) === 0) {
        if ($errMsg != "") {
            echo "<div id='errors' >" . $errMsg . "</div>";
        }

        if (isset($matches))
            addForm($matches);
        else
            addForm(null);
    }
    else {
		$number = file_get_contents("childNumber.txt");
		unset($_POST['submit']);
		if ($_POST['-id'] != $number) {
			$json = json_decode(file_get_contents("list/SantaList.json"), true);
			
			foreach ($json['Person'] as $key=>$per) 
				if ($per['-id'] == $_POST['-id']) 
					$json['Person'][$key] = $_POST;
				
			file_put_contents("list/SantaList.json", json_encode($json, JSON_PRETTY_PRINT));
		} else {
			$number++;
			file_put_contents("childNumber.txt", $number);
			
			$values = $_POST;
			$json = json_decode(file_get_contents("list/SantaList.json"), true);
			array_push($json['Person'], $values);
			
			file_put_contents("list/SantaList.json", json_encode($json, JSON_PRETTY_PRINT));
		}
        $_POST = array();

        addForm(null);
    }
?>
</div>
	<footer>
		<p>Copyright &copy; 2016 phdumaresq@gmail.com</p>
	</footer>
</body>
</html>