<!Doctype HTML>
<html>
<head>
    <title>New Account</title>
</head>

<body>
<?php
include "AccountFunctions.inc";

$_POST = array();
parse_str(file_get_contents('php://input'), $_POST);

$errors = ["fName" => "", "lName" => "", "address" => "", "city" => "", "province" => "",
    "postal" => "", "email" => "", "phone" => "", "pass" => "", "cPass" => ""];

$values = ["fName" => "", "lName" => "", "address" => "", "city" => "", "province" => "",
    "postal" => "", "email" => "", "phone" => "", "pass" => "", "cPass" => ""];

$regex = [
    "fName" => '/^[A-Z\'\h,-]+$/i',
    "lName" => '/^[A-Z\'\s,-]+$/i',
    "address" => '/^[0-9]{1,6}[\w\'\s,]+$/i',
    "city" => '/^[\w\'\s,]+$/i',
    "postal" => '/^([a-z]\d[a-z])\s?(\d[a-z]\d)$/i',
    "email" => '/^((?!.*?[~\s])(?=.*?[\w])?(?=.*?[!#$%&\'*+-\/=?^_`{|}~])?(?=.*?[.])?).{1,64}@((?=.*?[a-z])?(?=.*?[\d])?(?=.*?[-])?).{1,185}\.[a-z]{2,10}$/i',
    "phone" => "/^(1(\\+\\s?)|(\\s|-))?(([\\d]{3})|(\\([\\d]{3}\\)))\\s?-?([\\d]{3})\\s?-?([\\d]{4})$/",
    "pass" => "/^((?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-])).{8,16}$/",
];

$validForm = true;
$displayForm = true;

if (isset($_POST["submit"])) {
    validValue('fName', $errors, $regex, $values, "Please enter a valid first name", $validForm);
    validValue('lName', $errors, $regex, $values, "Please enter a valid last name", $validForm);
    validValue('address', $errors, $regex, $values, "Please enter a valid address", $validForm);
    validValue('city', $errors, $regex, $values, "Please enter a valid city", $validForm);
    validValue('postal', $errors, $regex, $values, "Please enter a valid postal code", $validForm);
    validValue('email', $errors, $regex, $values, "Please enter a valid email address", $validForm);
    validValue('phone', $errors, $regex, $values, "Please enter a valid phone number.", $validForm);

    if (!validValue('pass', $errors, $regex, $values, "Please enter a valid password.", $validForm)) {
        checkPasswordError($errors, $values);
    } else {
        if ($_POST['pass'] != $_POST['cPass']) {
            $errors['cPass'] = "Your passwords do not match";
            $validForm = false;
        }
    }
    $values['province'] = $_POST['province'];
    $displayForm = !$validForm;
}

if (isset($_POST["cancel"])) {
    $_POST = array();
}

if ($displayForm) {
    ?>
    <link href="styles/login.css" rel="stylesheet" type="text/css"/>
    <div class="container">
        <div id="header">
            <div id="heading"><h3><strong>Welcome to Happy Valley Kennels!</strong></h3></div>
            <p>Create Account</p>
        </div>
        <?php
        if (!$validForm) {
            echo "<div id='errors'>";
            displayErrors('fName', $errors);
            displayErrors('lName', $errors);
            displayErrors('address', $errors);
            displayErrors('city', $errors);
            displayErrors('postal', $errors);
            displayErrors('email', $errors);
            displayErrors('phone', $errors);
            displayErrors('pass', $errors);
            displayErrors('cPass', $errors);
            echo "</div>";
        }
        ?>
        <form method="POST" action="NewAccount.php" id="login">
            <label class="label">First Name: <br/>
                <input class="input<?php changeCSS('fName', $errors) ?>" type="text" name="fName" placeholder=" John"
                       value="<?php echo $values['fName'] ?>"/>
            </label><br/>
            <label class="label">Last Name:<br/>
                <input class="input<?php changeCSS('lName', $errors) ?>" type="text" name="lName" placeholder="  Smith"
                       value="<?php echo $values['lName'] ?>"/>
            </label><br/>
            <label class="label">Street:<br/>
                <input class="input<?php changeCSS('address', $errors) ?>" type="text" name="address"
                       placeholder="  123 example street" value="<?php echo $values['address'] ?>"/>
            </label><br/>
            <label class="label">City:<br/>
                <input class="input<?php changeCSS('city', $errors) ?>" type="text" name="city" placeholder="  Ottawa"
                       value="<?php echo $values['city'] ?>"/>
            </label><br/>
            <label class="label">Province:<br/>
                <select class="input" name="province">
                    <option <?php chooseProvince('province', $values, 'Alberta') ?> >Alberta</option>
                    <option <?php chooseProvince('province', $values, 'British Columbia') ?> >British Columbia</option>
                    <option <?php chooseProvince('province', $values, 'Manitoba') ?> >Manitoba</option>
                    <option <?php chooseProvince('province', $values, 'New Brunswick') ?> >New Brunswick</option>
                    <option <?php chooseProvince('province', $values, 'Newfoundland') ?> >Newfoundland</option>
                    <option <?php chooseProvince('province', $values, 'Northwest Territories') ?> >Northwest Territories</option>
                    <option <?php chooseProvince('province', $values, 'Nova Scotia') ?> >Nova Scotia</option>
                    <option <?php chooseProvince('province', $values, 'Nunavut') ?> >Nunavut</option>
                    <option <?php chooseProvince('province', $values, 'Ontario') ?> >Ontario</option>
                    <option <?php chooseProvince('province', $values, 'Prince Edward Island') ?> >Prince Edward Island</option>
                    <option <?php chooseProvince('province', $values, 'Quebec') ?> >Quebec</option>
                    <option <?php chooseProvince('province', $values, 'Yukon') ?> >Yukon</option>
                </select></label><br/>
            <label class="label">Postal Code:<br/>
                <input class="input<?php changeCSS('postal', $errors) ?>" type="text" name="postal"
                       placeholder="  A1A 1A1" value="<?php echo $values['postal'] ?>"/>
            </label><br/>
            <label class="label">Email:<br/>
                <input class="input<?php changeCSS('email', $errors) ?>" type="text" name="email"
                       placeholder="  abc123@example.ca" value="<?php echo $values['email'] ?>"/>
            </label><br/>
            <label class="label">Phone number:<br/>
                <input class="input<?php changeCSS('phone', $errors) ?>" type="text" name="phone"
                       placeholder="  (613) 123-4567" value="<?php echo $values['phone'] ?>"/>
            </label><br/>
            <label class="label">Password:<br/>
                <input class="input<?php changeCSS('pass', $errors) ?>" type="password" placeholder="  ********"
                       name="pass" value=""/>
            </label><br/>
            <label class="label">Confirm Password:<br/>
                <input class="input<?php changeCSS('cPass', $errors) ?>" type="password" placeholder="  ********"
                       name="cPass" value=""/>
            </label><br/><br/>

            <input type="submit" value="Create Account" name="submit" class="button" id="submit"/>
            <button name="cancel" class="button" id="cancel">Cancel</button>
        </form>
    </div>

    <?php
} else {
    $values['pass'] = md5($values['pass']);
    writeToFile($values);
    ?>
    <link href="styles/login.css" rel="stylesheet" type="text/css"/>
    <div class="welcome">
        <h1>Account Created!</h1>

        <p><?php
            echo $_POST['fName'] . " " . $_POST['lName'] . ", your account has been created. 
               You are now logged in as a Happy Valley Kennel customer";
            ?></p>
        <br/><a href='NewAccount.php'>Continue</a>
    </div>
    <?php
}
?>
</body>
</html>