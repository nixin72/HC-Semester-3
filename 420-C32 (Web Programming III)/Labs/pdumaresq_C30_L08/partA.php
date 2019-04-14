<!Doctype HTML>
<html>
<head>
    <title>Part A</title>
</head>

<body>
<?php
    $ReturnValue = 2 == 3;
        if (!$ReturnValue) { echo "2 == 3 -----> false<br />" ; }
            else { echo "2 == 3 -----> false" . $ReturnValue ; }
    $ReturnValue = "2" + "3";
        echo "\"2\" + \"3\" -----> $ReturnValue <br />";
    $ReturnValue = 2 >= 3;
        if (!$ReturnValue) { echo "2 >= 3 -----> false<br />" ; }
            else { echo "2 >= 3 -----> $ReturnValue <br />"; }
    $ReturnValue = 2 <= 3;
        if (!$ReturnValue) { echo "2 <= 3 -----> false<br />" ; }
            else { echo "2 <= 3 -----> $ReturnValue <br />"; }
    $ReturnValue = 2 + 3;
        echo "2 + 3 -----> $ReturnValue <br />";
    $ReturnValue = (3 >= 2) && (2>3);
        if (!$ReturnValue) { echo "(3 >= 2) && (2>3) -----> false<br />" ; }
            else { echo "(3 >= 2) && (2>3) -----> $ReturnValue <br />"; }
    $ReturnValue = (3 >= 2) || (2>3);
        if (!$ReturnValue) { echo "(3 >= 2) || (2>3) -----> false<br />" ; }
            else { echo "(3 >= 2) || (2>3) -----> $ReturnValue <br />"; }
?>
</body>
</html>