<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="dto.UserRegistrationResponse" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Buyer Profile</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f0f2f5;
            margin: 0;
            padding: 20px;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            max-width: 900px;
            background: #ffffff;
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border: 1px solid #c8e6c9; /* Light green border */
        }
        h1 {
            text-align: center;
            color: #2e7d32; /* Dark green text */
            margin-bottom: 20px;
            font-size: 2em;
            font-weight: 600;
        }
        .profile-info {
            display: flex;
            flex-direction: column;
            gap: 15px;
        }
        .profile-info p {
            font-size: 1.2em;
            margin: 0;
            padding: 10px;
            border-radius: 5px;
            background-color: #e8f5e9; /* Light green background */
            box-shadow: inset 0 1px 3px rgba(0, 0, 0, 0.1);
        }
        .profile-info label {
            font-weight: bold;
            color: #388e3c; /* Green color for labels */
        }
        .profile-info span {
            font-weight: normal;
            color: #4caf50; /* Green color for span text */
        }
        .profile-info p:hover {
            background-color: #c8e6c9; /* Slightly darker green on hover */
            cursor: pointer;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Buyer Profile</h1>
        <%
            UserRegistrationResponse user = (UserRegistrationResponse)request.getAttribute("user");
            if (user != null) {
        %>
            <div class="profile-info">
                <p><label>ID:</label> <span><%= user.getUser_id() %></span></p>
                <p><label>First Name:</label> <span><%= user.getUser_first_name() %></span></p>
                <p><label>Last Name:</label> <span><%= user.getUser_last_name() %></span></p>
                <p><label>Email:</label> <span><%= user.getUser_email() %></span></p>
                <p><label>Password:</label> <span><%= user.getUser_password() %></span></p>
                <p><label>Phone Number:</label> <span><%= user.getUser_phonenumber() %></span></p>
                <p><label>Address:</label> <span><%= user.getUser_address() %></span></p>
                <p><label>Role:</label> <span><%= user.getRole() %></span></p>
            </div>
        <% 
            }
            else { 
        %>
            <p>User information Not Found.</p>
        <% 
            }
        %>
    </div>
</body>
</html>
