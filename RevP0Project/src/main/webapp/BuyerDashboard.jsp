<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Buyer's Dashboard</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background: linear-gradient(to right, #e3f2f9, #a5d6a7); /* Gradient background with green shades */
            font-family: Arial, sans-serif;
        }
        .navbar {
            background-color: #2e7d32; /* Dark green for the navbar */
        }
        .navbar-brand {
            color: white !important; /* White text color for the brand */
        }
        .navbar-nav .nav-link {
            color: white !important; /* White text color for navbar links */
        }
        .navbar-nav .nav-link:hover {
            color: #b9fbc0 !important; /* Light green on hover */
        }
        .container {
            margin-top: 30px;
            padding: 30px;
            border-radius: 20px; /* Rounded corners for the container */
            background: rgba(255, 255, 255, 0.9); /* Semi-transparent white background */
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2); /* Larger shadow for a floating effect */
        }
        .card {
            border-radius: 20px; /* Rounded corners for the cards */
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); /* Shadow for depth */
            margin-bottom: 20px;
        }
        .card-header {
            background-color: #2e7d32; /* Dark green for the card header */
            color: white; /* White text color */
            font-weight: bold;
        }
        .btn-primary {
            background-color: #2e7d32; /* Matching button color */
            border: none; /* Remove default border */
            border-radius: 20px; /* Rounded corners for the button */
            padding: 10px 20px; /* Add some padding */
        }
        .btn-primary:hover {
            background-color: #1b5e20; /* Even darker green on hover */
        }
        .btn-danger {
            border-radius: 20px; /* Rounded corners for the button */
            padding: 10px 20px; /* Add some padding */
        }
        .card-body p {
            font-size: 1.2em; /* Slightly larger text for better readability */
        }
        .card-footer a {
            font-weight: bold; /* Make footer link bold */
        }
        .card-img-top {
            height: 200px;
            object-fit: cover;
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
                <a class="nav-link" href="Buyerprofile?user_email=${sessionScope.user_email}">Profile</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0" action="searchProducts" method="get">
            <input class="form-control mr-sm-2" type="search" placeholder="Search for products" aria-label="Search" name="query">
            <button class="btn btn-outline-light my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <div class="card-header text-center">
                    <h3>Welcome to Your Dashboard</h3>
                </div>
                <div class="card-body">
                    <p class="text-center">Manage your account, view products, and check your orders below.</p>
                    <div class="row">
                        <div class="col-md-4">
                            <div class="card">
                                <div class="card-header text-center">
                                    <h5>Available Products</h5>
                                </div>
                                <div class="card-body text-center">
                                    <a href="Buyerproducts.jsp" class="btn btn-primary">View Products</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="card">
                                <div class="card-header text-center">
                                    <h5>View Orders</h5>
                                </div>
                                <div class="card-body text-center">
                                    <a href="Buyerorders.jsp" class="btn btn-primary">Check Orders</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="card">
                                <div class="card-header text-center">
                                    <h5>Your Cart</h5>
                                </div>
                                <div class="card-body text-center">
                                    <a href="Buyercart.jsp" class="btn btn-primary">View Cart</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="card">
                                <div class="card-header text-center">
                                    <h5>Your Wishlist</h5>
                                </div>
                                <div class="card-body text-center">
                                    <a href="Buyerwishlist.jsp" class="btn btn-primary">View Wishlist</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="card">
                                <div class="card-header text-center">
                                    <h5>Categories</h5>
                                </div>
                                <div class="card-body text-center">
                                    <a href="Buyercategories.jsp" class="btn btn-primary">View Categories</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="card">
                                <div class="card-header text-center">
                                    <h5>Update Profile</h5>
                                </div>
                                <div class="card-body text-center">
                                    <a class="btn btn-primary" href="Buyerprofile?user_email=${sessionScope.user_email}">Edit Profile</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="card-footer text-center">
                    <a href="login.jsp" class="btn btn-danger">Logout</a>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
