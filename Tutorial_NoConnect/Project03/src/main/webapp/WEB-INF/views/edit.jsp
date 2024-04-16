<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Nong Hoang Vu</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1 class="text-center">Edit User</h1>
    <form action="/product/update?id=${account.id}" method="post">
        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="username" name="username" value="${account.username}">
            <label for="username">Username</label>
        </div>
        <div class="form-floating mb-3">
            <input type="password" class="form-control" id="password" name="password" value="${account.password}">
            <label for="password">Password</label>
        </div>
        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="fullName" name="fullName" value="${account.fullName}">
            <label for="fullName">FullName</label>
        </div>
        <div class="form-floating mb-3">
            <div class="form-check form-check-inline">Role:</div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="role" id="role_1" value="1" ${account.role == 1 ? "checked" : ""}>
                <label class="form-check-label" for="role_1">Admin</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="role" id="role_0" value="0" ${account.role == 0 ? "checked" : ""}>
                <label class="form-check-label" for="role_0">Guest</label>
            </div>
        </div>
        <div class="text-center">
            <button class="btn btn-success">Submit</button>
        </div>
    </form>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</html>
