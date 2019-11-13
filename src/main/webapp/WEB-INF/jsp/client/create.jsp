<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import ="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css" integrity="sha384-PmY9l28YgO4JwMKbTvgaS7XNZJ30MK9FAZjjzXtlqyZCqBY6X6bXIkM++IkyinN+" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap-theme.min.css" integrity="sha384-jzngWsPS6op3fgRCDTESqrEJwRKck+CILhJVO5VvaAZCq8JYf8HsR/HPpBOOPZfR" crossorigin="anonymous">

</head>
<body>
<div class="container">
    <h2>
        Add client
    </h2>
    <h3>
        ${message}
    </h3>
    <form method="post" action="<%=request.getContextPath()%>/client/create" class="form-horizontal">
        <div class="form-group form-group-lg">
            <label for="name" class="col-sm-2 control-label">Name:</label>
            <div class="col-sm-10">
                <input type="text" name="name" id="name" class="form-control" >
            </div>
        </div>
        <div class="form-group form-group-lg">
            <label for="surname" class="col-sm-2 control-label">Surname:</label>
            <div class="col-sm-10">
                <input type="text" id="surname" class="form-control" name="Surname"  >
            </div>
        </div>
        <div class="form-group form-group-lg">
            <label for="address" class="col-sm-2 control-label">Adress:</label>
            <div class="col-sm-10">
                <input type="text" id="address" class="form-control" name="Address"  >
            </div>
        </div>
        <div class="form-group form-group-lg">
            <label for="phone" class="col-sm-2 control-label">Phone:</label>
            <div class="col-sm-10">
                <input type="text" id="phone" class="form-control" name="phone"  >
            </div>
        </div>
        <div class="form-group form-group-lg">
            <label for="cpf" class="col-sm-2 control-label">CPF:</label>
            <div class="col-sm-10">
                <input type="text" id="cpf" class="form-control" name="cpf"  >
            </div>
        </div>
        <div class="form-group form-group-lg">
            <label for="E-mail" class="col-sm-2 control-label">E-mail:</label>
            <div class="col-sm-10">
                <input type="text" id="E-mail" class="form-control" name="E-mail"  >
            </div>
        </div>
        <div class="form-group form-group-lg">
            <label for="password" class="col-sm-2 control-label">Password:</label>
            <div class="col-sm-10">
                <input type="text" id="password" class="form-control" name="Password"  >
            </div>
        </div>
        <div style="float:right">
            <button type="submit" class="btn btn-primary">Save</button>
        </div>
    </form>



</div>

<br><br>

<a href="<%=request.getContextPath()%>/secure">Main Page</a>


</body>
</html>