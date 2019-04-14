<!Doctype HTML>
<html>
<head>
    <title>Part B1</title>
</head>
<body>
    <?php
        include 'myFunctions.php';
        echo evenlyDivided(13,3) . "<br />";
        echo evenlyDivided(12,3) . "<br />";
        echo evenlyDivided("12",3) . "<br />";
        echo evenlyDivided(12,"3") . "<br />";
        echo evenlyDivided("cat","dog") . "<br />";
        echo evenlyDivided(12,0) . "<br />";
    ?>
</body>
</html>