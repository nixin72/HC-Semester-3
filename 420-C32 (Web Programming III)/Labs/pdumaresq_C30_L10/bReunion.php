<!doctype html>
<html>
<head>
    <title>Add Reunion</title>
</head>

<body>
<?php
    $error = true;

    if (isset($_POST['submit'])) {
        $name = $_POST['name'];
        $error = $error && !($name === "");

        $desc = $_POST['desc'];
        $error = $error && !($desc === "");

        $imgN = $_FILES['file']['name'];
        $imgS = $_FILES['file']['tmp_name'];

        if (!file_exists("reunionImages")) {
            mkdir("reunionImages");
        }

        file_put_contents("reunionImages/".$imgN.".txt", $name."~".$desc);
        move_uploaded_file($imgS, "reunionImages/".$imgN);
    }

    if (!$error) {
        echo "An error occurred";
    }
    else {
        echo "The information has been added";
    }
?>
    <form action="bReunion.php" method="post" enctype="multipart/form-data">
        <input type="text" name="name" placeholder="Name"><br />
        <input type="text" name="desc" placeholder="Description"><br />
        <input type="file" name="file" id="file"><br />
        <input type="submit" name="submit" id="submit"><br />
    </form>
    <br /><br />
    <a href="bReunionView.php">bReunionView</a>
</body>
</html>