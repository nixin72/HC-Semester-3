<?php
    $genre = $_GET['genre'];
    $file = file_get_contents("files/albums.json");
    $album = json_decode($file, true);
    $respCont = "";

    function printArray($array, &$respCont) {
        foreach ($array as $key => $val)
            if (is_array($val)) {
                $respCont .= $key . "s: \n";
                printArray($val, $respCont);
            } else
                $respCont .= $key . ": " . $val . "\n";
    }

    foreach ($album['album'] as $curr)
        if ($curr['genre'] == $genre) {
            printArray($curr, $respCont);
            $respCont .= "\n";
        }

    //Out of curiosity, why does it try downloading the file when content type is application/php?
    header("Content-Type: application/json");
    header("Content-Length: " . strlen($file));
    echo $respCont;