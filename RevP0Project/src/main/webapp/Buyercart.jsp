<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cart</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background: linear-gradient(to right, #e8f5e9, #a5d6a7); /* Green gradient background */
            font-family: Arial, sans-serif;
        }
        .navbar {
            background-color: #388e3c; /* Dark green for the navbar */
        }
        .navbar-brand {
            color: white !important;
        }
        .navbar-nav .nav-link {
            color: white !important;
        }
        .navbar-nav .nav-link:hover {
            color: #c8e6c9 !important; /* Light green on hover */
        }
        .container {
            margin-top: 30px;
            padding: 30px;
            border-radius: 20px;
            background: rgba(255, 255, 255, 0.9);
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
        }
        .card {
            border-radius: 20px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            margin-bottom: 20px;
        }
        .card-header {
            background-color: #388e3c; /* Dark green for card header */
            color: white;
            font-weight: bold;
        }
        .btn-primary {
            background-color: #388e3c; /* Dark green for buttons */
            border: none;
            border-radius: 20px;
            padding: 10px 20px;
        }
        .btn-primary:hover {
            background-color: #2e7d32; /* Darker green on hover */
        }
        .btn-danger {
            border-radius: 20px;
            padding: 10px 20px;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark">
    <a class="navbar-brand" href="#">Revature Store BuyerDashboard</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="BuyerDashboard.jsp">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="Buyerproducts.jsp">Products</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="Buyerorders.jsp">Orders</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="Buyercart.jsp">Cart</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="Buyerwishlist.jsp">Wishlist</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="Buyercategories.jsp">Categories</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="Buyerprofile.jsp">Profile</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0" action="searchProducts" method="get">
            <input class="form-control mr-sm-2" type="search" placeholder="Search for products" aria-label="Search" name="query">
            <button class="btn btn-outline-light my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>

<div class="container">
    <h2 class="text-center">Cart</h2>
    <!-- Cart items will be displayed here -->
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
