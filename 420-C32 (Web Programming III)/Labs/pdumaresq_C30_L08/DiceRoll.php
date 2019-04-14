<!Doctype HTML>
<html>
<head>
    <title>Dice Roll</title>
</head>

<body>
<?php
$numRolls = 0;
$totals = [0,0,0,0,0,0,0,0,0,0,0];
$options = [2,3,4,5,6,7,8,9,10,11,12];

while ($numRolls < 50) {
    $die1 = rand(1,6);
    $die2 = rand(1,6);

    $dieNames = ["one", "two", "three", "four", "five", "six"];

    $score = $die1 + $die2;
    echo "The total of the score was $score <br />";

    checkForDoubles($die1, $die2);
    displayScoreText($score);
    $totals[$score-1]++;
    echo "<br />";

    $numRolls++;
}

for ($q = 0 ; $q < count($totals) ; $q++) {
    echo "Number of " . $options[$q] . "s: " . $totals[$q] . "<br />";
}

function displayScoreText($score) {
    $display = "";
    switch ($score) {
        case 2: $display = "You rolled snake eyes"; break;
        case 3: $display = "You rolled a loose deuce"; break;
        case 5: $display = "You rolled a fever five!"; break;
        case 7: $display = "You rolled a natural!"; break;
        case 9: $display = "You rolled a nina!"; break;
        case 11: $display = "You rolled a yo!"; break;
        case 12: $display = "You rolled boxcars!"; break;
    }
    echo "$display<br />";
}

function checkForDoubles($d1, $d2) {
    global $dieNames;
    $display = "";
    if ($d1 == $d2) {
        $display = "The roll was double " . $dieNames[$d1-1] .  "s";
    }
    else {
        $display = "The roll was a $d1 and a $d2";
    }

    echo "$display<br />";
}
?>
</body>
</html>