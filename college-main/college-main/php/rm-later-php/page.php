
<?php 
     session_start();
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="welcome.php" method="POST">
    Name: <input type="text" name="name"><br>
    E-mail: <input type="text" name="email"><br>
    <input type="submit">
    </form>

    </form>
    <?php 
         if(isset($_SESSION["logged"]) || $_SESSION['logged']  == !1) {
            header(header:'index.php');
            die();
         }
         
        // pop up the form if the user is not logged in 
         echo $_POST['name'];
         echo $_POST['email'];
    ?>

</body>
</html>