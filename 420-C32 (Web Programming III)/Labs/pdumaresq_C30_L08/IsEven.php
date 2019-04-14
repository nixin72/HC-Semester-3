<!Doctype HTML>
<html>
<head>
    <title>Is even</title>
</head>

<body>
<?php
    $arr = [4, 5, "100", "101", "third", "22nd", 22.2, 25.8, "fantastic4", 0];
    $even = 0;
    $odd = 0;
    $num = 0;
    foreach ($arr as $val) {
        $isValid = true;
        $isValid = $isValid && is_numeric($val);
        if ($isValid) {
            $isNumber="$val is a number.";
            echo "$isNumber<br />";
            $num++;

            $isValid = $isValid && (round($val) % 2 == 0);
            ($isValid) ? $eORo="Even" : $eORo="Odd";
            if ($isValid) {$even++;}
                else {$odd++;}
            echo "$val == $eORo <br /><br />";
        } else {
            $isNumber = "\"$val\" is not a number<br />";
            echo "$isNumber<br />";
        }
    }

    echo "Numbers: $num<br />";
    echo "Odd numbers: $odd<br />";
    echo "Even numbers: $even<br />";
?>
</body>
</html>
