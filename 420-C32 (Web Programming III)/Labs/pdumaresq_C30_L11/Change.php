<?php

class Change {
    private $fifty = 50;
    private $twenty = 20;
    private $ten = 10;
    private $five = 5;
    private $twonies = 2;
    private $loonies = 1;
    private $quarters = .25;
    private $dimes = .10;
    private $nickels = .05;

    /*
     * Functions
     */
    public function moneyBack($amountGiven, $price) {
        $owed = $amountGiven - $price;
    }

    /*
     * Accessor methods
     */
    public function getFifty() {
        return $this->fifty;
    }
    public function getTwenty() {
        return $this->twenty;
    }
    public function getTen() {
        return $this->ten;
    }
    public function getFive() {
        return $this->five;
    }
    public function getTwonies() {
        return $this->twonies;
    }
    public function getLoonies() {
        return $this->loonies;
    }
    public function getQuarters() {
        return $this->quarters;
    }
    public function getDimes() {
        return $this->dimes;
    }
    public function getNickels() {
        return $this->nickels;
    }

    /*
     * Mutator methods
     */
    public function setFifty($am) {
        $this->fifty = $am;
    }
    public function setTwenty($am) {
        $this->twenty = $am;
    }
    public function setTen($am) {
        $this->ten = $am;
    }
    public function setFive($am) {
        $this->five = $am;
    }
    public function setTwonies($am) {
        $this->twonies = $am;
    }
    public function setLoonies($am) {
        $this->loonies = $am;
    }
    public function setQuarters($am) {
        $this->quarters = $am;
    }
    public function setDimes($am) {
        $this->dimes = $am;
    }
    public function setNickels($am) {
        $this->nickels = $am;
    }
}