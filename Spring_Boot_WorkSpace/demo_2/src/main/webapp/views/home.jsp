<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            margin: 50px;
        }
        .container {
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 10px;
            max-width: 500px;
            margin: auto;
            background-color: #f9f9f9;
        }
        h1 {
            color: #4CAF50;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome to JSP!</h1>
        <p>This page is dynamically rendered using JSP.</p>
        <p><strong>Current Date and Time:</strong></p>
        <p><%= new java.util.Date() %></p>
    </div>
</body>
</html>
