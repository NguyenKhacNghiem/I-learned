<?php
    require_once('db.php') ;

    function add($name, $price)
    {      
        $connect = openConnection() ;

        $stm = $connect->prepare('insert into product(name, price) values(?, ?)') ;
        $stm->bind_param('si', $name, $price) ;

        $stm->execute();
        
        if($stm->affected_rows == 1) 
            return $stm->insert_id ;  // Thêm thành công: trả về id của sản phẩm vừa được thêm
                                      // . Nó là 1 con số tăng tự động của auto_increment
        return -1 ;  // Thêm thất bại
    }

    function get()
    {
        $connect = openConnection() ;

        // Ko có where nên ko cần dùng prepared statement
        $result = $connect->query('select * from product') ; 
        
        $products = array() ;

        while($row = $result->fetch_assoc())
            $products[] = $row ;
        
        return $products ;
    }

    function delete($id)
    {
        $connect = openConnection() ;

        $stm = $connect->prepare('delete from product where id = ?') ;
        $stm->bind_param('i', $id) ;

        $stm->execute() ;

        return $stm->affected_rows == 1 ; // xóa thành công hoặc không thành công
    }

    function update($id, $name, $price)
    {
        $connect = openConnection() ;

        $stm = $connect->prepare('update product set name = ?, price = ? where id = ?') ;
        $stm->bind_param('sii', $name, $price, $id) ;

        $stm->execute() ;

        return $stm->affected_rows == 1 ;
    }
?>