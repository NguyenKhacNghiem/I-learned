<?php
    header('Content-Type: application/json') ;
    header("Access-Control-Allow-Methods: *") ;  // muốn nhiều thì phẩy rồi viết thêm
    header("Access-Control-Allow-Origin: *") ;  // * là tất cả
    header("Access-Control-Allow-Headers: *") ;
    require_once('../product_db.php') ;
    
    if($_SERVER['REQUEST_METHOD'] != 'DELETE')
        die(json_encode(array('code' => 1, 'error' => 'This API is accept DELETE method only'))) ;
    
    $raw = file_get_contents('php://input') ;  // lấy toàn bộ dữ liệu mà server nhận được qua các phương thức
    $data = json_decode($raw) ;  // do chúng ta quy định dữ liệu đc gửi lên dưới dạng JSON String

    if($data->id == null)
        die(json_encode(array('code' => 2, 'error' => 'id is empty !'))) ;
    
    $id = $data->id ;
    $result = delete($id) ;

    if(!$result)
        die(json_encode(array('code' => 0, 'message' => 'ID not found !'))) ;
      
    die(json_encode(array('code' => 0, 'message' => 'Delete product success', 'data' => $id))) ;
?>