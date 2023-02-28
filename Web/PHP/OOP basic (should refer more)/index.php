<?php
    class Car
    {
        public $name ;
        private $color ;

        function __construct($name, $color)
        {
            $this->name = $name ;
            $this->color = $color ;
        }

        function setName($name)
        {
            $this->name = $name ;
        }

        function setColor($color)
        {
            $this->color = $color ;
        }

        function getName()
        {
            return $this->name ;
        }

        function getColor()
        {
            return $this->color ;
        }
    }

    // main
    $car1 = new Car("", "") ;
    
    $car1->setName("Audi") ;
    $car1->setColor("red") ;

    echo $car1->name . "-" . $car1->getColor() . "<br>" ;

    $car2 = new Car("Toyota", "yellow") ;

    echo $car2->name . "-" . $car2->getColor() ;
?>