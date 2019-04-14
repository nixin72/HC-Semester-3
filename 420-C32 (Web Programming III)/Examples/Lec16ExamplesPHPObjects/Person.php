<?php

/**
 * Created by PhpStorm.
 * User: amcdonald
 * Date: 11/23/2016
 * Time: 4:08 PM
 */
class Person
{
    var $firstName;
    var $lastName;
    function setFirstName($param) {
        $this->firstName = $param;
    }
    function getFirstName() {
        return $this->firstName;
    }
    function setLastName($param) {
        $this->lastName = $param;
    }
    function getLastName() {
        return $this->lastName;
    }

    function getFullName() {
        return $this->getFirstName() . ' ' . $this->getLastName();
    }
}