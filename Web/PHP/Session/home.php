<?php
    session_start() ;
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body> 
<?php
    if(!isset($_SESSION['name']))
    {
?>
        <div class="mt-2 ml-2">
            <p>You need to <a href="login.php" class="text-decoration-none font-weight-bold text-primary">login</a> to see your profile</p>
        </div>
<?php
    }
    else
    {
?>
        <div class="mt-2 ml-2">
            <p>Hello <span class="text-primary font-weight-bold"><?=$_SESSION['name']?></span></p>
            <p><a class="text-decoration-none text-primary font-weight-bold" href="profile.php">Here</a> is your profile</p> 
            <p>Click <a href="logout.php" class="text-primary text-decoration-none font-weight-bold">here</a> to logout</p> 
        </div>
<?php    
    }
?>
    
</body>
</html>