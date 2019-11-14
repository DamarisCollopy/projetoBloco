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
            <label for="surname" class="col-sm-2 control-label">surname:</label>
            <div class="col-sm-10">
                <input type="text" id="surname" class="form-control" name="surname"  >
            </div>
        </div>
        <div class="form-group form-group-lg">
            <label for="address" class="col-sm-2 control-label">adress:</label>
            <div class="col-sm-10">
                <input type="text" id="address" class="form-control" name="address"  >
            </div>
        </div>
        <div class="form-group form-group-lg">
            <label for="phone" class="col-sm-2 control-label">phone:</label>
            <div class="col-sm-10">
                <input type="text" id="phone" name="phone" class="form-control" onkeypress="$(this).mask('(00) 0000-00009')" >
            </div>
        </div>
        <div class="form-group form-group-lg">
            <label for="cpf" class="col-sm-2 control-label">CPF:</label>
            <div class="col-sm-10">
                <input type="text" id="cpf" class="form-control" name="cpf" onkeypress="$(this).mask('000.000.000-00');">
            </div>
        </div>
        <div class="form-group form-group-lg">
            <label for="email" class="col-sm-2 control-label">E-mail:</label>
            <div class="col-sm-10">
                <input type="text" id="email" class="form-control" name="email"  >
            </div>
        </div>
        <div class="form-group form-group-lg">
            <label for="password" class="col-sm-2 control-label">Password:</label>
            <div class="col-sm-10">
                <input type="text" id="password" class="form-control" name="password"  >
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