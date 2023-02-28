<?php
    session_start() ;

    if(!isset($_SESSION['name']))
    {
        header('location: login.php') ;
        die() ;
    }
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
    <div class="container">
        <div class="mt-5" style="width: 300px;margin: auto; box-shadow: 0px 0px 4px 4px rgba(0, 0, 0, 0.1);">
            <div>
                <img src="https://wallpaperaccess.com/full/5933142.png" style="width: 100%;">
            </div>

            <div class="text-center">
                <h5 class="font-weight-bold"><?=$_SESSION['name']?></h5>
                <p>Student</p>
                <p>Ton Duc Thang University</p>
                <div>
                    <a href="#"><i class="fa fa-dribbble text-dark"></i></a>
                    <a href="#"><i class="fa fa-twitter text-dark"></i></a>
                    <a href="#"><i class="fa fa-linkedin text-dark"></i></a>
                    <a href="#"><i class="fa fa-facebook text-dark"></i></a>
                </div>
            </div>

            <a href="#" class="text-decoration-none text-light">
                <div class="bg-dark text-center">Contact</div>
            </a>
            
            <a href="home.php" class="btn btn-danger w-100 p-0">Back</a>
        </div>
    </div>
</body>
</html>