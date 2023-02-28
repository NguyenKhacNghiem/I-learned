<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SQL PHP</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>
    <?php
    // B1: kết nối tới server
    $connect = new mysqli('127.0.0.1', 'root', '', /* 'shopping'*/);

    // Kiểm tra xem có kết nối thành công hay không
    if ($connect->connect_error)
        die('Connect to server: fail ' . $connect->connect_error);
    else
        echo 'Connect to server: success <br>';

    // B2: tạo database nếu chưa tồn tại
    $connect->query('create database if not exists shopping');

    // B3: use database
    $connect->select_db('shopping');

    // B4: tạo bảng
    $connect->query('create table if not exists product
                    (
                        id int auto_increment primary key, 
                        name varchar(100), 
                        price int
                    )');

    // Insert
    if (isset($_POST['name']) && isset($_POST['price'])) {
        $name = $_POST['name'];
        $price = $_POST['price'];

        if (empty($name) || empty($price))
            die('Plase enter name and price');
        else {
            $stm = $connect->prepare('insert into product(name, price) values(?, ?)');
            $stm->bind_param('si', $name, $price);

            if (!$stm->execute())
                die('Insert fail: ' . $stm->error);
            else
                echo ('Insert success');
        }
    }
    // else
    //     die('Insert fail !') ;

    // Select
    $stm = $connect->prepare('select * from product where price >= ?');

    $price = 100 ; // giả định là 100. Đáng lý ra là phải lấy từ user
    $stm->bind_param('i', $price) ;  

    if(!$stm->execute())
        die('Select fail: ' . $stm->error) ;
    
    $result = $stm->get_result() ;

    if ($result->num_rows == 0)
        echo "Empty !";
    else 
    {
    ?>
        <table class="table table-striped table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Price</th>
                </tr>
            </thead>
            <tbody>
                <?php
                $i = 0;
                while ($i < $result->num_rows) {
                    $row = $result->fetch_assoc();

                    $id = $row['id'];
                    $name = $row['name'];
                    $price = $row['price'];

                    echo "<tr>";
                    echo    "<td>$id</td>";
                    echo    "<td>$name</td>";
                    echo    "<td>$price</td>";
                    echo "</tr>";

                    $i++;
                }
                ?>
            </tbody>
        </table>

    <?php
    }

    // Delete
    if(isset($_POST['id']))
    {
        $id = $_POST['id'] ;

        if(empty($id))
            die('Please enter id to delete') ;

        $stm = $connect->prepare('delete from product where id = ?') ;
        $stm->bind_param('i', $id) ;

        if(!$stm->execute())
            die('Delete failed ' . $stm->error) ;
        else
        {
            if($stm->affected_rows == 0)
                die('Id is not exists.') ;
            else
                echo ('Delete success') ;
        }
    }
    // else
    //     die('Delete failed.') ;

    // Update: tương tự delete, thay vì truyền id thì truyền id, name, price.
    ?>
</body>

</html>