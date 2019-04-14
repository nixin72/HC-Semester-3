<?php

/**
 * Created by PhpStorm.
 * User: amcdonald
 * Date: 11/23/2016
 * Time: 9:45 PM
 */
class Books
{
    /* Member variables */
    protected $price;
    protected $title;

//    function __construct( $par1, $par2 ) {
//        $this->title = $par1 . ' and more';
//        $this->price = $par2 * 2;
//    }

    function Books( $par1, $par2 ) {
        $this->title = $par1;
        $this->price = $par2;
    }

    /* Member functions */
    public function setPrice($par){
       $this->price = $par;
    }

    public function getPrice(){
       return $this->price;
    }

    public function setTitle($par){
       $this->title = $par;
    }

    public function getTitle(){
       return  $this->title;
    }
}

//class Novel extends Books {
//    protected $publisher;
//
//    function __construct($p1, $p2, $p3) {
////        Books::Books($p1, $p2);
//        $this->publisher = $p3;
//    }
//
//    function setPublisher($par){
//        $this->publisher = $par;
//    }
//
//    function getPublisher(){
//        return $this->publisher;
//    }
//
//    function getPrice() {
//        return $this->price * 1.1;
//    }
//}