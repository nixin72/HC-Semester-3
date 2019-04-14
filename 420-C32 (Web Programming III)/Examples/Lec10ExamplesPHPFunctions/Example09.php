<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>foreach Statement</title>
</head>

<body>
<?php

$DaysOfWeek = array("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
foreach ($DaysOfWeek as $Day) {
    echo "<p>$Day</p>";
}

?>

<?php

$DaysofWeek = array("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
foreach ($DaysofWeek as $DayNumber => $Day) {
    echo "<p>Day $DayNumber is $Day</p>";
}

?>
</body>
</html>