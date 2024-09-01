<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Order Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<style>
    body {
        background-color: #e8f5e9; /* Light green background */
    }
    .form-label {
        color: #388e3c; /* Green color for form labels */
        font-weight: bold;
    }
    .form-control {
        border: 1px solid #388e3c; /* Green border for input fields */
        border-radius: 5px;
    }
    .btn-primary {
        background-color: #388e3c; /* Green button */
        border-color: #388e3c;
    }
    .btn-primary:hover {
        background-color: #2e7d32; /* Darker green on hover */
        border-color: #2e7d32;
    }
</style>
</head>
<body>

<form class="row g-3" action="/Orders" method="post">
  <div class="col-md-6">
    <label for="Order_id" class="form-label">Order ID</label>
    <input type="number" class="form-control" id="Order_id" name="Order_id">
  </div>
   
  <div class="col-md-6">
    <label for="user_id" class="form-label">User ID</label>
    <input type="number" class="form-control" id="user_id" name="user_id">
  </div>
  <div class="col-12">
    <label for="ShippingAddress" class="form-label">Shipping Address</label>
    <input type="text" class="form-control" id="ShippingAddress" name="ShippingAddress">
  </div>
  <div class="col-12">
    <label for="BillingAddress" class="form-label">Billing Address</label>
    <input type="text" class="form-control" id="BillingAddress" name="BillingAddress">
  </div>
  <div class="col-md-6">
    <label for="Order_Date" class="form-label">Order Date</label>
    <input type="date" class="form-control" id="Order_Date" name="Order_Date">
  </div>
  <div class="col-md-6">
    <label for="Order_Status" class="form-label">Order Status</label>
    <input type="text" class="form-control" id="Order_Status" name="Order_Status">
  </div>
  <div class="col-12">
    <button type="Submit" class="btn btn-primary">Submit</button>
  </div>
</form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
