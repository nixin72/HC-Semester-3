<!doctype html>
<html>
<head>
    <title>Bugs</title>
</head>
<body>
<?php
    if (!isset($_POST['fileName'])) {
        echo "!isset<br />";
        $_POST['fileName'] = file_get_contents("currentBugNumber.txt");
    }
    else
        echo "isset<br />";

    if (isset($_POST['submit'])) {
        $curFileName = file_get_contents("currentBugNumber.txt");

        if ($curFileName == $_POST['fileName']) {
            $curFileName++;
            file_put_contents("currentBugNumber.txt", $curFileName);
            $_POST['fileName'] = $curFileName;
        }

        foreach ($_POST as $err)
            if ($err != "Report Bug" && $err != "Save Changes")
                file_put_contents("bugData/".$_POST['fileName'].".txt", $err."\r\n", FILE_APPEND);
    }

    if (isset($_POST['cancel'])) {
        $_POST = array();
        $_POST['fileName'] = file_get_contents("currentBugNumber.txt");
    }

    $values = ["","","","",""];
    if (isset($_POST['changeFile'])) {
        $file = $_POST['file'];
        $cont = file("bugData/".$file);
        for ($q = 0 ; $q < count($cont) ; $q++)
            $values[$q] = $cont[$q];

        $_POST['fileName'] = substr($file,0,2);
    }
    var_dump($_POST);
?>
    <h2>Submit A new Bug</h2>
    <form method="POST" action="cBugs.php">
        <input type="text" name="prodName" placeholder="Product Name" value="<?php echo $values[0] ?>"/><br />
        <input type="text" name="version" placeholder="Version" value="<?php echo $values[1] ?>" /><br />
        <input type="text" name="hardware" placeholder="Hardware" value="<?php echo $values[2] ?>"/><br />
        <input type="text" name="OS" placeholder="Operating System" value="<?php echo $values[3] ?>"/><br />
        <input type="text" name="desc" placeholder="Description" value="<?php echo $values[4] ?>"/><br />
        <br />
        <input type="hidden" name="fileName"
        value="<?php
            if (count($_POST) == 3) {
                echo $_POST['fileName'];
            }
        ?>" />
        <input type="submit" name="submit"
        value="<?php
            if (count($_POST) == 3)
                echo "Save Changes";
            else
                echo "Report Bug";
        ?>" />
        <input type="submit" name="cancel" value="cancel" />
    </form>

    <form method="POST" action="cBugs.php">
        <h3>Chose file to edit</h3>
        <select title="" name="file">
            <option value="" disabled selected>Files</option>
            <?php
            $dir = opendir("bugData");
            while ($CurFile = readdir($dir))
                if (substr($CurFile, 0, 1) != ".")
                    echo "<option>$CurFile</option>";

            closedir($dir);
            ?>
        </select>
        <input type="hidden" name="fileName" value="<?php echo $_POST['fileName'] ?>" />
        <input type="submit" name="changeFile" value="Select File" />
    </form>
</body>
</html>