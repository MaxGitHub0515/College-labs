<?php
session_start();

// Initialize selected items if not set
if (!isset($_SESSION['selected_items'])) {
    $_SESSION['selected_items'] = [];
}

// Define available items -- OK
$result = [
    ['lista_item' => 'Item 1'],
    ['lista_item' => 'Item 2'],
    ['lista_item' => 'Item 3']
];

// Handle form submission
if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['selected_item'])) {
    $selectedItem = $_POST['selected_item'];

    // Avoid duplicates
    if (!in_array($selectedItem, $_SESSION['selected_items'])) {
        $_SESSION['selected_items'][] = $selectedItem;
    }
}

// Handle remove action
if (isset($_POST['remove_item'])) {
    $removeItem = $_POST['remove_item'];
    $_SESSION['selected_items'] = array_filter($_SESSION['selected_items'], function($item) use ($removeItem) {
        return $item !== $removeItem;
    });
}
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PHP Dropdown Without JS</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-4">
    <h3>Select an Item</h3>

    <form method="POST" class="mb-3">
        <div class="dropdown">
            <button class="btn btn-primary dropdown-toggle" type="button" data-bs-toggle="dropdown">
                Choose an Item
            </button>
            <ul class="dropdown-menu">
                <?php foreach ($result as $row): ?>
                    <li>
                        <button type="submit" name="selected_item" value="<?= $row['lista_item']; ?>" class="dropdown-item">
                            <?= $row['lista_item']; ?>
                        </button>
                    </li>
                <?php endforeach; ?>
            </ul>
        </div>
    </form>

    <h3>Selected Items</h3>
    <div class="d-flex flex-wrap">
        <?php foreach ($_SESSION['selected_items'] as $item): ?>
            <div class="card m-2" style="width: 18rem;">
                <div class="card-body">
                    <h5 class="card-title"><?= htmlspecialchars($item); ?></h5>
                    <p class="card-text">This item was selected.</p>
                    <form method="POST">
                        <input type="hidden" name="remove_item" value="<?= htmlspecialchars($item); ?>">
                        <button type="submit" class="btn btn-danger btn-sm">Remove</button>
                    </form>
                </div>
            </div>
        <?php endforeach; ?>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
