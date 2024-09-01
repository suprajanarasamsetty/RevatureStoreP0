<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Products</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <h1>List Of Products</h1>
    <style>
        body {
            background: linear-gradient(to right, #e8f5e9, #a5d6a7); /* Gradient background with green tones */
            font-family: Arial, sans-serif;
        }
        .navbar {
            background-color: #2e7d32; /* Darker green for the navbar */
        }
        .navbar-brand {
            color: white !important; /* White text color for the brand */
        }
        .navbar-nav .nav-link {
            color: white !important; /* White text color for navbar links */
        }
        .navbar-nav .nav-link:hover {
            color: #c8e6c9 !important; /* Light green on hover */
        }
        .container {
            margin-top: 30px;
            padding: 30px;
            border-radius: 20px; /* Rounded corners for the container */
            background: rgba(255, 255, 255, 0.9); /* Semi-transparent white background */
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2); /* Larger shadow for a floating effect */
        }
        .form-group label {
            font-weight: bold;
        }
        .btn-custom {
            background-color: #2e7d32; /* Matching button color with green theme */
            border: none;
            border-radius: 20px;
            padding: 10px 20px;
            color: white;
        }
        .btn-custom:hover {
            background-color: #1b5e20; /* Darker green on hover */
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
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="SellerdashBoard.jsp">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="Sellerproducts.jsp">View Products</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="addProduct.jsp">Add Product</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="Sellerorders.jsp">Orders</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="Sellerprofile.jsp">Profile</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="logout.jsp">Logout</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container">
    <h2 class="text-center">Add a New Product</h2>
    <form action="Product" method="post">
        <div class="form-group">
            <label for="productID">Product ID:</label>
            <input type="text" class="form-control" id="productID" name="productID" required>
        </div>
        <div class="form-group">
            <label for="productName">Product Name:</label>
            <input type="text" class="form-control" id="productName" name="productName" required>
        </div>
        <div class="form-group">
            <label for="productPrice">Product Price:</label>
            <input type="text" class="form-control" id="productPrice" name="productPrice" required>
        </div>
        <div class="form-group">
            <label for="sellerId">Seller ID:</label>
            <input type="text" class="form-control" id="sellerId" name="sellerId" required>
        </div>
        <div class="form-group">
            <label for="categoryId">Category ID:</label>
            <input type="text" class="form-control" id="categoryId" name="categoryId" required>
        </div>
        <button type="submit" class="btn btn-custom btn-block">Add Product</button>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
