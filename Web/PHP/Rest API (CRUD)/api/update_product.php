<?php
    header('Content-Type: application/json') ;
    require_once('../product_db.php') ;

    if($_SERVER['REQUEST_METHOD'] != 'PUT')
        die(json_encode(array('code' => 1, 'error' => 'This API is accept PUT method only'))) ;
    
    $raw = file_get_contents('php://input') ;
    $json = json_decode($raw) ;

    if($json->id == null || $json->name == null || $json->price == null)
        die(json_encode(array('code' => 2, 'error' => 'Please enter full !'))) ;
    
    $id = $json->id ;
    $name = $json->name ;
    $price = $json->price ;

    $result = update($id, $name, $price) ;

    if(!$result)
        die(json_encode(array('code' => 0, 'message' => 'ID not found !'))) ;
    
    die(json_encode(array('code' => 0, 'message' => 'Update product success'))) ;
?>