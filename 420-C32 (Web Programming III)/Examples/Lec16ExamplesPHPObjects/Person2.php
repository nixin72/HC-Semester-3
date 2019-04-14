<?php

/**
 * Created by PhpStorm.
 * User: amcdonald
 * Date: 11/23/2016
 * Time: 5:05 PM
 */
class Person2
{
    private $firstName;
    private $lastName;
    public function setFirstName($param) {
        $this->firstName = $param;
    }
    public function getFirstName() {
        return $this->firstName;
    }
    public function setLastName($param) {
        $this->lastName = $param;
    }
    public function getLastName() {
        return $this->lastName;
    }

    public function getFullName() {
        return $this->getFirstName() . ' ' . $this->getLastName();
    }

}