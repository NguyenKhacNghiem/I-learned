<?php
    header('Content-Type: application/json') ;
    require_once('../product_db.php') ;

    if($_SERVER['REQUEST_METHOD'] != 'GET')
        die(json_encode(array('code' => 1, 'error' => 'This API is accept GET method only.'))) ;

    $result = get() ;

    if($result == null)
        die(json_encode(array('code' => 0, 'message' => 'List product is empty'))) ;

    die(json_encode(array('code' => 0, 'message' => 'get product success.', 'data' => $result))) ;
?>