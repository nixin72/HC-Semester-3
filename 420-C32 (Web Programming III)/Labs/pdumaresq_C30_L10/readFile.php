<!doctype html>
<html>
<head>
    <title>Read file</title>
</head>

<body>
<?php
    $vowels = "/[aeiouy]/i";
    $consonants = "/[bcdfghjklmnpqrstvwxz]/i";
    $displayForm = true;

    if (isset($_POST['submit'])) {
        $content = file_get_contents($_FILES['file']['tmp_name']);
        $displayForm = false;
    }

    if ($displayForm) {
        ?>
        <form action="readFile.php" method="post" enctype="multipart/form-data">
            <input type="file" name="file" id="file">
            <br/>
            <input type="submit" name="submit" id="submit">
        </form>

        <?php
    }
    else {
        $displayForm = true;

        echo "File contents: $content<br /><br />";
        $vFound = [];
        $cFound = [];
        $oFound = [];

            for ($q = 0 ; $q < strlen($content) ; $q++) {
                if (preg_match($vowels, $content[$q])) {
                    array_push($vFound, $content[$q]);
                }
                else if (preg_match($consonants, $content[$q])) {
                    array_push($cFound, $content[$q]);
                }
                else {
                    array_push($oFound, $content[$q]);
                }
            }
        ?>
            <table border="1">
                <tr>
                    <td>Vowels</td>
                    <td>Consonants</td>
                    <td>Other</td>
                </tr>
                <tr>
                    <td>
                        <?php
                            for ($k = 0 ; $k < count($vFound) ; $k++) {
                                echo $vFound[$k];
                            }
                        ?>
                    </td>
                    <td>
                        <?php
                            for ($k = 0 ; $k < count($cFound) ; $k++) {
                                echo $cFound[$k];
                            }
                        ?>
                    </td>
                    <td>
                        <?php
                            for ($k = 0 ; $k < count($oFound) ; $k++) {
                                echo $oFound[$k];
                            }
                        ?>
                    </td>
                </tr>
                <tr>
                    <td> <?php echo count($vFound); ?> </td>
                    <td> <?php echo count($cFound); ?> </td>
                    <td> <?php echo count($oFound); ?> </td>
                </tr>
            </table>

        <br />
        <br />
        <a href="readFile.php">Back</a>
        <?php
        $_POST = array();
    }

?>


</body>
</html>