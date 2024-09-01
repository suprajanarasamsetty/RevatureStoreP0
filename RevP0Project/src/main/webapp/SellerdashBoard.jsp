<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Seller Dashboard</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background: linear-gradient(to right, #e8f5e9, #a5d6a7); /* Green gradient background */
            font-family: Arial, sans-serif;
        }
        .navbar {
            background-color: #388e3c; /* Darker green for the navbar */
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
            background-color: #388e3c; /* Darker green for the card header */
            color: white; /* White text color */
            font-weight: bold;
        }
        .btn-primary {
            background-color: #388e3c; /* Matching button color */
            border: none; /* Remove default border */
            border-radius: 20px; /* Rounded corners for the button */
            padding: 10px 20px; /* Add some padding */
        }
        .btn-primary:hover {
            background-color: #2c6b2f; /* Even darker green on hover */
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
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark">
    <a class="navbar-brand" href="#">Revature Store SellerDashboard</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="SellerdashBoard.jsp">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="Sellerproducts.jsp">View Products</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="Product?action=add">Add Product</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="Sellerorders.jsp">Orders</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="Sellerprofile.jsp">Profile</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0" action="Sellersearch.jsp" method="get">
            <input class="form-control mr-sm-2" type="search" placeholder="Search Products" aria-label="Search" name="query">
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
                    <p class="text-center">Manage your account, view products, add products and check your orders below.</p>
                    <div class="row">
                        <div class="col-md-4">
                            <div class="card">
                                <div class="card-header text-center">
                                    <h5>View Products</h5>
                                </div>
                                <div class="card-body text-center">
                                    <a href="Sellerproducts.jsp" class="btn btn-primary">View Products</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="card">
                                <div class="card-header text-center">
                                    <h5>Add Product</h5>
                                </div>
                                <div class="card-body text-center">
                                    <a href="Product?action=add" class="btn btn-primary">Add Product</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="card">
                                <div class="card-header text-center">
                                    <h5>View Orders</h5>
                                </div>
                                <div class="card-body text-center">
                                    <a href="Sellerorders.jsp" class="btn btn-primary">Check Orders</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="card">
                                <div class="card-header text-center">
                                    <h5>Update Profile</h5>
                                </div>
                                <div class="card-body text-center">
                                    <a href="Sellerprofile.jsp" class="btn btn-primary">Edit Profile</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- <div class="text-center mt-4">
                        <a href="Product?action=add" class="btn btn-primary">Add Product</a>
                    </div>
                     -->
                    <% if (request.getParameter("success") != null) { %>
                        <div class="alert alert-success mt-3">Product added successfully!</div>
                    <% } %>
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
