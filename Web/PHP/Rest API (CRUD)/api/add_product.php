<?php
    // Để cho trang web trả về kết quả dạng JSON
    header('Content-Type: application/json') ;
    require_once('../product_db.php') ;

    if($_SERVER['REQUEST_METHOD'] != 'POST')
        die(json_encode(array('code' => 1, 'error' => 'This API is accept POST method only'))) ;
    else if(isset($_POST['name']) && isset($_POST['price']))
    {
        $name = $_POST['name'] ;
        $price = $_POST['price'] ;

        if(empty($name) || empty($price))
            die(json_encode(array('code' => 2, 'error' => 'name or price is empty !'))) ;
        else
        {
            $addResult = add($name, $price) ;

            if($addResult != -1)
                die(json_encode(array('code' => 0, 'message' => 'Add product success', 'data' => $addResult))) ;
            else
                die(json_encode(array('code' => 4, 'error' => 'Something is wrong when add product'))) ;
        }
    }
    else
        die(json_encode(array('code' => 3, 'error' => 'Please enter name and price'))) ;
?>