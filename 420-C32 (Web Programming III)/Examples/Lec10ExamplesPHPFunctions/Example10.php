<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Includes</title>
</head>

<body>
<?php require "./includes/myfunction.php" ?>
<h2>Including files</h2>

<?php
echo "<p>Before calling the included function.</p>";
$myVar = callIncludeFunction();
echo "<p>This is after the included function.</p>";
echo "<p>The function returned: $myVar</p>";
?>
</body>
</html>