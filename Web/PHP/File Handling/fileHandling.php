<?php
    // mở file và đọc
    $file = fopen("input.txt", "r") ;
    $content = fread($file, filesize("input.txt")) ;
    echo $content ;
    fclose($file) ;

    // mở file và ghi
    $file = fopen("output.txt", "w") ;
    fwrite($file, $content . " from input.txt") ;
    fclose($file) ; 
?>