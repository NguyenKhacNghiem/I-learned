<?php
    $name = isset($_POST['name']) ? $_POST['name'] : "" ;
    $backgroundColor = isset($_POST['bg']) ? $_POST['bg'] : "" ;
    $textColor = isset($_POST['tc']) ? $_POST['tc'] : "" ;
    $duration = isset($_POST['time']) ? $_POST['time'] : 0 ;
    
    if(empty($name))
        die("Please enter your name") ;
    
    setcookie('nameCookie', $name, time() + $duration) ;
    setcookie('bgCookie', $backgroundColor, time() + $duration) ;
    setcookie('tcCookie', $textColor, time() + $duration) ;

    header('location: cookie.php') ;
?>