<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #e8f5e9; /* Light green background for the page */
        }
        .container {
            background-color: #a5d6a7; /* Light green background for the main container */
            padding: 20px;
            border-radius: 15px; /* Rounded corners for the container */
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* Subtle shadow */
        }
        .card {
            border-radius: 15px; /* Rounded corners for the card */
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* Subtle shadow for a lifting effect */
        }
        .card-header {
            background-color: #66bb6a; /* Darker green for the header */
            color: white; /* White text color */
        }
        .btn-primary {
            background-color: #66bb6a; /* Matching button color */
            border: none; /* Remove default border */
        }
        .btn-primary:hover {
            background-color: #388e3c; /* Even darker green on hover */
        }
        .card-body {
            background-color: white; /* White background for the form area */
        }
        .page-header {
            text-align: center;
            margin-top: 20px;
            color: #66bb6a; /* Darker green color for the heading */
        }
    </style>
</head>
<body>
<div class="container mt-5">
    <div class="page-header">
        <h1>Revature Store - P0</h1>
    </div>
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card">
                <div class="card-header text-center">
                    <h3>User Registration</h3>
                </div>
                <div class="card-body">
                    <!-- Registration Form -->
                    <form action="Users" method="post">
                        <div class="form-group">
                            <label for="user_first_name">First Name:</label>
                            <input type="text" class="form-control" id="user_first_name" name="user_first_name" required>
                        </div>
                        <div class="form-group">
                            <label for="user_last_name">Last Name:</label>
                            <input type="text" class="form-control" id="user_last_name" name="user_last_name" required>
                        </div>
                        <div class="form-group">
                            <label for="user_email">Email:</label>
                            <input type="email" class="form-control" id="user_email" name="user_email" required>
                        </div>
                        <div class="form-group">
                            <label for="user_password">Password:</label>
                            <input type="password" class="form-control" id="user_password" name="user_password" required>
                        </div>
                        <div class="form-group">
                            <label for="user_phonenumber">Phone Number:</label>
                            <input type="text" class="form-control" id="user_phonenumber" name="user_phonenumber" required>
                        </div>
                        <div class="form-group">
                            <label for="user_address">Address:</label>
                            <input type="text" class="form-control" id="user_address" name="user_address" required>
                        </div>
                        <div class="form-group">
    						<label for="user_role">Role:</label>
    						<select id="user_role" name="role" class="form-control" required>
        					<option value="">Select Role</option>
        					<option value="BUYER">BUYER</option>
      					    <option value="SELLER">SELLER</option>
    						</select>
						</div>
                        <button type="submit" class="btn btn-primary btn-block">Register</button>
                    </form>
                </div>
                <div class="card-footer text-center">
                    <a href="login.jsp">Already have an account? Login here</a>
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
