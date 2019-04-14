<?php
function validate($key, $regex, &$validForm, $err, &$errorMsg) {
    $val = preg_match($regex, $_POST[$key]);
    $errorMsg .= $val ? "" : $err;
    $validForm = $validForm && $val;
}

function addForm($json) {
    ?>
    <div id="searchForm">
        <form id="editChild" action="manageList.php" method="POST">
            <?php
                $file = json_decode(file_get_contents("list/SantaList.json"), true);
            ?>
            <select id="search" name="childList">
                <option>Make new</option>
                <?php
                    foreach ($file['Person'] as $per) {
                        echo "<option ";
						echo "value='" . $per['-id'] . "' ";
                        if ($json[0]['firstName'] . " " . $json[0]['lastName'] == $per['firstName'] . " " . $per['lastName']) {
                            echo "selected='selected'";
                        }
                        echo ">" . $per['firstName'] . " " . $per['lastName'] . "</option>";
                    }
                ?>
            </select>
            <br />
            <input type="submit" name="search" value="Search"/>
        </form>
    </div>
    <br /><br />
    <div id="addForm">
        <form action="manageList.php" method="post">
			<!--
				Hidden form field containing the child's id
				or the current id in the text file if there
				is not child who's been currently selected.
			-->
			
			
            <input type="hidden" name="-id" value="<?php
				if ($json != null) {
					echo $json[0]['-id'];
				}
				else {
					$number = file("childNumber.txt");
					echo $number[0];
				}
            ?>"/>
			
            <label>First Name: </label><br/>
            <input type="text" name="firstName"
                value="<?php
                    if ($json != null)
                        echo $json[0]['firstName'];
                    else
                        echo (isset($_POST["firstName"])) ? $_POST["firstName"] : "";
                ?>" /><br/>
				
            <label>Last Name: </label><br/>
            <input type="text" name="lastName"
                value="<?php
                    if ($json != null)
                        echo $json[0]['lastName'];
                    else
                        echo (isset($_POST["lastName"])) ? $_POST["lastName"] : "";
                ?>" /><br/>

            <label>Age: </label><br/>
            <input type="text" name="age"
                value="<?php
                    if ($json != null)
                        echo $json[0]['age'];
                    else
                        echo (isset($_POST["age"])) ? $_POST["age"] : "";
                ?>" /><br/>
				
			<label>City: </label><br/>
            <input type="text" name="city"
			value="<?php
				if ($json != null)
					echo $json[0]['city'];
				else
					echo (isset($_POST["city"])) ? $_POST["city"] : "";
			?>" /><br/>	

            <label>Details:</label><br/>
            <input type="text" name="details"
                value="<?php
                    if ($json != null)
                        echo $json[0]['details'];
                    else
                        echo (isset($_POST["details"])) ? $_POST["details"] : "";
                ?>" /><br/>


            <!--SELECT OPTION LIST-->
            <label>Current list:</label><br/>
            <select name="currList">
                <option <?php
                if ($json != null)
                    if ($json[0]['currList'] == "Good")
                        echo "selected='selected'";
                    else
                        if (isset($_POST['list']))
                            echo ($_POST['list'] == "Good") ? "selected='selected'" : "";
                ?> >Good
                </option>
                <option <?php
                if ($json != null)
                    if ($json[0]['currList'] == "Bad")
                        echo "selected='selected'";
                    else
                        if (isset($_POST['list']))
                            echo ($_POST['list'] == "Bad") ? "selected='selected'" : "";
                ?> >Bad
                </option>
                <option <?php
                if ($json != null)
                    if ($json[0]['currList'] == "Limbo")
                        echo "selected='selected'";
                    else
                        if (isset($_POST['list']))
                            echo ($_POST['list'] == "Limbo") ? "selected='selected'" : "";
                ?> >Limbo
                </option>
                <option <?php
                if ($json != null)
                    if ($json[0]['currList'] == "Unknown")
                        echo "selected='selected'";
                    else
                        if (isset($_POST['list']))
                            echo ($_POST['list'] == "Unknown") ? "selected='selected'" : "";
                ?> >Unknown
                </option>
            </select><br/>

			<!--Hidden field giving the server time-->
			<input type="hidden" name="time" value="<?php 
				date_default_timezone_set('America/Toronto');
				echo date("d-m-Y");
			?>" />

            <input type="submit" name="submit"/><br/>
        </form>
    </div>
    <?php
}