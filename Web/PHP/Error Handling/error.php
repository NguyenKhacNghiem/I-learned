<?php
    // function_name(level, message, errorFile, errorLine, errorContext)
    function myErrorHandler($level, $message, $file, $line)
    {   // các biến $level, $message, $file, $line do hệ thống tự cung cấp khi có lỗi
        echo "<p style=\"color: red\"><b>Error: </b>[$level] $message at line $line</p>" ;
        //error_log("Error: [$level] $message") ;  // in lỗi ra file log của server
        die() ; // có thể dùng hàm die() để xứ lý lỗi luôn
    }

    function devision($a, $b)
    {
        if($b == 0)
            trigger_error('Error device by zero') ; // giống throw new Exception trong Java
                                                    // nhưng sẽ lựa 1 hàm trong set_error_handler() để xử lý
                                                    // ở đây là hàm myErrorHandler()
        return $a / $b ;
    }

    set_error_handler("myErrorHandler") ;

    //echo $test ;  // lỗi vì $test chưa được khai báo 

    echo devision(10, 0) ;
?>

