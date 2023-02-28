<!-- server nằm cùng file với UI -->
<?php
    session_start() ;

    if(isset($_SESSION['name']))
    {
        header('location: profile.php') ;
        die() ;
    }

    $accounts = array  // danh sách các tài khoản đã được đăng ký
    (
        'admin' => array('name' => 'Nguyen Khac Nghiem', 'password' => '782002'),   // admin là username
        'client' => array('name' => 'Peter', 'password' => '123456')                // client là username         
    ) ;

    $error = '' ;

    if(isset($_POST['username']) && isset($_POST['password']))  // ko dùng !empty()
    {
        $username = $_POST['username'] ;
        $password = $_POST['password'] ;

        if($username == '' || $password == '')
            $error = 'Please enter your username and password.' ;
        else if(!array_key_exists($username, $accounts))        // ko dùng in_array()
            $error = 'Your account has not been registered.' ;
        else
        {
            $data = $accounts[$username] ;
        
            if($password != $data['password'])
                $error = 'Password is wrong. Please try again !' ;
            else
            {
                $_SESSION['name'] = $data['name'] ; 
                header('location: home.php') ;
                die() ;
            }
        }
    }
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <div class="mt-2 ml-2">
        <h2 class="font-weight-bold">Login</h2>
        <p>Please enter your username and your password</p>

        <form action="login.php" method="post">  <!-- tự gửi cho chính nó -> đăng nhập nên post -->
            <table>
                <tr>
                    <td>
                        <label for="username">Username:</label>
                    </td>
                    <td>
                        <input type="text" name="username" id="username">
                    </td>
                </tr>

                <tr>
                    <td>
                        <label for="password">Password:</label>
                    </td>
                    <td>
                        <input type="password" name="password" id="password">
                    </td>
                </tr>

                <tr>
                    <td></td>
                    <td class="pt-2">
                        <button type="submit" class="btn btn-primary">Login</button>
                    </td>
                </tr>
            </table>
        </form>

        <p style="color: red;margin-left: 10px;"><?=$error?></p>
    </div>
</body>
</html>