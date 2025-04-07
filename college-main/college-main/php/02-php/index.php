<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <title>Document</title>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-sm-12">
                loadCards($cards)
            </div>
        </div>
    </div>

    <?php

    require_once 'sepate,php';
    
    foreach ($cards as $card) {
        echo '<div class="card" style="width:400px;">';
        echo '<img class="card-img-top" src="' . $card->image . '" alt="Card image">';
        echo '<div class="card-body">';
        echo '<h4 class="card-title">' . $card->name . '</h4>';
        echo '<p class="card-text">Some example text.</p>';
        echo '<a href="' . $card->link . '" class="btn btn-primary">Pokaz profil</a>';
        echo '</div>';
        echo '</div>';
    }
    ?>
</body>
</html>
