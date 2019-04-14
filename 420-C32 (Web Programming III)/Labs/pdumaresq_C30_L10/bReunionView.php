<!doctype html>
<html>
<head>
    <title>View Reunion</title>
</head>

<body>
<?php
    $dir = opendir("reunionImages");
    while ($CurFile = readdir($dir)) {
        if (substr($CurFile, 0,1) != ".") {
            if (substr($CurFile, -4) != ".txt") {
                echo "<br /><img src=\"reunionImages/$CurFile\" />";
            }
            else {
                $cont = file_get_contents("reunionImages/".$CurFile);
                $name = substr($cont, 0, strpos($cont, "~"));
                echo "<br />".$name;
                $desc = substr($cont, strpos($cont,"~")+1);
                echo "<br />".$desc;
            }
        }

    }
    closedir($dir);
?>
<br />
<br />
<a href="bReunion.php">Add People</a>
</body>
</html>