
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
    <!-- Wyklad -->
    <a href="index.php?name=Ala">Click A</a>
    <a href="index.php?name=Jurek">Click B</a>

    <?php   
        if(isset($_GET['name'])){
            echo '<h1> Welcome ' . $_GET['name'] . '</h1>';

        } /* For comparision, it works as a simple react router */


        // Utilizing sessions
        /* https://www.w3schools.com/php/php_sessions.asp*/

        
        $name = "aaa";

        if($name == "admin") {
            $_SESSION["user"] = $name;
            $_SESSION["logged"] = 1;
        } else {
            session_unset();
            session_destroy();
        }
        
    ?>

    <a href="page.php">Click here to get an access to page.php</a>


</body>
</html>