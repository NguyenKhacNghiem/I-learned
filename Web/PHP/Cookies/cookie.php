<!-- Đọc cookies -->
<?php
    $name = isset($_COOKIE['nameCookie']) ? $_COOKIE['nameCookie'] : "" ;
    $backgroundColor = isset($_COOKIE['bgCookie']) ? $_COOKIE['bgCookie'] : "White" ;
    $textColor = isset($_COOKIE['tcCookie']) ? $_COOKIE['tcCookie'] : "Black" ;
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cookies</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    
    <style>
        body {
            background-color: <?=$backgroundColor?>;
            color: <?=$textColor?>;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <form style="max-width: 500px;margin: auto;" action="cookieServer.php" method="POST">
            <h2>Cookies Example</h2>

            <div class="form-group">
                <label for="name">Your name:</label>
                <input value="<?=$name?>" name="name" id="name" type="text" class="form-control" placeholder="Enter name">
            </div>

            <div class="form-group">
                <label for="bg">Background color:</label>
                <select class="form-control" name="bg" id="bg">
                    <option value="<?=$backgroundColor?>">Current (<?=$backgroundColor?>)</option>
                    <option value="Green">Green</option>
                    <option value="Yellow">Yellow</option>
                    <option value="Pink">Pink</option>
                </select>
            </div>

            <div class="form-group">
                <label for="tc">Text color:</label>
                <select class="form-control" name="tc" id="tc">
                    <option value="<?=$textColor?>">Current (<?=$textColor?>)</option>
                    <option value="Purple">Purple</option>
                    <option value="Blue">Blue</option>
                    <option value="Red">Red</option>
                </select>
            </div>

            <div class="form-group">
                <label for="time">Timeout (seconds):</label>
                <input type="number" class="form-control" id="time" name="time">
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</body>
</html>