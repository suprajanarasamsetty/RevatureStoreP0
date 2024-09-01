<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Category Creation Page</title>
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <style>
        body {
            background: linear-gradient(to right, #e8f5e9, #a5d6a7); /* Light green gradient background */
            font-family: Arial, sans-serif;
            padding: 20px;
        }
        form {
            background: rgba(255, 255, 255, 0.9);
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        label {
            font-weight: bold;
            color: #388e3c; /* Green color for labels */
        }
        input {
            border: 1px solid #388e3c; /* Green border for input fields */
            border-radius: 5px;
            padding: 8px;
            margin-bottom: 10px;
            width: 100%;
            box-sizing: border-box;
        }
        button {
            background-color: #388e3c; /* Green button */
            color: white;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            cursor: pointer;
        }
        button:hover {
            background-color: #2e7d32; /* Darker green on hover */
        }
    </style>
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

<form action="Categories/" method="post">
    <label for="category_id">Category ID</label>
    <input type="number" name="category_id" required>
    <br>
    <label for="category_name">Category Name</label>
    <input type="text" name="category_name" required>
    <br>
    <button type="submit">Save</button>
</form>

</body>
</html>
