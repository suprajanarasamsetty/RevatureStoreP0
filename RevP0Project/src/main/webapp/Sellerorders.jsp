<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Orders Management</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(to right, #e8f5e9, #66bb6a); /* Gradient background with green tones */
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
            color: #a5d6a7 !important; /* Light green on hover */
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
        .form-group label {
            font-weight: bold;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark">
    <a class="navbar-brand" href="#">RevShop SellerDashboard</a>
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
        </ul>
        <form class="form-inline my-2 my-lg-0 ml-auto" action="Sellersearch.jsp" method="get">
            <input class="form-control mr-sm-2" type="search" placeholder="Search Orders" aria-label="Search" name="query">
            <button class="btn btn-outline-light my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>

<div class="container">
    <h1 class="text-center my-4">Orders Management</h1>

    <!-- Form for creating a new order -->
    <div class="card">
        <div class="card-header text-center">
            Create New Order
        </div>
        <div class="card-body">
            <form action="Orders" method="post">
                <div class="form-group">
                    <label for="Order_id">Order ID</label>
                    <input type="number" class="form-control" id="Order_id" name="Order_id" required>
                </div>
                <div class="form-group">
                    <label for="user_id">User ID</label>
                    <input type="number" class="form-control" id="user_id" name="user_id" required>
                </div>
                <div class="form-group">
                    <label for="ShippingAddress">Shipping Address</label>
                    <input type="text" class="form-control" id="ShippingAddress" name="ShippingAddress" required>
                </div>
                <div class="form-group">
                    <label for="BillingAddress">Billing Address</label>
                    <input type="text" class="form-control" id="BillingAddress" name="BillingAddress" required>
                </div>
                <div class="form-group">
                    <label for="Order_Date">Order Date (yyyy-MM-ddTHH:mm:ss)</label>
                    <input type="datetime-local" class="form-control" id="Order_Date" name="Order_Date" required>
                </div>
                <div class="form-group">
                    <label for="Order_Status">Order Status</label>
                    <input type="text" class="form-control" id="Order_Status" name="Order_Status" required>
                </div>
                <div class="text-center">
                    <button type="submit" class="btn btn-primary">Create Order</button>
                </div>
            </form>
        </div>
    </div>

    <!-- Section for displaying orders -->
    <div class="card mt-4">
        <div class="card-header text-center">
            Orders List
        </div>
        <div class="card-body">
            <div id="ordersList">
                <!-- Orders will be displayed here -->
            </div>
        </div>
    </div>

</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script>
    // Fetch and display orders (if needed) can be added here
</script>
</body>
</html>
