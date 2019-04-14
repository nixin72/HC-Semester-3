<?php
function evenlyDivided(int $Number, int $Divisor): bool {
    if ($Divisor != 0) {
        if ($Number % $Divisor == 0) {
            return true;
        }
        else {
            return false;
        }
    }
    else {
        echo "Can't divide by 0.";
        return false;
    }
}

function checkRange($upperBound, $lowerBound, $divisor) {
    echo "<br />upper: $upperBound <br />lower: $lowerBound <br />divisor: $divisor<br />";
    $arr=[];
    $curr = $lowerBound;
    while ($curr < $upperBound) {
        //echo "<br />$curr";

        if (evenlyDivided($curr, $divisor)) {
//            echo "<br />" . $curr . $curr/$divisor;
            array_push($arr, $curr);
        }
        $curr++;
    }
    return $arr;
}