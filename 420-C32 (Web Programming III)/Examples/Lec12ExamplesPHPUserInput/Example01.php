<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Form Input</title>
</head>

<body>
<h2>Form Example 1</h2>
<form id="myForm" name="myForm" method="post" action="processform.php">
    <p>
        <label>First Name:
            <input type="text" name="fName" id="fName" />
        </label>
    </p>
    <p>
        <label>Last Name:
            <input name="lName" type="text" id="lName" size="35" maxlength="35" />
        </label>
    </p>
    <p>
        <label>Email Address:
            <input name="emailAddr" type="text" id="emailAddr" size="60" maxlength="60" />
        </label>
    </p>
    <p>
        <input type="submit" name="b1" id="b1" value="Submit" />
    </p>
</form>
<p>&nbsp;</p>
</body>
</html>