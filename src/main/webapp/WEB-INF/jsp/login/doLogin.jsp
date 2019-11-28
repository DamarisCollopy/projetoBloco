<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import ="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css" integrity="sha384-PmY9l28YgO4JwMKbTvgaS7XNZJ30MK9FAZjjzXtlqyZCqBY6X6bXIkM++IkyinN+" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
    <!-- Optional theme -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap-theme.min.css" integrity="sha384-jzngWsPS6op3fgRCDTESqrEJwRKck+CILhJVO5VvaAZCq8JYf8HsR/HPpBOOPZfR" crossorigin="anonymous">

</head>
<body>
<div class="container">

    <h2>
        Welcome to SmartFood !!!
        <br>
        Please, log in:
    </h2>
    <form method="post" action="<%=request.getContextPath()%>/login/doLogin" class="form-horizontal">
        <div class="form-group form-group-lg">
            <label for="email" class="col-sm-2 control-label">E-mail:</label>
            <div class="col-sm-10">
                <input type="text" id="email" class="form-control" name="email"  >
            </div>
        </div>
        <div class="form-group form-group-lg">
            <label for="password" class="col-sm-2 control-label">Password:</label>
            <div class="col-sm-10">
                <input type="password" id="password" class="form-control" name="password"  >
            </div>
        </div>
    <br>
    <div style="float:right">
        <button  type="submit" class="btn btn-primary">Login</button>
    </div>
    <form/>
    <h2>
        Or, order your food :
    </h2>
    <div style="float:right">
        <button type="submit" class="btn btn-primary">Express Order</button>
    </div>

</div>
</body>
</html>