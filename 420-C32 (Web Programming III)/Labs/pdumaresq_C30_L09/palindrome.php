<!Doctype html>
<html>
<head>
    <title>Palindrome test</title>
</head>
<body>
    <table border="1">
<?php
    isPalindrome("racecar noon civic noon racecar");
    isPalindrome("Aerate pet area");
    isPalindrome("I, man, am regal: a German am I");
    isPalindrome("Mr. Owl ate my metal worm.");
    isPalindrome("A man, a plan, a cat, a ham, a yak, a yam, a hat, a canal-Panama!");
    isPalindrome("Sh! Tom sees moths");
    isPalindrome("driveway");
    isPalindrome("Web Programming III");
    isPalindrome("Palindrome");

    function isPalindrome($s1) {
        if (preg_replace('/[\s]+/', "", strtolower($s1))
                === strrev(preg_replace('/[\s]+/', "", strtolower($s1))))
            echo "<tr><td>$s1</td><td>This is a perfect palindrome</td></tr>";
        else
            if (preg_replace('/[^\w]+/', "", strtolower($s1))
                    === strrev(preg_replace('/[^\w]+/', "", strtolower($s1))))
                echo "<tr><td>$s1</td><td>This is a standard palindrome</td></tr>";
            else
                echo "<tr><td>$s1</td><td>This is not a palindrome</td></tr>";
    }
?>
    </table>
</body>
</html>