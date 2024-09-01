<%-- <%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Buyer Products</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body style="background-color: thick sky blue;">
    <div class="container">
        <h1 class="text-center">Available Products</h1>
        <div class="row">
            <%
                List<dto.ProductResponse> products = (List<dto.ProductResponse>) request.getAttribute("products");
                if (products != null) {
                    for (dto.ProductResponse product : products) {
            %>
                <div class="col-md-4">
                    <div class="card mb-4">
                        <div class="card-body">
                            <h5 class="card-title">Product Name: <%= product.getProductName() %></h5>
                            <p class="card-text">Price: $<%= product.getProductPrice() %></p>
                            <p class="card-text">Category ID: <%= product.getCategoryID() %></p>
                            <p class="card-text">Seller ID: <%= product.getSellerID() %></p>
                        </div>
                    </div>
                </div>
            <%
                    }
                } else {
                    out.println("<p>No products available.</p>");
                    out.print("<br>");
                }
                if (products != null) {
                    out.println("Number of products: " + products.size());
                } else {
                    out.println("Products list is null.");
                }
            %>
        </div>
    </div>
</body> 
</html>--%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Buyer Products</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #e8f5e9; /* Light green background */
        }
        .card {
            border: 1px solid #c8e6c9;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        .card-body {
            background-color: #a5d6a7; /* Green card body */
            color: #2e7d32; /* Dark green text */
        }
        .card-title {
            color: #1b5e20; /* Darker green for the title */
        }
        .container {
            margin-top: 30px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1 class="text-center">Available Products</h1>
        <div class="row">
            <%
                List<dto.ProductResponse> products = (List<dto.ProductResponse>) request.getAttribute("products");
                if (products != null) {
                    for (dto.ProductResponse product : products) {
            %>
                <div class="col-md-4">
                    <div class="card mb-4">
                        <div class="card-body">
                            <h5 class="card-title">Product Name: <%= product.getProductName() %></h5>
                            <p class="card-text">Price: $<%= product.getProductPrice() %></p>
                            <p class="card-text">Category ID: <%= product.getCategoryID() %></p>
                            <p class="card-text">Seller ID: <%= product.getSellerID() %></p>
                        </div>
                    </div>
                </div>
            <%
                    }
                } else {
                    out.println("<p>No products available.</p>");
                    out.print("<br>");
                }
                if (products != null) {
                    out.println("Number of products: " + products.size());
                } else {
                    out.println("Products list is null.");
                }
            %>
        </div>
    </div>
</body>
</html>
