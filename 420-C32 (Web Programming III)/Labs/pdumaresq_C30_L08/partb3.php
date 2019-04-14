<!Doctype HTML>
<html>
<head>
    <title>Part B3</title>
</head>
<body>
<?php
    function sumProdHighLow($opp, ...$args) {
        $res = 1;
        if ($opp != "+" || $opp != "*" || $opp != ">" || $opp != "<") {
            if ($opp == "+") {
                for ($q = 0 ; $q < count($args) ; $q++) {
                    $res += $args[$q];
                }
            }
            if ($opp == "*") {
                for ($q = 0 ; $q < count($args) ; $q++) {
                    $res *= $args[$q];
                }
            }
            if ($opp == "<") {
                $res = $args[0];
                for ($q = 0 ; $q < count($args) ; $q++) {
                    if ($args[$q] < $res) {
                        $res = $args[$q];
                    }
                }
            }
            if ($opp == ">") {
                $res = $args[0];
                for ($q = 0 ; $q < count($args) ; $q++) {
                    if ($args[$q] > $res) {
                        $res = $args[$q];
                    }
                }
            }
        }
        for ($q = 0 ; $q < count($args) ; $q++) {
            echo $args[$q] . ", ";
        }
        echo "<br />Result: " . $res . "<br /><br />";
    }

    sumProdHighLow("+", 1, 2, 3, 4, 5);
    sumProdHighLow("*", 1, 2, 3, 4);
    sumProdHighLow(">", -10, 19, 23, 14, 35, 0, 10, 4);
    sumProdHighLow(">", -10, 19, 23, -14, 35, 0, 10, 4, 8, 12);

?>
</body>
</html>