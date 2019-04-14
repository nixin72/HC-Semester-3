<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Example 2</title>
</head>

<body>
<form id="mySecond" name="mySecond" method="post" action="processform2.php">
    <p>
        <label for="fName">First Name: </label>
        <input type="text" name="fName" id="fName" />
    </p>
    <p>
        <label for="lName">Last Name: </label>
        <input type="text" name="lName" id="lName" />
    </p>
    <p>
        <input type="checkbox" name="citizen" id="citizen" />
        <label for="citizen">Are you Canadian? </label>
    </p>
    <p>What is your age?<br />
        <label>
            <input type="radio" name="ageCategory" value="1" id="ageCategory_0" />
            10-15</label>
        <br />
        <label>
            <input type="radio" name="ageCategory" value="2" id="ageCategory_1" />
            16-20</label>
        <br />
        <label>
            <input type="radio" name="ageCategory" value="3" id="ageCategory_2" />
            21-25</label>
        <br />
        <label>
            <input type="radio" name="ageCategory" value="4" id="ageCategory_3" />
            26-30</label>
        <br />
        <label>
            <input type="radio" name="ageCategory" value="5" id="ageCategory_4" />
            Over 30</label>
    </p>
    <p>
        <label for="b2"></label>
        <input type="submit" name="b2" id="b2" value="Submit" />
        <br />
    </p>
</form>
</body>
</html>